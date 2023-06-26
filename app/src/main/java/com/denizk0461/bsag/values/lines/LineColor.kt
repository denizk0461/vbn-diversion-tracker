package com.denizk0461.bsag.values.lines

import androidx.annotation.AttrRes
import com.denizk0461.bsag.R

/**
 * This class is used to assign colors to certain lines. As lines may share colours, it would be
 * superfluous to add the specific color for each line individually.
 *
 * @param themedColor   theme-specific line color
 * @param webColor      line color as it appears on the website
 */
enum class LineColor(
    @AttrRes val themedColor: Int,
    @AttrRes val webColor: Int,
) {
    BLUE(R.attr.color_line_themed_blue, R.attr.color_line_web_blue),
    BLUE_DARK(R.attr.color_line_themed_blue_dark, R.attr.color_line_web_blue_dark),
    BLUE_LIGHT(R.attr.color_line_themed_blue_light, R.attr.color_line_web_blue_light),
    GREEN_DARK(R.attr.color_line_themed_green_dark, R.attr.color_line_web_green_dark),
    GREEN_LIGHT(R.attr.color_line_themed_green_light, R.attr.color_line_web_green_light),
    LAVENDER(R.attr.color_line_themed_lavender, R.attr.color_line_web_lavender),
    ORANGE(R.attr.color_line_themed_orange, R.attr.color_line_web_orange),
    PINK(R.attr.color_line_themed_pink, R.attr.color_line_web_pink),
    RED(R.attr.color_line_themed_red, R.attr.color_line_web_red),
    TURQUOISE(R.attr.color_line_themed_turquoise, R.attr.color_line_web_turquoise),
    VIOLET(R.attr.color_line_themed_violet, R.attr.color_line_web_violet),
    YELLOW(R.attr.color_line_themed_yellow, R.attr.color_line_web_yellow),
    DEFAULT(R.attr.color_line_themed_red, R.attr.color_line_web_red),
    ;
}