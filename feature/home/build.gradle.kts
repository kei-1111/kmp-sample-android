plugins {
    alias(libs.plugins.kmp.sample.android.feature)
}

android {
    namespace = "io.github.kei_1111.kmp_sample_android.feature.home"

    defaultConfig {
        buildConfigField("String", "DRAWABLE_PATH", "\"${projectDir}/src/main/res/drawable\"")
    }

    buildFeatures.buildConfig = true
}

dependencies {
    implementation(libs.coil.compose)
    implementation(libs.coil.network)
    implementation(libs.kmp.sample.library.home)
}