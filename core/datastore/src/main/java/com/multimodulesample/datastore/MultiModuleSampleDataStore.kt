package com.multimodulesample.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.mutablePreferencesOf
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

private const val PREFERENCES_NAME = "MultiModuleSample_User_Preference"

private val Context.dataStore by preferencesDataStore(
    name = PREFERENCES_NAME,
    /** Added corruption handler for crashlytics issue
     * Known issue: https://issuetracker.google.com/issues/256784635
     * Known issue: https://issuetracker.google.com/issues/354699421
     * BugId: 277034
     * */
    corruptionHandler = ReplaceFileCorruptionHandler {
        mutablePreferencesOf(

        )
    }
)

class MultiModuleSampleDataStore(context: Context) : IAppPreferences {

    private val dataStore: DataStore<Preferences> = context.dataStore


    override var isUserOnBoarded by PreferenceDataStore(
        dataStore = dataStore,
        key = booleanPreferencesKey(name = "IS_USER_ON_BOARDED"),
        defaultValue = false
    )

    override var userCountryCode by PreferenceDataStore(
        dataStore = dataStore,
        key = stringPreferencesKey(name = "USER_COUNTRY_CODE"),
        defaultValue = ""
    )

    override var userPhoneNumber by PreferenceDataStore(
        dataStore = dataStore,
        key = stringPreferencesKey(name = "USER_PHONE_NUMBER"),
        defaultValue = ""
    )


}