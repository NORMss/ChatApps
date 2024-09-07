@file:OptIn(ExperimentalMaterial3Api::class)

package com.norm.mychatapps.presentation.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.norm.mychatapps.domain.ChatRoom
import com.norm.mychatapps.presentation.component.ChatView
import com.norm.mychatapps.presentation.component.ErrorView
import com.norm.mychatapps.presentation.component.LoadingView

@Composable
fun HomeScreen(
    onLogout: () -> Unit,
    onCrateRoom: () -> Unit,
    onCharRoomSelect: (String) -> Unit,
) {
    val viewModel = viewModel<HomeViewModel>()
    val rooms by viewModel.rooms

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Chatty"
                    )
                },
                actions = {
                    IconButton(onClick = {
                        onLogout()
                    }
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Logout,
                            contentDescription = null,
                        )
                    }
                },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onCrateRoom
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = null,
                )
            }
        }
    ) { paddingValues ->
        rooms.DisplayResult(
            onLoading = {
                LoadingView()
            },
            onSuccess = { chatRooms ->
                if (chatRooms.isNotEmpty()) {
                    LazyColumn(
                        modifier = Modifier
                            .padding(paddingValues),
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        items(
                            items = chatRooms,
                            key = {
                                it.objectId
                            }
                        ) { room ->
                            val friendUsername = remember(room.participants) {
                                room.participants
                                    .filter { true }
                                    .map { participant ->
                                        participant
                                    }
                                    .firstOrNull()
                            }

                            val lastMessage by remember(room.messages) {
                                derivedStateOf {
                                    runCatching { room.messages.last().text }.getOrDefault("")
                                }
                            }

                            val unreadMessage by remember {
                                derivedStateOf {
                                    runCatching {
                                        room.listSeenMessages[room.objectId] != room.messages.last().objectId
                                    }.getOrDefault(false)
                                }
                            }

                            if (lastMessage.isNotEmpty()) {
                                ChatView(
                                    name = friendUsername ?: "Unknown",
                                    unreadMessages = unreadMessage,
                                    lastMessage = lastMessage,
                                    onClick = {
                                        onCharRoomSelect(room.objectId)
                                    }
                                )
                            }
                        }
                    }
                } else {
                    ErrorView(
                        message = "Empty ChatRoom"
                    )
                }
            },
            onError = {
                ErrorView(message = it)
            })
    }
}