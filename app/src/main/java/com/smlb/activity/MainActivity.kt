package com.smlb.activity

import android.os.Bundle
import butterknife.ButterKnife
import com.smlb.Contract.UserInfoContract
import com.smlb.R
import com.smlb.base.mvp.BaseMVPActivity
import com.smlb.bean.UserEntity
import com.smlb.model.UserInfoModel
import com.smlb.presenter.UserInfoPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseMVPActivity<UserInfoPresenter, UserInfoModel>(), UserInfoContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        this.text.setOnClickListener { showToast("xxx") }
    }

    override fun showLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onComplete() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showError() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUserInfoOnSuccess(entity: UserEntity) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
