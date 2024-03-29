package com.soar.network.retrofit


import com.soar.network.exception.APIException
import com.soar.network.exception.ExceptionEngine
import io.reactivex.Observer
import io.reactivex.disposables.Disposable

/**
 * 继承Subscriber_重写onError方法
 */
abstract class RxObserver<T> : Observer<T> {
    override fun onSubscribe(d: Disposable) {}
    override fun onError(e: Throwable) {
        if (e is APIException)
            onError(e)
        else
            onError(APIException(e, ExceptionEngine.ERROR.DEFAULT_ERROR)
        ) //其他默认code 0001
    }

    override fun onComplete() {}

    /**
     * 自定义错误回调
     */
    protected abstract fun onError(ex: APIException)
}