plugins {
    alias(libs.plugins.multimodulesample.android.library)
    alias(libs.plugins.multimodulesample.android.hilt)
}

android {
    namespace = "com.multimodulesample.datastore"
}

dependencies {
    implementation(libs.androidx.datastore.preferences)
}