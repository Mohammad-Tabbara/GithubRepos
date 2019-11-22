package com.mohammad.githubrepos.presentation.main

import com.mohammad.githubrepos.domain.ILogger

class MainPresenterImp(val view: MainContract.View, val interactor: MainContract.Interactor, val logger: ILogger): MainContract.Presentor {
    override fun onCreate() {
        view.initLayout()
        view.showTrending()
    }

    override fun trendingClick() {
        view.showTrending()
    }

    override fun settingsClick() {
        view.showSettings()
    }
}