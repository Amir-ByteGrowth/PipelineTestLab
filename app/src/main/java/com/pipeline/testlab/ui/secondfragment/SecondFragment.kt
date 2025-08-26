package com.pipeline.testlab.ui.secondfragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.pipeline.testlab.BR
import com.pipeline.testlab.R
import com.pipeline.testlab.baseclasses.BaseFragment
import com.pipeline.testlab.data.models.PostsResponseItem
import com.pipeline.testlab.data.remote.Resource
import com.pipeline.testlab.databinding.LayoutSecondBinding
import com.pipeline.testlab.ui.firstfragment.adapter.PostsRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : BaseFragment<LayoutSecondBinding, SecondViewModel>() {

    override val layoutId: Int
        get() = R.layout.layout_second
    override val viewModel: Class<SecondViewModel>
        get() = SecondViewModel::class.java
    override val bindingVariable: Int
        get() = BR.viewModel



    private lateinit var adapter: PostsRecyclerAdapter
    private var postsList: ArrayList<PostsResponseItem> = ArrayList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel.fetchPostsFromDb()
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialising()

    }

    private fun initialising() {

        adapter = PostsRecyclerAdapter(postsList, object : PostsRecyclerAdapter.ClickItemListener {
            override fun onClicked(position: Int) {

            }

            override fun onProductLiked(position: Int, isLiked: Boolean) {
            }

        })

        mViewDataBinding.recyclerPosts.layoutManager = LinearLayoutManager(requireContext())
        mViewDataBinding.recyclerPosts.adapter = adapter

    }



    //subscribing to network live data
    override fun subscribeToNetworkLiveData() {
        super.subscribeToNetworkLiveData()

        mViewModel.postsData.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    hideProgressBar()
                    it.data?.let {
                        postsList.addAll(it)
                        adapter.notifyDataSetChanged()
                    }

                }

                Resource.Status.LOADING -> {
                    showProgressBar()
                }

                Resource.Status.ERROR -> {
                    hideProgressBar()

                    Snackbar.make(
                        mViewDataBinding.recyclerPosts!!,
                        it.message!!,
                        Snackbar.LENGTH_SHORT
                    )
                        .show()

                }
            }
        })
    }
}