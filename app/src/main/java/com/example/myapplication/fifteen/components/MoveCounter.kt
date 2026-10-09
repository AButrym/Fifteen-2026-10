package com.example.myapplication.fifteen.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MoveCounter(
    n: Int,
    modifier: Modifier = Modifier
) {
    TextButton(onClick = {}, modifier = modifier) {
        Text(
            "Move count: $n",
            fontSize = MaterialTheme.typography.headlineMedium.fontSize

        )
    }
}

@Preview
@Composable
fun MoveCounterPreview() {
    MoveCounter(12)
}