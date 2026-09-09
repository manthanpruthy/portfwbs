package com.example.ui.components

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.Business
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.OpenInNew
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Pool
import androidx.compose.material.icons.filled.Psychology
import androidx.compose.material.icons.filled.SatelliteAlt
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.SportsSoccer
import androidx.compose.material.icons.filled.Terminal
import androidx.compose.material.icons.filled.VolunteerActivism
import androidx.compose.material.icons.filled.Waves
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.data.ExperienceItem
import com.example.data.FoundationalLeadership
import com.example.data.LeadershipCard
import com.example.data.LearningItem
import com.example.data.PortfolioRepository
import com.example.data.SkillCategory
import com.example.data.SkillItem
import com.example.data.SynergyNode
import com.example.ui.theme.AccentAmberBronze
import com.example.ui.theme.AccentPaleGold
import com.example.ui.theme.BorderHairlineMetallic
import com.example.ui.theme.BorderHairlineSubtle
import com.example.ui.theme.SurfaceElevation1
import com.example.ui.theme.SurfaceElevation2
import com.example.ui.theme.SurfaceElevation3
import com.example.ui.theme.TextBodyStone
import com.example.ui.theme.TextMutedSilver
import com.example.ui.theme.TextPrimaryIvory
import com.example.ui.theme.TextSecondaryPearl

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HeroSection(
  onExploreClick: () -> Unit,
  onContactClick: () -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 32.dp)
      .testTag("hero_section"),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    // Status Pill
    Surface(
      shape = RoundedCornerShape(50.dp),
      color = SurfaceElevation1,
      border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic),
      modifier = Modifier.testTag("hero_status_pill")
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 14.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
      ) {
        Box(
          modifier = Modifier
            .size(7.dp)
            .clip(CircleShape)
            .background(AccentAmberBronze)
        )
        Text(
          text = "AVAILABLE FOR OPPORTUNITIES",
          style = MaterialTheme.typography.labelSmall,
          fontSize = 10.sp,
          letterSpacing = 1.4.sp,
          color = AccentPaleGold,
          fontWeight = FontWeight.Medium
        )
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Name Headline
    Text(
      text = PortfolioRepository.profileName,
      style = MaterialTheme.typography.displayLarge,
      color = TextPrimaryIvory,
      textAlign = TextAlign.Center,
      modifier = Modifier.testTag("hero_headline_name")
    )

    Spacer(modifier = Modifier.height(12.dp))

    // Subtitle
    Text(
      text = PortfolioRepository.headline,
      style = MaterialTheme.typography.bodyLarge,
      color = TextSecondaryPearl,
      textAlign = TextAlign.Center,
      lineHeight = 22.sp,
      modifier = Modifier.padding(horizontal = 8.dp)
    )

    Spacer(modifier = Modifier.height(14.dp))

    // Editorial Quote
    Text(
      text = PortfolioRepository.quote,
      style = MaterialTheme.typography.headlineSmall,
      color = TextBodyStone,
      textAlign = TextAlign.Center,
      modifier = Modifier.padding(horizontal = 12.dp)
    )

    Spacer(modifier = Modifier.height(24.dp))

    // Category Focus Pills
    FlowRow(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 4.dp),
      horizontalArrangement = Arrangement.Center,
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      PortfolioRepository.specialtyPills.forEach { pill ->
        Surface(
          shape = RoundedCornerShape(50.dp),
          color = SurfaceElevation1,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
          modifier = Modifier.padding(horizontal = 3.dp)
        ) {
          Text(
            text = pill.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            fontSize = 9.sp,
            letterSpacing = 1.sp,
            color = TextSecondaryPearl,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(28.dp))

    // CTAs
    Row(
      horizontalArrangement = Arrangement.spacedBy(12.dp),
      verticalAlignment = Alignment.CenterVertically
    ) {
      Button(
        onClick = onExploreClick,
        colors = ButtonDefaults.buttonColors(
          containerColor = AccentAmberBronze,
          contentColor = SurfaceElevation1
        ),
        shape = RoundedCornerShape(50.dp),
        modifier = Modifier.testTag("hero_explore_button")
      ) {
        Text(
          text = "EXPLORE JOURNEY",
          style = MaterialTheme.typography.labelLarge,
          letterSpacing = 1.sp,
          fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.width(6.dp))
        Icon(
          imageVector = Icons.Default.ArrowDownward,
          contentDescription = null,
          modifier = Modifier.size(16.dp)
        )
      }

      OutlinedButton(
        onClick = onContactClick,
        shape = RoundedCornerShape(50.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic),
        colors = ButtonDefaults.outlinedButtonColors(
          contentColor = AccentPaleGold
        ),
        modifier = Modifier.testTag("hero_contact_button")
      ) {
        Text(
          text = "INITIATE CONTACT",
          style = MaterialTheme.typography.labelLarge,
          letterSpacing = 1.sp
        )
        Spacer(modifier = Modifier.width(6.dp))
        Icon(
          imageVector = Icons.Default.OpenInNew,
          contentDescription = null,
          modifier = Modifier.size(14.dp)
        )
      }
    }
  }
}

@Composable
fun ChapterHeader(
  chapterLabel: String,
  title: String,
  subtitle: String? = null,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(bottom = 18.dp)
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically,
      horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
      Text(
        text = chapterLabel.uppercase(),
        style = MaterialTheme.typography.labelSmall,
        fontSize = 11.sp,
        letterSpacing = 1.6.sp,
        color = AccentPaleGold,
        fontWeight = FontWeight.SemiBold
      )
      Box(
        modifier = Modifier
          .width(36.dp)
          .height(1.dp)
          .background(AccentAmberBronze.copy(alpha = 0.5f))
      )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text(
      text = title,
      style = MaterialTheme.typography.headlineLarge,
      color = TextPrimaryIvory
    )
    if (subtitle != null) {
      Spacer(modifier = Modifier.height(4.dp))
      Text(
        text = subtitle,
        style = MaterialTheme.typography.bodySmall,
        color = TextBodyStone
      )
    }
  }
}

