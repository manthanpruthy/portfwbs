package com.example.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val ObsidianColorScheme = darkColorScheme(
  primary = PrimaryGold,
  onPrimary = OnPrimaryDark,
  primaryContainer = PrimaryContainerGold,
  onPrimaryContainer = OnPrimaryContainerDark,
  secondary = SecondaryPearl,
  onSecondary = OnSecondaryDark,
  tertiary = AccentAmberBronze,
  onTertiary = Color(0xFF14161B),
  background = BackgroundDark,
  onBackground = OnBackgroundLight,
  surface = SurfaceDark,
  onSurface = OnSurfaceLight,
  surfaceVariant = SurfaceVariantDark,
  onSurfaceVariant = OnSurfaceVariantLight,
  outline = BorderHairlineMetallic,
  outlineVariant = BorderHairlineSubtle,
)

private val LightEditorialColorScheme = lightColorScheme(
  primary = AccentAmberBronze,
  onPrimary = Color.White,
  primaryContainer = Color(0xFFFFDEA5),
  onPrimaryContainer = Color(0xFF261900),
  secondary = Color(0xFF4A4E54),
  onSecondary = Color.White,
  background = Color(0xFFFBF9F5),
  onBackground = Color(0xFF1C1E24),
  surface = Color(0xFFFFFFFF),
  onSurface = Color(0xFF1C1E24),
  surfaceVariant = Color(0xFFF0EDE6),
  onSurfaceVariant = Color(0xFF5A5C64),
  outline = Color(0xFFC5A059),
  outlineVariant = Color(0xFFE2DFD8),
)

@Composable
fun MyApplicationTheme(
  darkTheme: Boolean = true, // Default to Signature Obsidian Dark Theme
  content: @Composable () -> Unit,
) {
  val colorScheme = if (darkTheme) ObsidianColorScheme else LightEditorialColorScheme

  MaterialTheme(
    colorScheme = colorScheme,
    typography = EditorialTypography,
    content = content
  )
}
