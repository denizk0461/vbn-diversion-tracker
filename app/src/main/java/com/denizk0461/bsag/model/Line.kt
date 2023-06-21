package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denizk0461.bsag.values.LineColor
import com.denizk0461.bsag.values.OperationTime
import com.denizk0461.bsag.values.VehicleType

/**
 * Representation of a tram or bus line.
 *
 * @param id            unique primary key
 * @param name          designation for the line, e.g. "1" or "25" or "N3"
 * @param vehicleType   type of vehicle used on this line
 * @param operationTime time at which this service operates
 * @param color         color the line will have as a background
 */
@Entity(
    tableName = "lines",
)
data class Line(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val vehicleType: VehicleType,
    val operationTime: OperationTime,
    val color: LineColor,
)

/**
 * Merges [Diversion] onto their specific [Line] objects and returns the result in a list of
 * [LineWithDiversion] objects.
 *
 * @param diversions    diversions to add to the lines
 * @return              list object with lines and their diversions. Only includes lines for
 *                      which diversions are available.
 */
//fun List<Line>.mergeDiversions(diversions: List<Diversion>): List<LineWithDiversion> {
//
//    // Cache the list of diversions to make it mutable
//    val cachedDiversions = diversions.toMutableList()
//
//    // Cached list for an individual line's diversions
//    val listOfDiversions = mutableListOf<String>()
//
//    // Final list for lines merged with diversions
//    val listOfLinesWithDiversion = mutableListOf<LineWithDiversion>()
//
//    // Iterate through all lines
//    this.forEach { line ->
//
//        /*
//         * Iterate through all diversions; do this reversed to allow for removing entries that have
//         * already been assigned.
//         */
//        for (index in cachedDiversions.indices.reversed()) {
//
//            // Check if the diversion is applicable to the line
//            if (line.id == cachedDiversions[index].lineId) {
//
//                // Add the diversion to the list of diversions for the line
//                listOfDiversions.add(cachedDiversions[index].diversion)
//
//                /*
//                 * Remove diversions that have already been assigned to a line to reduce the number
//                 * of iterations necessary.
//                 */
//                cachedDiversions.removeAt(index)
//            }
//        }
//
//        // Add the line to the final list if any diversions are available for it
//        if (listOfDiversions.isNotEmpty()) {
//
//            // Add the line
//            listOfLinesWithDiversion.add(
//                LineWithDiversion(
//                    name = line.name,
//                    vehicleType = line.vehicleType,
//                    color = line.color,
//                    operationTime = line.operationTime,
//                    diversions = listOfDiversions,
//                )
//            )
//
//            // Clear the list of diversions, as they have already been assigned to a line
//            listOfDiversions.clear()
//        }
//    }
//
//    // Return the list of lines with diversions attached, ordered by their primary key
//    return listOfLinesWithDiversion.sortedBy { it.id }
//}