@Composable
fun AboutSection(
  selectedNode: SynergyNode?,
  onNodeSelect: (SynergyNode) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("about_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter I · About",
      title = "More than one lane."
    )

    Surface(
      shape = RoundedCornerShape(16.dp),
      color = SurfaceElevation1,
      border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
      modifier = Modifier.fillMaxWidth()
    ) {
      Column(
        modifier = Modifier.padding(20.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
      ) {
        Text(
          text = "I'm a second-year Artificial Intelligence & Data Science engineering student at REVA University, curious about how Technology, Data, Business and People come together.",
          style = MaterialTheme.typography.bodyLarge,
          color = TextSecondaryPearl,
          lineHeight = 22.sp
        )

        Text(
          text = "I enjoy exploring new areas, learning through hands-on experiences and taking on roles where I can communicate, organise, collaborate and solve problems.",
          style = MaterialTheme.typography.bodyMedium,
          color = TextBodyStone,
          lineHeight = 20.sp
        )

        Text(
          text = "My experiences have taken me across PR, finance, event management, Leadership and AI-focused learning.",
          style = MaterialTheme.typography.bodyMedium,
          color = TextBodyStone,
          lineHeight = 20.sp
        )

        Spacer(modifier = Modifier.height(4.dp))

        Row(
          modifier = Modifier.fillMaxWidth(),
          horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
          Surface(
            shape = RoundedCornerShape(8.dp),
            color = SurfaceElevation2,
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
            modifier = Modifier.weight(1f)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Icon(
                imageVector = Icons.Default.School,
                contentDescription = null,
                tint = AccentPaleGold,
                modifier = Modifier.size(16.dp)
              )
              Text(
                text = PortfolioRepository.university,
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryPearl,
                fontSize = 10.sp
              )
            }
          }

          Surface(
            shape = RoundedCornerShape(8.dp),
            color = SurfaceElevation2,
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle)
          ) {
            Row(
              modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp),
              verticalAlignment = Alignment.CenterVertically,
              horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
              Icon(
                imageVector = Icons.Default.CalendarToday,
                contentDescription = null,
                tint = AccentPaleGold,
                modifier = Modifier.size(14.dp)
              )
              Text(
                text = PortfolioRepository.cohort,
                style = MaterialTheme.typography.labelSmall,
                color = TextSecondaryPearl,
                fontSize = 10.sp
              )
            }
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(20.dp))

    // Interactive Synergy Matrix
    SynergyMatrixView(
      selectedNode = selectedNode,
      onNodeSelect = onNodeSelect
    )
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ExperienceSection(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("experience_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter II · Experience",
      title = "Where I've learned by doing.",
      subtitle = "Industry Exposure · 2024–2025"
    )

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
      PortfolioRepository.experiences.forEach { exp ->
        ExperienceCard(item = exp)
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun ExperienceCard(item: ExperienceItem) {
  Surface(
    shape = RoundedCornerShape(16.dp),
    color = SurfaceElevation1,
    border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
    modifier = Modifier
      .fillMaxWidth()
      .testTag("experience_card_${item.company.lowercase()}")
  ) {
    Column(modifier = Modifier.padding(20.dp)) {
      Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
      ) {
        Column {
          Text(
            text = "${item.role.uppercase()} · ${item.duration}",
            style = MaterialTheme.typography.labelSmall,
            color = AccentPaleGold,
            letterSpacing = 1.sp,
            fontWeight = FontWeight.SemiBold
          )
          Text(
            text = item.company,
            style = MaterialTheme.typography.headlineMedium,
            color = TextPrimaryIvory
          )
        }

        Surface(
          shape = RoundedCornerShape(50.dp),
          color = SurfaceElevation2,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle)
        ) {
          Text(
            text = item.categoryTag,
            style = MaterialTheme.typography.labelSmall,
            fontSize = 9.sp,
            color = TextMutedSilver,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
          )
        }
      }

      Spacer(modifier = Modifier.height(12.dp))

      Text(
        text = item.description,
        style = MaterialTheme.typography.bodyMedium,
        color = TextBodyStone,
        lineHeight = 20.sp
      )

      Spacer(modifier = Modifier.height(16.dp))

      Box(
        modifier = Modifier
          .fillMaxWidth()
          .height(1.dp)
          .background(BorderHairlineSubtle)
      )

      Spacer(modifier = Modifier.height(12.dp))

      FlowRow(
        horizontalArrangement = Arrangement.spacedBy(6.dp),
        verticalArrangement = Arrangement.spacedBy(6.dp)
      ) {
        item.tags.forEach { tag ->
          Surface(
            shape = RoundedCornerShape(4.dp),
            color = SurfaceElevation2
          ) {
            Text(
              text = tag,
              style = MaterialTheme.typography.labelSmall,
              fontSize = 10.sp,
              color = TextSecondaryPearl,
              modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
            )
          }
        }
      }
    }
  }
}

@Composable
fun LeadershipSection(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("leadership_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter III · Leadership",
      title = "I like building things with people."
    )

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
      // Primary Mandate: Indian Data Club
      PortfolioRepository.mainLeadership.forEach { lead ->
        Surface(
          shape = RoundedCornerShape(16.dp),
          color = SurfaceElevation1,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic),
          modifier = Modifier
            .fillMaxWidth()
            .testTag("leadership_card_${lead.organization.replace(" ", "_").lowercase()}")
        ) {
          Column(modifier = Modifier.padding(20.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Surface(
                shape = RoundedCornerShape(50.dp),
                color = AccentAmberBronze.copy(alpha = 0.15f),
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic)
              ) {
                Text(
                  text = lead.badge.uppercase(),
                  style = MaterialTheme.typography.labelSmall,
                  fontSize = 9.sp,
                  color = AccentPaleGold,
                  letterSpacing = 1.sp,
                  modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
              }
              Text(
                text = lead.subBadge,
                style = MaterialTheme.typography.labelSmall,
                color = TextMutedSilver
              )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = lead.organization,
              style = MaterialTheme.typography.headlineMedium,
              color = TextPrimaryIvory
            )
            Text(
              text = lead.role,
              style = MaterialTheme.typography.labelMedium,
              color = AccentPaleGold,
              letterSpacing = 0.8.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
              text = lead.description,
              style = MaterialTheme.typography.bodyMedium,
              color = TextBodyStone,
              lineHeight = 20.sp
            )

            if (lead.metrics.isNotEmpty()) {
              Spacer(modifier = Modifier.height(16.dp))
              Row(
                modifier = Modifier
                  .fillMaxWidth()
                  .clip(RoundedCornerShape(10.dp))
                  .background(SurfaceElevation2)
                  .border(1.dp, BorderHairlineSubtle, RoundedCornerShape(10.dp))
                  .padding(12.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
              ) {
                lead.metrics.forEach { metric ->
                  Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                      text = metric.value,
                      style = MaterialTheme.typography.headlineSmall,
                      color = if (metric.value.contains("12+")) AccentPaleGold else TextPrimaryIvory,
                      fontWeight = FontWeight.Bold
                    )
                    Text(
                      text = metric.label.uppercase(),
                      style = MaterialTheme.typography.labelSmall,
                      fontSize = 8.sp,
                      color = TextMutedSilver,
                      letterSpacing = 0.8.sp
                    )
                  }
                }
              }
            }

            if (lead.tags.isNotEmpty()) {
              Spacer(modifier = Modifier.height(12.dp))
              Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(6.dp)
              ) {
                lead.tags.forEach { tag ->
                  Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = SurfaceElevation2
                  ) {
                    Text(
                      text = tag,
                      style = MaterialTheme.typography.labelSmall,
                      fontSize = 9.sp,
                      color = TextSecondaryPearl,
                      modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                  }
                }
              }
            }
          }
        }
      }

      // Foundational Leadership Track Record
      Surface(
        shape = RoundedCornerShape(16.dp),
        color = SurfaceElevation1.copy(alpha = 0.7f),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
        modifier = Modifier.fillMaxWidth()
      ) {
        Column(modifier = Modifier.padding(18.dp)) {
          Text(
            text = "FOUNDATIONAL LEADERSHIP TRACK RECORD",
            style = MaterialTheme.typography.labelSmall,
            color = TextMutedSilver,
            letterSpacing = 1.4.sp
          )
          Spacer(modifier = Modifier.height(14.dp))

          Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
            PortfolioRepository.foundationalLeadership.forEach { item ->
              Surface(
                shape = RoundedCornerShape(10.dp),
                color = SurfaceElevation2,
                border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
                modifier = Modifier.fillMaxWidth()
              ) {
                Column(modifier = Modifier.padding(14.dp)) {
                  Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                  ) {
                    Text(
                      text = item.title,
                      style = MaterialTheme.typography.titleSmall,
                      color = TextPrimaryIvory,
                      fontWeight = FontWeight.SemiBold
                    )
                    Text(
                      text = item.category.uppercase(),
                      style = MaterialTheme.typography.labelSmall,
                      fontSize = 9.sp,
                      color = AccentPaleGold
                    )
                  }
                  Text(
                    text = item.organization,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextMutedSilver,
                    fontSize = 11.sp
                  )
                  Spacer(modifier = Modifier.height(4.dp))
                  Text(
                    text = item.description,
                    style = MaterialTheme.typography.bodySmall,
                    color = TextBodyStone,
                    lineHeight = 16.sp
                  )
                }
              }
            }
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun SkillsSection(
  selectedCategory: SkillCategory,
  onCategorySelect: (SkillCategory) -> Unit,
  selectedSkill: SkillItem?,
  onSkillSelect: (SkillItem) -> Unit,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("skills_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter IV · Skills",
      title = "Interactive Skill Ecosystem.",
      subtitle = "A tripartite taxonomy of people capabilities, professional rigor, and emerging technical interests."
    )

    // Filter Chips Row
    Row(
      modifier = Modifier
        .fillMaxWidth()
        .clip(RoundedCornerShape(50.dp))
        .background(SurfaceElevation1)
        .border(1.dp, BorderHairlineSubtle, RoundedCornerShape(50.dp))
        .padding(4.dp),
      horizontalArrangement = Arrangement.SpaceBetween
    ) {
      SkillCategory.values().forEach { cat ->
        val isSelected = selectedCategory == cat
        Surface(
          shape = RoundedCornerShape(50.dp),
          color = if (isSelected) AccentAmberBronze else Color.Transparent,
          modifier = Modifier
            .weight(1f)
            .clip(RoundedCornerShape(50.dp))
            .clickable { onCategorySelect(cat) }
            .testTag("skill_filter_${cat.name.lowercase()}")
        ) {
          Text(
            text = cat.label.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            fontSize = 10.sp,
            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
            color = if (isSelected) SurfaceElevation1 else TextMutedSilver,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(vertical = 8.dp)
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Filtered skill cards
    val displayedSkills = if (selectedCategory == SkillCategory.ALL) {
      PortfolioRepository.skills
    } else {
      PortfolioRepository.skills.filter { it.category == selectedCategory }
    }

    FlowRow(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(8.dp),
      verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
      displayedSkills.forEach { skill ->
        val isSelected = selectedSkill?.name == skill.name
        val borderColor by animateColorAsState(
          targetValue = if (isSelected) AccentPaleGold else BorderHairlineSubtle,
          animationSpec = tween(150),
          label = "skill_border"
        )
        val bgColor by animateColorAsState(
          targetValue = if (isSelected) SurfaceElevation3 else SurfaceElevation1,
          animationSpec = tween(150),
          label = "skill_bg"
        )

        Surface(
          shape = RoundedCornerShape(10.dp),
          color = bgColor,
          border = androidx.compose.foundation.BorderStroke(1.dp, borderColor),
          modifier = Modifier
            .fillMaxWidth(0.485f)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onSkillSelect(skill) }
            .testTag("skill_card_${skill.name.replace(" ", "_").lowercase()}")
        ) {
          Column(modifier = Modifier.padding(12.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Box(
                modifier = Modifier
                  .size(6.dp)
                  .clip(CircleShape)
                  .background(
                    when (skill.category) {
                      SkillCategory.PEOPLE -> AccentAmberBronze
                      SkillCategory.PROFESSIONAL -> TextSecondaryPearl
                      SkillCategory.INTERESTS -> AccentPaleGold
                      else -> AccentAmberBronze
                    }
                  )
              )
              Text(
                text = skill.category.label.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 8.sp,
                color = TextMutedSilver
              )
            }
            Spacer(modifier = Modifier.height(6.dp))
            Text(
              text = skill.name,
              style = MaterialTheme.typography.titleSmall,
              color = TextPrimaryIvory,
              fontSize = 12.sp,
              fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
              text = skill.summary,
              style = MaterialTheme.typography.bodySmall,
              color = TextBodyStone,
              fontSize = 10.sp,
              lineHeight = 14.sp,
              maxLines = 2
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(14.dp))

    // Interactive Skill Detail Inspection Panel
    Surface(
      shape = RoundedCornerShape(10.dp),
      color = SurfaceElevation1,
      border = androidx.compose.foundation.BorderStroke(
        1.dp,
        if (selectedSkill != null) BorderHairlineMetallic else BorderHairlineSubtle
      ),
      modifier = Modifier
        .fillMaxWidth()
        .testTag("skill_detail_panel")
    ) {
      Row(
        modifier = Modifier.padding(horizontal = 14.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
      ) {
        Icon(
          imageVector = Icons.Default.Info,
          contentDescription = null,
          tint = if (selectedSkill != null) AccentPaleGold else TextMutedSilver,
          modifier = Modifier.size(18.dp)
        )
        Column(modifier = Modifier.weight(1f)) {
          if (selectedSkill != null) {
            Text(
              text = "${selectedSkill.name} · ${selectedSkill.category.label}",
              style = MaterialTheme.typography.labelMedium,
              color = AccentPaleGold,
              fontWeight = FontWeight.SemiBold
            )
            Text(
              text = selectedSkill.details,
              style = MaterialTheme.typography.bodySmall,
              color = TextSecondaryPearl,
              lineHeight = 17.sp
            )
          } else {
            Text(
              text = "Tap any skill card above to inspect applied context & methodology.",
              style = MaterialTheme.typography.bodySmall,
              color = TextBodyStone
            )
          }
        }
      }
    }
  }
}

@Composable
fun LearningSection(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("learning_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter V · Learning",
      title = "Always learning something new.",
      subtitle = "Specialized intensive workshops, technical sensor certifications, and civic engagements."
    )

    Column(verticalArrangement = Arrangement.spacedBy(14.dp)) {
      PortfolioRepository.learningItems.forEach { item ->
        Surface(
          shape = RoundedCornerShape(16.dp),
          color = SurfaceElevation1,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
          modifier = Modifier.fillMaxWidth()
        ) {
          Column(modifier = Modifier.padding(18.dp)) {
            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.Top
            ) {
              Box(
                modifier = Modifier
                  .size(36.dp)
                  .clip(RoundedCornerShape(8.dp))
                  .background(SurfaceElevation2)
                  .border(1.dp, BorderHairlineSubtle, RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center
              ) {
                Icon(
                  imageVector = when (item.iconName) {
                    "terminal" -> Icons.Default.Terminal
                    "satellite_alt" -> Icons.Default.SatelliteAlt
                    else -> Icons.Default.VolunteerActivism
                  },
                  contentDescription = null,
                  tint = AccentPaleGold,
                  modifier = Modifier.size(20.dp)
                )
              }

              Surface(
                shape = RoundedCornerShape(50.dp),
                color = SurfaceElevation2
              ) {
                Text(
                  text = item.category.uppercase(),
                  style = MaterialTheme.typography.labelSmall,
                  fontSize = 9.sp,
                  color = AccentPaleGold,
                  modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                )
              }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Text(
              text = item.title,
              style = MaterialTheme.typography.headlineMedium,
              fontSize = 18.sp,
              color = TextPrimaryIvory
            )

            Spacer(modifier = Modifier.height(6.dp))

            Text(
              text = item.description,
              style = MaterialTheme.typography.bodyMedium,
              color = TextBodyStone,
              lineHeight = 20.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
              modifier = Modifier.fillMaxWidth(),
              horizontalArrangement = Arrangement.SpaceBetween,
              verticalAlignment = Alignment.CenterVertically
            ) {
              Text(
                text = item.outcome,
                style = MaterialTheme.typography.labelSmall,
                color = TextMutedSilver
              )
              Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = null,
                tint = AccentPaleGold,
                modifier = Modifier.size(14.dp)
              )
            }
          }
        }
      }
    }
  }
}

@Composable
fun BeyondSection(modifier: Modifier = Modifier) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("beyond_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter VI · Beyond the Classroom",
      title = "Compete. Learn. Improve."
    )

    // Quote
    Surface(
      shape = RoundedCornerShape(12.dp),
      color = SurfaceElevation1,
      border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
      modifier = Modifier.fillMaxWidth()
    ) {
      Row(
        modifier = Modifier.padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
      ) {
        Box(
          modifier = Modifier
            .width(3.dp)
            .height(54.dp)
            .background(AccentAmberBronze)
        )
        Text(
          text = "“Sports have been an important part of my journey, helping me develop discipline, consistency, competitiveness and teamwork.”",
          style = MaterialTheme.typography.headlineSmall,
          fontSize = 15.sp,
          color = TextSecondaryPearl,
          lineHeight = 22.sp
        )
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // 4 Pillars Grid
    Row(
      modifier = Modifier.fillMaxWidth(),
      horizontalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      val pillars = listOf(
        "Discipline" to "Daily regimen",
        "Consistency" to "Steady reps",
        "Competition" to "Calibrated drive",
        "Teamwork" to "Relay trust"
      )
      pillars.forEach { (name, sub) ->
        Surface(
          shape = RoundedCornerShape(8.dp),
          color = SurfaceElevation1,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
          modifier = Modifier.weight(1f)
        ) {
          Column(
            modifier = Modifier.padding(vertical = 10.dp, horizontal = 4.dp),
            horizontalAlignment = Alignment.CenterHorizontally
          ) {
            Text(
              text = name.uppercase(),
              style = MaterialTheme.typography.labelSmall,
              fontSize = 9.sp,
              color = AccentPaleGold,
              fontWeight = FontWeight.SemiBold
            )
            Text(
              text = sub,
              style = MaterialTheme.typography.bodySmall,
              fontSize = 8.sp,
              color = TextMutedSilver
            )
          }
        }
      }
    }

    Spacer(modifier = Modifier.height(16.dp))

    // Athletic credentials
    Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
      PortfolioRepository.athleticCredentials.forEach { cred ->
        Surface(
          shape = RoundedCornerShape(12.dp),
          color = SurfaceElevation1,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
          modifier = Modifier.fillMaxWidth()
        ) {
          Row(
            modifier = Modifier.padding(14.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalAlignment = Alignment.Top
          ) {
            Box(
              modifier = Modifier
                .size(34.dp)
                .clip(CircleShape)
                .background(SurfaceElevation2)
                .border(1.dp, BorderHairlineMetallic, CircleShape),
              contentAlignment = Alignment.Center
            ) {
              Icon(
                imageVector = when (cred.icon) {
                  "pool" -> Icons.Default.Pool
                  "waves" -> Icons.Default.Waves
                  else -> Icons.Default.SportsSoccer
                },
                contentDescription = null,
                tint = AccentPaleGold,
                modifier = Modifier.size(16.dp)
              )
            }

            Column(modifier = Modifier.weight(1f)) {
              Text(
                text = cred.level.uppercase(),
                style = MaterialTheme.typography.labelSmall,
                fontSize = 9.sp,
                color = AccentPaleGold,
                letterSpacing = 1.sp
              )
              Text(
                text = cred.title,
                style = MaterialTheme.typography.titleSmall,
                color = TextPrimaryIvory,
                fontWeight = FontWeight.SemiBold
              )
              Text(
                text = cred.context,
                style = MaterialTheme.typography.bodySmall,
                color = TextMutedSilver,
                fontSize = 11.sp
              )
              Spacer(modifier = Modifier.height(4.dp))
              Text(
                text = cred.description,
                style = MaterialTheme.typography.bodySmall,
                color = TextBodyStone,
                lineHeight = 16.sp
              )
            }
          }
        }
      }
    }
  }
}

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun ContactSection(
  context: Context = LocalContext.current,
  modifier: Modifier = Modifier
) {
  Column(
    modifier = modifier
      .fillMaxWidth()
      .padding(horizontal = 20.dp, vertical = 24.dp)
      .testTag("contact_section")
  ) {
    ChapterHeader(
      chapterLabel = "Chapter VII · What's Next?",
      title = "I'm still early in the journey.",
      subtitle = "Interested in high-impact opportunities where I can learn, contribute, and experiment across technology and business."
    )

    // Domain Tags
    FlowRow(
      horizontalArrangement = Arrangement.spacedBy(6.dp),
      verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
      val domains = listOf(
        "AI & Data Science",
        "Technology Systems",
        "Business Strategy",
        "Product Innovation",
        "Communication & PR",
        "Analytics",
        "Student Leadership",
        "Internships"
      )
      domains.forEach { domain ->
        Surface(
          shape = RoundedCornerShape(50.dp),
          color = SurfaceElevation1,
          border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle)
        ) {
          Text(
            text = domain.uppercase(),
            style = MaterialTheme.typography.labelSmall,
            fontSize = 9.sp,
            color = if (domain.contains("AI") || domain.contains("PR") || domain.contains("Intern"))
              AccentPaleGold
            else
              TextSecondaryPearl,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp)
          )
        }
      }
    }

    Spacer(modifier = Modifier.height(24.dp))

    // Executive Contact Card
    Surface(
      shape = RoundedCornerShape(20.dp),
      color = SurfaceElevation1,
      border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic),
      shadowElevation = 8.dp,
      modifier = Modifier
        .fillMaxWidth()
        .testTag("contact_executive_card")
    ) {
      Column(modifier = Modifier.padding(22.dp)) {
        Text(
          text = "INITIATE COLLABORATION",
          style = MaterialTheme.typography.labelSmall,
          color = AccentPaleGold,
          letterSpacing = 1.4.sp
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Let's build something interesting.",
          style = MaterialTheme.typography.headlineMedium,
          color = TextPrimaryIvory
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
          text = "Always open to meaningful conversations, high-impact opportunities, and new ideas.",
          style = MaterialTheme.typography.bodyMedium,
          color = TextBodyStone
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Action Buttons
        Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
          // Email Me Button
          Button(
            onClick = {
              val intent = Intent(Intent.ACTION_SENDTO).apply {
                data = Uri.parse("mailto:${PortfolioRepository.email}")
                putExtra(Intent.EXTRA_SUBJECT, "Collaboration & Opportunities · Manthan Pruthy")
              }
              try {
                context.startActivity(intent)
              } catch (e: Exception) {
                Toast.makeText(context, "Contact: ${PortfolioRepository.email}", Toast.LENGTH_LONG).show()
              }
            },
            colors = ButtonDefaults.buttonColors(
              containerColor = AccentAmberBronze,
              contentColor = SurfaceElevation1
            ),
            shape = RoundedCornerShape(50.dp),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("contact_email_button")
          ) {
            Icon(
              imageVector = Icons.Default.Email,
              contentDescription = null,
              modifier = Modifier.size(18.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "EMAIL ME",
              style = MaterialTheme.typography.labelLarge,
              fontWeight = FontWeight.Bold,
              letterSpacing = 1.sp
            )
          }

          // LinkedIn Button
          OutlinedButton(
            onClick = {
              val intent = Intent(Intent.ACTION_VIEW, Uri.parse(PortfolioRepository.linkedinUrl))
              try {
                context.startActivity(intent)
              } catch (e: Exception) {
                Toast.makeText(context, "Opening LinkedIn...", Toast.LENGTH_SHORT).show()
              }
            },
            shape = RoundedCornerShape(50.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineMetallic),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = AccentPaleGold),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("contact_linkedin_button")
          ) {
            Icon(
              imageVector = Icons.Default.OpenInNew,
              contentDescription = null,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "CONNECT ON LINKEDIN",
              style = MaterialTheme.typography.labelLarge,
              letterSpacing = 1.sp
            )
          }

          // Download / Share Dossier Button
          OutlinedButton(
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
            shape = RoundedCornerShape(50.dp),
            border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = TextSecondaryPearl),
            modifier = Modifier
              .fillMaxWidth()
              .testTag("contact_dossier_button")
          ) {
            Icon(
              imageVector = Icons.Default.Download,
              contentDescription = null,
              modifier = Modifier.size(16.dp)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
              text = "SHARE DOSSIER OVERVIEW",
              style = MaterialTheme.typography.labelLarge,
              letterSpacing = 1.sp
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

        // Direct Quick Contacts
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
          Row(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp))
              .clickable {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${PortfolioRepository.phoneRaw}"))
                try {
                  context.startActivity(intent)
                } catch (e: Exception) {
                  Toast.makeText(context, PortfolioRepository.phone, Toast.LENGTH_SHORT).show()
                }
              }
              .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Phone,
              contentDescription = null,
              tint = AccentPaleGold,
              modifier = Modifier.size(16.dp)
            )
            Text(
              text = PortfolioRepository.phone,
              style = MaterialTheme.typography.bodyMedium,
              color = TextSecondaryPearl
            )
          }

          Row(
            modifier = Modifier
              .fillMaxWidth()
              .clip(RoundedCornerShape(8.dp))
              .clickable {
                val intent = Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:${PortfolioRepository.email}"))
                try {
                  context.startActivity(intent)
                } catch (e: Exception) {
                  Toast.makeText(context, PortfolioRepository.email, Toast.LENGTH_SHORT).show()
                }
              }
              .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
          ) {
            Icon(
              imageVector = Icons.Default.Email,
              contentDescription = null,
              tint = AccentPaleGold,
              modifier = Modifier.size(16.dp)
            )
            Text(
              text = PortfolioRepository.email,
              style = MaterialTheme.typography.bodyMedium,
              color = TextSecondaryPearl
            )
          }
        }
      }
    }
  }
}

@Composable
fun FooterSection(
  onScrollToTop: () -> Unit,
  modifier: Modifier = Modifier
) {
  Surface(
    color = SurfaceElevation1,
    border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
    modifier = modifier.fillMaxWidth()
  ) {
    Column(
      modifier = Modifier
        .fillMaxWidth()
        .padding(horizontal = 20.dp, vertical = 28.dp),
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = PortfolioRepository.profileName,
        style = MaterialTheme.typography.headlineMedium,
        color = TextPrimaryIvory
      )

      Spacer(modifier = Modifier.height(6.dp))

      Text(
        text = "© 2025 Manthan Pruthy. Architected with humanistic typography & refined editorial standards. REVA University.",
        style = MaterialTheme.typography.bodySmall,
        color = TextMutedSilver,
        textAlign = TextAlign.Center,
        lineHeight = 16.sp
      )

      Spacer(modifier = Modifier.height(18.dp))

      OutlinedButton(
        onClick = onScrollToTop,
        shape = RoundedCornerShape(50.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, BorderHairlineSubtle),
        colors = ButtonDefaults.outlinedButtonColors(contentColor = AccentPaleGold),
        modifier = Modifier.testTag("footer_scroll_top_button")
      ) {
        Icon(
          imageVector = Icons.Default.KeyboardArrowUp,
          contentDescription = null,
          modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(6.dp))
        Text(
          text = "BACK TO TOP",
          style = MaterialTheme.typography.labelSmall,
          letterSpacing = 1.sp
        )
      }
    }
  }
}
