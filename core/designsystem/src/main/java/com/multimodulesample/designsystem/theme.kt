package com.multimodulesample.designsystem

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

@Immutable
data class CustomColors(
    val primaryColor: Color = Color.Unspecified,
    val primaryVariantColor: Color = Color.Unspecified,
    val onPrimaryColor: Color = Color.Unspecified,
    val secondaryColor: Color = Color.Unspecified,
    val secondaryVariantColor: Color = Color.Unspecified,
    val onSecondaryColor: Color = Color.Unspecified,
    val surfaceColor: Color = Color.Unspecified,
    val secondarySurfaceColor: Color = Color.Unspecified,
    val tertarySurfaceColor: Color = Color.Unspecified,
    val primaryBackgroundColor: Color = Color.Unspecified,
    val secondaryBackgroundColor: Color = Color.Unspecified,
    val tertiaryBackgroundColor: Color = Color.Unspecified,
    val primaryLabelColor: Color = Color.Unspecified,
    val secondaryLabelColor: Color = Color.Unspecified,
    val tertiaryLabelColor: Color = Color.Unspecified,
    val accentColor: Color = Color.Unspecified,
    val accentVariantColor: Color = Color.Unspecified,
    val onAccentColor: Color = Color.Unspecified,
    val supportRedColor: Color = Color.Unspecified,
    val supportGreenColor: Color = Color.Unspecified,
    val supportBlueColor: Color = Color.Unspecified,
    val onSupportColor: Color = Color.Unspecified,
    val supportRedVariantColor: Color = Color.Unspecified,
    val supportGreenVariantColor: Color = Color.Unspecified,
    val supportBlueVariantColor: Color = Color.Unspecified,
    val onSupportRedVariantColor: Color = Color.Unspecified,
    val onSupportGreenVariantColor: Color = Color.Unspecified,
    val onSupportBlueVariantColor: Color = Color.Unspecified,
    val outline: Color = Color.Unspecified,
    val secondaryOutlineColor: Color = Color.Unspecified,
    val tertiaryOutlineColor: Color = Color.Unspecified,
    val separator: Color = Color.Unspecified,
    val disabled: Color = Color.Unspecified,
    val onDisabled: Color = Color.Unspecified
)

@Immutable
data class CustomTypography(
    val largeTitle: TextStyle,
    val title1: TextStyle,
    val title2: TextStyle,
    val title3: TextStyle,
    val headline1: TextStyle,
    val headline2: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val subHeadline1: TextStyle,
    val subHeadline2: TextStyle,
    val footnote: TextStyle,
    val caption1: TextStyle,
    val caption2: TextStyle,
    val caption3: TextStyle
)

val LocalCustomColors = staticCompositionLocalOf {
    CustomColors()
}
val LocalCustomTypography = staticCompositionLocalOf {
    typography
}

val lightThemeColors = CustomColors(
    primaryColor = blue_700,
    primaryVariantColor = blue_900,
    onPrimaryColor = alpha_dark_900,
    secondaryColor = orange_300,
    secondaryVariantColor = orange_50,
    onSecondaryColor = blue_grey_900,
    surfaceColor = blue_grey_50,
    secondarySurfaceColor = blue_100,
    tertarySurfaceColor = blue_50,
    primaryLabelColor = blue_grey_900,
    secondaryLabelColor = blue_grey_900.copy(alpha = 0.75f),
    tertiaryLabelColor = blue_grey_900.copy(alpha = 0.40f),
    accentColor = indigo_500,
    accentVariantColor = indigo_50,
    onAccentColor = indigo_800,
    supportRedColor = red_600,
    supportGreenColor = green_600,
    supportBlueColor = blue_600,
    onSupportColor = neutral_50,
    supportRedVariantColor = red_50,
    supportGreenVariantColor = green_50,
    supportBlueVariantColor = blue_50,
    onSupportRedVariantColor = red_900,
    onSupportGreenVariantColor = green_800,
    onSupportBlueVariantColor = blue_800,
    outline = blue_grey_700.copy(alpha = 0.8f),
    secondaryOutlineColor = blue_grey_700.copy(alpha = 0.24f),
    tertiaryOutlineColor = blue_grey_200,
    separator = blue_grey_700.copy(alpha = 0.15f),
    disabled = blue_grey_700.copy(alpha = 0.12f),
    onDisabled = black_700.copy(alpha = 0.38f),
    primaryBackgroundColor = Color.White,
    secondaryBackgroundColor = gray_100,
    tertiaryBackgroundColor = blue_grey_100
)

