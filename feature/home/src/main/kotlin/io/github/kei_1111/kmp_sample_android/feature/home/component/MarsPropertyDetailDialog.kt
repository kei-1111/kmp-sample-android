package io.github.kei_1111.kmp_sample_android.feature.home.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import coil3.compose.AsyncImage
import io.github.kei_1111.kmp_sample_android.core.designsystem.theme.KmpSampleAndroidTheme
import io.github.kei_1111.kmp_sample_android.feature.home.BuildConfig
import io.github.kei_1111.kmp_sample_library.core.model.MarsProperty
import io.github.kei_1111.kmp_sample_library.core.model.PropertyType
import java.text.NumberFormat
import java.util.Locale

@Composable
fun MarsPropertyDetailDialog(
    marsProperty: MarsProperty,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismiss
    ) {
        Surface(
            modifier = modifier,
            shape = MaterialTheme.shapes.medium,
            color = MaterialTheme.colorScheme.surface,
        ) {
            Column {
                AsyncImage(
                    model = marsProperty.imgSrc,
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.Fit
                )
                Column(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Column {
                        Text(
                            text = "ID",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            text = marsProperty.id,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }

                    Column {
                        Text(
                            text = "Price",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            text = NumberFormat.getCurrencyInstance(Locale.US)
                                .format(marsProperty.price),
                            style = MaterialTheme.typography.headlineMedium,
                            color = MaterialTheme.colorScheme.primary,
                        )
                    }

                    Column {
                        Text(
                            text = "Sale Type",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                        Text(
                            text = marsProperty.type.name,
                            style = MaterialTheme.typography.bodyLarge,
                            color = MaterialTheme.colorScheme.onSurface,
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview
private fun MarsPropertyDetailDialogPreview() {
    KmpSampleAndroidTheme {
        MarsPropertyDetailDialog(
            marsProperty = MarsProperty(
                id = "424905",
                price = 450000,
                type = PropertyType.RENT,
                imgSrc = "${BuildConfig.DRAWABLE_PATH}/img_mars_preview.jpg",
            ),
            onDismiss = {}
        )
    }
}