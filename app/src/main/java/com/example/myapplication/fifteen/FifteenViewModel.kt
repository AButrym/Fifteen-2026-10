package com.example.myapplication.fifteen

import androidx.lifecycle.ViewModel
import com.example.myapplication.engine.Field
import com.example.myapplication.engine.FifteenImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update


data class FifteenState(val field: Field, val moves: Int)

class FifteenViewModel : ViewModel() {
    private val fifteen = FifteenImpl()

    val state: StateFlow<FifteenState>
        field = MutableStateFlow(FifteenState(
            field=fifteen.randomSolvableField(),
            moves=0)
        )

    fun onTileClick(tile: Int) {
        state.update { oldState ->
            val (field, moves) = oldState
            val newField = fifteen.update(field, tile)
            if (newField == field) oldState
            else oldState.copy(field = newField, moves = moves + 1)
        }
    }
}