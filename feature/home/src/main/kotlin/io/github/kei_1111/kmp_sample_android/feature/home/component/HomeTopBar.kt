package io.github.kei_1111.kmp_sample_android.feature.home.component

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.lerp
import io.github.kei_1111.kmp_sample_android.core.designsystem.theme.KmpSampleAndroidTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeTopBar(
    scrollBehavior: TopAppBarScrollBehavior,
    modifier: Modifier = Modifier,
) {
    val statusBarHeight = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()
    val topPadding = lerp(
        start = statusBarHeight,
        stop = 0.dp,
        fraction = scrollBehavior.state.collapsedFraction
    )

    TopAppBar(
        title = {
            Text(
                text = "Mars Properties",
                style = MaterialTheme.typography.titleLarge,
            )
        },
        modifier = modifier,
        windowInsets = WindowInsets(0.dp, topPadding, 0.dp, 0.dp),
        scrollBehavior = scrollBehavior,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
private fun HomeTopBarPreview() {
    KmpSampleAndroidTheme {
        HomeTopBar(
            scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(),
        )
    }
}
