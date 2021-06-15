package com.skylabstechke.qhalainterview.utils

import android.util.Log
import kotlin.properties.Delegates

object NetWorkVariables {

    var isNetworkConnected : Boolean by Delegates.observable(false){
        property, oldValue, newValue ->
        Log.i("Network connectivity" , "$newValue")
    }

}