package com.mohammad.githubrepos.presentation.main

import com.mohammad.githubrepos.domain.ILogger

class MainPresenterImp(val view: MainContract.View, val logger: ILogger): MainContract.Presentor {
    override fun onCreate() {
        view.initLayout()
        view.showTrending()
    }

    override fun trendingClicked() {
        view.showTrending()
    }

    override fun settingsClicked() {
        view.showSettings()
    }
}