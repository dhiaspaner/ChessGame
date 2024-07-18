package pieces

import Board
import Spot
import kotlin.math.abs

class King(white: Boolean) : Piece(white) {
    var isCastlingDone: Boolean = false

    override fun canMove(board: Board, start: Spot, end: Spot): Boolean {
        // we can't move the piece to a Spot that
        // has a piece of the same color
        if (end.piece != null && end.piece!!.isWhite == this.isWhite) {
            return false
        }

        val x = abs(start.x - end.x)
        val y = abs(start.y - end.y)
        if (x + y == 1) {
            return true
        }
        if (x == 1 && y == 1) {
            return true
        }

        return false
    }

//    private fun isValidCastling(board: Board, start: Spot, end: Spot): Boolean {
//        if (this.isCastlingDone) {
//            return false
//        }
//
//        // Castling can only be done if the King and the chosen Rook have not moved yet
//        // Also, there should not be any pieces between the King and the Rook
//        // The King should not be in check, and should not pass through or land on a square attacked by enemy pieces
//
//        // Castling to the right (King-side)
//        if (start.y == 4 && (end.y == 6 || end.y == 2)) {
//            val rookSpot = if (end.y == 6) board.boxes[start.x][7] else board.boxes[start.x][0]
//            val rook = rookSpot.piece
//            if (rook != null && rook is Rook && rook.isWhite == this.isWhite && !rook.hasMoved) {
//                // Check if path between King and Rook is clear
//                val direction = if (end.y == 6) 1 else -1
//                for (i in 1 until (if (direction == 1) 3 else 4)) {
//                    if (board.boxes[start.x][start.y + i * direction].piece != null) {
//                        return false
//                    }
//                }
//                // Additional checks for whether the King is in check, passing through check, or ends in check can be added here
//
//                return true
//            }
//        }
//        return false
//    }
//
//    fun isCastlingMove(start: Spot, end: Spot): Boolean {
//        // check if the starting and ending position are correct
//        // King-side castling
//        if (start.y == 4 && end.y == 6 && start.x == end.x) {
//            return true
//        }
//
//        // Queen-side castling
//        if (start.y == 4 && end.y == 2 && start.x == end.x) {
//            return true
//        }
//
//        return false
//    }
}
