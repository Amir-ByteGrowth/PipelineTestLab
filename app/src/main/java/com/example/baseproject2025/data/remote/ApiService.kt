package com.example.baseproject2025.data.remote


import com.example.baseproject2025.data.models.PostsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("posts")
    suspend fun getPosts(): Response<PostsResponse>
}