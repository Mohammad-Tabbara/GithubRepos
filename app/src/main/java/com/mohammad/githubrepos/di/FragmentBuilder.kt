package com.mohammad.githubrepos.di

import com.mohammad.githubrepos.di.annotations.FragmentScope
import com.mohammad.githubrepos.presentation.main.settings.SettingsFragment
import com.mohammad.githubrepos.presentation.main.settings.SettingsModule
import com.mohammad.githubrepos.presentation.main.trending.TrendingFragment
import com.mohammad.githubrepos.presentation.main.trending.TrendingModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilder{

    @FragmentScope
    @ContributesAndroidInjector(modules = [TrendingModule::class])
    abstract fun bindTrendingFragment(): TrendingFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [SettingsModule::class])
    abstract fun bindSettingsFragment(): SettingsFragment
}