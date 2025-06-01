package com.picker.common

import android.content.Context
import android.content.Intent
import android.content.Intent.CATEGORY_DEFAULT
import android.content.Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS
import android.content.Intent.FLAG_ACTIVITY_NEW_TASK
import android.content.Intent.FLAG_ACTIVITY_NO_HISTORY
import android.net.Uri
import android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.PermissionState
import com.google.accompanist.permissions.isGranted
import com.google.accompanist.permissions.shouldShowRationale


object Utils {


    @OptIn(ExperimentalPermissionsApi::class)
    fun askPermission(
        permissionState: PermissionState,
        showRationale: () -> Unit,
        onLocationGranted: () -> Unit
    ) {
        if (permissionState.status.shouldShowRationale) {
            showRationale()
        } else if (permissionState.status.isGranted) {
            onLocationGranted()
        } else {
            permissionState.launchPermissionRequest()
        }
    }


    fun navigateToAppSettings(context: Context) {
        val intent = Intent(ACTION_APPLICATION_DETAILS_SETTINGS)
        with(intent) {
            data = Uri.fromParts("package", context.packageName, null)
            addCategory(CATEGORY_DEFAULT)
            addFlags(FLAG_ACTIVITY_NEW_TASK)
            addFlags(FLAG_ACTIVITY_NO_HISTORY)
            addFlags(FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        }
        context.startActivity(intent)

    }

}