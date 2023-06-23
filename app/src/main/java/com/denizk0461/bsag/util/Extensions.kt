package com.denizk0461.bsag.util

import android.content.res.Resources
import android.graphics.Color
import android.util.TypedValue
import android.view.View
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.denizk0461.bsag.R
import com.google.android.material.snackbar.Snackbar

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

/**
 * Show a snack bar. Colours will be applied according to the theme given.
 *
 * @receiver        theme to apply colours of
 * @param view      view where the snack bar will be shown in
 * @param text      text to present in the snack bar
 * @param anchor    view to anchor the snack bar to
 */
fun Resources.Theme.showSnackBar(view: CoordinatorLayout, text: String, anchor: View? = null) {
    val s = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
        // Set colours
        .setTextColor(getThemedColor(com.google.android.material.R.attr.colorOnSurfaceInverse))
        .setBackgroundTint(getThemedColor(com.google.android.material.R.attr.colorSurfaceInverse))

    // Set anchor view, if one has been passed
    anchor?.let { a -> s.setAnchorView(a) }
    s.show()
}

/**
 * Show an error snack bar. Error colours will be applied according to the theme given.
 *
 * @receiver        theme to apply colours of
 * @param view      view where the snack bar will be shown in
 * @param text      text to present in the snack bar
 * @param anchor    view to anchor the snack bar to
 */
fun Resources.Theme.showErrorSnackBar(view: CoordinatorLayout, text: String, anchor: View? = null) {
    val s = Snackbar
        .make(view, text, Snackbar.LENGTH_SHORT)
        // Set colours to signify an error
        .setBackgroundTint(getThemedColor(R.attr.colorErrorContainer))
        .setTextColor(getThemedColor(R.attr.colorOnErrorContainer))

    // Set anchor view, if one has been passed
    anchor?.let { a -> s.setAnchorView(a) }
    s.show()
}
