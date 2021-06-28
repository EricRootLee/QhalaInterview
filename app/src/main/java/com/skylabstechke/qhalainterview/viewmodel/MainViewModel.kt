package com.skylabstechke.qhalainterview.viewmodel

import androidx.lifecycle.*
import com.skylabstechke.qhalainterview.data.models.MoviesModel
import com.skylabstechke.qhalainterview.data.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    //var moviesResponse : LiveData<Response<MoviesModel>> = repository.networkRepository.getMovies().asLiveData()

    fun getMovies() :LiveData<MoviesModel>  =
       liveData(Dispatchers.IO) {
           emit()
       }

}