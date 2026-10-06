package com.example.myapplication.tictactoe.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.engine.CrossNoughtCell
import com.example.myapplication.engine.CrossNoughtCell.CROSS
import com.example.myapplication.engine.CrossNoughtCell.EMPTY
import com.example.myapplication.engine.CrossNoughtCell.NOUGHT
import com.example.myapplication.ui.theme.MyApplicationTheme

@Composable
fun CellCrossNought(cell: CrossNoughtCell) {
    val text = when (cell) {
        CROSS -> "❌"
        NOUGHT -> "⭕"
        EMPTY -> ""
    }
    Button(
        onClick = {},
        modifier = Modifier
            .padding(1.dp)
            .size(84.dp),
        contentPadding = PaddingValues.Zero,
        shape = MaterialTheme.shapes.extraSmall
    ) {
        Text(
            text = text,
            fontSize = 60.sp
        )
    }
}

@Preview(
    showBackground = true, device = "spec:width=392.7dp,height=850.9dp,dpi=440", group = "xo",
    name = "cross"
)
@Composable
fun GreetingPreview3() {
    MyApplicationTheme {
        CellCrossNought(CrossNoughtCell.CROSS)
    }
}

@Preview(
    showBackground = true, device = "spec:width=392.7dp,height=850.9dp,dpi=440", group = "xo",
    name = "nought"
)
@Composable
fun GreetingPreview4() {
    MyApplicationTheme {
        CellCrossNought(CrossNoughtCell.NOUGHT)
    }
}
