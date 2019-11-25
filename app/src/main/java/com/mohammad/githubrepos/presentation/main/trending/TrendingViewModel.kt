package com.mohammad.githubrepos.presentation.main.trending

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.framework.api.models.Repo
import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import com.mohammad.githubrepos.presentation._common.rxjava.ApiListener
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class TrendingViewModel @Inject constructor(private val interactor: TrendingContract.Interactor, private val logger: ILogger): ViewModel() {

    enum class FetchData{
        Load, Success, Fail, FailLoadMore
    }

    var pageSize: Int = 30
    private var since: String = "created:>2017-10-22"

    val init = InitLiveData()
    val dataStates = DataStatesLiveData()
    val repos  = ReposLiveData()

    fun onViewCreated() {
        init.sendAction(interactor.getTrendingSpan())
        repos.sendAction(mutableListOf())
        initSince()
        fetchTrending()
    }

    fun loadMore(offset: Int) {
        val pageNumber = offset/pageSize + 1
        interactor.getTrendingRepositories(since,pageNumber,object : ApiListener<RepoWrapper>(){
            override fun onSuccess(repoWrapper: RepoWrapper) {
                repos.sendAction(repoWrapper.repos)
                dataStates.sendAction(FetchData.Success.ordinal)
            }

            override fun onError(e: Throwable) {
                dataStates.sendAction(FetchData.FailLoadMore.ordinal)
                logger.e(e)
            }

        })
    }

    fun retryClicked() {
        fetchTrending()
    }

    private fun initSince(){
        val c = Calendar.getInstance()
        c.add(Calendar.DAY_OF_YEAR,-interactor.getTrendingSpan())
        val date = c.time
        val dateTimeFormatter = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        since = "created:>" + dateTimeFormatter.format(date)
    }

    private fun fetchTrending(){
        dataStates.sendAction(FetchData.Load.ordinal)
        interactor.getTrendingRepositories(since,1,object : ApiListener<RepoWrapper>(){
            override fun onSuccess(repoWrapper: RepoWrapper) {
                pageSize = repoWrapper.repos.size
                repos.sendAction(repoWrapper.repos)

                dataStates.sendAction(FetchData.Success.ordinal)
            }

            override fun onError(e: Throwable) {
                dataStates.sendAction(FetchData.Fail.ordinal)
                logger.e(e)
            }

        })
    }

    class InitLiveData: LiveData<Int>(){
        @MainThread
        fun sendAction(data: Int) {
            value = data
        }
    }

    class ReposLiveData: LiveData<MutableList<Repo>>(){
        @MainThread
        fun sendAction(data: List<Repo>) {
            value?.addAll(data)?: run {
                value = mutableListOf()
                value?.addAll(data)
            }
            this.value = value //Had To Trigger Action
        }
    }

    class DataStatesLiveData: LiveData<Int>(){
        @MainThread
        fun sendAction(data: Int) {
            value = data
        }
    }
}