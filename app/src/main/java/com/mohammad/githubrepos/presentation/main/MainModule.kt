package com.mohammad.githubrepos.presentation.main

import androidx.lifecycle.ViewModel
import com.mohammad.githubrepos.di.annotations.ViewModelKey
import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class MainModule {

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMyViewModel(mainViewModel: MainViewModel): ViewModel
}