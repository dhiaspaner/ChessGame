import pieces.Bishop
import pieces.King
import pieces.Knight
import pieces.Pawn
import pieces.Queen
import pieces.Rook

class Board {
    lateinit var boxes: List<List<Spot>>

    init {
        this.resetBoard()
    }

    fun resetBoard() {
        val boxes = mutableListOf<MutableList<Spot>>().apply {
            repeat(8) {
                add(mutableListOf())
            }
        }
        // initialize white pieces
        boxes[0].add(Spot(0, 0, Rook(true)))
        boxes[0].add(Spot(0, 1, Knight(true)))
        boxes[0].add(Spot(0, 2, Bishop(true)))
        boxes[0].add(Spot(0, 3, Queen(true)))
        boxes[0].add(Spot(0, 4, King(true)))
        boxes[0].add(Spot(0, 5, Bishop(true)))
        boxes[0].add( Spot(0, 6, Knight(true)))
        boxes[0].add(Spot(0, 7, Rook(true)))

        for (i in 0..7) {
            boxes[1].add(Spot(1, i, Pawn(true)))
            boxes[6].add(Spot(6, i, Pawn(false)))
        }

        // initialize black pieces
        boxes[7].add(Spot(7, 0, Rook(false)))
        boxes[7].add(Spot(7, 1, Knight(false)))
        boxes[7].add(Spot(7, 2, Bishop(false)))
        boxes[7].add(Spot(7, 3, Queen(false)))
        boxes[7].add(Spot(7, 4, King(false)))
        boxes[7].add(Spot(7, 5, Bishop(false)))
        boxes[7].add( Spot(7, 6, Knight(false)))
        boxes[7].add(Spot(7, 7, Rook(false)))



        // initialize remaining boxes without any piece
        for (i in 2..5) {
            for (j in 0..7) {
                boxes[i].add( Spot(i, j, null))
            }
        }

        this.boxes = boxes.toList()
    }

}