package pieces

import Board
import Spot
import kotlin.math.abs

class Rook(white: Boolean) : Piece(white) {
    var hasMoved: Boolean = false

    override fun canMove(board: Board, start: Spot, end: Spot): Boolean {
        // we can't move the piece to a Spot that has a piece of the same color
        if (end.piece != null && end.piece!!.isWhite == this.isWhite) {
            return false
        }

        val x = abs(start.x - end.x)
        val y = abs(start.y - end.y)

        // check if the move is either along the same row or the same column
        if (x != 0 && y != 0) {
            return false
        }

        // check if the path is clear
        if (x == 0) {
            // moving vertically
            val yDirection = if (end.y > start.y) 1 else -1
            var yStep = start.y + yDirection

            while (yStep != end.y) {
                if (board.boxes[start.x][yStep].piece != null) {
                    return false
                }
                yStep += yDirection
            }
        } else {
            // moving horizontally
            val xDirection = if (end.x > start.x) 1 else -1
            var xStep = start.x + xDirection

            while (xStep != end.x) {
                if (board.boxes[xStep][start.y].piece != null) {
                    return false
                }
                xStep += xDirection
            }
        }

        return true
    }

    fun move() {
        this.hasMoved = true
    }
}