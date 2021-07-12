package com.skylabstechke.qhalainterview.viewmodel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.skylabstechke.qhalainterview.data.local.MoviesEntity
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.repository.Repository
import com.skylabstechke.qhalainterview.utils.Common.ERROR_OCCURRED
import com.skylabstechke.qhalainterview.utils.Common.MOVIES_NOT_AVAILABLE
import com.skylabstechke.qhalainterview.utils.Common.NO_INTERNET_CONNECTION
import com.skylabstechke.qhalainterview.utils.Common.TIMEOUT
import com.skylabstechke.qhalainterview.utils.NetWorkVariables
import com.skylabstechke.qhalainterview.utils.NetworkResults
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel @ViewModelInject constructor(
    private val repository: Repository
) : ViewModel() {

    var moviesResponse: MutableLiveData<NetworkResults<MoviesModel>> = MutableLiveData()
    var moviesLocalData: LiveData<List<MoviesEntity>> =
        repository.localRepository.getMovies().asLiveData()

    fun getMovies() = viewModelScope.launch {
        getMoviesSafeCall()
    }

    private fun saveMoviesToRoom(moviesModel: MoviesModel) = viewModelScope.launch(Dispatchers.IO) {
        repository.localRepository.insertMovies(MoviesEntity(moviesModel))
    }

    private suspend fun getMoviesSafeCall() {
        moviesResponse.value = NetworkResults.Loading()
        if (NetWorkVariables.isNetworkConnected) {
            try {
                val response = repository.networkRepository.getMovies()
                moviesResponse.value = handleMoviesResponse(response)

                if (moviesResponse.value!!.data != null) {
                    moviesResponse.value!!.data?.let { saveMoviesToRoom(it) }
                }

            } catch (e: Exception) {
                moviesResponse.value = NetworkResults.Error(ERROR_OCCURRED)
            }

        } else {
            moviesResponse.value = NetworkResults.Error(NO_INTERNET_CONNECTION)
        }
    }

    private fun handleMoviesResponse(response: Response<MoviesModel>): NetworkResults<MoviesModel> {
        return when {
            response.message().toString().contains(TIMEOUT) -> {
                NetworkResults.Error(TIMEOUT)
            }
            response.body()!!.results.isNullOrEmpty() -> {
                NetworkResults.Error(MOVIES_NOT_AVAILABLE)
            }
            response.isSuccessful -> {
                NetworkResults.Success(response.body()!!)
            }
            else -> {
                NetworkResults.Error(response.message())
            }
        }
    }
}