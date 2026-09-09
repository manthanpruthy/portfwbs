package com.example.ui.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Download
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
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
import com.example.ui.theme.CanvasBase
import com.example.ui.theme.SurfaceElevation1
import com.example.ui.theme.SurfaceElevation2
import com.example.ui.theme.TextBodyStone
import com.example.ui.theme.TextMutedSilver
import com.example.ui.theme.TextPrimaryIvory
import com.example.ui.theme.TextSecondaryPearl

data class ChapterNavTarget(
  val number: String,
  val title: String,
  val chapterIndex: Int
)

val chapterTargets = listOf(
  ChapterNavTarget("01", "Chapter I · About", 1),
  ChapterNavTarget("02", "Chapter II · Experience", 2),
  ChapterNavTarget("03", "Chapter III · Leadership", 3),
  ChapterNavTarget("04", "Chapter IV · Skills", 4),
  ChapterNavTarget("05", "Chapter V · Learning", 5),
  ChapterNavTarget("06", "Chapter VI · Beyond", 6),
  ChapterNavTarget("07", "Chapter VII · Contact", 7)
)

@Composable
fun NavigationDrawerContent(
  currentChapterIndex: Int,
  onChapterSelect: (Int) -> Unit,
  onCloseDrawer: () -> Unit,
  context: Context = LocalContext.current,
  modifier: Modifier = Modifier
) {
  Surface(
    color = CanvasBase,
    modifier = modifier
      .fillMaxHeight()
      .width(300.dp)
      .testTag("side_navigation_drawer")
  ) {
    Column(
      modifier = Modifier
        .fillMaxHeight()
        .padding(20.dp),
      verticalArrangement = Arrangement.SpaceBetween
    ) {
      Column {
        // Drawer Header
        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.SpaceBetween,
          verticalAlignment = Alignment.CenterVertically
        ) {
          Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Box(
              modifier = Modifier
                .size(38.dp)
                .clip(CircleShape)
                .background(SurfaceElevation1)
                .border(1.dp, BorderHairlineMetallic, CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Text(
                text = "MP",
                fontFamily = FontFamily.Serif,
                fontStyle = FontStyle.Italic,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = AccentPaleGold
              )
            }
            Column {
              Text(
                text = PortfolioRepository.profileName,
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimaryIvory,
                fontWeight = FontWeight.SemiBold
              )
              Text(
                text = "AI & Data Science · REVA '26",
                style = MaterialTheme.typography.bodySmall,
                color = TextMutedSilver,
                fontSize = 10.sp
              )
            }
          }

          IconButton(
            onClick = onCloseDrawer,
            modifier = Modifier.testTag("drawer_close_button")
          ) {
            Icon(
              imageVector = Icons.Default.Close,
              contentDescription = "Close Menu",
              tint = TextMutedSilver
            )
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
          modifier = Modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(BorderHairlineSubtle)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Navigation Links
        Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
          chapterTargets.forEach { item ->
            val isActive = currentChapterIndex == item.chapterIndex

            Surface(
              shape = RoundedCornerShape(8.dp),
              color = if (isActive) SurfaceElevation1 else androidx.compose.ui.graphics.Color.Transparent,
              border = if (isActive)
                androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic)
              else
                null,
              modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .clickable {
                  onChapterSelect(item.chapterIndex)
                  onCloseDrawer()
                }
                .testTag("drawer_chapter_link_${item.number}")
            ) {
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .padding(horizontal = 12.dp, vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
              ) {
                Text(
                  text = item.title,
                  style = MaterialTheme.typography.labelSmall,
                  fontSize = 11.sp,
                  color = if (isActive) AccentPaleGold else TextBodyStone,
                  fontWeight = if (isActive) FontWeight.Bold else FontWeight.Normal,
                  letterSpacing = 0.8.sp
                )
                Text(
                  text = item.number,
                  style = MaterialTheme.typography.labelSmall,
                  fontSize = 9.sp,
                  color = TextMutedSilver
                )
              }
            }
          }
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Quick Dossier Action
        Button(
          onClick = {
            val dossierSummary = """
              MANTHAN PRUTHY — EXECUTIVE DOSSIER
              Technologist · AI & Data Science
              REVA University (Class of 2026)
              
              • Indian Data Club: Managing Director (500+ Community, 12+ Workshops)
              • Paytm: PR Intern (Fintech Scale)
              • GIVA: Finance Intern (D2C Commerce)
              • OSCODE: Event Management Team
              
              Contact: ${PortfolioRepository.email} | ${PortfolioRepository.phone}
            """.trimIndent()

            val shareIntent = Intent(Intent.ACTION_SEND).apply {
              type = "text/plain"
              putExtra(Intent.EXTRA_SUBJECT, "Executive Dossier - Manthan Pruthy")
              putExtra(Intent.EXTRA_TEXT, dossierSummary)
            }
            context.startActivity(Intent.createChooser(shareIntent, "Share Dossier"))
          },
          colors = ButtonDefaults.buttonColors(
            containerColor = SurfaceElevation1,
            contentColor = AccentPaleGold
          ),
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic),
          shape = RoundedCornerShape(8.dp),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("drawer_dossier_button")
        ) {
          Icon(
            imageVector = Icons.Default.Download,
            contentDescription = null,
            modifier = Modifier.size(16.dp)
          )
          Spacer(modifier = Modifier.width(6.dp))
          Text(
            text = "DOWNLOAD DOSSIER",
            style = MaterialTheme.typography.labelSmall,
            letterSpacing = 1.sp
          )
        }
      }

      // Drawer Footer
      Row(
        modifier = Modifier
          .fillMaxWidth()
          .border(1.dp, BorderHairlineSubtle, RoundedCornerShape(8.dp))
          .background(SurfaceElevation1, RoundedCornerShape(8.dp))
          .padding(horizontal = 12.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "Status",
          style = MaterialTheme.typography.labelSmall,
          color = TextMutedSilver
        )
        Row(
          verticalAlignment = Alignment.CenterVertically,
          horizontalArrangement = Arrangement.spacedBy(6.dp)
        ) {
          Box(
            modifier = Modifier
              .size(6.dp)
              .clip(CircleShape)
              .background(AccentAmberBronze)
          )
          Text(
            text = "Available for Opportunities",
            style = MaterialTheme.typography.labelSmall,
            fontSize = 9.sp,
            color = AccentPaleGold
          )
        }
      }
    }
  }
}
