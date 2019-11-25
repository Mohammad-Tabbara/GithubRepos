package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener
import io.reactivex.disposables.CompositeDisposable
import java.text.SimpleDateFormat
import java.util.*

class TrendingPresenterImp(val view: TrendingContract.View, val interactor: TrendingContract.Interactor, val logger: ILogger): TrendingContract.Presentor {

    var pageSize: Int = 30
    private var since: String = "created:>2017-10-22"
    val repos : MutableList<Repo> = mutableListOf()

    val compositeDisposable = CompositeDisposable()

    override fun onViewCreated() {
        view.initLayout(repos, interactor.getTrendingSpan())
        initSince()
        fetchTrending()
    }

    override fun loadMore(offset: Int) {
        val pageNumber = offset/pageSize + 1
        val loadMore = object : ApiListener<RepoWrapper>() {
            override fun onSuccess(repoWrapper: RepoWrapper) {
                repos.addAll(repoWrapper.repos)
                view.upDateData()
            }

            override fun onError(e: Throwable) {
                view.loadMoreFailed()
                logger.e(e)
            }

        }
        compositeDisposable.add(loadMore)
        interactor.getTrendingRepositories(since,pageNumber,loadMore)
    }

    override fun retryClicked() {
        fetchTrending()
    }

    override fun onDestroy() {
        compositeDisposable.clear()
    }

    private fun initSince(){
        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_YEAR,-interactor.getTrendingSpan())
        val date = c.time
        val dateTimeFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        since = "created:>" + dateTimeFormatter.format(date)
    }

    private fun fetchTrending(){
        view.showLoading()
        val fetchTrending = object : ApiListener<RepoWrapper>() {
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

        }
        compositeDisposable.add(fetchTrending)
        interactor.getTrendingRepositories(since,1,fetchTrending)
    }
}