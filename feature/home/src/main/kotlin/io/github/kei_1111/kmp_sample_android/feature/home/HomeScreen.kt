package io.github.kei_1111.kmp_sample_android.feature.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.kei_1111.kmp_sample_library.feature.home.HomeState
import io.github.kei_1111.kmp_sample_library.feature.home.HomeViewModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen() {
    val viewModel: HomeViewModel = koinViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        when (state) {
            is HomeState.Init -> {
                Text(text = "Welcome to Home Screen")
            }

            is HomeState.Loading -> {
                Text(text = "Loading...")
            }

            is HomeState.Error -> {
                Text(text = "Error")
            }

            is HomeState.Success -> {
                val data = (state as HomeState.Success).properties.joinToString(separator = "\n")
                Text(text = "Data: $data")
            }
        }
    }
}