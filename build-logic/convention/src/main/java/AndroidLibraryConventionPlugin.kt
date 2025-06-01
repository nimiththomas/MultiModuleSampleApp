import com.android.build.gradle.LibraryExtension
import com.multimodulesample.build_logic.androidTestImplementation
import com.multimodulesample.build_logic.configureKotlinAndroid
import com.multimodulesample.build_logic.libs
import com.multimodulesample.build_logic.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34
            }

            dependencies {
                testImplementation(kotlin("test"))
                testImplementation(libs.findLibrary("junit").get())
                androidTestImplementation(libs.findLibrary("androidx-junit").get())
                androidTestImplementation(libs.findLibrary("androidx-espresso-core").get())
            }
        }
    }
}
