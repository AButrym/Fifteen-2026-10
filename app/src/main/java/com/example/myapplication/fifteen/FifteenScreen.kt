package com.example.myapplication.fifteen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.fifteen.components.Grid
import com.example.myapplication.fifteen.components.MoveCounter
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun FifteenScreen(
    modifier: Modifier = Modifier,
    vm: FifteenViewModel = viewModel()
) {
    val state by vm.state.collectAsStateWithLifecycle()
    Box {
        Grid(state.field, modifier) { move ->
            vm.onTileClick(move)
        }
        MoveCounter(
            state.moves,
            modifier=Modifier
                .align(BiasAlignment(0f, 0.8f))
                .offset(y = (-20).dp)
        )
    }
}

@Preview(
    showBackground = true, device = "spec:width=392.7dp,height=850.9dp,dpi=440",
    showSystemUi = true, group = "fifteen", name = "shuffled"
)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        FifteenScreen()
    }
}