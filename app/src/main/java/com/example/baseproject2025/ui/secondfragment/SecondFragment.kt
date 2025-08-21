package com.example.baseproject2025.ui.secondfragment

import com.example.baseproject2025.BR
import com.example.baseproject2025.R
import com.example.baseproject2025.baseclasses.BaseFragment
import com.example.baseproject2025.databinding.LayoutSecondBinding

class SecondFragment : BaseFragment<LayoutSecondBinding, SecondViewModel>() {

    override val layoutId: Int
        get() = R.layout.layout_second
    override val viewModel: Class<SecondViewModel>
        get() = SecondViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel
}