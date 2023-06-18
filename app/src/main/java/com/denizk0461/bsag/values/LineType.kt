package com.denizk0461.bsag.values

/**
 * This class stores representations for vehicles that are used on certain lines.
 */
enum class LineType {

    // A medium-demand service run with bus vehicles.
    BUS,

    // A high-demand rail service run with tram vehicles.
    TRAM,

    // A low-demand service run with taxi cars.
    TAXI,
    ;
}