package com.norm.mychatapps.presentation.screen.auth

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {
    private var _myUsername: MutableState<String> = mutableStateOf("")
    val myUsername: State<String> = _myUsername

    private var _myPassword: MutableState<String> = mutableStateOf("")
    val myPassword: State<String> = _myPassword

    fun setUsername(username: String) {
        _myUsername.value = username
    }

    fun setPassword(password: String) {
        _myPassword.value = password
    }

    private fun loginTheUser(
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        if (
            _myUsername.value == "NORM" &&
            _myPassword.value == "123456"
        ) {
            onSuccess()
        } else {
            onError(
                "Incorrect login or password"
            )
        }
        TODO("implementation of temporal logic")
    }

    fun onSignInClick(
        onSuccess: () -> Unit,
        onError: (String) -> Unit,
    ) {
        loginTheUser(
            onSuccess = onSuccess,
            onError = onError,
        )
        TODO("implementation of temporal logic")
    }
}