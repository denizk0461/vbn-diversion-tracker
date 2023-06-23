package com.denizk0461.bsag.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.denizk0461.bsag.exception.LinesNotDownloadedException
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LineDiversionViewModel(application: Application) : AppViewModel(application) {

    fun getLines(): LiveData<List<Line>> = repository.getLines()
    fun getLinesAsList(): LiveData<List<Line>> = repository.getLines()
    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>> = repository.getLinesWithDiversions()

    fun fetchLines() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.fetchLines()
        }
    }

    fun fetchDiversions(context: Context, onFinish: () -> Unit, onError: (message: String) -> Unit) {
        try {
            viewModelScope.launch(Dispatchers.IO) {
                repository.fetchDiversions(onFinish)
            }
        } catch (e: LinesNotDownloadedException) {
            // TODO app should try downloading lines before throwing an error maybe?
            viewModelScope.launch(Dispatchers.Main) {
                onError(e.getDescription(context))
            }
        }
    }
}