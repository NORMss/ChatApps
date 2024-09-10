package com.norm.mychatapps.presentation.chat

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.navigation.toRoute
import com.norm.mychatapps.domain.ChatRoom
import com.norm.mychatapps.domain.Message
import com.norm.mychatapps.navigation.Screen
import com.norm.mychatapps.util.RequestState

const val TAG = "ChatViewModel"

class ChatScreenViewModel(
    saveStateHandle: SavedStateHandle,
) : ViewModel() {
    private val chatId = saveStateHandle.toRoute<Screen.Chat>().id

    val liveQueryClient: String? = null
    val subscription: String? = null
    val subscription2: String? = null

    private var _currentChat: MutableState<RequestState<ChatRoom?>> =
        mutableStateOf(RequestState.Loading)
    val currentChat: State<RequestState<ChatRoom?>> = _currentChat

    private var _messages = mutableStateListOf<Message>()
    val messages: List<Message> = _messages

    private val _messageInput: MutableState<String> = mutableStateOf("")
    val messageInput: State<String> = _messageInput

    private val _lastSeenMessage: MutableState<Message?> = mutableStateOf(null)
    val lastSeenMessage: MutableState<Message?> = _lastSeenMessage

    private val _seen: MutableState<Boolean> = mutableStateOf(false)
    val seen: State<Boolean> = _seen

    init {

    }

    fun setMessageInput(text: String) {
        _messageInput.value = text
    }

    private fun getChatRoomById(
        id: String,
        onComplete: (String?, String?) -> Unit,
    ) {
        TODO("getCharRoomsById")
    }

    private fun observeCharRooms(chatRoom: String) {
        TODO("observeCharRooms")
    }

    private fun observeMessages(chatRoom: String) {
        TODO("observeMessages")
    }

    private fun checkIfSeen(chatRoom: String) {
        TODO("checkIfSeen")
    }

    fun markMessageAsSeen(lastSeenMessage: Message) {
        getChatRoomById(chatId) { chat, chatError ->
            _lastSeenMessage.value = lastSeenMessage
        }
        TODO("markMessageAsSeen")
    }

    fun saveMessage(
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ){
        if (_currentChat.value is RequestState.Success) {

        }
        TODO("saveMessage")
    }
}