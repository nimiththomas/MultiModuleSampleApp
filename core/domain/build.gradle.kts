plugins {
    alias(libs.plugins.multimodulesample.android.library)
    alias(libs.plugins.multimodulesample.android.hilt)
}

android {
    namespace = "com.multimodulesample.domain"
}

dependencies {
    api(project(":core:data"))

}