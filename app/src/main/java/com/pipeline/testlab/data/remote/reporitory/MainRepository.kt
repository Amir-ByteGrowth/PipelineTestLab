package com.pipeline.testlab.data.remote.reporitory

import com.pipeline.testlab.data.local.db.AppDao
import com.pipeline.testlab.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    localDataSource: AppDao
) {

    suspend fun getPosts() = apiService.getPosts()

}