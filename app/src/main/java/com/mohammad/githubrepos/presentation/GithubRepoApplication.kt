package com.mohammad.githubrepos.presentation

import com.mohammad.githubrepos.di.AppModule
import com.mohammad.githubrepos.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class GithubRepoApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent
        .builder().application(this).appModule(AppModule()).build()
}