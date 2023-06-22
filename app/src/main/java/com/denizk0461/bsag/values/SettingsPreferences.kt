package com.denizk0461.bsag.values

/**
 * Preferences that the user can set via settings screen. Also includes values that are set without
 * the user's explicit input.
 *
 * @param key   key for the preference
 */
enum class SettingsPreferences(val key: String) {
    // - boolean preferences - //

    // - int preferences - //

    /**
     * Which color theme to use. Possible values:
     * 0: web colors
     * 1: app-themed colors
     * 2: greyscale
     *
     * See [com.denizk0461.bsag.values.preferences.ColorThemePreference]
     */
    COLOR_THEME("colortheme517483")

    // - string preferences - //

    ;
}