package com.compose.omtians9425.puppyadoption.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
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
import androidx.navigation.compose.navigate
import com.compose.omtians9425.puppyadoption.Puppy
import com.compose.omtians9425.puppyadoption.R
import com.compose.omtians9425.puppyadoption.Sex
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PuppyListScreen(puppies: List<Puppy>, navController: NavController) {
    PuppyList(
        puppies = puppies, navController = navController
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PuppyList(puppies: List<Puppy>, navController: NavController) {
    LazyVerticalGrid(cells = GridCells.Fixed(2), contentPadding = PaddingValues(16.dp)) {
        items(puppies) { puppy ->
            PuppyItem(puppy = puppy, navController = navController)
        }
    }
}

@Composable
fun PuppyItem(puppy: Puppy, navController: NavController) {
    Card(
        elevation = 10.dp,
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .padding(16.dp)
            .width(50.dp)
            .height(200.dp)
            .clickable { navController.navigate("detail/${puppy.id}") }
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
                        modifier = Modifier
                            .size(12.dp)
                            .align(Alignment.CenterVertically)
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