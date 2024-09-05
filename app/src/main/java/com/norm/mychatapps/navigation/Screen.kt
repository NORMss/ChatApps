package com.norm.mychatapps.navigation

import kotlinx.serialization.Serializable

sealed class Screen {
    @Serializable
    data object Auth : Screen()

    @Serializable
    data object Home : Screen()

    @Serializable
    data object ChatRoom : Screen()

    @Serializable
    data class Chat(val id: String) : Screen()
}