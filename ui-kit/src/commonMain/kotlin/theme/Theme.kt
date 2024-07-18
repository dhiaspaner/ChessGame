package theme


import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.intl.Locale
import theme.color.backgroundDark
import theme.color.backgroundLight
import theme.color.errorContainerDark
import theme.color.errorContainerLight
import theme.color.errorDark
import theme.color.errorLight
import theme.color.inverseOnSurfaceDark
import theme.color.inverseOnSurfaceLight
import theme.color.inversePrimaryDark
import theme.color.inversePrimaryLight
import theme.color.inverseSurfaceDark
import theme.color.inverseSurfaceLight
import theme.color.onBackgroundDark
import theme.color.onBackgroundLight
import theme.color.onErrorContainerDark
import theme.color.onErrorContainerLight
import theme.color.onErrorDark
import theme.color.onErrorLight
import theme.color.onPrimaryContainerDark
import theme.color.onPrimaryContainerLight
import theme.color.onPrimaryDark
import theme.color.onPrimaryLight
import theme.color.onSecondaryContainerDark
import theme.color.onSecondaryContainerLight
import theme.color.onSecondaryDark
import theme.color.onSecondaryLight
import theme.color.onSurfaceDark
import theme.color.onSurfaceLight
import theme.color.onSurfaceVariantDark
import theme.color.onSurfaceVariantLight
import theme.color.onTertiaryContainerDark
import theme.color.onTertiaryContainerLight
import theme.color.onTertiaryDark
import theme.color.onTertiaryLight
import theme.color.outlineDark
import theme.color.outlineLight
import theme.color.outlineVariantDark
import theme.color.outlineVariantLight
import theme.color.primaryContainerDark
import theme.color.primaryContainerLight
import theme.color.primaryDark
import theme.color.primaryLight
import theme.color.scrimDark
import theme.color.scrimLight
import theme.color.secondaryContainerDark
import theme.color.secondaryContainerLight
import theme.color.secondaryDark
import theme.color.secondaryLight
import theme.color.surfaceBrightDark
import theme.color.surfaceBrightLight
import theme.color.surfaceContainerDark
import theme.color.surfaceContainerHighDark
import theme.color.surfaceContainerHighLight
import theme.color.surfaceContainerHighestDark
import theme.color.surfaceContainerHighestLight
import theme.color.surfaceContainerLight
import theme.color.surfaceContainerLowDark
import theme.color.surfaceContainerLowLight
import theme.color.surfaceContainerLowestDark
import theme.color.surfaceContainerLowestLight
import theme.color.surfaceDark
import theme.color.surfaceDimDark
import theme.color.surfaceDimLight
import theme.color.surfaceLight
import theme.color.surfaceVariantDark
import theme.color.surfaceVariantLight
import theme.color.tertiaryContainerDark
import theme.color.tertiaryContainerLight
import theme.color.tertiaryDark
import theme.color.tertiaryLight
import theme.shape.Shapes

val LightColorScheme =
    lightColorScheme(
        primary = primaryLight,
        onPrimary = onPrimaryLight,
        primaryContainer = primaryContainerLight,
        onPrimaryContainer = onPrimaryContainerLight,
        secondary = secondaryLight,
        onSecondary = onSecondaryLight,
        secondaryContainer = secondaryContainerLight,
        onSecondaryContainer = onSecondaryContainerLight,
        tertiary = tertiaryLight,
        onTertiary = onTertiaryLight,
        tertiaryContainer = tertiaryContainerLight,
        onTertiaryContainer = onTertiaryContainerLight,
        error = errorLight,
        onError = onErrorLight,
        errorContainer = errorContainerLight,
        onErrorContainer = onErrorContainerLight,
        background = backgroundLight,
        onBackground = onBackgroundLight,
        surface = surfaceLight,
        onSurface = onSurfaceLight,
        surfaceVariant = surfaceVariantLight,
        onSurfaceVariant = onSurfaceVariantLight,
        outline = outlineLight,
        outlineVariant = outlineVariantLight,
        scrim = scrimLight,
        inverseSurface = inverseSurfaceLight,
        inverseOnSurface = inverseOnSurfaceLight,
        inversePrimary = inversePrimaryLight,
        surfaceDim = surfaceDimLight,
        surfaceBright = surfaceBrightLight,
        surfaceContainerLowest = surfaceContainerLowestLight,
        surfaceContainerLow = surfaceContainerLowLight,
        surfaceContainer = surfaceContainerLight,
        surfaceContainerHigh = surfaceContainerHighLight,
        surfaceContainerHighest = surfaceContainerHighestLight,
    )

val DarkColorScheme =
    darkColorScheme(
        primary = primaryDark,
        onPrimary = onPrimaryDark,
        primaryContainer = primaryContainerDark,
        onPrimaryContainer = onPrimaryContainerDark,
        secondary = secondaryDark,
        onSecondary = onSecondaryDark,
        secondaryContainer = secondaryContainerDark,
        onSecondaryContainer = onSecondaryContainerDark,
        tertiary = tertiaryDark,
        onTertiary = onTertiaryDark,
        tertiaryContainer = tertiaryContainerDark,
        onTertiaryContainer = onTertiaryContainerDark,
        error = errorDark,
        onError = onErrorDark,
        errorContainer = errorContainerDark,
        onErrorContainer = onErrorContainerDark,
        background = backgroundDark,
        onBackground = onBackgroundDark,
        surface = surfaceDark,
        onSurface = onSurfaceDark,
        surfaceVariant = surfaceVariantDark,
        onSurfaceVariant = onSurfaceVariantDark,
        outline = outlineDark,
        outlineVariant = outlineVariantDark,
        scrim = scrimDark,
        inverseSurface = inverseSurfaceDark,
        inverseOnSurface = inverseOnSurfaceDark,
        inversePrimary = inversePrimaryDark,
        surfaceDim = surfaceDimDark,
        surfaceBright = surfaceBrightDark,
        surfaceContainerLowest = surfaceContainerLowestDark,
        surfaceContainerLow = surfaceContainerLowDark,
        surfaceContainer = surfaceContainerDark,
        surfaceContainerHigh = surfaceContainerHighDark,
        surfaceContainerHighest = surfaceContainerHighestDark,
    )

val AppColorScheme = staticCompositionLocalOf { LightColorScheme }

val MaterialTheme.appColorScheme: ColorScheme
    @Composable
    @ReadOnlyComposable
    get() = AppColorScheme.current


@Composable
fun KotlinStarterTheme(
    isDark: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val starterColorScheme =
        remember(isDark) {
            if (isDark) DarkColorScheme else LightColorScheme
        }

    MaterialTheme(
        colorScheme = starterColorScheme,
        shapes = Shapes,
        content = content,
    )
}
