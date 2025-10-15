package com.example.composenavigationapp.ui.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.composenavigationapp.ui.navigation.Routes

@Preview(
    name = "Onboarding – Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    backgroundColor = 0xFF000000
)

@Composable
fun OnboardingPreviewDark() {
    val navController = rememberNavController()
    MaterialTheme(colorScheme = darkColorScheme()) {
        OnboardingScreen(navController)
    }
}

@Composable
fun OnboardingScreen(navController: NavController) {
    val c = MaterialTheme.colorScheme
    val gradientTop = c.surfaceVariant 
    val gradientBottom = c.background

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(gradientTop, gradientBottom)
                )
            )
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(
                containerColor = c.surfaceContainerHigh
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 24.dp, vertical = 28.dp)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "👋",
                    fontSize = 54.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Text(
                    text = "Selamat datang,\nKami dari Kelompok 6!",
                    style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                    textAlign = TextAlign.Center,
                    color = c.onSurface
                )

                Spacer(Modifier.height(12.dp))

                Text(
                    text = "Kami sedang melakukan Hands-on Jetpack Compose Navigation. Silakan klik tombol mulai untuk melanjutkan! :)",
                    style = MaterialTheme.typography.bodyMedium,
                    color = c.onSurfaceVariant,
                    textAlign = TextAlign.Center
                )

                Spacer(Modifier.height(24.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp),
                    onClick = { navController.navigate(Routes.HOME) }
                ) {
                    Text("Mulai")
                }
            }
        }
    }
}
