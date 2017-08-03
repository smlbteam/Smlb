package com.smlb.bean

import com.chad.library.adapter.base.entity.MultiItemEntity
import com.google.gson.annotations.SerializedName
import com.smlb.app.SmlbApplication
import java.io.Serializable


/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class ShotsEntity(@SerializedName("id")
                  var id: Int, @SerializedName("title")
                  var title: String?, @SerializedName("description")
                  var description: String?, @SerializedName("width")
                  var width: Int, @SerializedName("height")
                  var height: Int, @SerializedName("images")
                  var images: ImagesEntity?,
                  @SerializedName("views_count")
                  var viewsCount: Int, @SerializedName("likes_count")
                  var likesCount: Int, @SerializedName("comments_count")
                  var commentsCount: Int, @SerializedName("attachments_count")
                  var attachmentsCount: Int, @SerializedName("rebounds_count")
                  var reboundsCount: Int,
                  @SerializedName("buckets_count")
                  var bucketsCount: Int, @SerializedName("created_at")
                  var createdAt: String?, @SerializedName("updated_at")
                  var updatedAt: String?, @SerializedName("html_url")
                  var htmlUrl: String?, @SerializedName("attachments_url")
                  var attachmentsUrl: String?,
                  @SerializedName("buckets_url")
                  var bucketsUrl: String?, @SerializedName("comments_url")
                  var commentsUrl: String?, @SerializedName("likes_url")
                  var likesUrl: String?, @SerializedName("projects_url")
                  var projectsUrl: String?, @SerializedName("rebounds_url")
                  var reboundsUrl: String?,
                  @SerializedName("animated")
                  var isAnimated: Boolean, @SerializedName("user")
                  var user: UserEntity?, @SerializedName("team")
                  var team: TeamEntity?, @SerializedName("tags")
                  var tags: List<String>?) : Serializable, MultiItemEntity {

    class Builder {
        private var id: Int = 0
        private var title: String? = null
        private var description: String? = null
        private var width: Int = 0
        private var height: Int = 0
        private var images: ImagesEntity? = null
        private var views_count: Int = 0
        private var likes_count: Int = 0
        private var comments_count: Int = 0
        private var attachments_count: Int = 0
        private var rebounds_count: Int = 0
        private var buckets_count: Int = 0
        private var created_at: String? = null
        private var updated_at: String? = null
        private var html_url: String? = null
        private var attachments_url: String? = null
        private var buckets_url: String? = null
        private var comments_url: String? = null
        private var likes_url: String? = null
        private var projects_url: String? = null
        private var rebounds_url: String? = null
        private var animated: Boolean = false
        private var tags: List<String>? = null
        private var user: UserEntity? = null
        private var team: TeamEntity? = null

        fun setId(id: Int): Builder {
            this.id = id
            return this
        }

        fun setTitle(title: String): Builder {
            this.title = title
            return this
        }

        fun setDescription(description: String): Builder {
            this.description = description
            return this
        }

        fun setWidth(width: Int): Builder {
            this.width = width
            return this
        }

        fun setHeight(height: Int): Builder {
            this.height = height
            return this
        }

        fun setImages(images: ImagesEntity): Builder {
            this.images = images
            return this
        }

        fun setViewsCount(views_count: Int): Builder {
            this.views_count = views_count
            return this
        }

        fun setLikesCount(likes_count: Int): Builder {
            this.likes_count = likes_count
            return this
        }

        fun setCommentsCount(comments_count: Int): Builder {
            this.comments_count = comments_count
            return this
        }

        fun setAttachmentsCount(attachments_count: Int): Builder {
            this.attachments_count = attachments_count
            return this
        }

        fun setReboundsCount(rebounds_count: Int): Builder {
            this.rebounds_count = rebounds_count
            return this
        }

        fun setBucketsCount(buckets_count: Int): Builder {
            this.buckets_count = buckets_count
            return this
        }

        fun setCreatedAt(created_at: String): Builder {
            this.created_at = created_at
            return this
        }

        fun setUpdatedAt(updated_at: String): Builder {
            this.updated_at = updated_at
            return this
        }

        fun setHtmlUrl(html_url: String): Builder {
            this.html_url = html_url
            return this
        }

        fun setAttachmentsUrl(attachments_url: String): Builder {
            this.attachments_url = attachments_url
            return this
        }

        fun setBucketsUrl(buckets_url: String): Builder {
            this.buckets_url = buckets_url
            return this
        }

        fun setCommentsUrl(comments_url: String): Builder {
            this.comments_url = comments_url
            return this
        }

        fun setLikesUrl(likes_url: String): Builder {
            this.likes_url = likes_url
            return this
        }

        fun setProjectsUrl(projects_url: String): Builder {
            this.projects_url = projects_url
            return this
        }

        fun setReboundsUrl(rebounds_url: String): Builder {
            this.rebounds_url = rebounds_url
            return this
        }

        fun setAnimated(animated: Boolean): Builder {
            this.animated = animated
            return this
        }

        fun setTags(tags: List<String>): Builder {
            this.tags = tags
            return this
        }

        fun setUser(user: UserEntity): Builder {
            this.user = user
            return this
        }

        fun setTeam(team: TeamEntity): Builder {
            this.team = team
            return this
        }

        fun build(): ShotsEntity {
            return ShotsEntity(id, title, description, width, height, images, views_count, likes_count,
                    comments_count, attachments_count, rebounds_count, buckets_count, created_at, updated_at, html_url,
                    attachments_url, buckets_url, comments_url, likes_url, projects_url, rebounds_url, animated, user,
                    team, tags)
        }
    }

    override fun getItemType(): Int {
        return SmlbApplication.getAppConfig().getViewMode()
    }
}
