package com.example.bai1

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ComponentsListScreen(nav: NavController) {
    Scaffold(topBar = { TopAppBar(title = { Text("UI Components List") }) }) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Section("Display") {
                Item("Text", "Displays text") { nav.navigate(Routes.Text) }
                Item("Image", "Displays an image") { nav.navigate(Routes.Image) }
            }
            Section("Input") {
                Item("TextField", "Input field for text") { nav.navigate(Routes.TextField) }
                Item("PasswordField", "Input field for passwords") { nav.navigate(Routes.PasswordField) } // ⬅️
            }
            Section("Layout") {
                Item("Column", "Arranges elements vertically") { nav.navigate(Routes.ColumnLayout) }  // ⬅️
                Item("Row", "Arranges elements horizontally") { nav.navigate(Routes.RowLayout) }
            }
            Item("Tự tìm hiểu", "Tìm ra tất cả các thành phần UI Cơ bản") { }
        }
    }
}

@Composable
fun Section(title: String, content: @Composable () -> Unit) {
    Text(title, style = MaterialTheme.typography.labelLarge, modifier = Modifier.padding(vertical = 8.dp))
    Column { content() }
}

@Composable
fun Item(title: String, subtitle: String, onClick: () -> Unit) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp,
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp).clickable { onClick() }
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.bodyLarge)
            Text(subtitle, style = MaterialTheme.typography.bodySmall)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewListScreen() {
    val nav = rememberNavController()
    MaterialTheme { ComponentsListScreen(nav) }
}
