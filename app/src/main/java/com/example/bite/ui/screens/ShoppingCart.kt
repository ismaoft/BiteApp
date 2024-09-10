// ShoppingCartPage.kt
package com.example.bite.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.filled.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.Text
import androidx.compose.material3.Icon
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items


data class CartItem(val name: String, val quantity: Int, val price: Double)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShoppingCartPage(navController: NavController) {
    // Sample cart items
    val cartItems = listOf(
        CartItem(name = "Pizza", quantity = 2, price = 12.99),
        CartItem(name = "Burger", quantity = 1, price = 8.99),
        CartItem(name = "Pasta", quantity = 3, price = 9.99)
    )
    var totalAmount by remember { mutableStateOf(cartItems.sumOf { it.price * it.quantity }) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Shopping Cart", fontSize = 20.sp, color = Color.White)
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF00C3BE))
            )
        },
        bottomBar = {
            BottomNavigationBar(navController = navController)
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn {
                items(cartItems) { item ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(item.name)
                        Text("x${item.quantity}")
                        Text("${item.price * item.quantity}")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                "Total: $totalAmount",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFF00C3BE)
            )
        }
    }
}

@Composable
fun BottomNavigationBar4(navController: NavController) {
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
            onClick = { navController.navigate("home") }
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
            onClick = { navController.navigate("search") }
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
            onClick = { navController.navigate("profile") }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewShoppingCartPage() {
    val navController = rememberNavController()
    ShoppingCartPage(navController = navController)
}
