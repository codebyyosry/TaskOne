package com.yosry.dev.taskone.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val AppTypography = Typography(
    // Used for large headlines, like screen titles.
    headlineLarge = TextStyle(
        fontFamily = MyAppFont,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    // Used for standard text content.
    bodyLarge = TextStyle(
        fontFamily = MyAppFont,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    // Used for button labels and other small, prominent text.
    labelLarge = TextStyle(
        fontFamily = MyAppFont,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    )
    /* Define other text styles as needed */
)


