package com.smlb.app

import android.text.TextUtils
import com.smlb.bean.ImagesEntity
import com.smlb.bean.ShotsEntity
import com.smlb.bean.UserEntity
import okhttp3.ResponseBody
import org.jsoup.Jsoup
import org.jsoup.nodes.Element
import retrofit2.Converter
import retrofit2.Retrofit
import java.lang.reflect.Type
import java.util.regex.Pattern


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class SearchConverter : Converter<ResponseBody, List<ShotsEntity>> {

    companion object {
        val INSTANCE = SearchConverter()
        private val HOST = "https://dribbble.com"
        private val PATTERN_PLAYER_ID = Pattern.compile("users/(\\d+?)/", Pattern.DOTALL)
    }

    class Factory : Converter.Factory() {
        override fun responseBodyConverter(type: Type, annotations: Array<Annotation>, retrofit: Retrofit): Converter<ResponseBody, *> {
            return INSTANCE
        }
    }

    override fun convert(value: ResponseBody?): List<ShotsEntity> {
        val shotElements = Jsoup.parse(value!!.string(), HOST).select("li[id^=screenshot]")
        val shots = ArrayList<ShotsEntity>(shotElements.size)
        shotElements.mapNotNullTo(shots) { parseShot(it) }
        return shots
    }


    private fun parseShot(element: Element): ShotsEntity {
        val descriptionBlock = element.select("a.dribbble-over").first()
        var description = descriptionBlock.select("span.comment").text().trim()
        if (!TextUtils.isEmpty(description)) description = "<p>$description</p>"
        var imgUrl = element.select("img").first().attr("src")
        if (imgUrl.contains("_teaser.")) imgUrl = imgUrl.replace("_teaser.", ".")
        val imagesEntity = ImagesEntity()
        imagesEntity.mHidpi = imgUrl
        return ShotsEntity.Builder().setId(Integer.parseInt(element.id().replace("screenshot-", "")))
                .setHtmlUrl(HOST + element.select("a.dribbble-link").first().attr("href"))
                .setTitle(descriptionBlock.select("strong").first().text())
                .setDescription(description)
                .setImages(imagesEntity)
                .setAnimated(element.select("div.gif-indicator").first() != null)
                .setLikesCount(Integer.parseInt(element.select("li.fav").first().child(0).text().replaceAll(",", "")))
                .setCommentsCount(Integer.parseInt(element.select("li.cmnt").first().child(0).text().replaceAll(",", "")))
                .setViewsCount(Integer.parseInt(element.select("li.views").first().child(0).text().replaceAll(",", "")))
                .setUser(parsePlayer(element.select("h2").first()))
                .build()
    }

    private fun parsePlayer(element: Element): UserEntity {
        val userBlock = element.select("a.url").first()
        var avatarUrl = userBlock.select("img.photo").first().attr("src")
        if (avatarUrl.contains("/mini/")) {
            avatarUrl = avatarUrl.replace("/mini/", "/normal/")
        }
        val matchId = PATTERN_PLAYER_ID.matcher(avatarUrl)
        var id = -1
        if (matchId.find() && matchId.groupCount() == 1) {
            id = Integer.parseInt(matchId.group(1))
        }
        val slashUsername = userBlock.attr("href")
        val username = if (TextUtils.isEmpty(slashUsername)) null else slashUsername.substring(1)
        return UserEntity.Builder().setId(id)
                .setName(userBlock.text())
                .setUsername(username!!)
                .setHtmlUrl(HOST + slashUsername)
                .setAvatarUrl(avatarUrl)
                .setPro(element.select("span.badge-pro").size > 0)
                .build()
    }

}

private fun String.replaceAll(oldStr: String, targetStr: String): String? {
    return Pattern.compile(oldStr).matcher(this).replaceAll(targetStr)
}
