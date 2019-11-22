package com.mohammad.githubrepos.presentation.main

import android.os.Bundle
import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.presentation._common.activities.BaseActivity

class MainActivity : BaseActivity(), MainContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
