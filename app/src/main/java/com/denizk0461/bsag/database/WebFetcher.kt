package com.denizk0461.bsag.database

import com.denizk0461.bsag.model.Diversion
import com.denizk0461.bsag.values.Constants
import com.google.gson.Gson
import java.net.URL

/**
 * Retrieves data from the web and converts them into app objects to save in permanent storage.
 */
class WebFetcher {

    /**
     * Fetches a list of diversions from an online source.
     *
     * @return  list of diversions
     */
    fun fetch(): List<Diversion> {
        val connection = URL(Constants.DIVERSION_URL).openConnection().also { it.connect() }

        var result = ""

        connection.getInputStream().bufferedReader().use { r ->
            r.lineSequence().forEach { s ->
                result += "$s\n"
            }
        }

        return Gson().fromJson<List<Diversion>>(result, List::class.java)
    }
}