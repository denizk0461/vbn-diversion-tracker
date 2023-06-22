package com.denizk0461.bsag.values.preferences

/**
 * Which color theme to use. This is applied to the lines.
 */
enum class ColorThemePreference {

    /**
     * Use colors as they appear on the web. This does not respect light/dark mode setting.
     */
    WEB,

    /**
     * Use colors themed within the app. This respects light/dark mode setting.
     */
    THEMED,

    /**
     * Don't use colors and instead use greyscale. This respects light/dark mode setting.
     */
    GREYSCALE,
    ;
}