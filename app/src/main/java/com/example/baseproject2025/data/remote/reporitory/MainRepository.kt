package com.example.baseproject2025.data.remote.reporitory

import com.example.baseproject2025.data.local.db.AppDao
import com.example.baseproject2025.data.remote.ApiService
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    localDataSource: AppDao
) {

    suspend fun getPosts() = apiService.getPosts()

}