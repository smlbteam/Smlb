package com.smlb.bean

import com.google.gson.annotations.SerializedName
import java.io.Serializable



/**
 * Created by Sunmeng on 8/3/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class ImagesEntity : Serializable {
    @SerializedName("hidpi")
    var mHidpi: String? = null
    @SerializedName("normal")
    var mNormal: String? = null
    @SerializedName("teaser")
    var mTeaser: String? = null
}