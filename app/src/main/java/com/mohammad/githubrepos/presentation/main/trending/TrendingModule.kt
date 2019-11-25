package com.mohammad.githubrepos.presentation.main.trending

import androidx.lifecycle.ViewModel
import com.mohammad.githubrepos.di.annotations.ViewModelKey
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class TrendingModule {

    @Module
    companion object{
        @Provides
        @IntoMap
        @ViewModelKey(TrendingViewModel::class)
        @JvmStatic
        fun provideViewModel(interactor: TrendingContract.Interactor, logger: ILogger): ViewModel = TrendingViewModel(interactor, logger)

        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager):TrendingContract.Interactor = TrendingInteractor(contentManager)
    }
}