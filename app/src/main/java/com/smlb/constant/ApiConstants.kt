package com.smlb.constant

/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

interface ApiConstants {
    interface Url {
        companion object {
            const val BASE_URL = "https://api.dribbble.com/v1/"

            const val BASE_JSOUP_URL = "https://dribbble.com/"

            const val OAUTH_URL = "https://dribbble.com/oauth/"

            const val REDIRECT_URL = "http://lhunter.org/"
        }
    }

    interface Path {
        companion object {
            const val AUTHORIZE = "authorize"

            const val TOKEN = "token"

            const val SHOTS = "shots"

            const val SHOTS_DETAIL = "shots/{id}"

            const val SHOTS_COMMENTS = "shots/{id}/comments"

            const val SHOTS_COMMENTS_DETAIL = "shots/{shots}/comments/{id}"

            const val SHOTS_PUT_COMMENTS = "/shots/{shot}/comments/{id}"

            const val SHOTS_LIKE = "shots/{id}/like"

            const val SEARCH = "search"

            const val USER = "user"

            const val USER_FOLLOWERS = "users/{id}/followers"

            const val USER_SHOTS = "users/{id}/shots"

            const val USER_BUCKETS = "user/buckets"

            const val BUCKETS_DETAIL = "shots/{id}/buckets"

            const val ADD_SHOTS_TO_BUCKETS = "buckets/{id}/shots"
        }
    }

    interface ParamKey {
        companion object {

            const val CLIENT_ID = "client_id"

            const val CLIENT_SECRET = "client_secret"

            const val REDIRECT_URI = "redirect_uri"

            const val SCOPE = "scope"

            const val STATE = "state"

            const val CODE = "code"

            const val LIST = "list"

            const val TIME_FRAME = "timeframe"

            const val SORT = "sort"

            const val PAGE = "page"

            const val PER_PAGE = "per_page"

            const val SEARCH_KEY = "q"

            const val BODY = "body"

            const val SHOTS_ID = "shot_id"
        }
    }

    interface ParamValue {
        companion object {

            const val CLIENT_ID = "5b96cd9397a3a6a262fbf6ede2b59ecf6340ab01e9192f18abe46edbe4ce5519"

            const val CLIENT_SECRET = "ab73df88cc0dba31bf5776859ca63b9a4fba7ba6ee6e9361bbaa06aa9109fe37"

            const val TOKEN = "8f0fa00867e1e9883fdd82c0e98f701bc4cea519dc2c42a96e5d3699a237f62c"

            const val REDIRECT_URI = "http://lhunter.org/"

            const val SCOPE = "public write comment upload"

            const val STATE = "hunter"

            const val PAGE_SIZE = 20

            const val SEARCH_PAGE_SIZE = 10

            /**
             * 类型，默认返回所有类型
             */
            val LIST_VALUES = arrayOf("", "teams", "debuts", "playoffs", "rebounds", "animated")

            /**
             * 排序，默认返回综合排序
             */
            val SORT_VALUES = arrayOf("", "recent", "views", "comments")

            /**
             * 时间段，默认返回最新
             */
            val TIME_VALUES = arrayOf("", "week", "month", "year", "ever")
        }
    }

}