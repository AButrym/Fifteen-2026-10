package com.example.myapplication.engine

enum class CrossNoughtCell {
    CROSS, NOUGHT, EMPTY
}

enum class Turn {
    CROSS_TURN, NOUGHT_TURN
}

enum class GameStatus {
    CROSS_WON, NOUGHT_WON, DRAW, IN_PROGRESS
}

typealias CrossNoughtBoard = List<CrossNoughtCell>

data class GameState(val board: CrossNoughtBoard, val turn: Turn)

data class ClickPosition(val row: Int, val col: Int)

interface CrossNought {
    fun update(state: GameState, move: ClickPosition): GameState
    fun status(field: CrossNoughtBoard): GameStatus

    fun isFinished(field: CrossNoughtBoard): Boolean =
        status(field) != GameStatus.IN_PROGRESS

    companion object {
        const val DIM = 3
        val initialBoard = List(DIM * DIM) { CrossNoughtCell.EMPTY }
        val initialGameState = GameState(initialBoard, Turn.CROSS_TURN)
    }
}