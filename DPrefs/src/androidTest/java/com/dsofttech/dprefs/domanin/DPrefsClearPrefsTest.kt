package com.dsofttech.dprefs.domanin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.dsofttech.dprefs.enums.DPrefsDefaultValue
import com.dsofttech.dprefs.utils.DPrefs
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class DPrefsClearPrefsTest {
    /**
     * Initialize DPrefs Library
     * */
    private lateinit var context: Context
    private lateinit var dPrefs: DPrefsManagerContract

    /**
     * VARIABLES
     * */
    private val stringKey: String = "StringKey"
    private val stringValue: String = "StringValue"
    private val libraryStringValue: String = DPrefsDefaultValue.DEFAULT_VALUE_STRING.value as String

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        dPrefs = DPrefs.apply {
            initializeDPrefs(context)
        }

        // Save a String Preference
        dPrefs.putString(stringKey, stringValue)
    }

    /***********************
     * TEST CASE
     ***********************/

    @Test
    fun afterAllPreferencesAreClearedB_attemptToRetrieveTheStringSavedPriorToClearingThePrefs_returnsLibraryDefaultStringValue() {
        dPrefs.clearAllPrefs()
        val result = dPrefs.getString(stringKey)
        assertThat(result).isEqualTo(libraryStringValue)
    }
}
