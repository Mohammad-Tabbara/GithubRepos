package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.di.scopes.FragmentScope
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class TrendingModule {

    @FragmentScope
    @Binds
    abstract fun bindView(fragment: TrendingFragment):TrendingContract.View

    @Module
    companion object{
        @FragmentScope
        @Provides
        @JvmStatic
        fun providePresenter(view: TrendingContract.View, interactor: TrendingContract.Interactor, logger: ILogger):TrendingContract.Presentor = TrendingPresenterImp(view, interactor, logger)

        @FragmentScope
        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager):TrendingContract.Interactor = TrendingInteractor(contentManager)
    }
}