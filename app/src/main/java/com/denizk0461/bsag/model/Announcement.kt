package com.denizk0461.bsag.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * A high-priority announcement. This is never associated to a single line and is instead presented
 * in immediate view so that users are quickly notified about this information. This mostly includes
 * unpredictable, temporary diversions, as well as in-advance announcements for large-scale service
 * changes.
 *
 * @param id        unique primary key
 * @param content   text content for this announcement
 */
@Entity(
    tableName = "bsag_announcement",
)
data class Announcement(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val content: String,
)