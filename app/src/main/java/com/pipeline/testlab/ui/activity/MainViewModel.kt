package com.pipeline.testlab.ui.activity

//import androidx.hilt.lifecycle.ViewModelInject
import com.pipeline.testlab.utils.NetworkHelper
import com.pipeline.testlab.baseclasses.BaseViewModel
import com.pipeline.testlab.data.remote.reporitory.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : BaseViewModel() {


}
