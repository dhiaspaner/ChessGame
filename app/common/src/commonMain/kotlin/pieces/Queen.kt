package pieces

import Board
import Spot
import kotlin.math.abs

class Queen(white: Boolean) : Piece(white) {

    override fun canMove(board: Board, start: Spot, end: Spot): Boolean {
        // we can't move the piece to a Spot that has a piece of the same color
        if (end.piece != null && end.piece!!.isWhite == this.isWhite) {
            return false
        }

        val x = abs(start.x - end.x)
        val y = abs(start.y - end.y)

        // check if the move is along the same row, column or diagonal
        if (x == y || x == 0 || y == 0) {
            // check if the path is clear
            val xDirection = if (end.x > start.x) 1 else if (end.x < start.x) -1 else 0
            val yDirection = if (end.y > start.y) 1 else if (end.y < start.y) -1 else 0

            var xStep = start.x + xDirection
            var yStep = start.y + yDirection

            while (xStep != end.x || yStep != end.y) {
                if (board.boxes[xStep][yStep].piece != null) return false
                xStep += xDirection
                yStep += yDirection
            }
            return true
        }
        return false
    }
}
