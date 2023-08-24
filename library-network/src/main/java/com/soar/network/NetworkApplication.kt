package com.soar.network

import android.app.Application
import android.content.Context

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
class NetworkApplication :Application(){
    companion object{
        lateinit var context: Context
        lateinit var instance:Application
    }


    override fun onCreate() {
        super.onCreate()
        init()
    }

    private fun init() {
        instance = this
        context = getApplicationContext()
    }
}