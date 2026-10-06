package com.example.myapplication.fifteen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.fifteen.components.Grid
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun FifteenScreen(
    modifier: Modifier = Modifier,
    vm: FifteenViewModel = viewModel()
) {
    val field by vm.field.collectAsStateWithLifecycle()
    Grid(field, modifier) { move -> vm.onTileClick(move) }
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