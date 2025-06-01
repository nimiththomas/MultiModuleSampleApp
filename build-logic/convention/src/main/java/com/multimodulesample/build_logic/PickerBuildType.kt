package com.multimodulesample.build_logic

enum class PickerBuildType(val applicationIdSuffix: String? = null) {
    //    DEBUG(".debug"),   commented for now as package name without debug is configured in firebase
    DEBUG,
    RELEASE
}
