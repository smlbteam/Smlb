package com.smlb.base

import android.support.v7.widget.RecyclerView
import android.util.SparseArray
import android.view.View
import android.widget.TextView


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class BaseViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    private var mViews: SparseArray<View> = SparseArray()

    var mConvertView: View = itemView!!

    fun <T : View> getView(viewId: Int): T? {
        var view: View? = mViews.get(viewId)
        if (view == null) {
            view = mConvertView.findViewById(viewId)
            mViews.put(viewId, view)
        }
        return view as T?
    }

    fun setTvText(viewId: Int, text: String) {
        val textView = getView<TextView>(viewId)
        textView!!.text = text
    }

}