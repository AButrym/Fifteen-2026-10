package com.example.myapplication.fifteen.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.engine.Fifteen.Companion.EMPTY_CELL

@Composable
fun Tile(n: Int,
         callback: (Int) -> Unit = {}
) {
    val isEmpty = n == EMPTY_CELL
    Button(
        onClick = { callback(n) },
        modifier = Modifier
            .alpha(if (isEmpty) 0f else 1f)
            .padding(1.dp)
            .size(84.dp),
        contentPadding = PaddingValues.Zero,
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Text(
            text = if (isEmpty) "" else n.toString(),
            fontSize = 60.sp
        )
    }
}