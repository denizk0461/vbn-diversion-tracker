package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "diversions",
    foreignKeys = [
        ForeignKey(Line::class, ["id"], ["lineId"], ForeignKey.CASCADE),
    ],
)
data class Diversion(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val lineId: Int,
    val diversion: String,
)
