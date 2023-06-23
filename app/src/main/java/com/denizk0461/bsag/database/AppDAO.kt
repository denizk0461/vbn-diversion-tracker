package com.denizk0461.bsag.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Upsert
import com.denizk0461.bsag.model.Diversion
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.model.LineWithDiversions

@Dao
interface AppDAO {

    @Query("SELECT * FROM lines")
    fun getLines(): LiveData<List<Line>>

    @Query("SELECT COUNT(*) FROM lines")
    fun getLineCount(): Int

    @Query("SELECT * FROM diversions")
    fun getDiversions(): List<Diversion>

    @Transaction
    @Query("SELECT * FROM lines")
    fun getLinesWithDiversions(): LiveData<List<LineWithDiversions>>

    @Insert
    fun insertLines(lines: List<Line>)

    @Upsert
    fun upsertDiversions(diversions: List<Diversion>)

    @Query("DELETE FROM diversions WHERE id IN (:ids)")
    fun deleteDiversionsById(ids: List<Int>)

    @Query("DELETE FROM diversions")
    fun nukeDiversions()

    @Transaction
    fun refreshDiversions(idsToDelete: List<Int>, diversions: List<Diversion>) {
        deleteDiversionsById(idsToDelete)
        upsertDiversions(diversions)
    }
}