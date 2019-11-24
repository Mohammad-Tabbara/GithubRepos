package com.mohammad.githubrepos.presentation.main.settings

import com.mohammad.githubrepos.domain.IContentManager

class SettingsInteractor(val contentManager: IContentManager): SettingsContract.Interactor {

    override fun setTrendingSpan(trendingSpan: Int) {
        return contentManager.setTrendingSpan(trendingSpan)
    }

    override fun getTrendingSpan(): Int {
        return contentManager.getTrendingSpan()
    }
}