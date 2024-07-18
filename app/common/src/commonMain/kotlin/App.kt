import androidx.compose.runtime.Composable
import navigation.auth.login.LoginScreenNav
import cafe.adriel.voyager.navigator.Navigator
import theme.KotlinStarterTheme

@Composable
fun App() {
    KotlinStarterTheme {
        Navigator(LoginScreenNav())
    }
}