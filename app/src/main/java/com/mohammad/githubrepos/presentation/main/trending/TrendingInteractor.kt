package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener

class TrendingInteractor(val contentManager: IContentManager): TrendingContract.Interactor {
    override fun getTrendingRepositories(since: String, page: Int, apiListener: ApiListener<RepoWrapper>) {
        contentManager.getTrendingRepositories(since,page,apiListener)
    }
}