package com.mohammad.githubrepos.presentation.main.settings


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.mohammad.githubrepos.R
import com.mohammad.githubrepos.presentation._common.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_settings.*
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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onViewCreated()
    }

    override fun initLayout(trendingSpan: Int) {
        activity?.title = getString(R.string.settings)

        val list = listOf(3,7,14,30)
        var arrayAdapter : ArrayAdapter<Int>? = null
        context?.let {
            arrayAdapter = ArrayAdapter(it, android.R.layout.simple_spinner_item, list)
        }

        trendingSpanSpinner.adapter = arrayAdapter
        val selection = arrayAdapter?.getPosition(trendingSpan).let { if( it == -1) list.size -1 else it }?: list.size -1
        trendingSpanSpinner.setSelection(selection)
        trendingSpanSpinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent!!.getItemAtPosition(position).toString().toInt()
                presenter.onTrendingSpanItemSelected(selectedItem)
            }

        }
    }

}
