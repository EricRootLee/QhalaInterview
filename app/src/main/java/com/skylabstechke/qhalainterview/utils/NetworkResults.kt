package com.skylabstechke.qhalainterview.utils

sealed class NetworkResults<T>(
    val data: T? = null,
    val message: String? = null
) {

    class Success<T>(data: T?) : NetworkResults<T>(data)
    class Error<T>(message: String?) : NetworkResults<T>(message = message)
    class Loading<T> : NetworkResults<T>()
}
