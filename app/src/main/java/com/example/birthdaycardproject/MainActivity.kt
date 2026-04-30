package com.example.birthdaycardproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.birthdaycardproject.ui.theme.BirthdayCardProjectTheme

const val personName: String = "Justin"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BirthdayCardProjectTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color.Green //MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = "Happy Birthday, $personName!",
                        modifier = Modifier.padding(8.dp),
                        from = "Android"
                    )
                }
            }
        }
    }
}

@Composable
fun GreetingText(message: String, modifier: Modifier = Modifier, from: String = "Nobody") {
    Column {
        Column (
            verticalArrangement = Arrangement.Center,
            modifier = modifier
        ) {
            Text(
                text = message,
                modifier = modifier.background(Color.Cyan),
                fontSize = 80.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            Text(
                text = "From: $from",
                modifier = Modifier.padding(16.dp).align(alignment = Alignment.End).background(Color.Cyan),
                fontSize = 36.sp,
                textAlign = TextAlign.Right
            )
        }
        Box {
            Column (verticalArrangement = Arrangement.Bottom, modifier = modifier) {
                Row {
                    Text( text = "Crafted by Integral Software Studios")
                }
            }
        }
    }
}

@Composable
fun GreetingImage(message: String, from: String, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.androidparty),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alpha = 0.5F
        )
        GreetingText(message = message, from = from, modifier = modifier)
    }
}

@Preview(showBackground = true)
@Composable
fun BirthdayCardPreview() {
    BirthdayCardProjectTheme {
        val modifier = Modifier.padding(8.dp)

        GreetingImage("Happy Birthday $personName!", "Android", modifier = modifier)
    }
}