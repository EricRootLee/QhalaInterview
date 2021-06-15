package com.skylabstechke.qhalainterview.application

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.skylabstechke.qhalainterview.utils.NetworkMonitor
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class QhalaInterview : Application() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate() {
        super.onCreate()
        NetworkMonitor(this).startNetWorkCallback()
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onTerminate() {
        super.onTerminate()
        NetworkMonitor(this).stopNetworkCallback()
    }
}