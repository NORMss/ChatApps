package com.norm.mychatapps.presentation.screen.create_room

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CreateRoomScreenViewModel : ViewModel() {
    private val _allUsers =
        mutableStateListOf<String>() //private val _allUsers = mutableStateListOf<ParseUser>()
    val allUsers: List<String> = _allUsers //val allUsers: List<ParseUser> = _allUsers

    private val _searchQuery = mutableStateOf("")
    val searchQuery: State<String> = _searchQuery

    private val _isSearchBarActive = mutableStateOf(false)
    val isSearchBarActive: State<Boolean> = _isSearchBarActive

    fun updateSearchQuery(query: String) {
        _searchQuery.value = query
    }

    fun updateSearchActive(active: Boolean) {
        _isSearchBarActive.value = active
    }

    fun onSearch(
        onError: (String) -> Unit,
    ) {
        _isSearchBarActive.value = false
    }

    private fun createChatRoom(
        participants: List<String>,
        onSuccess: (String) -> Unit,
        onError: (String) -> Unit,
    ) {
        TODO("createChatRoom")
    }

    private fun checkForDuplicateChatRooms(
        participants: List<String>,
        onDuplicateFound: (String) -> Unit,
        onDuplicateNotFound: (String) -> Unit,
        onError: (String) -> Unit,
    ) {
        TODO("checkForDuplicateChatRooms")
    }

    fun checkForExistingChatRoom(
        user: String,
        onDuplicateFound: (String) -> Unit,
        onDuplicateNotFound: (String) -> Unit,
        onError: (String) -> Unit,
    ) {
        TODO("checkForExistingChatRoom")
    }
}