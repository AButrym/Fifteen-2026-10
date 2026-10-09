package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.fifteen.FifteenScreen
import com.example.myapplication.startmenu.AppScreen
import com.example.myapplication.startmenu.AppStartScreen
import com.example.myapplication.startmenu.AppStartViewModel
import com.example.myapplication.tictactoe.TicTacToeScreen

@Composable
fun NavigationHost(
    modifier: Modifier = Modifier,
    vm: AppStartViewModel = viewModel()
) {
    val state by vm.state.collectAsStateWithLifecycle()
    when (state.screen) {
        AppScreen.MainMenu  -> AppStartScreen(
            modifier = modifier,
            onFifteenClick = vm::onFifteenClick,
            onTicTacToeClick = vm::onTicTacToeClick
        )
        AppScreen.Fifteen   -> FifteenScreen(
            modifier = modifier,
            onBackClick = vm::navigateToMainMenu
        )
        AppScreen.TicTacToe -> TicTacToeScreen(
            modifier = modifier,
            onBackClick = vm::navigateToMainMenu
        )
    }
}