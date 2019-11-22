package com.mohammad.githubrepos.di

import com.mohammad.githubrepos.domain.IContentManager
import com.mohammad.githubrepos.domain.ILogger
import com.mohammad.githubrepos.framework.ContentManager
import com.mohammad.githubrepos.framework.Logger
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [BaseModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideContentManager(): IContentManager = ContentManager()

    @Singleton
    @Provides
    fun provideLogger(): ILogger = Logger()
}