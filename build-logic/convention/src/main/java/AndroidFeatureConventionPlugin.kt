import com.multimodulesample.build_logic.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("multimodulesample.android.library")
                apply("multimodulesample.android.hilt")
                apply("org.jetbrains.kotlin.plugin.serialization")
            }

            dependencies {
                add("implementation", project(":core:uicomponents"))
                add("implementation", project(":core:designsystem"))

                // Define common dependencies for feature modules
                add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())

            }
        }
    }
}
