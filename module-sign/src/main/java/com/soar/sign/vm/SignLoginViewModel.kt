package com.soar.sign.vm

import android.app.Application
import android.util.Log
import com.soar.cloud.bean.NaviBean
import com.soar.cloud.retrofit.APIMain
import com.soar.cloud.retrofit.ServerResultFunc
import com.soar.commonui.base.BaseViewModel
import com.soar.network.exception.APIException
import com.soar.network.exception.ExceptionEngine
import com.soar.network.exception.HttpResultFunc
import com.soar.network.retrofit.RetrofitClient
import com.soar.network.retrofit.RxObserver
import io.reactivex.Observable

/**
 * NAME：YONG_
 * Created at: 2023/8/24 17
 * Describe:
 */
class SignLoginViewModel(application: Application) : BaseViewModel(application) {

    fun getNaviJson(){
        val observable: Observable<List<NaviBean>> =
            RetrofitClient.getApi(APIMain.API_PLAY_ANDROID)!!.getNaviJson()!!
                .map(ServerResultFunc())
                .onErrorResumeNext(HttpResultFunc())
        RetrofitClient.toSubscribe(getLifecycleProvider(),observable,object : RxObserver<List<NaviBean>>(){
            override fun onError(ex: APIException) {
                Log.i("SignLoginViewModel", "onError: " + ex.message)

                if (ex.code == ExceptionEngine.ERROR.ERROR_NET)
                    uiLiveData.toastEvent.show(ex.displayMessage)
            }

            override fun onNext(t: List<NaviBean>) {
                Log.i("SignLoginViewModel", "onNext: $t")
            }

        })
    }
}