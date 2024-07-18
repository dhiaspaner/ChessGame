package theme.font

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import org.jetbrains.compose.resources.Font
import resources.Res
import resources.cairo_extra_bold


internal val CairoFontFamily: FontFamily
    @Composable
    get() =
        FontFamily(
            Font(
                Res.font.cairo_extra_bold,
                weight = FontWeight.ExtraBold,
            ),
        )