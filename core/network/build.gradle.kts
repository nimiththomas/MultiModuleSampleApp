plugins {
    alias(libs.plugins.multimodulesample.android.library)
    alias(libs.plugins.multimodulesample.android.hilt)
//    alias(libs.plugins.multimodulesample.android.firebase)
}
android {
    namespace = "com.multimodulesample.network"
}

dependencies {
    api(libs.okhttp)
    api(libs.okhttp.logging)
    api(libs.retrofit2.retrofit)
    api(libs.retrofit2.converter.gson)
}