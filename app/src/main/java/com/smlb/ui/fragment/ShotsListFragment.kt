package com.smlb.ui.fragment

import android.os.Bundle
import android.view.View
import com.smlb.base.mvp.BaseMVPListFragment
import com.smlb.bean.ShotsEntity
import com.smlb.contract.ShotsListContract
import com.smlb.model.ShotsListModel
import com.smlb.presenter.ShotsListPresenter
import com.smlb.widget.MaterialSpinner

/**
 * Created by Sunmeng on 8/8/2017.
 * E-Mail:Sunmeng1995@outlook.com
 * Description:
 */

class ShotsListFragment : BaseMVPListFragment<ShotsListPresenter, ShotsListModel>(),
        MaterialSpinner.OnItemSelectedListener<Nothing>, ShotsListContract.View {

    override fun onItemSelected(view: View, position: Int, item: Nothing) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getShotsOnSuccess(data: List<ShotsEntity>) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun init(view: View, savedInstanceState: Bundle) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}