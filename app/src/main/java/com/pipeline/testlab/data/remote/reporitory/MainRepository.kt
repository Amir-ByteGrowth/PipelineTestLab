package com.pipeline.testlab.data.remote.reporitory

import com.pipeline.testlab.data.local.db.AppDao
import com.pipeline.testlab.data.models.PostsResponse
import com.pipeline.testlab.data.remote.ApiService
import com.pipeline.testlab.data.remote.Resource
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: AppDao
) {

    suspend fun getPosts(): Resource<PostsResponse> {

        apiService.getPosts().let { response ->
            if (response.isSuccessful) {
                response.body()?.let {
                    it.map { movie ->
                        localDataSource.insertMovies(it)
                    }


                    return Resource.success(it)
                }
            }
            return Resource.error(response.message(), null)

        }

    }

}