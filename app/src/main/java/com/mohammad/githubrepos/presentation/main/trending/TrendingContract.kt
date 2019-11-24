package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener

class TrendingContract {
    interface View {
        fun initLayout(repos: MutableList<Repo>, trendingSpan: Int)
        fun upDateData()
        fun loadMoreFailed()
        fun showLoading()
        fun showData()
        fun showNoNetwork()
    }

    interface Presentor {
        fun onViewCreated()
        fun loadMore(offset: Int)
        fun retryClicked()
    }

    interface Interactor {
        fun getTrendingRepositories(since: String, page: Int, apiListener: ApiListener<RepoWrapper>)
        fun getTrendingSpan(): Int
    }
}