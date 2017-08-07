package com.smlb.base.mvp

import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.smlb.R
import com.smlb.base.BaseActivity
import com.smlb.constant.ApiConstants
import com.smlb.widget.CustomLoadMore


/**
 * Created by Sunmeng on 8/7/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class BaseMVPListActivity<P : BasePresenter<M, *>, M : BaseModel> : BaseActivity() {

    var mPresenter: P? = null
    var mModel: M? = null

    private lateinit var mRefreshLayout: SwipeRefreshLayout

    private lateinit var mAdapter: BaseQuickAdapter<*, *>

    private var mIsRefresh: Boolean = false
    private var mPage: Int = 0

    private var mErrorView: View? = null
    private var mEmptyView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter = TUtils.getT(this, 0) as P?
        mModel = TUtils.getT(this, 1) as M?
        if (this is BaseView) mPresenter!!.setVM(this@BaseMVPListActivity, mModel)
    }

    override fun onDestroy() {
        super.onDestroy()
        if (mPresenter != null) mPresenter!!.onDestroy()
    }

    private fun setupList(refreshLayout: SwipeRefreshLayout, recyclerView: RecyclerView, adapter: BaseQuickAdapter<*, *>) {
        val inflater = LayoutInflater.from(this)
        mAdapter = adapter

        /* 没有数据 */
        mEmptyView = inflater.inflate(R.layout.layout_empty_view, recyclerView.parent as ViewGroup, false)
        val tvEmptyViewMsg = mEmptyView!!.findViewById(R.id.tv_empty_view_msg) as TextView
        tvEmptyViewMsg.text = getEmptyViewMsg()

        /* 加载失败 */
        mErrorView = inflater.inflate(R.layout.layout_error_view, recyclerView.parent as ViewGroup, false)
        val tvErrorViewMsg = mErrorView!!.findViewById(R.id.tv_error_view_retry) as TextView
        tvErrorViewMsg.text = getErrorViewMsg()
        mErrorView!!.setOnClickListener({
            mRefreshLayout.isRefreshing = true
            requestData(true)
        })

        /* 刷新 */
        mRefreshLayout = refreshLayout
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(this, R.color.colorAccent))
        mRefreshLayout.setOnRefreshListener({ requestData(true) })

        /* 加载更多 */
        mAdapter.setLoadMoreView(CustomLoadMore())
        mAdapter.setAutoLoadMoreSize(18)
        mAdapter.setOnLoadMoreListener({ requestData(false) })

        /* 首次进入自动刷新 */
        mRefreshLayout.postDelayed({
            mRefreshLayout.isRefreshing = true
            requestData(true)
        }, 200)

        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = mAdapter
    }

    fun getEmptyViewMsg(): String {
        return "没有更多内容"
    }

    fun getErrorViewMsg(): String {
        return "重新加载"
    }

    private fun requestData(isRefresh: Boolean) {
        mIsRefresh = isRefresh
        if (mIsRefresh)
            mPage = 1
        else
            mPage++
    }

    fun setData(datas: List<Nothing>?) = if (mIsRefresh) {
        mAdapter.setNewData(datas)
        if (datas == null || datas.isEmpty()) {
            mAdapter.emptyView = mEmptyView
            mAdapter.notifyDataSetChanged()
        } else if (datas.size < getPageSize()) {
            mAdapter.loadMoreEnd()
        } else {
            mAdapter.loadMoreComplete()
        }
    } else {
        if (datas!!.isEmpty()) {
            mAdapter.loadMoreEnd()
        } else {
            mAdapter.addData(datas)
            mAdapter.loadMoreComplete()
        }
    }

    private fun getPageSize(): Int = ApiConstants.ParamValue.PAGE_SIZE

    fun showLoading() {}

    fun showError() {
        if (mIsRefresh) {
            mAdapter.emptyView = mErrorView
            mAdapter.notifyDataSetChanged()
        } else {
            mAdapter.loadMoreFail()
        }
    }

    fun onComplete() {
        mRefreshLayout.isRefreshing = false
    }
}