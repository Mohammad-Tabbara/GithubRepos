package com.mohammad.githubrepos.di

import com.mohammad.githubrepos.di.annotations.ActivityScope
import com.mohammad.githubrepos.presentation.main.MainActivity
import com.mohammad.githubrepos.presentation.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, ViewModelFactoryModule::class, FragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity
}