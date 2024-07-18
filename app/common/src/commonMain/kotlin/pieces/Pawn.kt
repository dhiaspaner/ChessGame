package pieces

import Board
import Spot
import kotlin.math.abs

class Pawn(white: Boolean) : Piece(white) {
    private val direction = if (this.isWhite) -1 else 1
    override fun canMove(board: Board, start: Spot, end: Spot): Boolean {
        val x = start.x - end.x
        val y = start.y - end.y
        // we can't move the piece to a Spot that has a piece of the same color
        if (end.piece?.isWhite == this.isWhite) return false
        val isFirstMove = if (this.isWhite) start.x == 1 else start.x == 6
        if (isFirstMove && x == 2 * direction && y == 0 && end.piece == null) {
            return true
        }

        if (x == direction && y == 0 && end.piece == null)
            return true


//         Capture diagonally
        if (x == direction && abs(y) == 1 && end.piece != null && end.piece?.isWhite != this.isWhite) {
            return true
        }

        // En passant capture
        if (x == direction && abs(y) == 1 && end.piece == null) { }
        return false
    }
}