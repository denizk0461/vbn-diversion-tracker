package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denizk0461.bsag.values.LineColor
import com.denizk0461.bsag.values.LineType

/**
 * Representation of a tram or bus line.
 *
 * @param id    unique primary key
 * @param name  designation for the line, e.g. "1" or "25"
 * @param type  type of vehicle used on this line
 * @param color color the line will have as a background
 */
@Entity(
    tableName = "bsag_line",
)
data class Line(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val type: LineType,
    val color: LineColor,
)