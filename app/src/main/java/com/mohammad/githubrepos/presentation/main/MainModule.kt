package com.mohammad.githubrepos.presentation.main

import androidx.lifecycle.ViewModel
import com.mohammad.githubrepos.di.annotations.ActivityScope
import com.mohammad.githubrepos.di.annotations.ViewModelKey

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @ActivityScope
    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}