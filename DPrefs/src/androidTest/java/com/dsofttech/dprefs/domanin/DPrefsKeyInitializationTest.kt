package com.dsofttech.dprefs.domanin

import com.dsofttech.dprefs.utils.DPrefs
import com.dsofttech.dprefs.utils.exceptions.DPrefsNotInitializedException
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Test

class DPrefsKeyInitializationTest {
    /**
     * dPrefs is initialized without calling .initializeDPrefs()
     * */
    private val dPrefs: DPrefsManagerContract = DPrefs

    /***********************
     * KEY INITIALIZATION TEST CASE
     ***********************/

    @Test
    fun prefsHasNotBeenInitializedBeforeAttemptingToUseIt_throwsDPrefsNotInitializedException() {
        val key = "Key"
        val value = "RandomString"
        val exception = assertThrows(DPrefsNotInitializedException::class.java) {
            dPrefs.putString(key, value)
        }
        assertEquals(DPrefsNotInitializedException().message, exception.message)
    }
}
