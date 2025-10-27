plugins {
    alias(libs.plugins.kmp.sample.android.application)
}

android {
    namespace = "io.github.kei_1111.kmp_sample_android"

    defaultConfig {
        applicationId = "io.github.kei_1111.kmp_sample_android"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(projects.core.designsystem)
    implementation(projects.feature.home)

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.material3)
    implementation(libs.kmp.sample.library.shared)
}