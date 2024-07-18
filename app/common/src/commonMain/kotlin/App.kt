import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun App() {
    MaterialTheme {
        val game = remember {
            Game(
                board = Board(),
                players = Pair(HumanPlayer(false), HumanPlayer(true))
            )
        }

        val spots = remember(game.board.boxes) {
            game.board.boxes
        }
        if (game.status != GameStatus.ACTIVE) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    text = if (game.status == GameStatus.WHITE_WIN) "White wins" else "Black wins",
                    style = TextStyle(
                        fontSize = 50.sp,
                        fontWeight = FontWeight.Bold,
                        color= Color.Yellow
                    )
                )
            }
        }
        else
        Column(modifier = Modifier.fillMaxSize()) {
            (0..7).forEach { i ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                ) {
                    (0..7).forEach() { j ->

                        SpotBox(
                            spots[i][j],
                            game = game
                        )
                    }
                }

            }
        }
    }
}