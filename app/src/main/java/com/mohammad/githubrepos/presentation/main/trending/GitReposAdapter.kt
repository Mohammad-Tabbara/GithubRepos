package com.mohammad.githubrepos.presentation.main.trending

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.presentation._common.custom.PaginationListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.repo_item.view.*

class GitReposAdapter(private val repos: MutableList<Repo>, private val gitReposAdapterListener: GitReposAdapterListener): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    enum class CellName{
        Repo,Loading;
    }


    private val paginationListener = PaginationListener(object : PaginationListener.LoadMore{
        override fun loadMore(offset:Int) {
            gitReposAdapterListener.loadMore(offset)
            notifyItemInserted(repos.size)
        }
    })

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(viewType == CellName.Repo.ordinal){
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.repo_item,parent,false)
            RepoHolder(v)
        }else{
            val v: View = LayoutInflater.from(parent.context).inflate(R.layout.data_loading,parent,false)
            ProgressHolder(v)
        }

    }

    override fun getItemViewType(position: Int): Int {
        return if(position < repos.size) CellName.Repo.ordinal else CellName.Loading.ordinal
    }

    override fun getItemCount(): Int = if(!paginationListener.isLoading) repos.size else repos.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder is RepoHolder) {
            holder.repoName.text = repos[position].name
            holder.repoDescription.text = repos[position].description
            holder.ownerName.text = repos[position].owner.login
            val startCount = repos[position].stars
            val starCountText = if(startCount > 1000) String.format("★ %.1fk",startCount.toFloat().div(1000)) else "★ $startCount"
            holder.starsCount.text = starCountText
            Picasso.get().load(repos[position].owner.avatar_url)
                .into(holder.ownerImage)
        }
    }

    override fun onAttachedToRecyclerView(recyclerView: RecyclerView) {
        super.onAttachedToRecyclerView(recyclerView)
        recyclerView.addOnScrollListener(paginationListener)
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        recyclerView.removeOnScrollListener(paginationListener)
    }

    fun updateData() {
        paginationListener.isLoading = false
        notifyItemRemoved(repos.size)
        if(itemCount < repos.size) {
            notifyItemRangeInserted(itemCount, repos.size)
        }
    }

    fun loadMoreFailed() {
        paginationListener.isLoading = false
        notifyItemRemoved(repos.size)
    }

    inner class RepoHolder(itemView:View): RecyclerView.ViewHolder(itemView){
        val repoName: TextView = itemView.repoName
        val repoDescription: TextView = itemView.repoDescription
        val ownerName: TextView = itemView.ownerName
        val starsCount: TextView = itemView.starsCount
        val ownerImage: ImageView = itemView.ownerImage
    }
    inner class ProgressHolder(itemView:View): RecyclerView.ViewHolder(itemView)

    interface GitReposAdapterListener{
        fun loadMore(offset: Int)
    }
}