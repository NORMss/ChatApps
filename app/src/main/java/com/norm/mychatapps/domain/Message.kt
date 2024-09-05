package com.norm.mychatapps.domain

data class Message(
    val objectId: String,
    val chatRoom: String, //val chatRoom: ParseObject
    val owner: String, //val owner: ParseUser
    val text: String,
    val timeStamp: Long,
)
