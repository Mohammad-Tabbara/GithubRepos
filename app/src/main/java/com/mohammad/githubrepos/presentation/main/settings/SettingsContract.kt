package com.mohammad.githubrepos.presentation.main.settings

class SettingsContract {
    interface Interactor {
        fun setTrendingSpan(trendingSpan: Int)
        fun getTrendingSpan(): Int
    }
}