package com.mohammad.githubrepos.presentation.main.trending

import com.mohammad.githubrepos.di.scopes.FragmentScope
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [TrendingProviders::class])
abstract class TrendingModule {

    @FragmentScope
    @Binds
    abstract fun bindView(fragment: TrendingFragment):TrendingContract.View

}

@Module
object TrendingProviders{
    @FragmentScope
    @Provides
    fun providePresenter(view: TrendingContract.View, interactor: TrendingContract.Interactor, logger: ILogger):TrendingContract.Presentor = TrendingPresenterImp(view, interactor, logger)

    @FragmentScope
    @Provides
    fun provideInteractor(contentManager: IContentManager):TrendingContract.Interactor = TrendingInteractor(contentManager)
}