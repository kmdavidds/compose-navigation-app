package com.example.composenavigationapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.material3.MaterialTheme
import com.example.composenavigationapp.ui.theme.ComposeNavigationAppTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeNavigationAppTheme {
                Text(
                    text = "Hello Compose Navigation",
                    style = MaterialTheme.typography.headlineSmall
                )
            }
        }
    }
}
