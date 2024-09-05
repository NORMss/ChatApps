package com.norm.mychatapps.domain

data class ChatRoom(
    val objectId: String,
    val participants: List<String>, //val participants: List<ParseUser>
    val messages: List<Message>,
    val listSeenMessages: Map<String, String>
)