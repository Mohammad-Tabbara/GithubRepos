package com.mohammad.githubrepos.di

import android.content.Context
import com.mohammad.githubrepos.presentation.Constants
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.domain.Iprefs
import com.mohammad.githubrepos.framework.ContentManager
import com.mohammad.githubrepos.framework.Logger
import com.mohammad.githubrepos.framework.Prefs
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

    @Reusable
    @Provides
    fun providePrefs(context: Context): Iprefs = Prefs(context)

    @Singleton
    @Provides
    fun provideContentManager(githubService: GithubService,prefs: Iprefs): IContentManager = ContentManager(githubService,prefs)

    @Singleton
    @Provides
    fun provideLogger(): ILogger = Logger()
}