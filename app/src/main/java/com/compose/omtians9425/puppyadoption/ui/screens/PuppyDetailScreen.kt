import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
import com.compose.omtians9425.puppyadoption.puppies
import dev.chrisbanes.accompanist.coil.CoilImage


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PuppyDetailScreen(puppyId: Int?, navController: NavController) {
    puppyId ?: return
    Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()) {
        Header(puppyId, navController)
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .offset(y = 150.dp)
                .padding(24.dp)
                .fillMaxSize()
        ) {
            OverviewCard(puppyId)
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = puppies.single { it.id == puppyId }.description, modifier = Modifier
                    .verticalScroll(
                        rememberScrollState()
                    )
            )
        }
        ExtendedFloatingActionButton(
            text = { Text(text = "Adopt") },
            onClick = { /*TODO*/ },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}

@Composable
fun Header(puppyId: Int, navController: NavController) {
    Box(
        modifier = Modifier.height(250.dp)
    ) {
        CoilImage(
            data = puppies.single { it.id == puppyId }.imageUrl,
            contentDescription = puppies.first().name,
            fadeIn = true,
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = Modifier.fillMaxSize().background(
                Brush.verticalGradient(
                    colors = listOf(Color.DarkGray, Color.Transparent),
                    startY = -20.0f, endY = 150.0f
                )
            )
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

@Composable
fun OverviewCard(puppyId: Int) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(150.dp)
            .width(300.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
        ) {
            Text(
                text = puppies.single { it.id == puppyId }.name,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.W600,
                fontSize = 25.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = puppies.single { it.id == puppyId }.breed,
                fontFamily = FontFamily.Monospace,
                fontSize = 15.sp
            )
            Row {
                Text(
                    text = "${puppies.single { it.id == puppyId }.age}year",
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp
                )
                Spacer(modifier = Modifier.width(8.dp))
                Icon(
                    painter = painterResource(
                        id = when (puppies.single { it.id == puppyId }.sex) {
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
                    text = puppies.single { it.id == puppyId }.sex.rawValue,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 15.sp
                )
            }
        }
    }
}