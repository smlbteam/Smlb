package com.smlb.presenter.adapter

import android.content.Context
import com.smlb.R
import com.smlb.base.BaseAdapter
import com.smlb.base.BaseViewHolder


/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class SimpleSpinnerAdapter(context: Context, data: List<String>): BaseAdapter<String>() {
    override fun onBindItemData(holder: BaseViewHolder, position: Int) {
        holder.setTvText(R.id.tv_item_spinner, mData[position])
    }
}