package com.mohammad.githubrepos.presentation.main

import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class MainModule {

    @Binds
    abstract fun bindView(activity: MainActivity):MainContract.View

    @Module
    companion object{
        @Provides
        @JvmStatic
        fun providePresenter(view: MainContract.View, interactor: MainContract.Interactor, logger: ILogger):MainContract.Presentor = MainPresenterImp(view, interactor, logger)

        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager):MainContract.Interactor = MainInteractor(contentManager)
    }
}