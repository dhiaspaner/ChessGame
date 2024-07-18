import Game
import Spot
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.sp
import kotlinstarter.app.common.generated.resources.Res
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource


@Composable
fun RowScope.SpotBox(
    spot: Spot,
    game: Game
) {

    val isInMovePossibilities = remember(game.movePossibilities, game.selectedSpot) {
        game.movePossibilities.contains(spot)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .background(
                color = if ((spot.x + spot.y) % 2 == 0) Color.White else Color.Black,
                shape = RectangleShape
            )
            .drawBehind {
                if (isInMovePossibilities)
                    drawCircle(
                        color = Color.Green,
                        radius = size.minDimension / 2.2f,
                        center = Offset(size.width / 2, size.height / 2)
                    )
            }
            .pointerInput(isInMovePossibilities) {
                detectTapGestures(
                    onTap = {
                        if (isInMovePossibilities) game.selectedSpot?.let { game.playerMove(it, spot) }
                        else game.selectedSpot = spot
                    }
                )
            }
    ) {
        spot.piece?.let {
            PieceImage(it)
        }
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
fun PieceImage(
    piece: pieces.Piece
) {
//    val image = when (piece) {
//        is pieces.Bishop -> Res.drawable
//        is pieces.King -> Res.drawable.compose_multiplatform
//        is pieces.Knight -> Res.drawable.compose_multiplatform
//        is pieces.Pawn -> Res.drawable.compose_multiplatform
//        is pieces.Queen -> Res.drawable.compose_multiplatform
////        is pieces.Rook -> Res.drawable.black_queen
//        else -> Res.drawable.compose_multiplatform
//    }

    val pieceName = when (piece) {
        is pieces.Bishop -> "B"
        is pieces.King -> "K"
        is pieces.Knight -> "N"
        is pieces.Pawn -> "P"
        is pieces.Queen -> "Q"
        is pieces.Rook -> "R"
        else -> ""
    }

    Text(
        text = pieceName,
        fontSize = 20.sp,
        color = if (piece.isWhite) Color.Green else Color.Red
    )

    PieceImage(pieceName)


}