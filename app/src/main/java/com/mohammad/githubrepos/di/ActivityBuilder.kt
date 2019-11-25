package com.mohammad.githubrepos.di

import com.mohammad.githubrepos.di.scopes.ActivityScope
import com.mohammad.githubrepos.presentation.main.MainActivity
import com.mohammad.githubrepos.presentation.main.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainModule::class, FragmentBuilder::class])
    abstract fun bindMainActivity(): MainActivity
}