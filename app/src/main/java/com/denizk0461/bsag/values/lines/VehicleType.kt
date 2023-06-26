package com.denizk0461.bsag.values.lines

/**
 * This class stores representations for vehicles that are used on certain lines.
 */
enum class VehicleType {

    // A medium to very high-demand service run with trains
    TRAIN,

    // A high-demand rail service run with tram vehicles
    TRAM,

    // A medium-demand service run with bus vehicles
    BUS,

    // A low-demand service run by volunteers with minibuses
    BUERGERBUS,

    // A low-demand service run with taxi cabs
    TAXI,

    /*
     * "Anrufsammeltaxi", also called "Anruflinientaxi" – A very low-demand taxi service that only
     * runs after calling certain number
     */
    AST,
    ;
}