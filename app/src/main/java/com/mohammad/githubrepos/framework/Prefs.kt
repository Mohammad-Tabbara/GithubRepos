package com.mohammad.githubrepos.framework

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.mohammad.githubrepos.domain.Iprefs


class Prefs(private val context: Context) : Iprefs {
    override fun setTrendingSpan(trendingSpan: Int) {
        val editor: SharedPreferences.Editor = context.getSharedPreferences(Iprefs.GithubRepoPrefs, MODE_PRIVATE).edit()
        editor.putInt(Iprefs.TrendingSpan, trendingSpan)
        editor.apply()
    }

    override fun getTrendingSpan(): Int {
        val prefs: SharedPreferences = context.getSharedPreferences(Iprefs.GithubRepoPrefs, MODE_PRIVATE)
        return prefs.getInt(Iprefs.TrendingSpan, 30)
    }
}