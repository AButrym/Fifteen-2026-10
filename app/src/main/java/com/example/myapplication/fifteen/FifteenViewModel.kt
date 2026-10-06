package com.example.myapplication.fifteen

import androidx.lifecycle.ViewModel
import com.example.myapplication.engine.Field
import com.example.myapplication.engine.FifteenImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class FifteenViewModel : ViewModel() {
    private val fifteen = FifteenImpl()
    private var _field = MutableStateFlow(fifteen.randomSolvableField())
    val field: StateFlow<Field>
        get() = _field

    fun onTileClick(tile: Int) {
        _field.update { fifteen.update(it, tile) }
    }
}