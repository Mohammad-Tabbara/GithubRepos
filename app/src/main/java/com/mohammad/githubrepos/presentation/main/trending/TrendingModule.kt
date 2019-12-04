package com.mohammad.githubrepos.presentation.main.trending

import androidx.lifecycle.ViewModel
import com.mohammad.githubrepos.di.annotations.FragmentScope
import com.mohammad.githubrepos.di.annotations.ViewModelKey
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
class TrendingModule {

    @FragmentScope
    @Provides
    @IntoMap
    @ViewModelKey(TrendingViewModel::class)
    fun provideViewModel(interactor: TrendingContract.Interactor, logger: ILogger): ViewModel = TrendingViewModel(interactor, logger)

    @FragmentScope
    @Provides
    fun provideInteractor(contentManager: IContentManager):TrendingContract.Interactor = TrendingInteractor(contentManager)
}