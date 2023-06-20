package com.denizk0461.bsag.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.denizk0461.bsag.model.Line

@Dao
interface AppDAO {

    @Query("SELECT * FROM lines")
    fun getAllLines(): LiveData<List<Line>>
}