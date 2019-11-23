package com.mohammad.githubrepos.di

import com.mohammad.githubrepos.presentation.Constants
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.framework.ContentManager
import com.mohammad.githubrepos.framework.Logger
import com.mohammad.githubrepos.framework.api.GithubService
import dagger.Module
import dagger.Provides
import dagger.Reusable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [BaseModule::class])
class AppModule {

    @Reusable
    @Provides
    fun provideGithubApi(): GithubService {
        return Retrofit.Builder()
            .baseUrl(Constants.GITHUB_API)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build().create(GithubService::class.java)
    }

    @Singleton
    @Provides
    fun provideContentManager(githubService: GithubService): IContentManager = ContentManager(githubService)

    @Singleton
    @Provides
    fun provideLogger(): ILogger = Logger()
}