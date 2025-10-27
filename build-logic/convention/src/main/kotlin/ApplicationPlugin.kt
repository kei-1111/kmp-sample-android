import com.android.build.api.dsl.ApplicationExtension
import io.github.kei_1111.kmp_sample_android.configureAndroidCompose
import io.github.kei_1111.kmp_sample_android.configureKotlinAndroid
import io.github.kei_1111.kmp_sample_android.libs
import io.github.kei_1111.kmp_sample_android.versions
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class ApplicationPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            apply(plugin = "com.android.application")
            apply(plugin = "org.jetbrains.kotlin.android")

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                configureAndroidCompose(this)
                defaultConfig.targetSdk = libs.versions("targetSdk").toInt()
            }
        }
    }
}