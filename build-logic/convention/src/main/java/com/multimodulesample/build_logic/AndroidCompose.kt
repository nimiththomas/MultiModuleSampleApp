package com.multimodulesample.build_logic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
//        buildFeatures {
//            compose = true
//        }


        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            implementation(platform(bom))
            androidTestImplementation(platform(bom))
            implementation(libs.findLibrary("androidx.compose.material3").get())
            debugImplementation(libs.findLibrary("androidx-compose-ui-tooling").get())
            implementation(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
            implementation(libs.findLibrary("androidx-lifecycle-runtime-compose").get())
            implementation(libs.findLibrary("accompanist-permissions").get())
            add("implementation", libs.findLibrary("androidx.hilt.navigation.compose").get())
            implementation(libs.findLibrary("androidx-navigation-compose").get())
            implementation(libs.findLibrary("androidx-paging-runtime").get())
            implementation(libs.findLibrary("androidx-paging-compose").get())
        }
    }
}
