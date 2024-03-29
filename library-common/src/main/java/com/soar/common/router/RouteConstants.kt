package com.soar.common.router

/**
 * NAME：YONG_
 * Created at: 2023/3/23 18
 * Describe:
 */
open class RouteConstants {
    /**
     * 身份验证组件
     */
    open class Sign {
        companion object {
            const val SIGN = "/sign"
            //登录界面
            const val SIGN_LOGIN = SIGN+"/login"
        }
    }

    /**
     * 用户组件
     */
    open class USER {
        companion object {
            const val USER = "/user"
            //
            const val USER_USERDETAIL = "$USER/userDetail"
        }
    }
}