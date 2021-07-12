package com.skylabstechke.qhalainterview.utils

import android.util.Log
import timber.log.Timber
import kotlin.properties.Delegates

object NetWorkVariables {

    var isNetworkConnected : Boolean by Delegates.observable(false){
            _, _, newValue ->
        Timber.i("Network connectivity $newValue")
    }

}