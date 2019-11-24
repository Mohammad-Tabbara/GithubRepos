package com.mohammad.githubrepos.presentation.main.settings

import com.mohammad.githubrepos.domain.ILogger

class SettingsPresenterImp(val view: SettingsContract.View, val interactor: SettingsContract.Interactor, val logger: ILogger): SettingsContract.Presentor {
    override fun onViewCreated() {
        view.initLayout(interactor.getTrendingSpan())
    }

    override fun onTrendingSpanItemSelected(selectedItem: Int) {
        interactor.setTrendingSpan(selectedItem)
    }
}