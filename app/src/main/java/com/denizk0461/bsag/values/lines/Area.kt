package com.denizk0461.bsag.values.lines

/**
 * Services are divided by areas to geographically locate them and let the user
 * easily view only the lines that are relevant to them. A line may be assigned to
 * multiple areas.
 */
enum class Area {

    // Regional trains are separate, as they run through many districts
    ZUGVERKEHR,

    // Areas starting with ST are cities
    ST_BREMEN,
    ST_BREMERHAVEN,
    ST_DELMENHORST,
    ST_OLDENBURG,

    // Areas starting with LK are districts (Landkreis)
    LK_AMMERLAND,
    LK_CUXHAVEN,
    LK_DIEPHOLZ,
    LK_NIENBURG,
    LK_OLDENBURG,
    LK_OSTERHOLZ,
    LK_ROTENBURG,
    LK_VERDEN,
    LK_WESERMARSCH,
}