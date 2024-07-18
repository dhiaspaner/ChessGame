import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import pieces.King
import pieces.Piece


class Game(
    val board: Board,
    private val players: Pair<Player, Player>,
) {

    private var currentTurn: Player = if (players.first.isWhiteSide) players.first else players.second
    private val movesPlayed: MutableList<Move> = mutableListOf()
    var status: GameStatus by mutableStateOf(GameStatus.ACTIVE)

    var selectedSpot by mutableStateOf<Spot?>(null)

    val movePossibilities: List<Spot>
        get() {
            val spot = selectedSpot ?: return emptyList()
            val piece = spot.piece ?: return emptyList()
            if (piece.isWhite != currentTurn.isWhiteSide) return emptyList()
            return board.boxes.map { row -> row.filter { piece.canMove(board, spot, it) } }.flatten()
        }


    fun playerMove(startSpot: Spot, endSpot: Spot) {
        val move = Move(currentTurn, startSpot, endSpot)
        makeMove(move, currentTurn)
    }

    private fun makeMove(move: Move, player: Player) {
        val sourcePiece: Piece = move.start.piece ?: return
        // valid player
        if (player !== currentTurn) {
            return
        }

//        if (sourcePiece.isWhite != player.isWhiteSide) {
//            return false
//        }
        // valid move?
        if (!sourcePiece.canMove(board, move.start, move.end)) {
            return
        }


        // kill?
//        if (sourcePiece is King && sourcePiece.isCastlingMove(move.start, move.end)) {
//            move.isCastlingMove = true
//        }


        // store the move
        movesPlayed.add(move)

        if (move.end.piece is King) {
            if (player.isWhiteSide) this.status = GameStatus.WHITE_WIN
            else this.status = GameStatus.BLACK_WIN
        }

        // move piece from the stat box to end box
        move.end.piece = move.pieceMoved
        move.start.piece = null
        selectedSpot = null


        // set the current turn to the other player
        if (this.currentTurn === players.first) this.currentTurn = players.second
        else this.currentTurn = players.first

    }
}