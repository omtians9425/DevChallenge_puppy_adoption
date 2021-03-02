package com.compose.omtians9425.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.omtians9425.puppyadoption.ui.theme.PuppyAdoptionTheme
import dev.chrisbanes.accompanist.coil.CoilImage

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyListScreen()
                }
            }
        }
    }
}

data class Puppy(
    val name: String,
    val breed: String,
    val age: Int,
    val sex: Sex,
    val imageUrl: String,
    val description: String,
)

enum class Sex(val rawValue: String) {
    BOY("Boy"), GIRL("Girl")
}

@Composable
fun PuppyListScreen() {
    PuppyList(
        puppies = listOf(
            Puppy(
                name = "Max",
                breed = "Labrador retriever",
                age = 1,
                sex = Sex.BOY,
                imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsq4yzm0S7Tim6fFga3sphSS7BTSIGjtuIHA&usqp=CAU",
                description = "",
            ),
            Puppy(
                name = "Maggie",
                breed = "Labrador retriever",
                age = 3,
                sex = Sex.GIRL,
                imageUrl = "https://www.min-breeder.com/data/handbook/14736/main_14736_88096_detail.jpg",
                description = "",
            ),
            Puppy(
                name = "Bailey",
                breed = "Golden retriever",
                age = 1,
                sex = Sex.BOY,
                imageUrl = "https://img.benesse-cms.jp/pet-dog/item/image/normal/resized/resized_b374345f-a774-45a9-8042-0779aba15936.jpg",
                description = "",
            ),
            Puppy(
                name = "Lola",
                breed = "Pug",
                age = 2,
                sex = Sex.GIRL,
                imageUrl = "https://besthqwallpapers.com/Uploads/15-8-2017/18667/thumb2-pug-puppy-cute-animals-dogs-decorative-dogs.jpg",
                description = "",
            ),
            Puppy(
                name = "Coco",
                breed = "Shih tzu",
                age = 1,
                sex = Sex.GIRL,
                imageUrl = "https://breeder-one.jp/uploads/photo/47995/slide_ad935bd4-fe36-4437-b66b-f90e8eed6ce7.jpeg",
                description = "",
            ),
            Puppy(
                name = "Rocky",
                breed = "Doberman",
                age = 1,
                sex = Sex.BOY,
                imageUrl = "https://passerellewan.jp/puppies/manager/upfile/921_351b52b9ec2148.jpg",
                description = "",
            ),
        )
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppyList(puppies: List<Puppy>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)) {
        items(puppies) { puppy ->
            PuppyItem(puppy = puppy)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .width(50.dp)
            .height(200.dp)
    ) {
        Box {
            CoilImage(
                data = puppy.imageUrl,
                contentDescription = puppy.name,
                fadeIn = true,
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f, endY = 650f
                        )
                    )
                    .padding(16.dp),
                verticalArrangement = Arrangement.Bottom,
            ) {
                Text(
                    text = puppy.name,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.W400
                )
                Text(
                    text = puppy.breed,
                    color = Color.White,
                    fontFamily = FontFamily.Monospace,
                    fontSize = 10.sp
                )
                Row {
                    Text(
                        text = "${puppy.age}year",
                        color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Icon(
                        painter = painterResource(
                            id = when (puppy.sex) {
                                Sex.BOY -> R.drawable.ic_male
                                Sex.GIRL -> R.drawable.ic_female
                            }
                        ),
                        contentDescription = "Sex",
                        tint = Color.White,
                        modifier = Modifier.size(12.dp)
                    )
                    Text(
                        text = puppy.sex.rawValue, color = Color.White,
                        fontFamily = FontFamily.Monospace,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppyAdoptionTheme {
        PuppyListScreen()
    }
}