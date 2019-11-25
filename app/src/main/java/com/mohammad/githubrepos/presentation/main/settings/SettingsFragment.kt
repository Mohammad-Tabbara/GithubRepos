package com.mohammad.githubrepos.presentation.main.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.di.factory.DaggerViewModelFactory
import com.mohammad.githubrepos.presentation._common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class SettingsFragment : BaseFragment() {

    companion object{
        fun newInstance(): SettingsFragment = SettingsFragment()
    }

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    lateinit var viewModel: SettingsViewModel

    var arrayAdapter : ArrayAdapter<Int>? = null
    private val list = listOf(3,7,14,30)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this,viewModelFactory).get(SettingsViewModel::class.java)
        viewModel.onViewCreated()
        initLayout()
        initObservers()
    }

    private fun initLayout() {
        activity?.title = getString(R.string.settings)
        context?.let {
            arrayAdapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, list)
        }

        trendingSpanSpinner.adapter = arrayAdapter

    }

    private fun initObservers(){
        viewModel.spinnerLiveData.observe(this, Observer { trendingSpan ->
            initSpinner(trendingSpan)
        })
    }

    private fun initSpinner(trendingSpan: Int){
        val selection = arrayAdapter?.getPosition(trendingSpan).let { if( it == -1) list.size -1 else it }?: list.size -1
        trendingSpanSpinner.setSelection(selection)
        trendingSpanSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position).toString().toInt()
                viewModel.onTrendingSpanItemSelected(selectedItem)
            }

        }
    }

}
