package com.denizk0461.bsag.exception

import android.content.Context
import com.denizk0461.bsag.R
import java.io.IOException

/**
 * This exception is used to notify the user if they are trying to download diversion notices but
 * have not yet downloaded information on the lines yet.
 *
 * @param certain   whether it is certain that the lines not having been downloaded caused the
 *                  issue; for example, if the lines table in the database is entirely empty, it is
 *                  certain that the user has not downloaded the lines. However, if the exception
 *                  has been thrown as a result of an SQLiteConstraintException, it may be possible
 *                  that, for instance, a foreign key may be wrong, or that a new line has been
 *                  added and a diversion notice for it is available, but the user has not updated
 *                  their lines. Hence, the uncertainty.
 */
class LinesNotDownloadedException(private val certain: Boolean) : IOException() {

    fun getDescription(context: Context): String = context.getString(if (certain) {
        R.string.exception_lines_not_downloaded_certain
    } else {
        R.string.exception_lines_not_downloaded_uncertain
    })
}