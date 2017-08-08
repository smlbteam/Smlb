package com.smlb.ui

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.mikepenz.materialdrawer.AccountHeader
import com.mikepenz.materialdrawer.AccountHeaderBuilder
import com.mikepenz.materialdrawer.Drawer
import com.mikepenz.materialdrawer.DrawerBuilder
import com.mikepenz.materialdrawer.model.DividerDrawerItem
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem
import com.mikepenz.materialdrawer.model.ProfileDrawerItem
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem
import com.mikepenz.materialdrawer.model.interfaces.IProfile
import com.smlb.R
import com.smlb.app.AppConstants
import com.smlb.app.SmlbApplication
import com.smlb.base.mvp.BaseMVPActivity
import com.smlb.bean.UserEntity
import com.smlb.contract.UserInfoContract
import com.smlb.model.UserInfoModel
import com.smlb.presenter.UserInfoPresenter
import com.smlb.ui.activity.LoginActivity
import com.smlb.ui.fragment.SearchFragment
import com.smlb.ui.fragment.ShotsListFragment
import com.smlb.utils.SPUtils
import com.smlb.utils.UserInfoUtils
import com.smlb.widget.MaterialSpinner
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseMVPActivity<UserInfoPresenter, UserInfoModel>(), UserInfoContract.View,
        AccountHeader.OnAccountHeaderListener, Toolbar.OnMenuItemClickListener, Drawer.OnDrawerItemClickListener {

    /**
     * 侧滑菜单 Item 标识
     */
    private val NAV_IDENTITY_PROFILE = 100L
    private val NAV_IDENTITY_HOME = 101L
    private val NAV_IDENTITY_FOLLOWING = 102L
    private val NAV_IDENTITY_BUCKETS = 103L
    private val NAV_IDENTITY_LIKES = 104L
    private val NAV_IDENTITY_SETTINGS = 105L

    /**
     * Spinner 菜单
     */
    private val SELECTOR_TYPE = arrayOf("全部", "团队", "首秀", "精品", "再创作", "动画")
    private val SELECTOR_SORT = arrayOf("最热", "最新", "浏览最多", "评论最多")
    private val SELECTOR_TIME = arrayOf("当前", "周", "月", "年", "所有")

    /**
     * Toolbar 菜单栏图标
     */
    private val VIEW_MODE_ICON_RES = intArrayOf(R.mipmap.ic_action_small_info, R.mipmap.ic_action_small, R.mipmap.ic_action_large_info, R.mipmap.ic_action_large)

    val REQUEST_CODE_LOGIN = 100

    var mLayoutSpinner: View? = null
    var mSpinnerSelectorType: MaterialSpinner? = null//all
    var mSpinnerSelectorSort: MaterialSpinner? = null//hot
    var mSpinnerSelectorTime: MaterialSpinner? = null//current

    private val mFragmentList: List<Fragment>? = null
    private val mShotsListFragment: ShotsListFragment? = null

    private val mFragmentManager: FragmentManager? = null

    private val mSearchFragment: SearchFragment? = null

    private val mExitTime: Long = 0

    private var mAccountHeader: AccountHeader? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        shouldAuthorize()
        initNavDrawer()
    }

    private fun shouldAuthorize() {
        if (!(SPUtils.get(this, AppConstants.SP_IS_FIRST_RUN, false) as Boolean)) {
            startActivityForResult(Intent(this, LoginActivity::class.java), REQUEST_CODE_LOGIN)
            SPUtils.put(this, AppConstants.SP_IS_FIRST_RUN, true)
        }
    }

    private fun initNavDrawer() {
        setSupportActionBar(toolbar_main)
        toolbar_main.setOnMenuItemClickListener(this)

        val navHeader = ProfileDrawerItem()
        if (SmlbApplication.getAppConfig().isLogin()) {
            navHeader.withName(UserInfoUtils.getCurrentUser(this)?.name)
                    .withIcon(UserInfoUtils.getCurrentUser(this)?.avatarUrl)
                    .withIdentifier(NAV_IDENTITY_PROFILE)
        } else {
            navHeader.withName("点击头像登录")
                    .withIcon(ContextCompat.getDrawable(this, R.mipmap.dribbble))
                    .withIdentifier(NAV_IDENTITY_PROFILE)
        }
        mAccountHeader = AccountHeaderBuilder().withActivity(this)
                .addProfiles(navHeader)
                .withSelectionListEnabled(false)
                .withOnAccountHeaderListener(this)
                .build()

        val homeDrawerItem = PrimaryDrawerItem()
        homeDrawerItem.withName("首页")
                .withIcon(R.drawable.iv_home_grey_24dp)
                .withIdentifier(NAV_IDENTITY_HOME)
                .withOnDrawerItemClickListener(this)
                .withSelectedIcon(R.drawable.iv_home_pink_24dp)

        val followingDrawerItem = PrimaryDrawerItem()
        followingDrawerItem.withName("关注的人")
                .withIdentifier(NAV_IDENTITY_FOLLOWING)
                .withIcon(R.drawable.iv_follower_grey_24dp)
                .withOnDrawerItemClickListener(this)
                .withSelectedIcon(R.drawable.iv_follower_pink_24dp)

        val bucketsDrawerItem = PrimaryDrawerItem()
        bucketsDrawerItem.withName("收藏夹")
                .withIdentifier(NAV_IDENTITY_BUCKETS)
                .withIcon(R.drawable.iv_bucket_grey_24dp)
                .withOnDrawerItemClickListener(this)
                .withSelectedIcon(R.drawable.iv_bucket_pink_24dp)

        val likesDrawerItem = PrimaryDrawerItem()
        likesDrawerItem.withName("喜欢")
                .withIdentifier(NAV_IDENTITY_LIKES)
                .withIcon(R.drawable.iv_like_grey_24dp)
                .withOnDrawerItemClickListener(this)
                .withSelectedIcon(R.drawable.iv_like_pink_24dp)

        val settingsDrawerItem = SecondaryDrawerItem()
        settingsDrawerItem.withName("设置")
                .withIdentifier(NAV_IDENTITY_SETTINGS)
                .withIcon(R.drawable.iv_settings_grey_24dp)
                .withOnDrawerItemClickListener(this)
                .withSelectable(false)

        val builder = DrawerBuilder()
        builder.withActivity(this)
                .withToolbar(toolbar_main)
                .withActionBarDrawerToggleAnimated(true)
                .withAccountHeader(mAccountHeader!!)
                .addDrawerItems(homeDrawerItem, followingDrawerItem, bucketsDrawerItem, likesDrawerItem,
                        DividerDrawerItem(), settingsDrawerItem)

        builder.build()
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

    override fun onProfileChanged(view: View?, profile: IProfile<*>?, current: Boolean): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onItemClick(view: View?, position: Int, drawerItem: IDrawerItem<*, *>?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
