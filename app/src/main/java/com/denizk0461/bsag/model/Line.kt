package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.denizk0461.bsag.values.lines.Area
import com.denizk0461.bsag.values.lines.LineColor
import com.denizk0461.bsag.values.lines.OperationTime
import com.denizk0461.bsag.values.lines.VehicleType

/**
 * Representation of a tram or bus line.
 *
 * @param id            unique primary key
 * @param lineId        ID used to assign diversions to the line
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
    val lineId: Int,
    val name: String,
    val route: String,
    val area: List<Area>, // TODO how do I implement this?
    val vehicleType: VehicleType,
    val operationTime: OperationTime,
    val color: LineColor,
)