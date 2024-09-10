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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.bite.navigation.Screen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderHistoryPage(navController: NavHostController) {
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
                            text = "Order History",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF00C3BE))
            )
        },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.White)
                    .padding(padding)
                    .padding(16.dp)
            ) {


                Text("Order History", fontSize = 24.sp, color = Color(0xFF00C3BE))
                Spacer(modifier = Modifier.height(16.dp))

                // Add list of orders
                OrderItem(orderNumber = "Order #1", date = "2024-09-01", total = "$30.00")
                Spacer(modifier = Modifier.height(8.dp))
                OrderItem(orderNumber = "Order #2", date = "2024-09-02", total = "$45.00")
            }
        }
    )
}

@Composable
fun OrderItem(orderNumber: String, date: String, total: String) {
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp).background(Color(0xFFEFEFEF))) {
        Text("Order Number: $orderNumber", fontSize = 16.sp)
        Text("Date: $date", fontSize = 14.sp)
        Text("Total: $total", fontSize = 14.sp)
    }
}

@Composable
fun BottomNavigationBar3(navController: NavController) {

    NavigationBar(
        containerColor = Color(0xFF00C3BE),
        contentColor = Color.White,
        tonalElevation = 8.dp
    ) {
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = {
                Text(
                    "Home",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            selected = false,
            onClick = { navController.navigate(Screen.Home.route)}
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Search, contentDescription = "Search") },
            label = {
                Text(
                    "Search",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            selected = true,
            onClick = { navController.navigate(Screen.SearchPage.route) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Filled.AccountCircle, contentDescription = "Profile") },
            label = {
                Text(
                    "Profile",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            },
            selected = false,
            onClick = { navController.navigate(Screen.Home.route) }
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewOrderHistoryPage() {
    OrderHistoryPage(navController = rememberNavController())
}
