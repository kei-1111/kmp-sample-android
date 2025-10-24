package io.github.kei_1111.kmp_sample_android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import io.github.kei_1111.kmp_sample_android.feature.home.HomeScreen
import io.github.kei_1111.kmp_sample_android.ui.theme.KmpSampleAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KmpSampleAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { _ ->
                    HomeScreen()
                }
            }
        }
    }
}
