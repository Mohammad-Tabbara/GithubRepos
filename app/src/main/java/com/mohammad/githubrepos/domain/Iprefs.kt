package com.mohammad.githubrepos.domain

interface Iprefs {

    companion object{
        const val GithubRepoPrefs: String = "GITHUB_REPO_PREFS"
        const val TrendingSpan: String = "TRENDING_SPAN"
    }

    fun setTrendingSpan(trendingSpan: Int)
    fun getTrendingSpan(): Int
}