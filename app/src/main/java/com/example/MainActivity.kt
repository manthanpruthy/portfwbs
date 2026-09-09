package com.example

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.data.PortfolioRepository
import com.example.data.SkillCategory
import com.example.data.SkillItem
import com.example.data.SynergyNode
import com.example.ui.components.AboutSection
import com.example.ui.components.AppViewMode
import com.example.ui.components.BeyondSection
import com.example.ui.components.ContactSection
import com.example.ui.components.ExperienceSection
import com.example.ui.components.FooterSection
import com.example.ui.components.HeroSection
import com.example.ui.components.LeadershipSection
import com.example.ui.components.LearningSection
import com.example.ui.components.LiveWebView
import com.example.ui.components.NavigationDrawerContent
import com.example.ui.components.SkillsSection
import com.example.ui.components.TopNavigationHeader
import com.example.ui.theme.CanvasBase
import com.example.ui.theme.MyApplicationTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    enableEdgeToEdge()
    setContent {
      MyApplicationTheme {
        PortfolioApp()
      }
    }
  }
}

@Composable
fun PortfolioApp() {
  val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
  val scope = rememberCoroutineScope()
  val lazyListState = rememberLazyListState()

  var viewMode by remember { mutableStateOf(AppViewMode.NATIVE_EDITORIAL) }
  var selectedSynergyNode by remember { mutableStateOf<SynergyNode?>(PortfolioRepository.synergyNodes.first()) }
  var selectedSkillCategory by remember { mutableStateOf(SkillCategory.ALL) }
  var selectedSkill by remember { mutableStateOf<SkillItem?>(PortfolioRepository.skills.first()) }

  // Derive chapter indicator
  val currentChapterBadge by remember {
    derivedStateOf {
      when (lazyListState.firstVisibleItemIndex) {
        0 -> "PROLOGUE"
        1 -> "CHAPTER I · 01"
        2 -> "CHAPTER II · 02"
        3 -> "CHAPTER III · 03"
        4 -> "CHAPTER IV · 04"
        5 -> "CHAPTER V · 05"
        6 -> "CHAPTER VI · 06"
        else -> "CHAPTER VII · 07"
      }
    }
  }

  val currentChapterIndex by remember {
    derivedStateOf {
      when (lazyListState.firstVisibleItemIndex) {
        0 -> 1
        1 -> 1
        2 -> 2
        3 -> 3
        4 -> 4
        5 -> 5
        6 -> 6
        else -> 7
      }
    }
  }

  ModalNavigationDrawer(
    drawerState = drawerState,
    drawerContent = {
      NavigationDrawerContent(
        currentChapterIndex = currentChapterIndex,
        onChapterSelect = { chapterIdx ->
          scope.launch {
            if (viewMode == AppViewMode.LIVE_WEB_MONOGRAPH) {
              viewMode = AppViewMode.NATIVE_EDITORIAL
            }
            lazyListState.animateScrollToItem(chapterIdx)
          }
        },
        onCloseDrawer = {
          scope.launch { drawerState.close() }
        }
      )
    },
    modifier = Modifier.testTag("portfolio_modal_drawer")
  ) {
    Scaffold(
      modifier = Modifier
        .fillMaxSize()
        .background(CanvasBase),
      contentWindowInsets = WindowInsets(0, 0, 0, 0)
    ) { innerPadding ->
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(CanvasBase)
          .padding(innerPadding)
      ) {
        if (viewMode == AppViewMode.LIVE_WEB_MONOGRAPH) {
          // Live responsive WebView mode
          Box(
            modifier = Modifier
              .fillMaxSize()
              .statusBarsPadding()
              .navigationBarsPadding()
          ) {
            LiveWebView(
              modifier = Modifier
                .fillMaxSize()
                .padding(top = 64.dp)
            )
          }
        } else {
          // Native Compose Editorial Monograph
          LazyColumn(
            state = lazyListState,
            modifier = Modifier
              .fillMaxSize()
              .testTag("portfolio_scroll_container")
          ) {
            // Spacer for floating header
            item(key = "top_spacer") {
              Spacer(modifier = Modifier.height(72.dp))
            }

            // Hero Section (Prologue)
            item(key = "hero") {
              HeroSection(
                onExploreClick = {
                  scope.launch {
                    lazyListState.animateScrollToItem(2) // Jump to About Section
                  }
                },
                onContactClick = {
                  scope.launch {
                    lazyListState.animateScrollToItem(8) // Jump to Contact Section
                  }
                }
              )
            }

            // Chapter I: About
            item(key = "about") {
              AboutSection(
                selectedNode = selectedSynergyNode,
                onNodeSelect = { selectedSynergyNode = it }
              )
            }

            // Chapter II: Experience
            item(key = "experience") {
              ExperienceSection()
            }

            // Chapter III: Leadership
            item(key = "leadership") {
              LeadershipSection()
            }

            // Chapter IV: Skills
            item(key = "skills") {
              SkillsSection(
                selectedCategory = selectedSkillCategory,
                onCategorySelect = { selectedSkillCategory = it },
                selectedSkill = selectedSkill,
                onSkillSelect = { selectedSkill = it }
              )
            }

            // Chapter V: Learning
            item(key = "learning") {
              LearningSection()
            }

            // Chapter VI: Beyond the Classroom
            item(key = "beyond") {
              BeyondSection()
            }

            // Chapter VII: What's Next & Contact
            item(key = "contact") {
              ContactSection()
            }

            // Footer
            item(key = "footer") {
              FooterSection(
                onScrollToTop = {
                  scope.launch {
                    lazyListState.animateScrollToItem(0)
                  }
                }
              )
            }

            // Bottom navigation bar padding spacer
            item(key = "bottom_spacer") {
              Spacer(modifier = Modifier.navigationBarsPadding())
            }
          }
        }

        // Pinned Top Navigation Floating Header
        TopNavigationHeader(
          currentChapter = if (viewMode == AppViewMode.LIVE_WEB_MONOGRAPH) "WEB VIEW" else currentChapterBadge,
          currentMode = viewMode,
          onToggleMode = {
            viewMode = if (viewMode == AppViewMode.NATIVE_EDITORIAL) {
              AppViewMode.LIVE_WEB_MONOGRAPH
            } else {
              AppViewMode.NATIVE_EDITORIAL
            }
          },
          onOpenDrawer = {
            scope.launch { drawerState.open() }
          },
          modifier = Modifier
            .align(Alignment.TopCenter)
            .statusBarsPadding()
        )
      }
    }
  }
}
