package com.example.ui.components

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.PortfolioRepository
import com.example.data.SynergyNode
import com.example.ui.theme.AccentAmberBronze
import com.example.ui.theme.AccentPaleGold
import com.example.ui.theme.BorderHairlineMetallic
import com.example.ui.theme.BorderHairlineSubtle
import com.example.ui.theme.SurfaceElevation1
import com.example.ui.theme.SurfaceElevation2
import com.example.ui.theme.TextBodyStone
import com.example.ui.theme.TextMutedSilver
import com.example.ui.theme.TextPrimaryIvory
import com.example.ui.theme.TextSecondaryPearl

@Composable
fun SynergyMatrixView(
  selectedNode: SynergyNode?,
  onNodeSelect: (SynergyNode) -> Unit,
  modifier: Modifier = Modifier
) {
  Surface(
    modifier = modifier
      .fillMaxWidth()
      .testTag("synergy_matrix_card"),
    shape = RoundedCornerShape(16.dp),
    color = SurfaceElevation1,
    border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle)
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
      ) {
        Text(
          text = "SYNERGY MATRIX",
          style = MaterialTheme.typography.labelSmall,
          color = TextMutedSilver,
          letterSpacing = 2.sp
        )
        Box(
          modifier = Modifier
            .size(8.dp)
            .clip(CircleShape)
            .background(AccentAmberBronze)
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Orbital visual representation
      Box(
        modifier = Modifier
          .size(260.dp)
          .padding(8.dp),
        contentAlignment = Alignment.Center
      ) {
        // Orbit rings
        Canvas(modifier = Modifier.fillMaxSize()) {
          val center = this.center
          val radiusOuter = size.minDimension / 2f - 30.dp.toPx()
          val radiusInner = radiusOuter * 0.65f

          // Outer ring
          drawCircle(
            color = Color(0x33C5A059),
            radius = radiusOuter,
            center = center,
            style = Stroke(width = 1.dp.toPx())
          )

          // Inner ring
          drawCircle(
            color = Color(0x1FFFFFFF),
            radius = radiusInner,
            center = center,
            style = Stroke(width = 1.dp.toPx())
          )
        }

        // Center Core: Synthesis Core
        Box(
          modifier = Modifier
            .size(72.dp)
            .clip(CircleShape)
            .background(SurfaceElevation2)
            .border(1.dp, BorderHairlineMetallic, CircleShape),
          contentAlignment = Alignment.Center
        ) {
          Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
              text = "Synthesis",
              fontFamily = FontFamily.Serif,
              fontStyle = FontStyle.Italic,
              fontSize = 11.sp,
              color = AccentPaleGold
            )
            Text(
              text = "CORE",
              style = MaterialTheme.typography.labelSmall,
              fontSize = 8.sp,
              letterSpacing = 1.sp,
              color = TextMutedSilver
            )
          }
        }

        // Node Top: Technology
        val techNode = PortfolioRepository.synergyNodes.first { it.title == "Technology" }
        NodeChip(
          node = techNode,
          isSelected = selectedNode?.title == techNode.title,
          onClick = { onNodeSelect(techNode) },
          modifier = Modifier
            .align(Alignment.TopCenter)
            .testTag("synergy_node_technology")
        )

        // Node Right: Data
        val dataNode = PortfolioRepository.synergyNodes.first { it.title == "Data" }
        NodeChip(
          node = dataNode,
          isSelected = selectedNode?.title == dataNode.title,
          onClick = { onNodeSelect(dataNode) },
          modifier = Modifier
            .align(Alignment.CenterEnd)
            .testTag("synergy_node_data")
        )

        // Node Bottom: Business
        val bizNode = PortfolioRepository.synergyNodes.first { it.title == "Business" }
        NodeChip(
          node = bizNode,
          isSelected = selectedNode?.title == bizNode.title,
          onClick = { onNodeSelect(bizNode) },
          modifier = Modifier
            .align(Alignment.BottomCenter)
            .testTag("synergy_node_business")
        )

        // Node Left: People
        val peopleNode = PortfolioRepository.synergyNodes.first { it.title == "People" }
        NodeChip(
          node = peopleNode,
          isSelected = selectedNode?.title == peopleNode.title,
          onClick = { onNodeSelect(peopleNode) },
          modifier = Modifier
            .align(Alignment.CenterStart)
            .testTag("synergy_node_people")
        )
      }

      Spacer(modifier = Modifier.height(16.dp))

      // Status display panel
      AnimatedContent(
        targetState = selectedNode,
        transitionSpec = {
          fadeIn(animationSpec = tween(220)) togetherWith
              fadeOut(animationSpec = tween(180))
        },
        label = "synergy_details"
      ) { node ->
        Surface(
          modifier = Modifier
            .fillMaxWidth()
            .testTag("synergy_status_panel"),
          shape = RoundedCornerShape(10.dp),
          color = SurfaceElevation2,
          border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (node != null) BorderHairlineMetallic else BorderHairlineSubtle
          )
        ) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .padding(horizontal = 14.dp, vertical = 12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Info,
              contentDescription = "Synergy focus info",
              tint = if (node != null) AccentPaleGold else TextMutedSilver,
              modifier = Modifier.size(18.dp)
            )
            Column(modifier = Modifier.weight(1f)) {
              if (node != null) {
                Text(
                  text = "${node.title} · ${node.subtitle}",
                  style = MaterialTheme.typography.labelMedium,
                  color = AccentPaleGold,
                  fontWeight = FontWeight.SemiBold
                )
                Text(
                  text = node.description,
                  style = MaterialTheme.typography.bodySmall,
                  color = TextSecondaryPearl,
                  lineHeight = 17.sp
                )
              } else {
                Text(
                  text = "Tap any quadrant node above to inspect multidisciplinary focus.",
                  style = MaterialTheme.typography.bodySmall,
                  color = TextBodyStone
                )
              }
            }
          }
        }
      }
    }
  }
}

@Composable
private fun NodeChip(
  node: SynergyNode,
  isSelected: Boolean,
  onClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  val borderColor by animateColorAsState(
    targetValue = if (isSelected) AccentPaleGold else BorderHairlineSubtle,
    animationSpec = tween(200),
    label = "border_color"
  )
  val backgroundColor by animateColorAsState(
    targetValue = if (isSelected) AccentAmberBronze.copy(alpha = 0.2f) else SurfaceElevation2,
    animationSpec = tween(200),
    label = "bg_color"
  )
  val textColor by animateColorAsState(
    targetValue = if (isSelected) AccentPaleGold else TextSecondaryPearl,
    animationSpec = tween(200),
    label = "text_color"
  )

  Surface(
    modifier = modifier
      .clip(RoundedCornerShape(6.dp))
      .clickable(onClick = onClick),
    shape = RoundedCornerShape(6.dp),
    color = backgroundColor,
    border = androidx.compose.foundation.BorderStroke(1.dp, borderColor)
  ) {
    Text(
      text = node.title.uppercase(),
      style = MaterialTheme.typography.labelSmall,
      fontSize = 10.sp,
      fontWeight = FontWeight.SemiBold,
      letterSpacing = 1.sp,
      color = textColor,
      modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp),
      textAlign = TextAlign.Center
    )
  }
}
