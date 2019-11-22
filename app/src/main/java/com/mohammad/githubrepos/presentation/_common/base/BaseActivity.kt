package com.mohammad.githubrepos.presentation._common.base

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity :DaggerAppCompatActivity(){
    inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> Unit) {
        val fragmentTransaction = beginTransaction()
        fragmentTransaction.func()
        fragmentTransaction.commit()
    }
}