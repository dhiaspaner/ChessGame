package pieces

import Board
import Spot


abstract class Piece(white: Boolean) {
    var isKilled: Boolean = false
    var isWhite: Boolean = white

    abstract fun canMove(
        board: Board,
        start: Spot, end: Spot
    ): Boolean
}


