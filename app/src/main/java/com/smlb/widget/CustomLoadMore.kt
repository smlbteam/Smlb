package com.smlb.widget

import com.chad.library.adapter.base.loadmore.LoadMoreView
import com.smlb.R

/**
 * Created by Sunmeng on 8/7/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class CustomLoadMore : LoadMoreView() {
    override fun getLayoutId(): Int {
        return R.layout.layout_load_more
    }

    override fun isLoadEndGone(): Boolean {
        return false
    }

    override fun getLoadingViewId(): Int {
        return R.id.lay_load_more_loading_view
    }

    override fun getLoadFailViewId(): Int {
        return R.id.lay_load_more_load_fail_view
    }

    override fun getLoadEndViewId(): Int {
        return R.id.tv_load_more_no_more
    }
}