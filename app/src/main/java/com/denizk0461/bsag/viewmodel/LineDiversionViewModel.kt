package com.denizk0461.bsag.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import com.denizk0461.bsag.model.Line

class LineDiversionViewModel(application: Application) : AppViewModel(application) {

    fun getAllLines(): LiveData<List<Line>> = repository.getAllLines()
}