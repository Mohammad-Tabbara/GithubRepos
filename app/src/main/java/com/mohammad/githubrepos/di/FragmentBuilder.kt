package com.mohammad.githubrepos.di

import com.mohammad.githubrepos.presentation.main.settings.SettingsFragment
import com.mohammad.githubrepos.presentation.main.settings.SettingsModule
import com.mohammad.githubrepos.presentation.main.trending.TrendingFragment
import com.mohammad.githubrepos.presentation.main.trending.TrendingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder{
    @ContributesAndroidInjector(modules = [TrendingModule::class])
    abstract fun bindTrendingFragment(): TrendingFragment

    @ContributesAndroidInjector(modules = [SettingsModule::class])
    abstract fun bindSettingsFragment(): SettingsFragment
}