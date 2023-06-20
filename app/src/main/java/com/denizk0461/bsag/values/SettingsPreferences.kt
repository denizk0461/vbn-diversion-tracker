package com.denizk0461.bsag.values

/**
 * Preferences that the user can set via settings screen. Also includes values that are set without
 * the user's explicit input.
 *
 * @param key   key for the preference
 */
enum class SettingsPreferences(val key: String) {
    // - boolean preferences - //
    USE_THEMED_COLORS("themedcolors517483")

    // - int preferences - //

    // - string preferences - //

    ;
}