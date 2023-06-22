package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

/**
 * Line-specific diversion notice or otherwise relevant information. Must always be linked to a
 * [Line] object.
 *
 * @param id            unique primary key
 * @param lineId        primary key of the line this notice is associated with
 * @param title         title for the diversion
 * @param description   text content for the diversion
 * @param start         descriptor for the start of the diversion; should be a date and time stamp,
 *                      such as "Montag, 05.06.2023, ca. 3:00"
 * @param end           descriptor for the end of the diversion; for example, a date and time
 *                      stamp "Freitag, 23.06.2023, ca. 3:00" or a general notice "auf Weiteres"
 * @param read          whether the user has read this notice
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
    val title: String,
    val description: String,
    val start: String,
    val end: String,
    var read: Boolean = false,
) {

    /**
     * Checks if this [Diversion] object matches another [Diversion]. Equality is based on the ID of
     * the line the diversions are assigned, as well as the text contents.
     *
     * @param other [Diversion] to compare to
     * @return      whether they are the same diversion notice
     */
    fun matches(other: Diversion): Boolean {
        return (this.lineId == other.lineId &&
                this.title == other.title &&
                this.description == other.description &&
                this.start == other.start &&
                this.end == other.end)
    }
}
