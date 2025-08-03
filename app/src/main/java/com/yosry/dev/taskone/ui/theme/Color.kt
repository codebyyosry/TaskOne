package com.yosry.dev.taskone.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Your primary brand colors, inspired by your orange and white logo.
val OrangePrimary = Color(0xFFFFA500) // A vibrant orange
val OrangeLight = Color(0xFFFFC966)  // A lighter orange for dark theme primary
val WhiteCream = Color(0xFFFFF7E6)   // An off-white, warm and creamy
val DarkGrey = Color(0xFF121212)     // Standard dark theme background
val LightGrey = Color(0xFF212121)    // Standard dark theme surface

// --- Light Theme Color Scheme ---
internal val LightColorScheme = lightColorScheme(
    primary = OrangePrimary,
    secondary = OrangeLight,
    tertiary = Color.Gray,

    // The color of text and icons displayed on top of the primary color.
    onPrimary = Color.White,
    // The color of text and icons displayed on top of the secondary color.
    onSecondary = Color.Black,
    // The color of text and icons displayed on top of the tertiary color.
    onTertiary = Color.White,

    // The background color that appears behind scrollable content.
    // NOTE: For your gradient, you will apply it manually. This is a fallback.
    background = WhiteCream,
    // The color of surfaces such as cards, sheets, and menus.
    surface = WhiteCream,

    // The color of text and icons displayed on top of the background color.
    onBackground = DarkGrey,
    // The color of text and icons displayed on top of the surface color.
    onSurface = DarkGrey
)

// --- Dark Theme Color Scheme ---
internal val DarkColorScheme = darkColorScheme(
    primary = OrangeLight, // Lighter orange for better contrast on dark backgrounds
    secondary = OrangePrimary,
    tertiary = Color.DarkGray,

    // The color of text and icons displayed on top of the primary color.
    onPrimary = Color.Black,
    // The color of text and icons displayed on top of the secondary color.
    onSecondary = Color.Black,
    // The color of text and icons displayed on top of the tertiary color.
    onTertiary = Color.White,

    // The background color that appears behind scrollable content.
    background = DarkGrey,
    // The color of surfaces such as cards, sheets, and menus.
    surface = LightGrey,

    // The color of text and icons displayed on top of the background color.
    onBackground = WhiteCream,
    // The color of text and icons displayed on top of the surface color.
    onSurface = WhiteCream
)