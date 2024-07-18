import pieces.Piece


class Move(private val player: Player,  val start: Spot,  val end: Spot) {
    val pieceMoved = start.piece
    var pieceKilled: Piece? = null
    var isCastlingMove: Boolean = false
}