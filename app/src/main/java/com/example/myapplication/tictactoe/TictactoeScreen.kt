package com.example.myapplication.tictactoe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun TicTacToeScreen(
    modifier: Modifier = Modifier,
    vm: TicTacToeViewModel = viewModel()
) {
    Box(modifier = modifier.fillMaxSize()) {
        Text(
            "TODO: implement TicTacToeScreen",
            modifier = Modifier.align(Alignment.Center)
        )
    }
}