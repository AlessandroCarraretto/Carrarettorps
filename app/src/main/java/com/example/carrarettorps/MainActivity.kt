package com.example.carrarettorps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.carrarettorps.ui.theme.CarrarettorpsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CarrarettorpsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ButtonsAndText()
                }
            }
        }
    }
}

@Composable
fun ButtonsAndText() {

    var number by remember { mutableStateOf(0)
    }

    var numberComputer by remember { mutableStateOf(0)
    }

    var punti by remember { mutableStateOf(0)
    }
    var punticomputer by remember { mutableStateOf(0)
    }
    var testo = ""

    var vinto by remember { mutableStateOf(0)
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Row (
            Modifier .padding(bottom = 16.dp)
        ){

            Button(
                onClick = { number = 0
                    numberComputer = computer()
                    if(number == 0 && numberComputer == 1 || number == 1 && numberComputer == 2 || number == 2 && numberComputer == 0)
                    {
                        vinto = 0
                        punticomputer++
                    }
                    if(number == 1 && numberComputer == 0 || number == 2 && numberComputer == 1 || number == 0 && numberComputer == 2)
                    {
                        vinto = 1
                        punti++
                    }
                    if(number == numberComputer )
                    {
                        vinto = 2
                    }
                }) { Text(text = "rock")}

            Button(
                onClick = { number = 1
                    numberComputer = computer()
                    if(number == 0 && numberComputer == 1 || number == 1 && numberComputer == 2 || number == 2 && numberComputer == 0)
                    {
                        vinto = 0
                        punticomputer++
                    }
                    if(number == 1 && numberComputer == 0 || number == 2 && numberComputer == 1 || number == 0 && numberComputer == 2)
                    {
                        vinto = 1
                        punti++
                    }
                    if(number == numberComputer || number == numberComputer || number == numberComputer)
                    {
                        vinto = 2
                    }}) { Text(text = "paper")}

            Button(
                onClick = { number = 2
                    numberComputer = computer();
                    if(number == 0 && numberComputer == 1 || number == 1 && numberComputer == 2 || number == 2 && numberComputer == 0)
                    {
                        vinto = 0
                        punticomputer++
                    }
                    if(number == 1 && numberComputer == 0 || number == 2 && numberComputer == 1 || number == 0 && numberComputer == 2)
                    {
                        vinto = 1
                        punti++
                    }
                    if(number == numberComputer || number == numberComputer || number == numberComputer)
                    {
                        vinto = 2
                    }}) { Text(text = "scissor")}
        }
        Row {

            Text(
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 36.sp,
                text = ""+punti

            )
            immagine(number)
            immagine(numberComputer)
            Text(
                modifier = Modifier.padding(top = 16.dp),
                fontSize = 36.sp,
                text = ""+punticomputer)

        }


        when (vinto) {
            0 -> {
                testo = stringResource(R.string.lose)
            }
            1 -> {
                testo = stringResource(R.string.win)
            }
            2 -> {
                testo = stringResource(R.string.draw)
            }
        }


        Text(
            fontSize = 36.sp,
            color = Color.Black,
            text = testo

        )
    }
}




@Composable
fun immagine(number: Int) {
    if(number == 0){
        Image(painter = painterResource(R.drawable.rock), contentDescription = null)
    }
    if (number == 1){
        Image(painter = painterResource(R.drawable.paper), contentDescription = null)
    }
    if (number == 2){
        Image(painter = painterResource(R.drawable.scissors), contentDescription = null)
    }
}

fun computer():Int{ //numero casuale da 0 a 2
    return (0..2).random()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CarrarettorpsTheme {
        ButtonsAndText()
    }
}