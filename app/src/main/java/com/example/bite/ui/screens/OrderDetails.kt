package com.example.bite.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import androidx.navigation.NavHostController
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import coil.compose.rememberAsyncImagePainter


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailsPage(navController: NavHostController, orderId: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Logo Image
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = "https://res.cloudinary.com/dsqnq3xg4/image/upload/v1725915999/LogoAppU_gpji6y.png",
                            ),
                            contentDescription = "Logo",
                            modifier = Modifier.size(100.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Order Details",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF00C3BE))
            )
        },
        bottomBar = {
            BottomNavigationBar(navController) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(padding)
                    .padding(16.dp)
            ) {
                // Add Logo here

                // Display order details
                Text("Order ID: $orderId", fontSize = 20.sp, color = Color(0xFF00C3BE))
                Spacer(modifier = Modifier.height(8.dp))
                OrderDetailItem(label = "Date", value = "2024-09-10")
                Spacer(modifier = Modifier.height(8.dp))
                OrderDetailItem(label = "Status", value = "Processing")
                Spacer(modifier = Modifier.height(8.dp))
                OrderDetailItem(label = "Total", value = "$30.00")
                Spacer(modifier = Modifier.height(16.dp))

                // Example order items
                Text("Order Items", fontSize = 18.sp, color = Color(0xFF00C3BE))
                Spacer(modifier = Modifier.height(8.dp))
                OrderItem(name = "Pizza", quantity = 1, price = "$15.00")
                Spacer(modifier = Modifier.height(4.dp))
                OrderItem(name = "Burger", quantity = 2, price = "$15.00")
            }
        }
    )
}

@Composable
fun OrderDetailItem(label: String, value: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label, fontSize = 16.sp, color = Color.Black)
        Text(value, fontSize = 16.sp, color = Color.Black)
    }
}

@Composable
fun OrderItem(name: String, quantity: Int, price: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("$quantity x $name", fontSize = 16.sp, color = Color.Black)
        Text(price, fontSize = 16.sp, color = Color.Black)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewOrderDetailsPage() {
    OrderDetailsPage(navController = rememberNavController(), orderId = "123456")
}
