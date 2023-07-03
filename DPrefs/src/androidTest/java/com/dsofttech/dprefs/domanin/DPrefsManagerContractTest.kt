package com.dsofttech.dprefs.domanin

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.dsofttech.dprefs.data.TestObject
import com.dsofttech.dprefs.utils.DPrefs
import com.dsofttech.dprefs.utils.Utils.getSampleObject
import com.dsofttech.dprefs.utils.Utils.getSampleObject2
import com.dsofttech.dprefs.utils.exceptions.DPrefsKeyAlreadyExistsException
import com.google.common.truth.Truth.assertThat
import com.google.gson.Gson
import org.junit.AfterClass
import org.junit.Assert.*
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Test

class DPrefsManagerContractTest {

    /**
     * FOR SERIALIZING AND DE-SERIALIZING OBJECTS
     * */
    private lateinit var gson: Gson

    /**
     * DEFAULT VALUES SET BY THE CALLER
     * */
    private val defaultStringValue = "DEFAULT_STRING_VALUE"
    private val defaultIntValue = 970
    private val defaultFloatValue = 200.00F
    private val defaultDoubleValue = 700.965
    private val defaultLongValue = 500L
    private val defaultBooleanValue = true

    /**
     * DEFAULT VALUES RETURNED BY THE LIBRARY
     * */
    private val libraryDefaultStringValue = ""
    private val libraryDefaultIntValue = -1111111
    private val libraryDefaultFloatValue = -0.1000001F
    private val libraryDefaultDoubleValue = -0.1000001
    private val libraryDefaultLongValue = -1111111L
    private val libraryDefaultBooleanValue = false

    @Before
    fun setUp() {
        gson = Gson()
    }

    companion object {
        private val context: Context = ApplicationProvider.getApplicationContext()
        private val dPrefsManager: DPrefsManagerContract = DPrefs.apply {
            initializeDPrefs(context)
        }

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
        private const val DOES_KEY_EXIST_CORRECT_KEY = "DOES_KEY_EXIST_CORRECT_KEY"
        private const val DOES_KEY_EXIST_WRONG_KEY = "DOES_KEY_EXIST_WRONG_KEY"
        private const val REMOVE_PREFS_KEY_1 = "REMOVE_PREFS_KEY_1"
        private const val REMOVE_PREFS_KEY_2 = "REMOVE_PREFS_KEY_2"

        /******************
         * VALUES TO BE SAVED
         ******************/
        private const val STRING_VALUE = "This is a string"
        private const val INT_VALUE = 125
        private const val FLOAT_VALUE = 100.55F
        private const val DOUBLE_VALUE = 123.03
        private const val LONG_VALUE = 150L
        private const val BOOLEAN_VALUE = true
        private val OBJECT_VALUE = getSampleObject()
        private val OBJECT_VALUE_2 = getSampleObject2()
        private const val REMOVE_PREFS_VALUE_1 = "REMOVE_PREFS_VALUE_1"
        private const val REMOVE_PREFS_VALUE_2 = "REMOVE_PREFS_VALUE_2"

        @BeforeClass
        @JvmStatic
        fun setUpBeforeClass() {
            dPrefsManager.clearAllPrefs()
            dPrefsManager.putString(STRING_KEY, STRING_VALUE)
            dPrefsManager.putInt(INT_KEY, INT_VALUE)
            dPrefsManager.putFloat(FLOAT_KEY, FLOAT_VALUE)
            dPrefsManager.putDouble(DOUBLE_KEY, DOUBLE_VALUE)
            dPrefsManager.putLong(LONG_KEY, LONG_VALUE)
            dPrefsManager.putBoolean(BOOLEAN_KEY, BOOLEAN_VALUE)
            dPrefsManager.putObject(OBJECT_KEY, OBJECT_VALUE)
            dPrefsManager.putString(DOES_KEY_EXIST_CORRECT_KEY, "DOES_KEY_EXISTS_TEST_CASE")
            dPrefsManager.putString(REMOVE_PREFS_KEY_1, REMOVE_PREFS_VALUE_1)
            dPrefsManager.putString(REMOVE_PREFS_KEY_2, REMOVE_PREFS_VALUE_2)
        }

        @AfterClass
        @JvmStatic
        fun tearDownAfterClass() {
            dPrefsManager.clearAllPrefs()
        }
    }

