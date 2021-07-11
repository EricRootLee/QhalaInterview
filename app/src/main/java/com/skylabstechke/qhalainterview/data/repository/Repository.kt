package com.skylabstechke.qhalainterview.data.repository

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class Repository @Inject constructor(
    private val networkDatasource: NetworkDatasource,
    private val localDatasource: LocalDatasource
) {

    val networkRepository = networkDatasource
    val localRepository = localDatasource

}