package com.smlb.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable

/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class UserEntity(@SerializedName("id")
                 var id: Int, @SerializedName("name")
                 var name: String?, @SerializedName("username")
                 var username: String?, @SerializedName("html_url")
                 var htmlUrl: String?, @SerializedName("avatar_url")
                 var avatarUrl: String?, @SerializedName("bio")
                 var bio: String?,
                 @SerializedName("location")
                 var location: String?, @SerializedName("links")
                 var links: LinksEntity?, @SerializedName("buckets_count")
                 var bucketsCount: Int, @SerializedName("comments_received_count")
                 var commentsReceivedCount: Int,
                 @SerializedName("followers_count")
                 var followersCount: Int, @SerializedName("followings_count")
                 var followingsCount: Int, @SerializedName("likes_count")
                 var likesCount: Int, @SerializedName("likes_received_count")
                 var likesReceivedCount: Int,
                 @SerializedName("projects_count")
                 var projectsCount: Int, @SerializedName("rebounds_received_count")
                 var reboundsReceivedCount: Int, @SerializedName("shots_count")
                 var shotsCount: Int, @SerializedName("teams_count")
                 var teamsCount: Int,
                 @SerializedName("can_upload_shot")
                 var isCanUploadShot: Boolean, @SerializedName("type")
                 var type: String?, @SerializedName("pro")
                 var isPro: Boolean, @SerializedName("buckets_url")
                 var bucketsUrl: String?, @SerializedName("followers_url")
                 var followersUrl: String?,
                 @SerializedName("following_url")
                 var followingUrl: String?, @SerializedName("likes_url")
                 var likesUrl: String?, @SerializedName("projects_url")
                 var projectsUrl: String?, @SerializedName("shots_url")
                 var shotsUrl: String?, @SerializedName("teams_url")
                 var teamsUrl: String?,
                 @SerializedName("created_at")
                 var createdAt: String?, @SerializedName("updated_at")
                 var updatedAt: String?) : Serializable {

    class Builder {

        private var id: Int = 0
        private var name: String? = null
        private var username: String? = null
        private var htmlUrl: String? = null
        private var avatarUrl: String? = null
        private var bio: String? = null
        private var location: String? = null
        private var links: LinksEntity? = null
        private var bucketsCount: Int = 0
        private var commentsReceivedCount: Int = 0
        private var followersCount: Int = 0
        private var followingsCount: Int = 0
        private var likesCount: Int = 0
        private var likesReceivedCount: Int = 0
        private var projectsCount: Int = 0
        private var reboundsReceivedCount: Int = 0
        private var shotsCount: Int = 0
        private var teamsCount: Int = 0
        private var canUploadShot: Boolean = false
        private var type: String? = null
        private var pro: Boolean = false
        private var bucketsUrl: String? = null
        private var followersUrl: String? = null
        private var followingUrl: String? = null
        private var likesUrl: String? = null
        private var projectsUrl: String? = null
        private var shotsUrl: String? = null
        private var teamsUrl: String? = null
        private var createdAt: String? = null
        private var updatedAt: String? = null

        fun setId(id: Int): Builder {
            this.id = id
            return this
        }

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setUsername(username: String): Builder {
            this.username = username
            return this
        }

        fun setHtmlUrl(htmlUrl: String): Builder {
            this.htmlUrl = htmlUrl
            return this
        }

        fun setAvatarUrl(avatarUrl: String): Builder {
            this.avatarUrl = avatarUrl
            return this
        }

        fun setBio(bio: String): Builder {
            this.bio = bio
            return this
        }

        fun setLocation(location: String): Builder {
            this.location = location
            return this
        }

        fun setLinks(links: LinksEntity): Builder {
            this.links = links
            return this
        }

        fun setBucketsCount(bucketsCount: Int): Builder {
            this.bucketsCount = bucketsCount
            return this
        }

        fun setCommentsReceivedCount(commentsReceivedCount: Int): Builder {
            this.commentsReceivedCount = commentsReceivedCount
            return this
        }

        fun setFollowersCount(followersCount: Int): Builder {
            this.followersCount = followersCount
            return this
        }

        fun setFollowingsCount(followingsCount: Int): Builder {
            this.followingsCount = followingsCount
            return this
        }

        fun setLikesCount(likesCount: Int): Builder {
            this.likesCount = likesCount
            return this
        }

        fun setLikesReceivedCount(likesReceivedCount: Int): Builder {
            this.likesReceivedCount = likesReceivedCount
            return this
        }

        fun setProjectsCount(projectsCount: Int): Builder {
            this.projectsCount = projectsCount
            return this
        }

        fun setReboundsReceivedCount(reboundsReceivedCount: Int): Builder {
            this.reboundsReceivedCount = reboundsReceivedCount
            return this
        }

        fun setShotsCount(shotsCount: Int): Builder {
            this.shotsCount = shotsCount
            return this
        }

        fun setTeamsCount(teamsCount: Int): Builder {
            this.teamsCount = teamsCount
            return this
        }

        fun setCanUploadShot(canUploadShot: Boolean): Builder {
            this.canUploadShot = canUploadShot
            return this
        }

        fun setYype(type: String): Builder {
            this.type = type
            return this
        }

        fun setPro(pro: Boolean): Builder {
            this.pro = pro
            return this
        }

        fun setBucketsUrl(bucketsUrl: String): Builder {
            this.bucketsUrl = bucketsUrl
            return this
        }

        fun setFollowersUrl(followersUrl: String): Builder {
            this.followersUrl = followersUrl
            return this
        }

        fun setFollowingUrl(followingUrl: String): Builder {
            this.followingUrl = followingUrl
            return this
        }

        fun setLikesUrl(likesUrl: String): Builder {
            this.likesUrl = likesUrl
            return this
        }

        fun setProjectsUrl(projectsUrl: String): Builder {
            this.projectsUrl = projectsUrl
            return this
        }

        fun setShotsUrl(shotsUrl: String): Builder {
            this.shotsUrl = shotsUrl
            return this
        }

        fun setTeamsUrl(teamsUrl: String): Builder {
            this.teamsUrl = teamsUrl
            return this
        }

        fun setCreatedAt(createdAt: String): Builder {
            this.createdAt = createdAt
            return this
        }

        fun setUpdatedAt(updatedAt: String): Builder {
            this.updatedAt = updatedAt
            return this
        }

        fun build(): UserEntity {
            return UserEntity(id, name, username, htmlUrl, avatarUrl, bio, location, links, bucketsCount,
                    commentsReceivedCount, followersCount, followingsCount, likesCount, likesReceivedCount,
                    projectsCount, reboundsReceivedCount, shotsCount, teamsCount, canUploadShot, type, pro, bucketsUrl,
                    followersUrl, followingUrl, likesUrl, projectsUrl, shotsUrl, teamsUrl, createdAt, updatedAt)
        }
    }

}