    /***********************
     * STRINGS TEST CASES
     ***********************/
    @Test
    fun stringValueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsItsOwnDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getString(key) == libraryDefaultStringValue
        assertThat(result).isTrue()
    }

    @Test
    fun stringValueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValueThatWasSet() {
        val key = "key"
        val result =
            dPrefsManager.getString(key, defaultStringValue) == defaultStringValue
        assertThat(result).isTrue()
    }

    @Test
    fun attemptIsMadeToSaveNewStringValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = "NewValue"
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putString(STRING_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenStringValueExistsForKey_returnsSavedString() {
        val key = STRING_KEY
        val value = STRING_VALUE
        val result = dPrefsManager.getString(key)
        assertEquals(result, value)
    }

    /***********************
     * INT TEST
     ***********************/
    @Test
    fun intValueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsItsOwnDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getInt(key) == libraryDefaultIntValue
        assertThat(result).isTrue()
    }

    @Test
    fun intValueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValueThatWasSet() {
        val key = "key"
        val result =
            dPrefsManager.getInt(key, defaultIntValue) == defaultIntValue
        assertThat(result).isTrue()
    }

    @Test
    fun attemptIsMadeToSaveNewIntValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = 1000
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putInt(INT_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenIntValueExistsForKey_returnsSavedInt() {
        val key = INT_KEY
        val value = INT_VALUE
        val result = dPrefsManager.getInt(key)
        assertEquals(result, value)
    }

    /***********************
     * Long TEST
     ***********************/
    @Test
    fun longValueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsItsOwnDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getLong(key) == libraryDefaultLongValue
        assertThat(result).isTrue()
    }

    @Test
    fun longValueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValueThatWasSet() {
        val key = "key"
        val result =
            dPrefsManager.getLong(key, defaultLongValue) == defaultLongValue
        assertThat(result).isTrue()
    }

    @Test
    fun attemptIsMadeToSaveNewLongValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = 1000L
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putLong(LONG_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenLongValueExistsForKey_returnsSavedLong() {
        val key = LONG_KEY
        val value = LONG_VALUE
        val result = dPrefsManager.getLong(key)
        assertEquals(result, value)
    }

    /***********************
     * FLOAT TEST
     ***********************/
    @Test
    fun floatValueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsItsOwnDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getFloat(key) == libraryDefaultFloatValue
        assertThat(result).isTrue()
    }

    @Test
    fun floatValueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValueThatWasSet() {
        val key = "key"
        val result =
            dPrefsManager.getFloat(key, defaultFloatValue) == defaultFloatValue
        assertThat(result).isTrue()
    }

    @Test
    fun attemptIsMadeToSaveNewFloatValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = 10.99F
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putFloat(FLOAT_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenFloatValueExistsForKey_returnsSavedFloat() {
        val key = FLOAT_KEY
        val value = FLOAT_VALUE
        val result = dPrefsManager.getFloat(key)
        assertEquals(result, value)
    }

    /***********************
     * DOUBLE TEST
     ***********************/
    @Test
    fun doubleValueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsItsOwnDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getDouble(key) == libraryDefaultDoubleValue
        assertThat(result).isTrue()
    }

    @Test
    fun doubleValueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValueThatWasSet() {
        val key = "key"
        val result =
            dPrefsManager.getDouble(key, defaultDoubleValue) == defaultDoubleValue
        assertThat(result).isTrue()
    }

    @Test
    fun attemptIsMadeToSaveNewDoubleValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = 10.99
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putDouble(DOUBLE_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenDoubleValueExistsForKey_returnsSavedDouble() {
        val key = DOUBLE_KEY
        val value = DOUBLE_VALUE
        val result = dPrefsManager.getDouble(key)
        assertThat(result).isEqualTo(value)
    }

    /***********************
     * BOOLEAN TEST
     ***********************/
    @Test
    fun booleanValueDoesNotExistForKeyAndNoDefaultValueSet_theLibraryReturnsItsOwnDefaultValue() {
        val key = "key"
        val result = dPrefsManager.getBoolean(key) == libraryDefaultBooleanValue
        assertThat(result).isTrue()
    }

    @Test
    fun booleanValueDoesNotExistForKeyAndDefaultValueIsSet_theLibraryReturnsTheDefaultValueThatWasSet() {
        val key = "key"
        val result =
            dPrefsManager.getBoolean(key, defaultBooleanValue) == defaultBooleanValue
        assertThat(result).isTrue()
    }

    @Test
    fun attemptIsMadeToSaveNewBooleanValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = false
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putBoolean(BOOLEAN_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenBooleanValueExistsForKey_returnsSavedDouble() {
        val key = BOOLEAN_KEY
        val value = BOOLEAN_VALUE
        val result = dPrefsManager.getBoolean(key)
        assertEquals(result, value)
    }

    /***********************
     * OBJECT TEST
     ***********************/
    @Test
    fun objectValueDoesNotExistForKey_theLibraryReturnsNull() {
        val key = "key"
        val result = dPrefsManager.getObject(key, TestObject::class.java)
        assertThat(result).isNull()
    }

    @Test
    fun attemptIsMadeToSaveNewObjectValueWithAKeyThatAlreadyExists_throwsKeyAlreadyExistException() {
        val newValue = OBJECT_VALUE_2
        val dPrefsKeyAlreadyExistExceptionMessage =
            "Key already exist, kindly change the key to a new unique set of character string"
        val exception = assertThrows(DPrefsKeyAlreadyExistsException::class.java) {
            dPrefsManager.putObject(OBJECT_KEY, newValue)
        }
        assertEquals(dPrefsKeyAlreadyExistExceptionMessage, exception.message)
    }

    @Test
    fun whenValueExistsForKey_returnsTheSavedObject() {
        val key = OBJECT_KEY
        val value = OBJECT_VALUE
        val result = dPrefsManager.getObject(key, TestObject::class.java)
        assertEquals(result, value)
    }

    /******************
     * KEY TESTS
     *****************/

    @Test
    fun whenKeyExists_doesKeyExistsMethodCall_returnsTrue() {
        val result = dPrefsManager.doesKeyExists(DOES_KEY_EXIST_CORRECT_KEY)
        assertTrue(result)
    }

    @Test
    fun whenKeyDoesNotExist_doesKeyExistsMethodCall_returnsFalse() {
        val result = dPrefsManager.doesKeyExists(DOES_KEY_EXIST_WRONG_KEY)
        assertFalse(result)
    }

    @Test
    fun afterPreferenceHasBeenRemoved_doesKeyExistMethodCall_returnsFalse() {
        dPrefsManager.removePref(REMOVE_PREFS_KEY_1)
        val result = dPrefsManager.doesKeyExists(REMOVE_PREFS_KEY_1)
        assertFalse(result)
    }

    @Test
    fun afterPreferenceHasBeenRemoved_attemptToRetrieveThePreference_returnsDefaultValue() {
        dPrefsManager.removePref(REMOVE_PREFS_KEY_2)
        val result = dPrefsManager.getString(REMOVE_PREFS_KEY_2)
        assertThat(result).isEqualTo(libraryDefaultStringValue)
    }
}
