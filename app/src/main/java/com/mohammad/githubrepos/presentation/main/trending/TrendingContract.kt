package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener

class TrendingContract {
    interface View {
        fun bindData(repos: MutableList<Repo>)
        fun upDateData()
        fun loadMoreFailed()
    }

    interface Presentor {
        fun onViewCreated()
        fun loadMore(offset: Int)
    }

    interface Interactor {
        fun getTrendingRepositories(since: String, page: Int, apiListener: ApiListener<RepoWrapper>)
    }
}