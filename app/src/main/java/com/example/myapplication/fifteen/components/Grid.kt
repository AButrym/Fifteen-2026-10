package com.example.myapplication.fifteen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.myapplication.engine.*
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun Grid(field: Field,
         modifier: Modifier = Modifier,
         callback: (Int) -> Unit = {}
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(4) { row ->
            Row {
                repeat(4) { col ->
                    Tile(field[row, col], callback)
                }
            }
        }
    }
}

@Preview(
    showBackground = true, device = "spec:width=392.7dp,height=850.9dp,dpi=440",
    showSystemUi = true, group = "fifteen", name = "shuffled"
)
@Composable
fun GreetingPreview2() {
    MyApplicationTheme {
        val field = (1..16).shuffled()
        Grid(field)
    }
}