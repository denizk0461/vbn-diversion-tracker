package com.denizk0461.bsag.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LineDiversionViewModel(application: Application) : AppViewModel(application) {

    fun getLines(): LiveData<List<Line>> = repository.getLines()
    fun getLinesAsList(): LiveData<List<Line>> = repository.getLines()
    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>> = repository.getLinesWithDiversions()

    fun fetch(onFinish: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetch(onFinish)
        }
    }
}