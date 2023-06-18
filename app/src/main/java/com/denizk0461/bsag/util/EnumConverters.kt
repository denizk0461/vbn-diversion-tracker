package com.denizk0461.bsag.util

import androidx.room.TypeConverter
import com.denizk0461.bsag.values.LineColor
import com.denizk0461.bsag.values.LineType

/**
 * Conversions between enum values and their titles. Used to store enum values in Room entities.
 */
object EnumConverters {

    /**
     * Converts from a string to an enum object of a specified type.
     *
     * @param value title of the enum value
     * @return      associated enum value
     */
    @TypeConverter
    inline fun <reified T : Enum<T>> toEnumObject(value: String): T = enumValueOf(value)

    /**
     * Converts from an enum object to its name as a string.
     *
     * @param value enum value
     * @return      its title
     */
    @TypeConverter
    inline fun <reified T : Enum<T>>fromEnumObject(value: T): String = value.name

    /**
     * Converts from a string to a [com.denizk0461.bsag.values.LineColor] object. If the requested
     * object could not be found, returns [com.denizk0461.bsag.values.LineColor.DEFAULT].
     *
     * @param value name of the object to find
     * @return      object or [com.denizk0461.bsag.values.LineColor.DEFAULT] if it could not be found
     */
    fun toLineColor(value: String): LineColor = try {
        enumValueOf(value)
    } catch (_: IllegalArgumentException) {
        LineColor.DEFAULT
    }

    /**
     * Converts from a string to a [com.denizk0461.bsag.values.LineType] object. If the requested
     * object could not be found, returns [com.denizk0461.bsag.values.LineType.BUS].
     *
     * @param value name of the object to find
     * @return      object or [com.denizk0461.bsag.values.LineType.BUS] if it could not be found
     */
    fun toLineType(value: String): LineType = try {
        enumValueOf(value)
    } catch (_: IllegalArgumentException) {
        LineType.BUS
    }
}