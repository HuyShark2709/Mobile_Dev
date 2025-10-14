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
fun RowLayoutScreen(nav: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Row Layout") },
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
                .padding(horizontal = 16.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            repeat(4) { RowCard() }   // 4 hàng như ảnh
        }
    }
}

/** Một hàng đúng layout trong ảnh: nền xám bo góc + 3 ô xanh (giữa đậm). */
@Composable
private fun RowCard() {
    val container = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f)
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = container),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
                .height(64.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Pill(isPrimary = false, modifier = Modifier.weight(1f))
            Pill(isPrimary = true,  modifier = Modifier.weight(1f))
            Pill(isPrimary = false, modifier = Modifier.weight(1f))
        }
    }
}

/** Ô bo góc xanh — đậm/nhạt theo isPrimary. */
@Composable
private fun Pill(isPrimary: Boolean, modifier: Modifier = Modifier) {
    val color =
        if (isPrimary) MaterialTheme.colorScheme.primary
        else MaterialTheme.colorScheme.primary.copy(alpha = 0.45f)

    Box(
        modifier = modifier
            .fillMaxHeight()
            .clip(RoundedCornerShape(14.dp))
            .background(color)
    )
}

@Preview(showBackground = true, name = "Row Layout")
@Composable
private fun PreviewRowLayoutScreen() {
    val nav = rememberNavController()
    MaterialTheme { RowLayoutScreen(nav) }
}
