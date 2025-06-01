plugins {
    alias(libs.plugins.multimodulesample.android.library)
    alias(libs.plugins.multimodulesample.android.hilt)
}


android {
    namespace = "com.multimodulesample.data"
}

dependencies {
    api(project(":core:network"))
    implementation(project(":core:datastore"))
}