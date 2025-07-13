package io.github.kei_1111.kmp_sample_android.feature.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import io.github.kei_1111.kmp_sample_library.Greeting

@Composable
fun HomeScreen() {
    Text(
        text = Greeting().greet()
    )
}