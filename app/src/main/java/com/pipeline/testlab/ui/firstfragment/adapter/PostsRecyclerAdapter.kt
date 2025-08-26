package com.pipeline.testlab.ui.firstfragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.pipeline.testlab.R
import com.pipeline.testlab.data.models.PostsResponseItem


class PostsRecyclerAdapter(
    val list: List<PostsResponseItem>,
    private val listener: ClickItemListener? = null
) :
    RecyclerView.Adapter<PostsRecyclerAdapter.PostsViewHolder>() {

    interface ClickItemListener {
        fun onClicked(position: Int)
        fun onProductLiked(position: Int, isLiked: Boolean)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return PostsViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {

        holder.bind(position)




    }

    override fun getItemCount(): Int = list.size


    inner class PostsViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_recyclerview, parent, false)) {
        private var tv_postsId: TextView? = null
        private var tv_title: TextView? = null
        private var tv_body: TextView? = null
        private var tv_userId: TextView? = null
        var mLikeButton: Button? = null
        var linearlayout: LinearLayout? = null


        init {
            tv_postsId = itemView.findViewById(R.id.tv_postsId)
            tv_title = itemView.findViewById(R.id.tv_title)
            tv_body = itemView.findViewById(R.id.tv_body)
            tv_userId = itemView.findViewById(R.id.tv_userId)
            linearlayout = itemView.findViewById(R.id.linearlayout)
            mLikeButton = itemView.findViewById(R.id.mLikeButton)
        }

        fun bind(position: Int) {
            val post: PostsResponseItem = list[position]
            tv_postsId?.text = "Post id : " + post.id.toString()
            tv_userId?.text = "User id : " + post.userId.toString()
            tv_body?.text = "Body : " + post.body
            tv_title?.text = "Title : " + post.title

            linearlayout!!.setOnClickListener { listener?.onClicked(position) }

            mLikeButton!!.setOnClickListener { listener?.onProductLiked(position, true) }
        }

    }
}
