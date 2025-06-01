plugins {
    alias(libs.plugins.multimodulesample.android.library.compose)
    alias(libs.plugins.multimodulesample.android.feature)
}

android {
    namespace = "com.multimodulesample.feature2"
}

dependencies {
    implementation(project(":core:domain"))
    implementation(project(":core:common"))
}