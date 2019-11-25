package com.mohammad.githubrepos.presentation.main.settings

import com.mohammad.githubrepos.di.scopes.FragmentScope
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module
abstract class SettingsModule {

    @FragmentScope
    @Binds
    abstract fun bindView(fragment: SettingsFragment):SettingsContract.View

    @Module
    companion object{
        @FragmentScope
        @Provides
        @JvmStatic
        fun providePresenter(view: SettingsContract.View, interactor: SettingsContract.Interactor, logger: ILogger):SettingsContract.Presentor = SettingsPresenterImp(view, interactor, logger)

        @FragmentScope
        @Provides
        @JvmStatic
        fun provideInteractor(contentManager: IContentManager):SettingsContract.Interactor = SettingsInteractor(contentManager)
    }
}