package com.example.bai1

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(onReady: () -> Unit) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("UI components") }) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text("Trần Gia Huy", style = MaterialTheme.typography.titleLarge)
            Text("070205003522", style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(16.dp))

            Image(
                painter = painterResource(R.drawable.compose_logo),
                contentDescription = "Compose Logo",
                modifier = Modifier.size(140.dp)
            )
            Spacer(Modifier.height(24.dp))
            Text("Jetpack Compose", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(12.dp))
            Text(
                "Jetpack Compose is a modern UI toolkit for building native Android apps using a declarative programming approach.",
                textAlign = TextAlign.Center
            )
            Spacer(Modifier.height(28.dp))
            Button(
                onClick = onReady,
                modifier = Modifier.fillMaxWidth().height(54.dp),
                shape = RoundedCornerShape(12.dp)
            ) { Text("I’m ready") }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewWelcomeScreen() {
    MaterialTheme { WelcomeScreen(onReady = {}) }
}
