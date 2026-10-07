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

    fun onTileClick(tile: Int) {
        field.update { fifteen.update(it, tile) }
    }
}