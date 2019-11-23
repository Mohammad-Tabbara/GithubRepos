package com.mohammad.githubrepos.framework.api

import com.mohammad.githubrepos.framework.api.models.RepoWrapper
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {

    @GET("/search/repositories")
    fun getTrendingRepositories(
        @Query("q") query:String,
        @Query("sort") sort: String,
        @Query("order") order: String,
        @Query("page") page: Int): Single<RepoWrapper>
}