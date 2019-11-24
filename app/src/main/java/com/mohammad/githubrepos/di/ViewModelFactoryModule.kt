package com.mohammad.githubrepos.di

import androidx.lifecycle.ViewModelProvider
import com.mohammad.githubrepos.di.factory.DaggerViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {
    @Binds
    abstract fun bindViewModelFactory(viewModelFactory: DaggerViewModelFactory): ViewModelProvider.Factory
}