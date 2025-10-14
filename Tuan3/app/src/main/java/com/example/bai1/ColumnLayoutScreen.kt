package com.example.bai1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ColumnLayoutScreen(nav: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Column Layout") },
                navigationIcon = {
                    IconButton(onClick = { nav.navigateUp() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    PillWide(isPrimary = false, modifier = Modifier.fillMaxWidth().height(72.dp))
                    PillWide(isPrimary = true,  modifier = Modifier.fillMaxWidth().height(72.dp))
                    PillWide(isPrimary = false, modifier = Modifier.fillMaxWidth().height(72.dp))
                }
            }
        }
    }
}

@Composable
private fun PillWide(isPrimary: Boolean, modifier: Modifier = Modifier) {
    val color =
        if (isPrimary) MaterialTheme.colorScheme.secondary
        else MaterialTheme.colorScheme.secondary.copy(alpha = 0.35f)

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(color)
    )
}

@Preview(showBackground = true)
@Composable
private fun PreviewColumnLayout() {
    val nav = rememberNavController()
    MaterialTheme { ColumnLayoutScreen(nav) }
}
