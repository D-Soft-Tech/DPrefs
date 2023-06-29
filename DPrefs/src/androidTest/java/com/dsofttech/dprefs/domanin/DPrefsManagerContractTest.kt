package com.dsofttech.dprefs.domanin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.dsofttech.dprefs.utils.Utils
import com.google.common.truth.Truth.assertThat
import org.junit.AfterClass
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class DPrefsManagerContractTest {
    private lateinit var context: Context
    private lateinit var dPrefsManager: DPrefsManager

    /**
     * DEFAULT VALUES SET BY THE CALLER
     * */
    private val DEFAULT_STRING_VALUE = "DEFAULT_STRING_VALUE"
    private val DEFAULT_INT_VALUE = "DEFAULT_INT_VALUE"
    private val DEFAULT_FLOAT_VALUE = "DEFAULT_FLOAT_VALUE"
    private val DEFAULT_DOUBLE_VALUE = "DEFAULT_DOUBLE_VALUE"
    private val DEFAULT_LONG_VALUE = "DEFAULT_LONG_VALUE"
    private val DEFAULT_BOOLEAN_VALUE = "DEFAULT_BOOLEAN_VALUE"

    /**
     * DEFAULT VALUES RETURNED BY THE LIBRARY
     * */
    private val LIBRARY_DEFAULT_STRING_VALUE = ""
    private val LIBRARY_DEFAULT_INT_VALUE = -1111111
    private val LIBRARY_DEFAULT_FLOAT_VALUE = -0.1000001F
    private val LIBRARY_DEFAULT_DOUBLE_VALUE = -0.1000001
    private val LIBRARY_DEFAULT_LONG_VALUE = -1111111L
    private val LIBRARY_DEFAULT_BOOLEAN_VALUE = false

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        dPrefsManager = DPrefsManager(context)
    }

    companion object {
        private val context: Context = ApplicationProvider.getApplicationContext()
        private val dPrefsManager = DPrefsManager(context)

        /**
         * KEYS TO BE USED FOR SAVING VALUES INTO PREFERENCES
         * */
        private const val STRING_KEY = "STRING_KEY"
        private const val INT_KEY = "INT_KEY"
        private const val FLOAT_KEY = "FLOAT_KEY"
        private const val DOUBLE_KEY = "DOUBLE_KEY"
        private const val LONG_KEY = "LONG_KEY"
        private const val BOOLEAN_KEY = "BOOLEAN_KEY"
        private const val OBJECT_KEY = "OBJECT_KEY"

        /******************
         * VALUES TO BE SAVED
         ******************/
        private const val STRING_VALUE = "This is a string"
        private const val INT_VALUE = 125
        private const val FLOAT_VALUE = 100.55F
        private const val DOUBLE_VALUE = 123.03
        private const val LONG_VALUE = 150L
        private const val BOOLEAN_VALUE = true
        private val OBJECT_VALUE = Utils.getSampleObject()

        @BeforeClass
        @JvmStatic
        fun setUpBeforeClass() {
            // dPrefsManager.putString(STRING_KEY, STRING_VALUE)
            dPrefsManager.putInt(INT_KEY, INT_VALUE)
            dPrefsManager.putFloat(FLOAT_KEY, FLOAT_VALUE)
            dPrefsManager.putDouble(DOUBLE_KEY, DOUBLE_VALUE)
            dPrefsManager.putLong(LONG_KEY, LONG_VALUE)
            dPrefsManager.putBoolean(BOOLEAN_KEY, BOOLEAN_VALUE)
            dPrefsManager.putObject(OBJECT_KEY, OBJECT_VALUE)
        }

        @AfterClass
        @JvmStatic
        fun tearDown() {
            dPrefsManager.clearAllPrefs()
        }
    }

    /***********************
     * GET STRINGS
     ***********************/
    @Test
    fun valueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsTheExpectedDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getString(key) == LIBRARY_DEFAULT_STRING_VALUE
        assertThat(result).isTrue()
    }

    @Test
    fun valueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getString(key, DEFAULT_STRING_VALUE) == DEFAULT_STRING_VALUE
        assertThat(result).isTrue()
    }

    @Test
    fun whenValueExistsForKey_returnsSavedString() {
        val key = STRING_KEY
        val result = dPrefsManager.getString(key) == DEFAULT_STRING_VALUE
        assertThat(result).isTrue()
    }
}
