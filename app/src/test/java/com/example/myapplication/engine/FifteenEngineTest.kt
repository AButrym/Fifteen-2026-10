package com.example.myapplication.engine

import com.example.myapplication.engine.Fifteen.Companion.EMPTY_CELL
import com.example.myapplication.engine.Fifteen.Companion.solvedField
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class FifteenEngineTest {

    private val fifteen = FifteenImpl()

    @Test
    fun testSolvedFieldIsSolvable() {
        assertTrue(fifteen.isSolvable(solvedField))
    }

    @Test
    fun testIsSolvable1() {
        val field = listOf(
            1, 2, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, EMPTY_CELL,
            13, 14, 15, 12
        )
        assertTrue(fifteen.isSolvable(field))
    }

    @Test
    fun testUnsolvableField2() {
        val field = listOf(
            1, 2, 3, 4,
            5, 7, 6, 8,
            9, 10, 11, 12,
            13, 14, 15, EMPTY_CELL
        )
        assertFalse(fifteen.isSolvable(field))
    }

    @Test
    fun testUnsolvableField() {
        val field = buildList {
            addAll(1..13)
            add(15)
            add(14)
            add(EMPTY_CELL)
        }
        assertFalse(fifteen.isSolvable(field))
    }

    @Test
    fun testIsSolved() {
        assertTrue(fifteen.isSolved(solvedField))
        val unsolved = listOf(
            2, 1, 3, 4,
            5, 6, 7, 8,
            9, 10, 11, 12,
            13, 14, 15, EMPTY_CELL
        )
        assertFalse(fifteen.isSolved(unsolved))
    }

    @Test
    fun testRandomSolvableField() {
        repeat(10) {
            val field = fifteen.randomSolvableField()
            assertEquals(16, field.size)
            assertTrue(field.containsAll((1..EMPTY_CELL).toList()))
            assertTrue(fifteen.isSolvable(field))
        }
    }

    @Test
    fun testUpdateValidMove() {
        // In solvedField, empty cell is at index 15 (row 3, col 3).
        // Adjacent tiles are tile 12 (at index 11) and tile 15 (at index 14).
        // Let's move tile 15.
        val updated = fifteen.update(solvedField, 15)
        val expected = buildList {
            addAll(1..14)
            add(EMPTY_CELL)
            add(15)
        }
        assertEquals(expected, updated)
    }

    @Test
    fun testUpdateHorizontalAndVerticalMoves() {
        // Custom field where EMPTY_CELL is at index 5 (row 1, col 1)
        // Indices:
        // Row 0: 1, 2, 3, 4 (indices 0, 1, 2, 3)
        // Row 1: 5, EMPTY, 6, 7 (indices 4, 5, 6, 7)
        // Row 2: 8, 9, 10, 11 (indices 8, 9, 10, 11)
        // Row 3: 12, 13, 14, 15 (indices 12, 13, 14, 15)
        val customField = listOf(
            1, 2, 3, 4,
            5, EMPTY_CELL, 6, 7,
            8, 9, 10, 11,
            12, 13, 14, 15
        )
        val expectedUpdated1 = listOf(
            1, 2, 3, 4,
            EMPTY_CELL, 5, 6, 7,
            8, 9, 10, 11,
            12, 13, 14, 15
        )
        val expectedUpdated2 = listOf(
            1, EMPTY_CELL, 3, 4,
            5, 2, 6, 7,
            8, 9, 10, 11,
            12, 13, 14, 15
        )

        // Move tile 5 (at index 4) into empty (index 5)
        val afterLeftMove = fifteen.update(customField, 5)
        assertEquals(expectedUpdated1, afterLeftMove)

        // Move tile 2 (at index 1) into empty (index 5)
        val afterUpMove = fifteen.update(customField, 2)
        assertEquals(expectedUpdated2, afterUpMove)
    }

    @Test
    fun testUpdateInvalidMove() {
        // In solvedField, empty cell is at index 15. Tile 1 is at index 0 (not adjacent).
        val updated = fifteen.update(solvedField, 1)
        assertEquals(solvedField, updated)
    }

    @Test
    fun testIxToRowCol() {
        assertEquals(0 to 0, fifteen.ixToRowCol(0))
        assertEquals(1 to 1, fifteen.ixToRowCol(5))
        assertEquals(3 to 3, fifteen.ixToRowCol(15))
    }
}
