import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.omtians9425.puppyadoption.ui.screens.puppies
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyDetailScreen(navController: NavController) {
    Column {
        Box(modifier = Modifier.height(200.dp)) {
            CoilImage(
                data = puppies.first().imageUrl,
                contentDescription = puppies.first().name,
                fadeIn = true,
                contentScale = ContentScale.Crop,
            )
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.Default.ArrowBack,
                    contentDescription = "back",
                    tint = Color.White
                )
            }
        }
    }
}