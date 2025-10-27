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
        register("application") {
            id = libs.plugins.kmp.sample.android.application.get().pluginId
            implementationClass = "ApplicationPlugin"
        }
        register("library") {
            id = libs.plugins.kmp.sample.android.library.asProvider().get().pluginId
            implementationClass = "LibraryPlugin"
        }
        register("libraryCompose") {
            id = libs.plugins.kmp.sample.android.library.compose.get().pluginId
            implementationClass = "LibraryComposePlugin"
        }
        register("feature") {
            id = libs.plugins.kmp.sample.android.feature.get().pluginId
            implementationClass = "FeaturePlugin"
        }
    }
}
