package com.smlb.base

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

abstract class BaseAdapter<T> : RecyclerView.Adapter<BaseViewHolder>() {

    lateinit var mData: MutableList<T>
    lateinit var mContext: Context

    private var mLayoutId: Int = 0

    private var mListener: OnItemClickListener<T>? = null

    interface OnItemClickListener<in T> {
        fun onItemClick(position: Int, data: T)
    }

    fun BaseAdapter(context: Context, data: MutableList<T>, layoutId: Int) {
        mData = data
        mContext = context
        mLayoutId = layoutId
    }

    protected abstract fun onBindItemData(holder: BaseViewHolder, position: Int)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        val view = LayoutInflater.from(mContext).inflate(mLayoutId, parent, false)
        return BaseViewHolder(view)
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        onBindItemData(holder, position)

        if (mListener != null) holder.mConvertView.setOnClickListener {
            val pos = holder.adapterPosition
            mListener!!.onItemClick(pos, mData[pos])
        }
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    fun setOnItemClickListener(listener: OnItemClickListener<String>) {
        mListener = listener as OnItemClickListener<T>
    }

    fun getItemData(position: Int): T {
        return mData[position]
    }

    fun getData(): List<T> {
        return mData
    }

    fun add(data: T, position: Int) {
        mData.add(position, data)
        notifyItemInserted(position)
    }

    fun reloadData(data: List<T>) {
        clean()
        addAll(data)
    }

    fun addAll(list: List<T>) {
        mData.addAll(list)
        notifyItemRangeInserted(0, mData.size)
    }

    fun remove(position: Int) {
        mData.removeAt(position)
        notifyItemRemoved(position)
    }

    fun clean() {
        val size = mData.size
        mData.clear()
        notifyItemRangeRemoved(0, size)
    }

    fun setLayoutId(layoutId: Int) {
        mLayoutId = layoutId
    }

}