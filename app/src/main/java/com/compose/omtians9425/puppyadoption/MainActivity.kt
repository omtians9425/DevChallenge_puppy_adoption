package com.compose.omtians9425.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.omtians9425.puppyadoption.ui.theme.PuppyAdoptionTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    PuppyListScreen("Android")
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
fun PuppyListScreen(name: String) {
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
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.min-breeder.com%2FusefulArticle-14736.html&psig=AOvVaw2ZLt1n--rCwt7Zq8ySmMTy&ust=1614698896638000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCKDhlKS0j-8CFQAAAAAdAAAAABAD",
                description = "",
            ),
            Puppy(
                name = "Bailey",
                breed = "Golden retriever",
                age = 1,
                sex = Sex.BOY,
                imageUrl = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fimg.benesse-cms.jp%2Fpet-dog%2Fitem%2Fimage%2Fnormal%2Fresized%2Fresized_b374345f-a774-45a9-8042-0779aba15936.jpg&imgrefurl=https%3A%2F%2Fdog.benesse.ne.jp%2Fdoglist%2Fbig%2Fcontent%2F%3Fid%3D13429&tbnid=4Rt_WOya106klM&vet=10CFkQMyiPAWoXChMI4KbK17SP7wIVAAAAAB0AAAAAEAI..i&docid=T9wu9TsDTpEVuM&w=509&h=339&q=%E3%82%B4%E3%83%BC%E3%83%AB%E3%83%87%E3%83%B3%E3%83%AC%E3%83%88%E3%83%AA%E3%83%90%E3%83%BC%20%E5%AD%90%E7%8A%AC&ved=0CFkQMyiPAWoXChMI4KbK17SP7wIVAAAAAB0AAAAAEAI",
                description = "",
            ),
            Puppy(
                name = "Lola",
                breed = "Pug",
                age = 2,
                sex = Sex.GIRL,
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbesthqwallpapers.com%2Fja%2F%25E5%258B%2595%25E7%2589%25A9%2F%25E3%2583%2591%25E3%2582%25B0-%25E5%25AD%2590%25E7%258A%25AC-%25E3%2581%258B%25E3%2582%258F%25E3%2581%2584%25E3%2581%2584%25E5%258B%2595%25E7%2589%25A9%25E3%2581%259F%25E3%2581%25A1-%25E7%258A%25AC-%25E8%25A3%2585%25E9%25A3%25BE%25E7%258A%25AC-18667&psig=AOvVaw3RBIhjzEWfEbfZkHwAEDN5&ust=1614699092911000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMCd_Ym1j-8CFQAAAAAdAAAAABAM",
                description = "",
            ),
            Puppy(
                name = "Coco",
                breed = "Shih tzu",
                age = 1,
                sex = Sex.GIRL,
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fbreeder-one.jp%2Fpuppy%2F47995&psig=AOvVaw0iDPlgTAXFgnHnI2d3tJrV&ust=1614699332377000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMC62fO1j-8CFQAAAAAdAAAAABAD",
                description = "",
            ),
            Puppy(
                name = "Rocky",
                breed = "Doberman",
                age = 1,
                sex = Sex.BOY,
                imageUrl = "https://www.google.com/url?sa=i&url=https%3A%2F%2Fpasserellewan.jp%2Fpuppies%2Fdetail.php%3Fnum%3D921&psig=AOvVaw36E7cNTRKJgKqqh7pbLHV9&ust=1614699417791000&source=images&cd=vfe&ved=0CAIQjRxqFwoTCMCOnKi2j-8CFQAAAAAdAAAAABAE",
                description = "",
            ),
        )
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppyList(puppies: List<Puppy>) {
    LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 128.dp)) {
        items(puppies) { puppy ->
            PuppyItem(puppy = puppy)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy) {
    Text(text = puppy.name)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppyAdoptionTheme {
        PuppyListScreen("Android")
    }
}