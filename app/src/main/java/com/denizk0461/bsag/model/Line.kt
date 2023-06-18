package com.denizk0461.bsag.model

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
data class Line(
    val id: Int,
    val name: String,
    val type: LineType,
    val color: LineColor,
)