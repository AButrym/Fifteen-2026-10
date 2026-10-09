package com.example.myapplication.fifteen

import androidx.lifecycle.ViewModel
import com.example.myapplication.engine.Field
import com.example.myapplication.engine.FifteenImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FifteenViewModel : ViewModel() {
    private val fifteen = FifteenImpl()

    val field: StateFlow<Field>
        field = MutableStateFlow(fifteen.randomSolvableField())

    val moves: StateFlow<Int>
        field = MutableStateFlow(0)

    fun onTileClick(tile: Int) {
        field.update {
            val old = it
            val newValue = fifteen.update(it, tile)
            if (newValue != old) moves.update { it1 -> it1 + 1 }
            newValue
        }
    }
}