val darkThemeColors = CustomColors(
    primaryColor = red_600,
    primaryVariantColor = blue_500,
    onPrimaryColor = alpha_light,
    secondaryColor = orange_200,
    secondaryVariantColor = orange_600,
    onSecondaryColor = blue_grey_50,
    surfaceColor = blue_grey_900,
    secondarySurfaceColor = blue_800,
    tertarySurfaceColor = blue_900,
    primaryLabelColor = blue_grey_900,
    secondaryLabelColor = blue_grey_900.copy(alpha = 0.75f),
    tertiaryLabelColor = blue_grey_900.copy(alpha = 0.40f),
    accentColor = indigo_500,
    accentVariantColor = indigo_50,
    onAccentColor = indigo_800,
    supportRedColor = red_600,
    supportGreenColor = green_600,
    supportBlueColor = blue_600,
    onSupportColor = neutral_50,
    supportRedVariantColor = red_50,
    supportGreenVariantColor = green_50,
    supportBlueVariantColor = blue_50,
    onSupportRedVariantColor = red_900,
    onSupportGreenVariantColor = green_800,
    onSupportBlueVariantColor = blue_800,
    outline = blue_grey_50,
    secondaryOutlineColor = blue_gray_2000,
    tertiaryOutlineColor = blue_gray_20000,
    separator = blue_gray_300.copy(alpha = 0.8f),
    disabled = blue_grey_700.copy(alpha = 0.60f),
    onDisabled = black_700.copy(alpha = 1f),
    primaryBackgroundColor = blue_grey_900,
    secondaryBackgroundColor = blue_grey_900.copy(alpha = 0.75f),
    tertiaryBackgroundColor = blue_grey_900.copy(alpha = 0.40f)
)

val typography = CustomTypography(
    largeTitle = TextStyle(fontSize = 32.sp, lineHeight = 36.sp, fontFamily = FontFamily.SansSerif),
    title1 = TextStyle(fontSize = 25.sp, lineHeight = 28.sp, fontFamily = FontFamily.SansSerif),
    title2 = TextStyle(fontSize = 22.sp, lineHeight = 26.sp, fontFamily = FontFamily.SansSerif),
    title3 = TextStyle(fontSize = 20.sp, lineHeight = 24.sp, fontFamily = FontFamily.SansSerif),
    headline1 = TextStyle(fontSize = 16.sp, lineHeight = 20.sp, fontFamily = FontFamily.SansSerif),
    headline2 = TextStyle(fontSize = 17.sp, lineHeight = 23.sp, fontFamily = FontFamily.SansSerif),
    body1 = TextStyle(fontSize = 16.sp, lineHeight = 20.sp, fontFamily = FontFamily.SansSerif),
    body2 = TextStyle(fontSize = 16.sp, lineHeight = 24.sp, fontFamily = FontFamily.SansSerif),
    subHeadline1 = TextStyle(
        fontSize = 15.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily.SansSerif
    ),
    subHeadline2 = TextStyle(
        fontSize = 15.sp,
        lineHeight = 20.sp,
        fontFamily = FontFamily.SansSerif
    ),
    footnote = TextStyle(fontSize = 14.sp, lineHeight = 18.sp, fontFamily = FontFamily.SansSerif),
    caption1 = TextStyle(fontSize = 12.sp, lineHeight = 18.sp, fontFamily = FontFamily.SansSerif),
    caption2 = TextStyle(fontSize = 12.sp, lineHeight = 16.sp, fontFamily = FontFamily.SansSerif),
    caption3 = TextStyle(fontSize = 11.sp, lineHeight = 14.sp, fontFamily = FontFamily.SansSerif)

)

@Composable
fun MultiModuleSampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,

    ) {
    val colorTheme = if (darkTheme) {
        darkThemeColors
    } else {
        lightThemeColors
    }

    CompositionLocalProvider(
        LocalCustomColors provides colorTheme,
        LocalCustomTypography provides typography,
        content = content
    )
}

object MultiModuleSampleTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current
    val typography: CustomTypography
        @Composable
        get() = LocalCustomTypography.current
}
