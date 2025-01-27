package com.example.bookreader

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookreader.navigation.ReaderNavigation
import com.example.bookreader.ui.theme.BookReaderTheme
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BookReaderTheme {
                ReaderApp()
                // A surface container using the 'background' color from the theme

//                val db =  FirebaseFirestore.getInstance()
//                val user:MutableMap<String,Any> = HashMap()
//                user["firstName"] = "Mohd"
//                user["lastName"] = "Aasim"
//

            }
        }
    }
}

@Composable
fun ReaderApp(){
    Surface(
        color = MaterialTheme.colorScheme.background,
        modifier = Modifier.fillMaxSize() ,
        content = {
                Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    ReaderNavigation()
                }

    }
    )
}




//                    db.collection("users")
//                        .add(user)
//                        .addOnSuccessListener {
//                            Log.e("FB","onCreate:${it.id}")
//                        }.addOnFailureListener {
//                            Log.e("FB","onCreate:${it}")
//
//                        }




@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookReaderTheme {
        Greeting("Android")
    }
}