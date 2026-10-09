package com.example.myapplication.tictactoe

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.R

@Composable
fun TicTacToeScreen(
    modifier: Modifier = Modifier,
    vm: TicTacToeViewModel = viewModel(),
    onBackClick: () -> Unit = {}
) {
    Box(modifier = modifier.fillMaxSize()) {
        Button(onClick = onBackClick, modifier = Modifier.align(Alignment.BottomCenter)) {
            Text(stringResource(R.string.back_to_menu))
        }
        TextButton(onClick = {}, modifier = Modifier.align(Alignment.Center)) {
            Text("TODO: implement TicTacToeScreen")
        }
    }
}