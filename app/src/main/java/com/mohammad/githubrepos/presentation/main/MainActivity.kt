package com.mohammad.githubrepos.presentation.main

import android.os.Bundle
import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.presentation._common.base.BaseActivity
import com.mohammad.githubrepos.presentation.main.settings.SettingsFragment
import com.mohammad.githubrepos.presentation.main.trending.TrendingFragment
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presentor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter.onCreate()
    }

    override fun initLayout() {
        setSupportActionBar(toolbar)

        navigation.setOnNavigationItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.trending -> {
                    presenter.trendingClick()
                    true
                }
                R.id.settings -> {
                    presenter.settingsClick()
                    true
                }
                else -> false
            }
        }
    }

    override fun showTrending() {
        supportActionBar?.title = resources.getString(R.string.trending)
        supportFragmentManager.inTransaction {
            add(R.id.container, TrendingFragment.newInstance())
        }
    }

    override fun showSettings() {
        supportActionBar?.title = resources.getString(R.string.settings)
        supportFragmentManager.inTransaction {
            add(R.id.container, SettingsFragment.newInstance())
        }
    }
}
