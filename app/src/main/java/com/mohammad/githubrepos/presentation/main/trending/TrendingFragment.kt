package com.mohammad.githubrepos.presentation.main.trending


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.presentation._common.base.BaseFragment
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class TrendingFragment : BaseFragment(), TrendingContract.View {

    companion object{
        fun newInstance():TrendingFragment = TrendingFragment()
    }

    @Inject
    lateinit var presenter: TrendingContract.Presentor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false)
    }


}
