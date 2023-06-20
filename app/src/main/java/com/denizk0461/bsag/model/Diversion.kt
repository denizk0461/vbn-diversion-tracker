package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * A diversion specific to a single [Line].
 *
 * @param id        unique primary key
 * @param lineId    primary key of the associated [Line]
 * @param content   text for this diversion
 */
@Entity(
    tableName = "bsag_diversions",
    foreignKeys = [
        ForeignKey(
            Line::class,
            ["id"],
            ["lineId"],
            onDelete = ForeignKey.CASCADE,
        ),
    ],
)
data class Diversion(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val lineId: Int,
    val content: String,
)