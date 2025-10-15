package com.example.composenavigationapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Preview(showBackground = true)
@Composable
fun HelpPreview() {
    HelpScreen(navController = rememberNavController())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen(navController: NavController) {
    val faqList = listOf(
        "Apa fungsi aplikasi ini?" to "Aplikasi ini dibuat untuk mempraktikkan navigasi antar halaman di Jetpack Compose.",
        "Bagaimana cara membuka halaman detail?" to "Kamu dapat menekan salah satu item di HomeScreen untuk melihat detailnya.",
        "Apa fungsi tombol FAB di bawah?" to "FAB digunakan untuk menambah data baru ke daftar di HomeScreen.",
        "Bagaimana cara kembali ke halaman sebelumnya?" to "Gunakan tombol kembali sistem atau klik tombol 'Kembali' di halaman detail."
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Help & Panduan") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Kembali"
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(faqList) { (question, answer) ->
                Card(
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.surfaceVariant
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            text = question,
                            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(Modifier.height(6.dp))
                        Text(
                            text = answer,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}
