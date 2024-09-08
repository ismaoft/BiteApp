package com.example.bite.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ActionButton(
    text: String,          // Parámetro para el texto del botón
    onClick: () -> Unit,   // Parámetro para la acción onClick
    modifier: Modifier = Modifier   // Parámetro opcional modifier
) {
    Button(
        onClick = onClick,  // Aquí estamos asignando el onClick correctamente
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFF41B9B2),
            contentColor = Color.White
        ),
        modifier = modifier  // Usamos el modifier opcional
            .fillMaxWidth()
            .height(50.dp)
    ) {
        Text(
            text = text,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
