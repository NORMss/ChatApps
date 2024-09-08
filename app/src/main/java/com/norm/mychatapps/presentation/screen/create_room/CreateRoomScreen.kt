@file:OptIn(ExperimentalMaterial3Api::class)

package com.norm.mychatapps.presentation.screen.create_room

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.norm.mychatapps.presentation.component.ErrorView
import com.norm.mychatapps.presentation.component.UserView

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CreateRoomScreen(
    openChatScreen: (String) -> Unit,
    onBackClick: () -> Unit,
) {
    val context = LocalContext.current
    val viewModel = viewModel<CreateRoomScreenViewModel>()
    val allUsers = viewModel.allUsers
    val isSearchBarActivity by viewModel.isSearchBarActive
    val searchQuery by viewModel.searchQuery

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Create a Chat"
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = onBackClick
                    ) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            viewModel.updateSearchActive(true)
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                        )
                    }
                }
            )
        },
    ) { paddingValues ->
        if (isSearchBarActivity) {
            SearchBar(
                inputField = {
                    SearchBarDefaults.InputField(
                        query = searchQuery,
                        onQueryChange = { viewModel.updateSearchQuery(it) },
                        onSearch = { viewModel.updateSearchActive(false) },
                        expanded = isSearchBarActivity,
                        onExpandedChange = { viewModel.updateSearchActive(it) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Search,
                                contentDescription = null,
                            )
                        },
                        trailingIcon = {
                            if (isSearchBarActivity) {
                                IconButton(
                                    onClick = {
                                        if (searchQuery.isNotEmpty()) viewModel.updateSearchQuery("")
                                        else viewModel.updateSearchActive(active = false)
                                    }
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Close,
                                        contentDescription = null,
                                    )
                                }
                            }
                        },
                    )
                },
                expanded = isSearchBarActivity,
                onExpandedChange = { viewModel.updateSearchActive(it) },
                content = {}
            )
        }
        if (allUsers.isNotEmpty()) {
            LazyColumn(
                modifier = Modifier
                    .padding(12.dp)
                    .padding(
                        paddingValues = paddingValues,
                    ),
                verticalArrangement = Arrangement.spacedBy(12.dp),
            ) {
                items(
                    items = allUsers,
                    key = { it },
                ) { user ->
                    UserView(
                        username = user,
                        onClick = {
                            TODO("checkForExistingChatRoom")
                        }
                    )
                }
            }
        } else {
            ErrorView(
                message = "Search for a user"
            )
        }
    }
}