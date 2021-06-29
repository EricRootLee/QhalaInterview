package com.skylabstechke.qhalainterview.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.repository.Repository
import com.skylabstechke.qhalainterview.utils.NetWorkVariables
import com.skylabstechke.qhalainterview.utils.NetworkResults
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber


class MainViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    var moviesResponse: MutableLiveData<NetworkResults<MoviesModel>> = MutableLiveData()

    fun getMovies() = viewModelScope.launch {
        getMoviesSafeCall()
    }

    private suspend fun getMoviesSafeCall() {
        moviesResponse.value = NetworkResults.Loading()
        if (NetWorkVariables.isNetworkConnected) {
            try {

                val response = repository.networkRepository.getMovies()
                moviesResponse.value = handleMoviesResponse(response)

            } catch (e: Exception) {
                moviesResponse.value = NetworkResults.Error("An Error Occurred")
            }

        } else {
            moviesResponse.value = NetworkResults.Error("No Internet Connection")
        }
    }

    private fun handleMoviesResponse(response: Response<MoviesModel>): NetworkResults<MoviesModel> {
        when {
            response.message().toString().contains("timeout") -> {
                return NetworkResults.Error("Timeout")
            }
            response.body()!!.results.isNullOrEmpty() -> {
                return NetworkResults.Error("Movies Not Available")
            }
            response.isSuccessful -> {
                Timber.d("RESPONSE -> ${response.body().toString()}")
                return NetworkResults.Success(response.body()!!)
            }
            else -> {
                return NetworkResults.Error(response.message())
            }
        }
    }
}