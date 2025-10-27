// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false

    // kmp-sample-android
    alias(libs.plugins.kmp.sample.android.android.application) apply false
    alias(libs.plugins.kmp.sample.android.android.library) apply false
    alias(libs.plugins.kmp.sample.android.android.library.compose) apply false
}