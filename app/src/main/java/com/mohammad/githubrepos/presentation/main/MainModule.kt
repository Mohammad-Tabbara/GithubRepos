package com.mohammad.githubrepos.presentation.main

import com.mohammad.githubrepos.di.scopes.ActivityScope
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [MainProviders::class])
abstract class MainModule {

    @ActivityScope
    @Binds
    abstract fun bindView(activity: MainActivity):MainContract.View

}

@Module
object MainProviders{
    @ActivityScope
    @Provides
    fun providePresenter(view: MainContract.View, logger: ILogger):MainContract.Presentor = MainPresenterImp(view, logger)
}