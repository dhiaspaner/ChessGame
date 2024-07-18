
import pieces.Piece

class Spot(
    val x: Int,
    val y: Int,
    var piece: Piece? = null,
    val isWhite: Boolean = true
) {
}