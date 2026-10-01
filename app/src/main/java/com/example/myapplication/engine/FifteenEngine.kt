package com.example.myapplication.engine

import com.example.myapplication.engine.Fifteen.Companion.DIM
import com.example.myapplication.engine.Fifteen.Companion.EMPTY_CELL
import kotlin.math.abs

typealias Field = List<Int>


interface Fifteen {
    fun randomSolvableField(): Field
    fun update(field: Field, move: Int): Field

    fun isSolved(field: Field): Boolean = (field == solvedField)

    companion object {
        const val DIM = 4
        const val EMPTY_CELL = DIM * DIM
        val solvedField = buildList {
            addAll(1..15)
            add(EMPTY_CELL)
        }
    }
}

class FifteenImpl : Fifteen {
    override fun randomSolvableField(): Field {
        while (true) {
            val field = Fifteen.solvedField.shuffled()
            if (isSolvable(field)) {
                return field
            }
        }
    }

    override fun update(field: Field, move: Int): Field {
        val emptyIndex = field.indexOf(EMPTY_CELL)
        val moveIndex = field.indexOf(move)
        if (moveIndex == -1) return field
        val (row1, col1) = ixToRowCol(emptyIndex)
        val (row2, col2) = Coordinates(field.indexOf(move))
        if (row1 == row2 && abs(col1 - col2) == 1 ||
            col1 == col2 && abs(row1 - row2) == 1
        ) {
            val res = field.toMutableList()
            res[emptyIndex] = move
            res[moveIndex] = EMPTY_CELL
            return res.toList()
        }
        return field
    }

    fun ixToRowCol(ix: Int) = ix / DIM to ix % DIM

    private data class Coordinates(val row: Int, val col: Int) {
        constructor(ix: Int) : this(row = ix / DIM, col = ix % DIM)
    }

    internal fun isSolvable(field: Field): Boolean {
        var inversions = 0
        for (i in field.indices) {
            if (field[i] == EMPTY_CELL) {
                continue
            }
            for (j in i + 1 until field.size) {
                if (field[j] == EMPTY_CELL) {
                    continue
                }
                if (field[i] > field[j]) {
                    inversions++
                }
            }
        }
        val emptyIndex = field.indexOf(EMPTY_CELL)
        val row = emptyIndex / DIM
        return (inversions + row) % 2 != 0
    }
}
