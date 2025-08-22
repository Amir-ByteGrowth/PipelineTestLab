package com.pipeline.testlab.ui.secondfragment

import com.pipeline.testlab.BR
import com.pipeline.testlab.R
import com.pipeline.testlab.baseclasses.BaseFragment
import com.pipeline.testlab.databinding.LayoutSecondBinding

class SecondFragment : BaseFragment<LayoutSecondBinding, SecondViewModel>() {

    override val layoutId: Int
        get() = R.layout.layout_second
    override val viewModel: Class<SecondViewModel>
        get() = SecondViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel
}