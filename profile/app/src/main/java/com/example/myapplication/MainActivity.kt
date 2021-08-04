package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.NonDisposableHandle.parent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProfileScreen()
        }
    }
}

@Composable
fun Greeting(name: String) {
    val arrayOfString: Array<String> = arrayOf("0000", "0000", "0000", "0000")

    Row() {
        arrayOfString.forEach {
            TextField(
                value = "",
                onValueChange = {
                    Log.e("TextFieldDemo", "输入内容更新")
                },
                placeholder = { Text(it) },
                modifier = Modifier
                    .width(50.dp)
                    .height(10.dp)
                    .size(14.dp)
            )
        }
    }

}

@Composable
fun ButtonSection() {
    val count: MutableState<Int> = remember {
        mutableStateOf(0)
    }
    Button(onClick = { count.value++ }) {
        Text(text = "click ${count.value}")
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        Greeting("Android")
        ButtonSection()
    }
}