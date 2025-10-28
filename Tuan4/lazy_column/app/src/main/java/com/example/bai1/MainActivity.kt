package com.example.bai1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bai1.ui.theme.Bai1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bai1Theme {
                val nav = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // NavHost quản lý 3 màn: home , list, detail
                    NavHost(
                        navController = nav,
                        startDestination = "home",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("home") {
                            Greeting(
                                name = "Android",
                                navController = nav
                            )
                        }
                        composable("list") {
                            LazyColumnScreen(nav)
                        }
                        composable("detail/{index}") { backStackEntry ->
                            val index = backStackEntry.arguments?.getString("index") ?: "0"
                            DetailScreen(nav, index)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(
    name: String,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ){
        Spacer(modifier= Modifier.height(150.dp))
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier.size(300.dp),
            contentScale = ContentScale.Fit
        )
        Spacer(modifier= Modifier.height(30.dp))
        Text(
            text = "Navigation",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier= Modifier.height(12.dp))
        Text(
            text = "is a framework that simplifies the implementation of navigation between different UI components (activities, fragments, or composables) in an app",
            fontSize = 18.sp,
            color = Color.Black,
            lineHeight = 25.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 12.dp)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = { navController.navigate("list") },   // ➜ sang màn LazyColumn
            modifier = Modifier
                .fillMaxWidth(0.78f)
                .height(54.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4AA0E6))
        ) {
            Text(text = "PUSH", fontSize = 20.sp)
        }
    }
}
