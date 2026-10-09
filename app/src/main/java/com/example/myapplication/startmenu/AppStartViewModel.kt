package com.example.myapplication.startmenu

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

enum class AppScreen {
    MainMenu, Fifteen, TicTacToe
}

data class AppState(val screen: AppScreen)


class AppStartViewModel : ViewModel() {
    val state: StateFlow<AppState>
        field = MutableStateFlow(AppState(AppScreen.MainMenu))

    fun onFifteenClick() {
        state.update { oldState -> oldState.copy(screen = AppScreen.Fifteen) }
    }

    fun onTicTacToeClick() {
        state.update { oldState -> oldState.copy(screen = AppScreen.TicTacToe) }
    }

    fun navigateToMainMenu() {
        state.update { oldState -> oldState.copy(screen = AppScreen.MainMenu) }
    }
}
