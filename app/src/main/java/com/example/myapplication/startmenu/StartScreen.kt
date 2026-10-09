package com.example.myapplication.startmenu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.fifteen.FifteenScreen
import com.example.myapplication.tictactoe.TicTacToeScreen

@Composable
fun AppStartScreen(
    modifier: Modifier = Modifier,
    onFifteenClick: () -> Unit = {},
    onTicTacToeClick: () -> Unit = {}
) {
    Row(
        modifier = modifier
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(onClick = onFifteenClick) {
            Text("Fifteen")
        }
        Button(onClick = onTicTacToeClick) {
            Text("Tic-Tac-Toe")
        }
    }
}

@Preview
@Composable
fun AppStartScreenPreview() {
    AppStartScreen()
}