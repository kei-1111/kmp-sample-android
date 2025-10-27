import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "io.github.kei_1111.kmp_sample_android.build_logic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradle)
    compileOnly(libs.kotlin.gradle)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = libs.plugins.kmp.sample.android.android.application.get().pluginId
            implementationClass = "AndroidApplicationPlugin"
        }

        register("androidLibrary") {
            id = libs.plugins.kmp.sample.android.android.library.asProvider().get().pluginId
            implementationClass = "AndroidLibraryPlugin"
        }

        register("androidLibraryCompose") {
            id = libs.plugins.kmp.sample.android.android.library.compose.get().pluginId
            implementationClass = "AndroidLibraryComposePlugin"
        }
    }
}
