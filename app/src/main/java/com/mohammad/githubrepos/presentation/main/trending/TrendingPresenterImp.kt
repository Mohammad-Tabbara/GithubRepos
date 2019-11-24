package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener
import java.text.SimpleDateFormat
import java.util.*

class TrendingPresenterImp(val view: TrendingContract.View, val interactor: TrendingContract.Interactor, val logger: ILogger): TrendingContract.Presentor {

    var pageSize: Int = 30
    private var since: String = "created:>2017-10-22"
    val repos : MutableList<Repo> = mutableListOf()

    override fun onViewCreated() {
        view.initLayout(repos)
        initSince()
        fetchTrending()
    }

    override fun loadMore(offset: Int) {
        val pageNumber = offset/pageSize + 1
        interactor.getTrendingRepositories(since,pageNumber,object : ApiListener<RepoWrapper>(){
            override fun onSuccess(repoWrapper: RepoWrapper) {
                repos.addAll(repoWrapper.repos)
                view.upDateData()
            }

            override fun onError(e: Throwable) {
                view.loadMoreFailed()
                logger.e(e)
            }

        })
    }

    override fun retryClicked() {
        fetchTrending()
    }

    private fun initSince(){
        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_YEAR,-30)
        val date = c.time
        val dateTimeFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        since = "created:>" + dateTimeFormatter.format(date)
    }

    private fun fetchTrending(){
        view.showLoading()
        interactor.getTrendingRepositories(since,1,object : ApiListener<RepoWrapper>(){
            override fun onSuccess(repoWrapper: RepoWrapper) {
                pageSize = repoWrapper.repos.size
                repos.addAll(repoWrapper.repos)
                view.showData()
                view.upDateData()
            }

            override fun onError(e: Throwable) {
                view.showNoNetwork()
                logger.e(e)
            }

        })
    }
}