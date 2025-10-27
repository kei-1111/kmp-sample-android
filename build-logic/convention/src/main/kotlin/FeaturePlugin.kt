import io.github.kei_1111.kmp_sample_android.implementation
import io.github.kei_1111.kmp_sample_android.library
import io.github.kei_1111.kmp_sample_android.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.dependencies

class FeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "kmp.sample.android.library.compose")

            dependencies {
                implementation(project(":core:designsystem"))

                implementation(libs.library("androidx.material3"))
                implementation(libs.library("koin.compose.viewmodel"))
            }
        }
    }
}