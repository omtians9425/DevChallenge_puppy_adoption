package com.compose.omtians9425.puppyadoption

import PuppyDetailScreen
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
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
                        composable("list") { PuppyListScreen(controller) }
                        composable("detail") { PuppyDetailScreen(controller) }
                    }
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PuppyAdoptionTheme {
        val controller = rememberNavController()
        PuppyListScreen(controller)
    }
}