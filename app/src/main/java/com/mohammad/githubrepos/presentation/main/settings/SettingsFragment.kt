package com.mohammad.githubrepos.presentation.main.settings


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
class SettingsFragment : BaseFragment(), SettingsContract.View {

    companion object{
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

    @Inject
    lateinit var presenter: SettingsContract.Presentor

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }


}
