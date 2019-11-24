package com.mohammad.githubrepos.domain

import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener

interface IContentManager {
    fun getTrendingRepositories(since: String, page: Int, apiListener: ApiListener<RepoWrapper>)
}