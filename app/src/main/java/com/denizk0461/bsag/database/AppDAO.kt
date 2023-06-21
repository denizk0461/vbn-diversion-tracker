package com.denizk0461.bsag.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.denizk0461.bsag.model.Diversion
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions

@Dao
interface AppDAO {

    @Query("SELECT * FROM lines")
    fun getLines(): LiveData<List<Line>>

    @Query("SELECT * FROM diversions")
    fun getDiversions(): List<Diversion>

    @Transaction
    @Query("SELECT * FROM lines")
    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>>

    @Insert
    fun insert(diversions: List<Diversion>)

    // TODO this cannot be left here like this, because diversions need an unread counter
    @Query("DELETE FROM diversions")
    fun nukeDiversions()
}