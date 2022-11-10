package com.example.composecourse

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.composecourse.ui.theme.ComposeCourseTheme
import kotlin.random.Random


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCourseTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column(Modifier.fillMaxSize()) {
                        var color by remember {
                            mutableStateOf(Color.Green)
                        }

                        ColorBox(
                            Modifier
                                .weight(1f)
                                .fillMaxSize()) {
                            color = it
                        }

                        Box(modifier = Modifier
                            .background(color)
                            .weight(1f)
                            .fillMaxSize())
                    }


                }

            }
        }
    }
}

@Composable
fun ColorBox(
    modifier: Modifier = Modifier,
    updateColor: (Color) -> Unit) {

    Box(modifier = modifier
        .background(Color.Blue)
        .clickable {
            updateColor ( Color(
                Random.nextFloat(),
                Random.nextFloat(),
                Random.nextFloat(),
                1f)
            )
        })
        {
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeCourseTheme {
    }
}