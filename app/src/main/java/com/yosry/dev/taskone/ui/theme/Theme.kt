@file:Suppress("DEPRECATION")

package com.yosry.dev.taskone.ui.theme

import android.app.Activity
import android.os.Build
import android.view.WindowInsets
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

/**
 * The main theme for the application.
 *
 * This composable handles:
 * - Applying the correct color scheme (light or dark).
 * - Applying the custom typography and shapes.
 * - Setting up the system bars for an edge-to-edge display.
 * - Providing RTL/LTR support implicitly.
 *
 * @param darkTheme Whether the theme should be in dark mode. Defaults to the system setting.
 * @param content The content to be displayed within the theme.
 */
@Composable
fun TaskOneTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    // This effect sets up the system bars for an edge-to-edge display.
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            // On API 35+, the status bar is transparent by default with edge-to-edge enabled.
            // This call is required for older versions and is deprecated on 35+.
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.VANILLA_ICE_CREAM) { // Android 15+
                window.decorView.setOnApplyWindowInsetsListener { view, insets ->
                    val statusBarInsets = insets.getInsets(WindowInsets.Type.statusBars())
                    view.setBackgroundColor(Color.Transparent.toArgb())

                    // Adjust padding to avoid overlap
                    view.setPadding(0, statusBarInsets.top, 0, 0)
                    insets
                }
            } else {
                // For Android 14 and below
                window.statusBarColor = Color.Transparent.toArgb()
            }

            // Tell the system that our app will handle drawing behind the system bars.
            WindowCompat.setDecorFitsSystemWindows(window, false)

            // Set the color of the status bar icons (light or dark).
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
        }
    }

    // Provides the MaterialTheme values to the content.
    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        shapes = AppShapes,
        content = content
    )
}

/**
 * A Box composable that applies a custom gradient background.
 * The gradient is designed to work well with both light and dark themes.
 *
 * @param modifier Modifier to be applied to the Box.
 * @param content The content to be placed on top of the gradient.
 */
@Composable
fun GradientBackground(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    // Determine gradient colors based on the current theme
    val gradientColors = if (isSystemInDarkTheme()) {
        listOf(
            OrangePrimary,
            DarkGrey
        )
    } else {
        listOf(
            WhiteCream,
            OrangePrimary
        )
    }

    val brush = Brush.verticalGradient(colors = gradientColors)

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(brush)
    ) {
        content()
    }
}