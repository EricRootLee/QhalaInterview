package com.skylabstechke.qhalainterview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skylabstechke.qhalainterview.data.repository.Repository
import com.skylabstechke.qhalainterview.models.MoviesModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val moviesResponse = MutableLiveData<Response<MoviesModel>>()

    fun  getMovies = viewModelScope.launch {

    }
}