package com.norm.mychatapps.presentation.screen.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.norm.mychatapps.domain.ChatRoom
import com.norm.mychatapps.util.RequestState

typealias Rooms = RequestState<List<ChatRoom>>

class HomeViewModel : ViewModel() {
    private var _rooms: MutableState<Rooms> = mutableStateOf(RequestState.Loading)
    val rooms: State<Rooms> = _rooms

    init {
        observeChatRooms()
    }

    private fun observeChatRooms() {
        updateChatRooms("query")
        TODO("Not yet implemented")
    }

    private fun updateChatRooms(query: String) {
        println(query)
        TODO("updateChatRooms")
    }
}