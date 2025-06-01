plugins {
    alias(libs.plugins.multimodulesample.android.library)
    alias(libs.plugins.multimodulesample.android.library.compose)
}

android {
    namespace = "com.multimodulesample.uicomponents"
}

dependencies {
    api(project(":core:designsystem"))
}