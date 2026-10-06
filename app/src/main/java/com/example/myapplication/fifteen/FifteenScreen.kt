package com.example.myapplication.fifteen

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.engine.FifteenImpl
import com.example.myapplication.fifteen.components.Grid
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun FifteenScreen(
    modifier: Modifier = Modifier
) {
    val fifteen = remember { FifteenImpl() }
    var field by rememberSaveable { mutableStateOf(fifteen.randomSolvableField()) }
    Grid(field, modifier) { move -> field = fifteen.update(field, move) }
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