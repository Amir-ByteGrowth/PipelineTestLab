package com.example.baseproject2025.data.remote

import javax.inject.Inject

class ApiHelper @Inject constructor(
    private val apiService: ApiService
) {

    suspend fun getUsers() = apiService.getPosts()
}