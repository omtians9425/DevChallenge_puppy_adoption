package com.compose.omtians9425.puppyadoption

import PuppyDetailScreen
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.compose.omtians9425.puppyadoption.ui.screens.PuppyListScreen
import com.compose.omtians9425.puppyadoption.ui.theme.PuppyAdoptionTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val controller = rememberNavController()
                    NavHost(navController = controller, startDestination = "list") {
                        composable("list") { PuppyListScreen(puppies, controller) }
                        composable(
                            "detail/{puppyId}",
                            arguments = listOf(navArgument("puppyId") { type = NavType.IntType })
                        ) { backStackEntry ->
                            PuppyDetailScreen(
                                backStackEntry.arguments?.getInt("puppyId"),
                                controller
                            )
                        }
                    }
                }
            }
        }
    }
}

data class Puppy(
    val id: Int,
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

val puppies = listOf(
    Puppy(
        id = 1,
        name = "Max",
        breed = "Labrador retriever",
        age = 1,
        sex = Sex.BOY,
        imageUrl = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRsq4yzm0S7Tim6fFga3sphSS7BTSIGjtuIHA&usqp=CAU",
        description = "The Labrador Retriever, often abbreviated to Labrador, is a breed of retriever-gun dog from the United Kingdom that was developed from imported Canadian fishing dogs. The Labrador is one of the most popular dog breeds in a number of countries in the world, particularly in the Western world.\n" +
                "\n" +
                "A favourite disability assistance breed in many countries, Labradors are frequently trained to aid those with blindness or autism, act as a therapy dog, or perform screening and detection work for law enforcement and other official agencies. The breed is best known for their obedience, loyalty, and playful composure. Additionally, they are prized as sporting and hunting dogs. Ancestors include a breed used in Newfoundland as fishing dogs, that would help in bringing in the fishing nets and recapture escaped fish.",
    ),
    Puppy(
        id = 2,
        name = "Maggie",
        breed = "Labrador retriever",
        age = 3,
        sex = Sex.GIRL,
        imageUrl = "https://www.min-breeder.com/data/handbook/14736/main_14736_88096_detail.jpg",
        description = "",
    ),
    Puppy(
        id = 3,
        name = "Bailey",
        breed = "Golden retriever",
        age = 1,
        sex = Sex.BOY,
        imageUrl = "https://img.benesse-cms.jp/pet-dog/item/image/normal/resized/resized_b374345f-a774-45a9-8042-0779aba15936.jpg",
        description = "",
    ),
    Puppy(
        id = 4,
        name = "Lola",
        breed = "Pug",
        age = 2,
        sex = Sex.GIRL,
        imageUrl = "https://besthqwallpapers.com/Uploads/15-8-2017/18667/thumb2-pug-puppy-cute-animals-dogs-decorative-dogs.jpg",
        description = "",
    ),
    Puppy(
        id = 5,
        name = "Coco",
        breed = "Shih tzu",
        age = 1,
        sex = Sex.GIRL,
        imageUrl = "https://breeder-one.jp/uploads/photo/47995/slide_ad935bd4-fe36-4437-b66b-f90e8eed6ce7.jpeg",
        description = "",
    ),
    Puppy(
        id = 6,
        name = "Rocky",
        breed = "Doberman",
        age = 1,
        sex = Sex.BOY,
        imageUrl = "https://passerellewan.jp/puppies/manager/upfile/921_351b52b9ec2148.jpg",
        description = "",
    ),
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppyAdoptionTheme {
        val controller = rememberNavController()
        PuppyListScreen(puppies, controller)
    }
}