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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                    color = MaterialTheme.colorScheme.background
                ) {
                    GreetingImage(
                        message = stringResource(R.string.happy_birthday_text, personName),
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
            // Birthday message
            Text(
                text = message,
                modifier = modifier.background(Color.Cyan),
                fontSize = 80.sp,
                lineHeight = 116.sp,
                textAlign = TextAlign.Center
            )
            // Signature text
            Text(
                text = stringResource(R.string.signature_text, from),
                modifier = Modifier
                    .padding(16.dp)
                    .align(alignment = Alignment.CenterHorizontally)
                    .background(Color.Cyan),
                fontSize = 36.sp
            )
        }
        Box {
            Column (verticalArrangement = Arrangement.Bottom, modifier = modifier) {
                Row {
                    Text( text = stringResource(R.string.copyright_text, "Integral Software Studios"))
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

        GreetingImage(stringResource(R.string.happy_birthday_text, personName), "Android", modifier = modifier)
    }
}