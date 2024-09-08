package com.example.bite.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class AuthViewModel : ViewModel() {

    // Datos quemados para simular usuarios
    private val users = mutableListOf(
        User("admin", "admin@example.com", "adminpassword", "admin"),
        User("user", "user@example.com", "userpassword", "user")
    )

    // Estado para el usuario actual logueado
    private val _currentUser = MutableStateFlow<User?>(null)
    val currentUser: StateFlow<User?> = _currentUser

    // Estado para manejar errores de inicio de sesión
    private val _loginError = MutableStateFlow<String?>(null)
    val loginError: StateFlow<String?> = _loginError

    // Función para hacer login
    fun login(email: String, password: String) {
        val user = users.find { it.email == email && it.password == password }
        if (user != null) {
            _currentUser.update { user }
            _loginError.update { null }  // Resetear errores en caso de éxito
        } else {
            _loginError.update { "Credenciales incorrectas" }
        }
    }

    // Función para registrar un nuevo usuario
    fun register(name: String, email: String, password: String, role: String) {
        val newUser = User(name, email, password, role)
        users.add(newUser)
        _currentUser.update { newUser }  // Actualiza el estado del usuario registrado
    }

    // Función para cerrar sesión
    fun logout() {
        _currentUser.update { null }
    }
}

data class User(val name: String, val email: String, val password: String, val role: String)
