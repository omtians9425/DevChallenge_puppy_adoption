import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.compose.omtians9425.puppyadoption.ui.screens.puppies
import dev.chrisbanes.accompanist.coil.CoilImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyDetailScreen(navController: NavController) {
    Box {
        Box(modifier = Modifier.height(250.dp)) {
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
        Box(
            modifier = Modifier
                .offset(y = 200.dp)
                .clip(RoundedCornerShape(32.dp))
                .background(color = Color(0xFF5a65fa))
                .fillMaxSize(),
        )
    }
}