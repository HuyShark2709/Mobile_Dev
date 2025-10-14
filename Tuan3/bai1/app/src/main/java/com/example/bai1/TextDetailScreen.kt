package com.example.bai1

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily

val AlexBrush = FontFamily(Font(R.font.alex_brush_regular))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextDetailScreen(nav: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Text Detail",
                        textAlign = TextAlign.Center
                    )
                },
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
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            verticalArrangement = Arrangement.Top
        ) {
            val annotated = buildAnnotatedString {
                append("The ")
                withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                    append("quick ")
                }
                withStyle(
                    SpanStyle(
                        color = Color(0xFFB87333), // màu nâu cam của chữ Brown
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Brown")
                }
                append("\nfox j u m p s ")
                withStyle(SpanStyle(fontWeight = FontWeight.Bold)) {
                    append("over")
                }
                append("\n")
                withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append("the ")
                }
                withStyle(
                    SpanStyle(
                        fontStyle = FontStyle.Italic,
                        fontFamily = AlexBrush,          // ✅ áp dụng AlexBrush cho “lazy”
                        fontSize = 36.sp,                // (tuỳ) làm nổi hơn
                        fontWeight = FontWeight.Bold
                    )
                ) { append("lazy") }
                append(" dog.")
            }

            Text(
                text = annotated,
                fontSize = 28.sp,
                lineHeight = 38.sp,
                textAlign = TextAlign.Start
            )

            Spacer(Modifier.height(16.dp))
            Divider(color = Color.LightGray, thickness = 1.dp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTextDetailScreen() {
    val nav = rememberNavController()
    MaterialTheme { TextDetailScreen(nav) }
}
