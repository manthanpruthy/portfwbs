package com.example.ui.components

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.viewinterop.AndroidView
import com.example.ui.theme.AccentAmberBronze
import com.example.ui.theme.CanvasBase

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun LiveWebView(
  modifier: Modifier = Modifier
) {
  var isLoading by remember { mutableStateOf(true) }

  Box(
    modifier = modifier
      .fillMaxSize()
      .background(CanvasBase)
      .testTag("live_webview_container")
  ) {
    AndroidView(
      factory = { ctx ->
        WebView(ctx).apply {
          setBackgroundColor(CanvasBase.toArgb())
          settings.apply {
            javaScriptEnabled = true
            domStorageEnabled = true
            databaseEnabled = true
            loadWithOverviewMode = true
            useWideViewPort = true
            cacheMode = WebSettings.LOAD_DEFAULT
            allowFileAccess = true
            allowContentAccess = true
          }
          webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
              super.onPageStarted(view, url, favicon)
              isLoading = true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
              super.onPageFinished(view, url)
              isLoading = false
            }

            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
              val url = request?.url?.toString() ?: return false
              if (url.startsWith("mailto:") || url.startsWith("tel:")) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                try {
                  ctx.startActivity(intent)
                } catch (e: Exception) {
                  // Ignore
                }
                return true
              }
              if (url.startsWith("http://") || url.startsWith("https://")) {
                if (!url.contains("localhost") && !url.contains("android_asset")) {
                  val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                  try {
                    ctx.startActivity(intent)
                  } catch (e: Exception) {
                    // Ignore
                  }
                  return true
                }
              }
              return false
            }
          }
          loadUrl("file:///android_asset/portfolio.html")
        }
      },
      modifier = Modifier
        .fillMaxSize()
        .testTag("portfolio_webview")
    )

    if (isLoading) {
      Box(
        modifier = Modifier
          .fillMaxSize()
          .background(CanvasBase.copy(alpha = 0.8f)),
        contentAlignment = Alignment.Center
      ) {
        CircularProgressIndicator(
          color = AccentAmberBronze,
          modifier = Modifier.testTag("webview_loading_indicator")
        )
      }
    }
  }
}
