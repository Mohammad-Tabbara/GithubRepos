package com.mohammad.githubrepos.framework

import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.framework.api.GithubService
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ContentManager(private val service: GithubService): IContentManager {
    override fun getTrendingRepositories(since: String, page: Int, apiListener: ApiListener<RepoWrapper>) {
        subscribe(service.getTrendingRepositories(since,"stars","desc",page),apiListener)
    }

    private fun <T: Any> subscribe(single: Single<T>, listener: ApiListener<T>){
        single.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(listener)
    }
}