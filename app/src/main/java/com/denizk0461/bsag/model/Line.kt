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
 * @param diversions    JSON object containing all diversions
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
    val diversions: String,
)