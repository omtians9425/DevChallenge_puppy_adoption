import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.compose.omtians9425.puppyadoption.R
import com.compose.omtians9425.puppyadoption.Sex
import com.compose.omtians9425.puppyadoption.ui.screens.puppies
import dev.chrisbanes.accompanist.coil.CoilImage

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyDetailScreen(navController: NavController) {
    Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()) {
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
        Card(
            elevation = 10.dp,
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .height(150.dp)
                .width(300.dp)
                .offset(y = 200.dp)
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
            ) {
                Text(
                    text = puppies.first().name,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W600,
                    fontSize = 25.sp
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = puppies.first().breed,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp
                )
                Row {
                    Text(
                        text = "${puppies.first().age}year",
                        fontFamily = FontFamily.Monospace,
                        fontSize = 15.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(
                            id = when (puppies.first().sex) {
                                Sex.BOY -> R.drawable.ic_male
                                Sex.GIRL -> R.drawable.ic_female
                            }
                        ),
                        contentDescription = "Sex",
                        modifier = Modifier
                            .size(15.dp)
                            .align(alignment = Alignment.CenterVertically)
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = puppies.first().sex.rawValue,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 15.sp
                    )
                }
            }
        }
    }
}