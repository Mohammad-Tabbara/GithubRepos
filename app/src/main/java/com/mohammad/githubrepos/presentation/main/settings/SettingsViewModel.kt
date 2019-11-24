package com.mohammad.githubrepos.presentation.main.settings

import androidx.annotation.MainThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class SettingsViewModel @Inject constructor(val interactor: SettingsContract.Interactor): ViewModel() {

    val spinnerLiveData: SpinnerLiveData = SpinnerLiveData()

    fun onViewCreated() {
        spinnerLiveData.sendAction(interactor.getTrendingSpan())
    }

    fun onTrendingSpanItemSelected(selectedItem: Int) {
        interactor.setTrendingSpan(selectedItem)
    }

    class SpinnerLiveData: LiveData<Int>(){
        @MainThread
        fun sendAction(data: Int) {
            value = data
        }
    }
}