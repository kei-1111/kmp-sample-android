package io.github.kei_1111.kmp_sample_android.feature.home.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.github.kei_1111.kmp_sample_library.core.model.MarsProperty
import io.github.kei_1111.kmp_sample_library.core.model.PropertyType
import java.text.NumberFormat
import java.util.Locale

@Composable
fun MarsPropertyCard(
    marsProperty: MarsProperty,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier.wrapContentSize(),
    ) {
        Column {
            AsyncImage(
                model = marsProperty.imgSrc,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Crop
            )
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp),
            ) {
                val formattedPrice = NumberFormat.getCurrencyInstance(Locale.US).format(marsProperty.price)
                Text(
                    text = formattedPrice,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.labelLarge,
                )
            }
        }
    }
}

@Composable
@Preview
private fun MarsPropertyCardPreview() {
    MarsPropertyCard(
        marsProperty = MarsProperty(
            id = "424905",
            imgSrc = "https://mars.nasa.gov/msl-raw-images/proj/msl/redops/ods/surface/sol/03900/opgs/edr/fcam/FLB_645486870EDR_F0481570FHAZ00323M_.JPG",
            price = 450000,
            type = PropertyType.RENT,
        )
    )
}