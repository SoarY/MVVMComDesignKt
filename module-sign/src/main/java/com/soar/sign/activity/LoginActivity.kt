package com.soar.sign.activity

import android.os.Bundle
import com.alibaba.android.arouter.facade.annotation.Route
import com.soar.common.router.RouteConstants
import com.soar.commonui.base.BaseActivity
import com.soar.sign.BR
import com.soar.sign.R
import com.soar.sign.databinding.SignActivityLoginBinding
import com.soar.sign.vm.SignLoginViewModel

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
@Route(path = RouteConstants.Sign.SIGN_LOGIN)
class LoginActivity : BaseActivity<SignActivityLoginBinding, SignLoginViewModel>(){
    override fun initContentView(savedInstanceState: Bundle?): Int {
        return R.layout.sign_activity_login
    }

    override fun initVariableId(): Int {
        return BR.vm
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initView()
        initData()
    }

    private fun initView() {}

    private fun initData() {
        mViewModel.getNaviJson()
    }
}