package uz.turgunboyevjurabek.simpleshimmer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import uz.turgunboyevjurabek.simpleshimmer.ui.theme.SimpleShimmerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimpleShimmerTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var isLoading by remember {
                        mutableStateOf(true)
                    }

                    LaunchedEffect(key1 = true){
                        delay(5000)
                        isLoading=false
                    }
                    LazyColumn(modifier = Modifier.fillMaxSize()){
                        items(20){
                            ShimmerListItem(
                                isLoading = isLoading,
                                contentAfterLoading = {
                                    Row(modifier = Modifier
                                        .padding(16.dp)
                                        .fillMaxWidth()) {
                                        Icon(imageVector = Icons.Default.Star, contentDescription = null, modifier = Modifier.size(100.dp), tint = Color(
                                            0xFFFF0000
                                        )
                                        )
                                        Spacer(modifier =Modifier.width(10.dp) )
                                        Column {
                                            Text(text = "Assalom alekum ,Nma gap", color = Color.Green)
                                            Spacer(modifier =Modifier.width(6.dp) )
                                            Text(text = "Va alekum assalom, tinch", color = Color.Cyan)
                                        }

                                    }

                                },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            )
                        }
                    }

                }
            }
        }
    }
}