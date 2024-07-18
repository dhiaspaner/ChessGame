
interface  Player {
    var isWhiteSide: Boolean
    var isHumanPlayer: Boolean
}

class HumanPlayer(whiteSide: Boolean) : Player {
    override var isWhiteSide: Boolean = whiteSide
    override var isHumanPlayer: Boolean = true
}

class ComputerPlayer(whiteSide: Boolean) : Player {
    override var isWhiteSide: Boolean = whiteSide
    override var isHumanPlayer: Boolean = false
}