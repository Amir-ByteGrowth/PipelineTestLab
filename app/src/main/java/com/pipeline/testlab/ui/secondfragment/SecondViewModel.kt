package com.pipeline.testlab.ui.secondfragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.pipeline.testlab.baseclasses.BaseViewModel
import com.pipeline.testlab.data.models.PostsResponse
import com.pipeline.testlab.data.remote.Resource
import com.pipeline.testlab.data.remote.reporitory.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SecondViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : BaseViewModel() {

    private val _posts = MutableLiveData<Resource<PostsResponse>>()
    val postsData: LiveData<Resource<PostsResponse>>
        get() = _posts

    fun fetchPostsFromDb() {
        viewModelScope.launch {
            _posts.postValue(Resource.loading(null))
            delay(2000)
            mainRepository.getPosts().let {
                _posts.postValue(it)
            }


        }
    }
}