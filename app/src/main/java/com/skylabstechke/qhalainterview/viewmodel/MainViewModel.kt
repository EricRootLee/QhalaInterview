package com.skylabstechke.qhalainterview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import com.skylabstechke.qhalainterview.data.repository.Repository
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {
}