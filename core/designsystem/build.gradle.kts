plugins {
    alias(libs.plugins.kmp.sample.android.library.compose)
}

android {
    namespace = "io.github.kei_1111.kmp_sample_android.core.designsystem"
}

dependencies {
    implementation(libs.androidx.material3)
}