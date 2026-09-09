package com.example.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Language
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.PhoneAndroid
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioRepository
import com.example.ui.theme.AccentAmberBronze
import com.example.ui.theme.AccentPaleGold
import com.example.ui.theme.BorderHairlineMetallic
import com.example.ui.theme.BorderHairlineSubtle
import com.example.ui.theme.SurfaceElevation1
import com.example.ui.theme.SurfaceElevation2
import com.example.ui.theme.TextPrimaryIvory
import com.example.ui.theme.TextSecondaryPearl

enum class AppViewMode {
  NATIVE_EDITORIAL,
  LIVE_WEB_MONOGRAPH
}

@Composable
fun TopNavigationHeader(
  currentChapter: String,
  currentMode: AppViewMode,
  onToggleMode: () -> Unit,
  onOpenDrawer: () -> Unit,
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 12.dp, vertical = 8.dp)
      .testTag("top_navigation_bar"),
    shape = RoundedCornerShape(50.dp),
    color = SurfaceElevation1.copy(alpha = 0.94f),
    border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
    shadowElevation = 8.dp
  ) {
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 10.dp, vertical = 6.dp),
      horizontalArrangement = Arrangement.SpaceBetween,
      verticalAlignment = Alignment.CenterVertically
    ) {
      // Left: Monogram + Name
      Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.testTag("header_identity_tag")
      ) {
        Box(
          modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .background(SurfaceElevation2)
            .border(1.dp, BorderHairlineMetallic, CircleShape),
          contentAlignment = Alignment.Center
        ) {
          Text(
            text = "MP",
            fontFamily = FontFamily.Serif,
            fontStyle = FontStyle.Italic,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            color = AccentPaleGold
          )
        }
        Spacer(modifier = Modifier.width(8.dp))
        Text(
          text = PortfolioRepository.profileName,
          style = MaterialTheme.typography.titleSmall,
          color = TextPrimaryIvory,
          fontWeight = FontWeight.SemiBold
        )
      }

      // Right: Chapter Badge + Mode Switcher + Drawer
      Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        // Chapter Badge
        Surface(
          shape = RoundedCornerShape(50.dp),
          color = SurfaceElevation2,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
          modifier = Modifier.testTag("chapter_badge_pill")
        ) {
          Text(
            text = currentChapter,
            style = MaterialTheme.typography.labelSmall,
            fontSize = 9.sp,
            color = AccentPaleGold,
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            letterSpacing = 1.sp
          )
        }

        // Web / Native View Toggle
        Surface(
          shape = RoundedCornerShape(50.dp),
          color = if (currentMode == AppViewMode.LIVE_WEB_MONOGRAPH)
            AccentAmberBronze.copy(alpha = 0.25f)
          else
            SurfaceElevation2,
          border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (currentMode == AppViewMode.LIVE_WEB_MONOGRAPH) BorderHairlineMetallic else BorderHairlineSubtle
          ),
          modifier = Modifier
            .clip(RoundedCornerShape(50.dp))
            .clickable(onClick = onToggleMode)
            .testTag("view_mode_toggle")
        ) {
          Row(
            modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(4.dp)
          ) {
            Icon(
              imageVector = if (currentMode == AppViewMode.LIVE_WEB_MONOGRAPH)
                Icons.Default.PhoneAndroid
              else
                Icons.Default.Language,
              contentDescription = "Switch presentation mode",
              tint = AccentPaleGold,
              modifier = Modifier.size(14.dp)
            )
            Text(
              text = if (currentMode == AppViewMode.LIVE_WEB_MONOGRAPH) "NATIVE" else "WEB",
              style = MaterialTheme.typography.labelSmall,
              fontSize = 9.sp,
              color = AccentPaleGold,
              letterSpacing = 1.sp
            )
          }
        }

        // Drawer Menu Button
        IconButton(
          onClick = onOpenDrawer,
          modifier = Modifier
            .size(34.dp)
            .testTag("drawer_menu_button")
        ) {
          Icon(
            imageVector = Icons.Default.Menu,
            contentDescription = "Open Chapters Menu",
            tint = TextSecondaryPearl,
            modifier = Modifier.size(18.dp)
          )
        }
      }
    }
  }
}
