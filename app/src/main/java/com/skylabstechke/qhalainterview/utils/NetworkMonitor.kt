package com.skylabstechke.qhalainterview.utils

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkRequest
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.RequiresPermission
import timber.log.Timber

class NetworkMonitor
@RequiresPermission(android.Manifest.permission.ACCESS_NETWORK_STATE)
constructor(private val application: Application) {

    private val networkCallback = @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    object : ConnectivityManager.NetworkCallback() {

        override fun onAvailable(network: Network) {
            NetWorkVariables.isNetworkConnected = true
            Timber.i("Network Available")
        }

        override fun onLosing(network: Network, maxMsToLive: Int) {
            NetWorkVariables.isNetworkConnected = false
            Timber.i("Network Lost")
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun startNetWorkCallback() {
        val cm: ConnectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val builder: NetworkRequest.Builder = NetworkRequest.Builder()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            cm.registerDefaultNetworkCallback(networkCallback)
        } else {
            cm.registerNetworkCallback(builder.build(), networkCallback)
        }

    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun stopNetworkCallback() {
        val cm: ConnectivityManager =
            application.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        cm.unregisterNetworkCallback(ConnectivityManager.NetworkCallback())
    }
}