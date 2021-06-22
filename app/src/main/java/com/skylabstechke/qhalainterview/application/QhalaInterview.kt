package com.skylabstechke.qhalainterview.application

import android.app.Application
import android.os.Build
import androidx.annotation.RequiresApi
import com.facebook.stetho.Stetho
import com.skylabstechke.qhalainterview.utils.NetworkMonitor
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class QhalaInterview : Application() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate() {
        super.onCreate()
        //start network monitor
        NetworkMonitor(this).startNetWorkCallback()
        //plant timber
        Timber.plant(Timber.DebugTree())
        //init stetho
        Stetho.initializeWithDefaults(this)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onTerminate() {
        super.onTerminate()
        NetworkMonitor(this).stopNetworkCallback()
    }
}