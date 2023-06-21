package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Line-specific diversion notice or otherwise relevant information. Must always be linked to a
 * [Line] object.
 *
 * @param id        unique primary key
 * @param lineId    primary key of the line this notice is associated with
 * @param diversion text content for the diversion
 * @param read      whether the user has read this notice
 */
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
    var read: Boolean = false,
) {

    /**
     * Checks if this [Diversion] object matches another [Diversion]. Equality is based on the ID of
     * the line the diversions are assigned, as well as the text content.
     *
     * @param other [Diversion] to compare to
     * @return      whether they are the same diversion notice
     */
    fun matches(other: Diversion): Boolean {
        return (this.lineId == other.lineId && this.diversion == other.diversion)
    }
}
