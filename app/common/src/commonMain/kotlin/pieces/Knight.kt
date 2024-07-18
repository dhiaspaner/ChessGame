package pieces

import Board
import Spot
import kotlin.math.abs

class Knight(white: Boolean) : Piece(white) {
    override fun canMove(
        board: Board,
        start: Spot,
        end: Spot
    ): Boolean {
        // we can't move the piece to a spot that has
        // a piece of the same colour
        if (end.piece?.isWhite == this.isWhite) {
            return false
        }

        val x = abs((start.x - end.x).toDouble()).toInt()
        val y = abs((start.y - end.y).toDouble()).toInt()
        return x * y == 2
    }
}