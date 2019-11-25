package com.mohammad.githubrepos.presentation.main

import com.mohammad.githubrepos.di.scopes.ActivityScope
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainModule {

    @ActivityScope
    @Binds
    abstract fun bindView(activity: MainActivity):MainContract.View

    @Module
    companion object{
        @ActivityScope
        @Provides
        @JvmStatic
        fun providePresenter(view: MainContract.View, interactor: MainContract.Interactor, logger: ILogger):MainContract.Presentor = MainPresenterImp(view, interactor, logger)

        @ActivityScope
        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager):MainContract.Interactor = MainInteractor(contentManager)
    }
}