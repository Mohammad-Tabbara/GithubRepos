package com.mohammad.githubrepos.presentation.main.trending


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.di.factory.DaggerViewModelFactory
import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.presentation._common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_trending.*
import kotlinx.android.synthetic.main.no_network_connection.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TrendingFragment : BaseFragment(), GitReposAdapter.GitReposAdapterListener {

    companion object{
        fun newInstance():TrendingFragment = TrendingFragment()
    }

    var adapter: GitReposAdapter? = null

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    lateinit var viewModel: TrendingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(TrendingViewModel::class.java)
        viewModel.onViewCreated()
        initObservers()
    }

    fun initObservers(){
        viewModel.init.observe(this, Observer {trendingSpan ->
            initLayout(trendingSpan)
        })
        viewModel.dataStates.observe(this, Observer { ordinal ->
            when(TrendingViewModel.FetchData.values()[ordinal]){
                TrendingViewModel.FetchData.Load -> {
                    showLoading()
                }
                TrendingViewModel.FetchData.Success -> {
                    showData()
                }
                TrendingViewModel.FetchData.Fail -> {
                    showNoNetwork()
                }
                TrendingViewModel.FetchData.FailLoadMore -> {
                    loadMoreFailed()
                }
            }
        })
        viewModel.repos.observe(this, Observer {repos ->
            loadData(repos)
        })
    }

    private fun initLayout(trendingSpan: Int) {
        activity?.title = String.format(getString(R.string.trending_title),trendingSpan)
        retryButton.setOnClickListener {
            viewModel.retryClicked()
        }
    }

    private fun showLoading(){
        trendingProgressbar.visibility = View.VISIBLE
        trendingRepositories.visibility = View.GONE
        noNetwork.visibility = View.GONE
    }

    private fun showData(){
        trendingProgressbar.visibility = View.GONE
        trendingRepositories.visibility = View.VISIBLE
        noNetwork.visibility = View.GONE
    }

    private fun showNoNetwork(){
        trendingProgressbar.visibility = View.GONE
        trendingRepositories.visibility = View.GONE
        noNetwork.visibility = View.VISIBLE
    }

    private fun loadMoreFailed(){
        adapter?.loadMoreFailed()
    }

    private fun loadData(repos: MutableList<Repo>) {
        adapter?.updateData()?: run {
            adapter = GitReposAdapter(repos,this)
            trendingRepositories.adapter = adapter
            trendingRepositories.layoutManager = LinearLayoutManager(context)
        }
    }


    override fun loadMore(offset: Int) {
        viewModel.loadMore(offset)
    }


}
