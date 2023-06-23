package com.denizk0461.bsag.database

import com.denizk0461.bsag.model.Diversion
import com.denizk0461.bsag.model.Line
import com.denizk0461.bsag.values.Constants
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

/**
 * Retrieves data from the web and converts them into app objects to save in permanent storage.
 */
class WebFetcher {

    /**
     * Fetches a list of lines from an online source.
     *
     * @return  list of lines
     */
    fun fetchLines(): List<Line> {
        val connection = URL(Constants.LINE_URL).openConnection().also { it.connect() }

        var result = ""

        connection.getInputStream().bufferedReader().use { r ->
            r.lineSequence().forEach { s ->
                result += "$s\n"
            }
        }

        // Necessary to convert from JSON to typed array objects
        val typeToken = object : TypeToken<List<Line>>() {}.type

        // Return typed array
        return Gson().fromJson(result, typeToken)
    }

    /**
     * Fetches a list of diversions from an online source.
     *
     * @return  list of diversions
     */
    fun fetchDiversions(): List<Diversion> {
        val connection = URL(Constants.DIVERSION_URL).openConnection().also { it.connect() }

        var result = ""

        connection.getInputStream().bufferedReader().use { r ->
            r.lineSequence().forEach { s ->
                result += "$s\n"
            }
        }

        // Necessary to convert from JSON to typed array objects
        val typeToken = object : TypeToken<List<Diversion>>() {}.type

        // Return typed array
        return Gson().fromJson(result, typeToken)
    }
}