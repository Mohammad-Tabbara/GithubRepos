package com.mohammad.githubrepos.presentation.main.trending


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager

import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.presentation._common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_trending.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TrendingFragment : BaseFragment(), TrendingContract.View, GitReposAdapter.GitReposAdapterListener {

    companion object{
        fun newInstance():TrendingFragment = TrendingFragment()
    }

    var adapter: GitReposAdapter? = null

    @Inject
    lateinit var presenter: TrendingContract.Presentor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()

    }

    override fun bindData(repos: MutableList<Repo>) {
        adapter = GitReposAdapter(repos,this)
        trendingRepositories.adapter = adapter
        trendingRepositories.layoutManager = LinearLayoutManager(context)

    }

    override fun upDateData() {
        adapter?.updateData()
    }

    override fun loadMoreFailed() {
        adapter?.loadMoreFailed()
    }

    override fun loadMore(offset: Int) {
        presenter.loadMore(offset)
    }


}
