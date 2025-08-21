package com.example.baseproject2025.ui.activity

//import androidx.hilt.lifecycle.ViewModelInject
import com.example.baseproject2025.utils.NetworkHelper
import com.example.baseproject2025.baseclasses.BaseViewModel
import com.example.baseproject2025.data.remote.reporitory.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {


}
