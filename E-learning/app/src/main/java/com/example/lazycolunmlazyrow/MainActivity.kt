package com.example.lazycolunmlazyrow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.savedstate.SavedState

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContent {
            demoAppScreen()
        }
    }
}
@Composable
fun demoAppScreen() {

    val topics = remember {
        mutableStateListOf(
            "Kotlin", "Compose", "Android", "UI", "Firebase",
            "Retrofit", "Coroutines", "SQL", "Architecture", "Tools",
            "Testing", "Design", "Debug", "Network", "Jetpack"
        )
    }

    val courses = remember {
        (1..40).map { index ->
            "Khoá học Android số $index"
        }.toMutableStateList()   // MutableStateList<String>
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
                .statusBarsPadding()
        ) {

            // ---- Tiêu đề ----
            Row(
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Chủ đề",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF121212)
                )
            }

            // ---- LazyRow chủ đề ----
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                items(topics) { topic ->
                    Box(
                        modifier = Modifier
                            .background(Color(0xFFE0E0E0), MaterialTheme.shapes.medium)
                            .padding(horizontal = 20.dp, vertical = 8.dp)
                    ) {
                        Text(topic)
                    }
                }
            }

            Spacer(Modifier.height(10.dp))

            // ---- Danh sách khoá học ----
            Text(
                text = "Danh sách khoá học",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(courses) { courseName ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color(0xFFF2F2F2), MaterialTheme.shapes.large)
                            .padding(20.dp)
                    ) {
                        Text(courseName, fontWeight = FontWeight.SemiBold)
                    }
                }
            }
        }

        // ---- Nút + thêm item ----
        FloatingActionButton(
            onClick = {
                val newTopic = "New ${topics.size + 1}"
                topics.add(newTopic)

                val newCourse = "Khoá học Android số ${courses.size + 1}"
                courses.add(newCourse)
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
        ) {
            Text("+")
        }
    }
}