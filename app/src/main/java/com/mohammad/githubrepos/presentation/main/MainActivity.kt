package com.mohammad.githubrepos.presentation.main

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.di.factory.DaggerViewModelFactory
import com.mohammad.githubrepos.presentation._common.base.BaseActivity
import com.mohammad.githubrepos.presentation.main.settings.SettingsFragment
import com.mohammad.githubrepos.presentation.main.trending.TrendingFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity() {

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    lateinit var  viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this, this.viewModelFactory).get(MainViewModel::class.java)
        viewModel.onCreate()
        initObservers()
        initLayout()
    }

    private fun initObservers(){
        viewModel.bottomBarNavigation.observe(this, Observer { ordinal ->

            when(MainViewModel.BottomNavigation.values()[ordinal]){
                MainViewModel.BottomNavigation.Trending -> {
                    showTrending()
                }
                MainViewModel.BottomNavigation.Settings -> {
                    showSettings()
                }
            }
        })
    }

    private fun initLayout() {
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.trending -> {
                    viewModel.trendingClicked()
                    true
                }
                R.id.settings -> {
                    viewModel.settingsClicked()
                    true
                }
                else -> false
            }
        }
    }

    private fun showTrending(){
        supportFragmentManager.inTransaction {
            add(R.id.container, TrendingFragment.newInstance())
        }
    }

    private fun showSettings(){
        supportFragmentManager.inTransaction {
            add(R.id.container, SettingsFragment.newInstance())
        }
    }
}
