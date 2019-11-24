package com.mohammad.githubrepos.presentation.main.settings

class SettingsContract {
    interface View {
        fun initLayout(trendingSpan: Int)
    }

    interface Presentor {
        fun onViewCreated()
        fun onTrendingSpanItemSelected(selectedItem: Int)
    }

    interface Interactor {
        fun setTrendingSpan(trendingSpan: Int)
        fun getTrendingSpan(): Int
    }
}