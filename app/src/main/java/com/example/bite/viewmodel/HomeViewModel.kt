package com.example.bite.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeViewModel : ViewModel() {
    private val _categories = MutableStateFlow(listOf("Muffins", "Cakes", "Brownies", "Bread"))
    val categories: StateFlow<List<String>> = _categories

    private val _categoryImages = MutableStateFlow(listOf(
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904854/muffin_liacuk.png",
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904853/cakes_ulod5b.png",
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904853/brownie_p4tnyv.png",
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724904853/bread_mwqirr.png"
    ))
    val categoryImages: StateFlow<List<String>> = _categoryImages

    private val _restaurants = MutableStateFlow(listOf("Restaurant 1", "Restaurant 2", "Restaurant 3"))
    val restaurants: StateFlow<List<String>> = _restaurants

    private val _restaurantImages = MutableStateFlow(listOf(
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724993362/restaurante1_v8jwcf.webp",
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724993514/restaurante2_q2pki4.webp",
        "https://res.cloudinary.com/dlpnivtso/image/upload/v1724993640/restaurante3_exrmdi.webp"
    ))
    val restaurantImages: StateFlow<List<String>> = _restaurantImages
}
