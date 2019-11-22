package com.mohammad.githubrepos.di

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

@Module
abstract class BaseModule {
    @Binds
    abstract fun provideContext(application: Application): Context
}