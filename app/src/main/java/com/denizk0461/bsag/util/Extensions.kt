package com.denizk0461.bsag.util

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.denizk0461.bsag.R

/**
 * Retrieves a specified colour customised to the currently applied theme.
 *
 * @param id    attribute ID of the colour reference
 * @return      resolved colour
 */
fun Resources.Theme.getThemedColor(@AttrRes id: Int): Int = TypedValue().also { value ->
    resolveAttribute(id, value, true)
}.data

/**
 * Calculates whether black would provide the best contrast on a given color, and returns the result.
 *
 * @receiver    color to calculate a contrast to
 * @return      black or white
 */
@ColorInt
fun Int.getConstrast(): Int = Color.parseColor(if ((
        Color.red(this) * 0.299 +
        Color.green(this) * 0.587 +
        Color.blue(this) * 0.114) > 186
) {
    "#212121"
} else {
    "#ffffff"
})

/**
 * Applies a rainbow colour effect to a progress circle of a given [SwipeRefreshLayout]. The circle
 * will rotate through 4 different colours during the refresh process.
 */
fun SwipeRefreshLayout.setRainbowProgressCircle() {
    setColorSchemeColors(
        context.getColor(R.color.swipe_red),
        context.getColor(R.color.swipe_blue),
        context.getColor(R.color.swipe_green),
        context.getColor(R.color.swipe_yellow),
    )
}
