package io.github.kei_1111.kmp_sample_android.feature.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
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
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                AsyncImage(
                    model = marsProperty.imgSrc,
                    contentDescription = null,
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )

                Text(
                    text = marsProperty.type.name,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .background(
                            color = MaterialTheme.colorScheme.primaryContainer,
                            shape = RoundedCornerShape(
                                topStart = 0.dp,
                                topEnd = 0.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 0.dp,
                            )
                        )
                        .padding(horizontal = 16.dp)
                        .padding(vertical = 4.dp),
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .padding(vertical = 8.dp),
            ) {
                Text(
                    text = NumberFormat.getCurrencyInstance(Locale.US).format(marsProperty.price),
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
        ),
        modifier = Modifier.width(150.dp)
    )
}