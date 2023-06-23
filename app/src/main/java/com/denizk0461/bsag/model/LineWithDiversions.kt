package com.denizk0461.bsag.model

import androidx.room.Embedded
import androidx.room.Relation

/**
 * Representation of a tram or bus line with diversions relevant to the line merged into a list.
 *
 * @param line          line object
 * @param diversions    list containing all diversions for the line
 */
data class LineWithDiversions(
    @Embedded val line: Line,
    @Relation(
        parentColumn = "lineId",
        entityColumn = "lineId",
    )
    val diversions: List<Diversion>,
)
