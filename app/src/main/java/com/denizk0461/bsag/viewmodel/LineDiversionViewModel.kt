package com.denizk0461.bsag.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions

class LineDiversionViewModel(application: Application) : AppViewModel(application) {

    fun getLines(): LiveData<List<Line>> = repository.getLines()
    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>> = repository.getLinesWithDiversions()

    fun fetch() { doAsync { repository.fetch() } }
}