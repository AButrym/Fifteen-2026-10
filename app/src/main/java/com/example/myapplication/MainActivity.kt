package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapplication.engine.CrossNoughtCell
import com.example.myapplication.engine.Field
import com.example.myapplication.engine.Fifteen
import com.example.myapplication.engine.Fifteen.Companion.EMPTY_CELL
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { padding ->
                    Grid(
                        Fifteen.solvedField,
                        modifier = Modifier.padding(padding)
                    )
                }
            }
        }
    }
}



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

@Composable
fun Cell(n: Int) {
    val isEmpty = n == EMPTY_CELL
    Button(
        onClick = {},
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



@Composable
fun Grid(field: Field,
         modifier: Modifier = Modifier
) {
    var i = 0

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        repeat(4) {
            Row {
                repeat(4) {
                    Cell(field[i++])
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
