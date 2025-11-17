package com.example.productdetail.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import java.text.NumberFormat
import java.util.*

private val YellowBorder = Color(0xFFFFC107)
private val PriceRed = Color(0xFFD80000)
private val LightGrayBg = Color(0xFFF2F2F2)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailRoute(
    vm: ProductDetailViewModel,
    onBack: () -> Unit
) {
    val state by vm.state.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "Product detail",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Rounded.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { inner ->
        when (state) {
            is ProductUiState.Loading -> Box(
                Modifier
                    .padding(inner)
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) { CircularProgressIndicator() }

            is ProductUiState.Error -> Column(
                Modifier
                    .padding(inner)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text("Có lỗi khi tải dữ liệu")
                Spacer(Modifier.height(8.dp))
                Button(onClick = vm::fetch) { Text("Thử lại") }
            }

            is ProductUiState.Success -> {
                val p = (state as ProductUiState.Success).product
                val priceStr = NumberFormat.getCurrencyInstance(Locale("vi", "VN"))
                    .format(p.price)

                Column(
                    Modifier
                        .padding(inner)
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Ảnh bo tròn
                    AsyncImage(
                        model = p.image,
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(280.dp)
                            .clip(RoundedCornerShape(16.dp))
                            .background(Color.White),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(Modifier.height(12.dp))

                    // Tên trong khung viền vàng
                    Text(
                        text = p.name,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontWeight = FontWeight.SemiBold,
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                BorderStroke(2.dp, YellowBorder),
                                shape = RoundedCornerShape(6.dp)
                            )
                            .padding(8.dp)
                    )

                    Spacer(Modifier.height(8.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Giá:",
                            color = PriceRed,
                            fontWeight = FontWeight.Bold
                        )
                        Spacer(Modifier.width(6.dp))
                        Text(
                            text = priceStr,
                            color = PriceRed,
                            fontWeight = FontWeight.ExtraBold,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(Modifier.height(12.dp))

                    Surface(
                        color = LightGrayBg,
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = p.description,
                            modifier = Modifier.padding(14.dp),
                            color = Color(0xFF3A3A3A)
                        )
                    }

                    Spacer(Modifier.height(24.dp))
                }
            }
        }
    }
}
