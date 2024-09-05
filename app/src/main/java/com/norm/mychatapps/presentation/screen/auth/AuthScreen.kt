package com.norm.mychatapps.presentation.screen.auth

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun AuthScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextField(
            value = "",
            onValueChange = {
            },
            placeholder = {
                Text(
                    text = "Username"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
            ),
        )
        Spacer(
            modifier = Modifier
                .fillMaxSize()
        )
        TextField(
            value = "",
            onValueChange = {

            },
            placeholder = {
                Text(
                    text = "Password"
                )
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
            ),
        )
    }
}