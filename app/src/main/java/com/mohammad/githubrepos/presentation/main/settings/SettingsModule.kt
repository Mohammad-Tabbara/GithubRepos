package com.mohammad.githubrepos.presentation.main.settings

import androidx.lifecycle.ViewModel
import com.mohammad.githubrepos.di.annotations.ViewModelKey
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.presentation.main.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class SettingsModule {

    @Module
    companion object{

        @Provides
        @IntoMap
        @ViewModelKey(SettingsViewModel::class)
        @JvmStatic
        fun bindSettingsViewModel(interactor: SettingsContract.Interactor): ViewModel = SettingsViewModel(interactor)

        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager):SettingsContract.Interactor = SettingsInteractor(contentManager)
    }
}