package com.example.myapplication.engine2


/*
Cell
├─> Empty
└─> Player
    ├─> Cross
    └─> Nought
GameStatus
├─> InProgress
├─> Draw
└─> Winner <─ Player <─ Cell
    ├─> Cross
    └─> Nought
*/

sealed interface Cell
sealed interface Player : Cell
sealed interface GameStatus
sealed interface Winner : GameStatus, Player

object Cross : Cell, Player, Winner
object Nought : Cell, Player, Winner
object Empty : Cell
object Draw : GameStatus
object InProgress : GameStatus

typealias Board = List<Cell>

data class GameState(val board: Board, val currentPlayer: Player)

data class Position(val row: Int, val col: Int)

interface CrossNought {
    fun update(state: GameState, move: Position): GameState
    fun status(field: Board): GameStatus

    fun isFinished(field: Board): Boolean =
        status(field) != InProgress

    companion object {
        const val DIM = 3
        val initialBoard = List(DIM * DIM) { Empty }
        val initialGameState = GameState(initialBoard, Cross)
    }
}

val Player.next: Player
    get() = when (this) {
        Cross  -> Nought
        Nought -> Cross
    }
