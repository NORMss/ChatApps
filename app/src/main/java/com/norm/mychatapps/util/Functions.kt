package com.norm.mychatapps.util

import com.norm.mychatapps.domain.Message
import kotlinx.datetime.Clock

//message processing simulation
fun mapMessages(chatRoom: List<String>): List<Message> {
    return chatRoom.map { message ->
        Message(
            objectId = message.length.toString(),
            chatRoom = chatRoom.first(),
            owner = message.reversed(),
            text = message,
            timeStamp = Clock.System.now().toEpochMilliseconds(),
        )
    }
}