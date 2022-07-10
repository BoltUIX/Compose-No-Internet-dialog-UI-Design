package compose.material.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import compose.material.theme.ui.theme.Material3ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Material3ComposeTheme {

                val infoDialog = remember { mutableStateOf(false) }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Column(
                        modifier = Modifier
                            .padding(20.dp)
                            .verticalScroll(rememberScrollState())
                    ) {


                        Spacer(modifier = Modifier.height(47.dp))

                        //...................................................................
                        // Info dialog demo button to show Info Jetpack compose custom dialog
                        Button(
                            onClick = {
                                infoDialog.value = true
                            },
                            modifier = Modifier.align(Alignment.CenterHorizontally),
                        ) {
                            Text(
                                text = "Show Info Dialog",
                                style = MaterialTheme.typography.labelLarge,
                            )
                        }
                    }
                }

                if (infoDialog.value) {
                    InfoDialog(
                        title = "Whoops!",
                        desc = "No Internet Connection found.\n" +
                                "Check your connection or try again.",
                        onDismiss = {
                            infoDialog.value = false
                        }
                    )
                }
            }
        }
    }
}

