package com.dsofttech.dprefs.domanin // ktlint-disable filename

import com.dsofttech.dprefs.enums.DPrefsDefaultValue
import com.dsofttech.dprefs.utils.DPrefs
import com.dsofttech.dprefs.utils.exceptions.DPrefsException
import com.dsofttech.dprefs.utils.exceptions.DPrefsKeyAlreadyExistsException
import com.dsofttech.dprefs.utils.exceptions.DPrefsNotInitializedException

/**
 * An interface that defines all the contracts that can be performed by this preferences library
 *
 * @author Adebayo Oloyede
 *
 * @since 1.0.0 <br /> (June, 2023)
 *
 * [Github](https://github.com/D-Soft-Tech/DPrefs)
 *
 * [LinkedIn](https://www.linkedin.com/in/adebayo-oloyede/ "Adebayo Oloyede, Android Engineer")
 * */
internal interface DPrefsManagerContract {
    /**
     * Saves a preference value of type [String]
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     * ``` kt
     * val stringToSave = "The string you want to save"
     * val stringKey = "STRING_VALUE_KEY
     * DPrefs.putString(stringKey, stringToSave)
     * ```
     *
     * <b><em>Sample Usage ``Java``</em></b>
     * ``` java
     * String stringToSave = "The string you want to save";
     * String key = "STRING_VALUE_KEY;
     * DPrefs.INSTANCE.putString(key, stringToSave);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getString] method call
     * @param [value] This is the exact preference that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putString(key: String, value: String)

    /**
     * Saves a preference value of type [Int]
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     * ``` kt
     * val intToSave = 507
     * val key = "INT_VALUE_KEY"
     * DPrefs.putInt(key, intToSave)
     * ```
     *
     * <b><em>Sample Usage ``Java``</em></b>
     * ``` java
     * int intToSave = 507;
     * String key = "INT_VALUE_KEY";
     * DPrefs.INSTANCE.putInt(key, intToSave);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getInt] method call
     * @param [value] This is the ``int`` that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putInt(key: String, value: Int)

    /**
     * Saves a preference value of type [Boolean]
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     * ``` kt
     * val booleanToSave = true
     * val key = "BOOLEAN_VALUE_KEY"
     * DPrefs.putBoolean(key, booleanToSave)
     * ```
     *
     * <b><em>Sample Usage ``Java``</em></b>
     * ``` java
     * boolean booleanToSave = true;
     * String key = "BOOLEAN_VALUE_KEY";
     * DPrefs.INSTANCE.putBoolean(key, booleanToSave);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value will be saved. this is also what should be used to retrieve the saved value from preference by passing it to [getBoolean] method call
     * @param [value] This is the ``boolean`` value that you want to save into preference.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putBoolean(key: String, value: Boolean)

    /**
     * Saves a preference value of type [Float]
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     * ``` kt
     * val floatToSave = 10.03F
     * val key = "FLOAT_VALUE_KEY"
     * DPrefs.putFloat(key, floatToSave)
     * ```
     *
     * <br />
     *
     * <b><em>Sample Usage ``Java``</em></b>
     * ``` java
     * float floatToSave = 10.03f;
     * String key = "FLOAT_VALUE_KEY";
     * DPrefs.INSTANCE.putFloat(key, floatToSave);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getFloat] method call
     * @param [value] This is the exact ``float`` value that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putFloat(key: String, value: Float)

    /**
     * Saves a preference value of type [Long]
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     * ``` kt
     * val longToSave = 150L
     * val key = "LONG_VALUE_KEY"
     * DPrefs.putLong(key, longToSave)
     * ```
     *
     * <b><em>Sample Usage ``Java``</em></b>
     * ``` java
     * long longToSave = 150l;
     * String key = "LONG_VALUE_KEY";
     * DPrefs.INSTANCE.putLong(key, longToSave);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getLong] method call
     * @param [value] This is the ``Long`` value that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putLong(key: String, value: Long)

    /**
     * Saves a preference value of type [Double]
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     * ``` kt
     * val doubleToSave = 123.03
     * val key = "DOUBLE_VALUE_KEY"
     * DPrefs.putDouble(key, doubleToSave)
     * ```
     *
     * <b><em>Sample Usage ``Java``</em></b>
     * ``` java
     * double doubleToSave = 123.03;
     * String key = "DOUBLE_VALUE_KEY";
     * DPrefs.INSTANCE.putDouble(key, doubleToSave);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getDouble] method call
     * @param [value] This is the exact Double value that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putDouble(key: String, value: Double)

    /**
     * Save an object as a preference
     *
     * <br />
     *
     * <b><em>Sample Usage</em></b>
     *
     * ``` json
     {
     "firstName": "Adebayo",
     "lastName": "Oloyede",
     "age": 31,
     "address": "Oyo state, Nigeria",
     "latitude": 3.3456987,
     "longitude": 7.432765,
     "isLoggedIn": true
     }
     ```

     > The ``UserInfo`` data class can be modelled from the above ``json`` payload. like so:
     ``` kt
     // UserInfo Model
     data class UserInfo(
     val firstName: String,
     val lastName: String,
     val age: Int,
     val address: String,
     val latitude: Double,
     val longitude: Double,
     val isLoggedIn: Boolean
     )
     ```
     *
     * <br />
     *
     * <b><em>Sample Usage ``Kotlin``</em></b>
     ``` kt
     // Instantiate an object of UserInfo
     val userA = UserInfo("Adebayo", "Oloyede", 31, "Oyo state, Nigeria", 3.3456987, 7.432765, true)

     // save userA as preference
     val objectKey = "OBJECT_VALUE_KEY"

     DPrefs.putObject(objectKey, userA)
     ```
     *
     * <br />
     *
     * <b><em>Sample Usage ``Java``</em></b>
     *
     * ``` java
     * // Instantiate an object of UserInfo
     * UserInfo userA = new UserInfo("Adebayo", "Oloyede", 31, "Oyo state, Nigeria", 3.3456987, 7.432765, true);
     *
     * // save userA as preference
     * String objectKey = "OBJECT_VALUE_KEY";
     * DPrefs.INSTANCE.putObject(objectKey, userA);
     * ```
     *
     * @param [key] This is the uniqueId with which the object [value] will be saved, this is also what the saved object will be accessed by from preference by passing it to [getObject] method call
     * @param [value] This is the object that you want to save into preference.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun <T> putObject(key: String, value: T)

    /**
     * Retrieves a preference value of type [String] that had previously been saved into preferences
     *
     * <br />
     *
     * <b>Sample Usage Kotlin</b>
     *
     * ``` kt
     * val key = "STRING_VALUE_KEY"
     * val defaultValue = "DefaultString"
     * val savedString: String = DPrefs.getString(key, defaultValue)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage Java</b>
     *
     * ``` java
     * String key = "STRING_VALUE_KEY";
     * String defaultValue = "DefaultString";
     * String savedString = DPrefs.INSTANCE.getString(key, defaultValue);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value was saved by the [putString] method
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return [String] which is the saved value, if the value does not exist in preferences it returns [defaultValue] passed to it or [DEFAULT_VALUE_STRING][DPrefsDefaultValue.DEFAULT_VALUE_STRING] if [defaultValue] is not set.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun getString(
        key: String,
        defaultValue: String = DPrefsDefaultValue.DEFAULT_VALUE_STRING.value as String,
    ): String

    /**
     * Retrieves a preference value of type [Int] that had previously been saved into preferences
     *
     * <br />
     *
     * <b>Sample Usage Kotlin</b>
     *
     * ``` kt
     * val key = "INT_VALUE_KEY"
     * val defaultValue = 10
     * val savedInt = DPrefs.getInt(key, defaultValue)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage Java</b>
     *
     * ``` java
     * String key = "INT_VALUE_KEY";
     * int defaultValue = 10;
     * int savedInt = DPrefs.INSTANCE.getInt(key, defaultValue);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value was saved by [putInt]
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return [Int] which is the saved value , if the value does not exist in preferences it returns [defaultValue] passed to it or empty string i.e [DEFAULT_VALUE_INT][DPrefsDefaultValue.DEFAULT_VALUE_INT] if [defaultValue] is not set.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun getInt(
        key: String,
        defaultValue: Int = DPrefsDefaultValue.DEFAULT_VALUE_INT.value as Int,
    ): Int

    /**
     * Retrieves a preference value of type [Boolean] that had previously been saved into preferences
     *
     * <br />
     *
     * <b>Sample Usage Kotlin</b>
     *
     * ``` kt
     * val key = "BOOLEAN_VALUE_KEY"
     * val defaultValue = false
     * val savedBoolean = DPrefs.getBoolean(key, defaultValue)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage Java</b>
     *
     * ``` java
     * String key = "BOOLEAN_VALUE_KEY";
     * boolean defaultValue = false;
     * boolean savedBoolean = DPrefs.INSTANCE.getBoolean(key, defaultValue);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value was saved by [putBoolean]
     * @param [defaultValue] A [Boolean] that will be returned in the event that no preference value exists for the provided [key]
     * @return [Boolean] which is the saved value , if the value does not exist in preferences it returns [defaultValue] or [DEFAULT_VALUE_BOOLEAN][DPrefsDefaultValue.DEFAULT_VALUE_BOOLEAN] if [defaultValue] is not set.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun getBoolean(
        key: String,
        defaultValue: Boolean = DPrefsDefaultValue.DEFAULT_VALUE_BOOLEAN.value as Boolean,
    ): Boolean

    /**
     * Retrieves a preference value of type [Float] that had previously been saved into preferences
     *
     *
     *
     * <br />
     *
     * <b>Sample Usage ``Kotlin``</b>
     *
     * ``` kt
     * val key = "FLOAT_VALUE_KEY"
     * val defaultValue = 10.03F
     * val savedFloat = DPrefs.getFloat(key, defaultValue)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage ``Java``</b>
     *
     * ``` java
     * String key = "FLOAT_VALUE_KEY";
     * float defaultValue = 10.03f;
     * float savedFloat = DPrefs.INSTANCE.getFloat(key, defaultValue);
     * ```
     *
     *
     * @param [key] This is the uniqueId with which the preference value was saved by calling [putFloat] method
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return A [Float] which is the saved value, if the value does not exist in preferences it returns [defaultValue] passed to it or [DEFAULT_VALUE_FLOAT][DPrefsDefaultValue.DEFAULT_VALUE_FLOAT] if [defaultValue] is not set.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun getFloat(
        key: String,
        defaultValue: Float? = DPrefsDefaultValue.DEFAULT_VALUE_FLOAT.value as Float,
    ): Float

    /**
     * Retrieves a preference value of type [Long] that had previously been saved into preferences
     *
     *
     * <br />
     *
     * <b>Sample Usage ``Kotlin``</b>
     *
     * ``` kt
     * val key = "LONG_VALUE_KEY"
     * val defaultValue = 150L
     * val savedLong = DPrefs.getLong(key, defaultValue)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage ``Java``</b>
     *
     * ``` java
     * String key = "LONG_VALUE_KEY";
     * Long defaultValue = 150L;
     * Long savedLong = DPrefs.INSTANCE.getLong(key, defaultValue);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value was saved by calling [putLong] method
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return A [Long] which is the saved value, if the value does not exist in preferences it returns the [defaultValue] or [DEFAULT_VALUE_LONG][DPrefsDefaultValue.DEFAULT_VALUE_LONG] if [defaultValue] is not set.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun getLong(
        key: String,
        defaultValue: Long = DPrefsDefaultValue.DEFAULT_VALUE_LONG.value as Long,
    ): Long

    /**
     * Retrieves a preference value of type [Double] that had previously been saved into preferences
     *
     * <br />
     *
     * <b>Sample Usage ``Kotlin``</b>
     *
     * ``` kt
     * val key = "DOUBLE_VALUE_KEY"
     * val defaultValue = 10.45
     * val savedDouble = DPrefs.getDouble(key, defaultValue)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage ``Java``</b>
     *
     * ``` java
     * String key = "DOUBLE_VALUE_KEY";
     * DOUBLE defaultValue = 10.45;
     * DOUBLE savedDouble = DPrefs.INSTANCE.getDouble(key, defaultValue);
     * ```
     *
     * @param [key] This is the uniqueId with which the preference value was saved by calling [putDouble] method
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return A [Double] which is the saved value, if the value does not exist in preferences it returns the [defaultValue] or [DEFAULT_VALUE_DOUBLE][DPrefsDefaultValue.DEFAULT_VALUE_DOUBLE] if [defaultValue] is not set.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun getDouble(
        key: String,
        defaultValue: Double = DPrefsDefaultValue.DEFAULT_VALUE_DOUBLE.value as Double,
    ): Double

    /**
     * Retrieves an object from preferences.
     *
     * <br />
     *
     * <b>Sample Usage ``Kotlin``</b>
     *
     * ``` kt
     * val key = "OBJECT_VALUE_KEY"
     * val savedObject = DPrefs.getObject(key, UserInfo::class)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage ``Java``</b>
     *
     * ``` java
     * String key = "OBJECT_VALUE_KEY";
     * UserInfo savedObject = DPrefs.INSTANCE.getObject(key, UserInfo.class);
     * ```
     *
     * @param [key] The key with which you want to get the object from the preferences. <br />
     * Note. This is also the key with which the object was saved.
     * @param [type] This is the type of the object you want to retrieve from the preferences.
     * Note. This is also the type you must have saved initially.
     * @return An object of type [T] which was saved or null if no value exists for the [key]
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * @see [putObject]
     * */
    fun <T> getObject(key: String, type: T): Any?

    /**
     * Removes a preference value.
     *
     * <br />
     *
     * <b>Sample Usage ``Kotlin``</b>
     *
     * ``` kt
     * val key = "STRING_VALUE_KEY"
     * DPrefs.removePref(key)
     * ```
     *
     * <br />
     *
     * <b>Sample Usage ``Java``</b>
     *
     * ``` java
     * String key = "STRING_VALUE_KEY";
     * DPrefs.INSTANCE.removePref(key);
     * ```
     *
     *
     * Removes a preference value that had previously been saved into preferences.
     *
     * Note, the preference value that you are targeting to remove by this can be of any type
     * @param [key] This is the uniqueId with which the preference value was saved
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun removePref(key: String)

    /**
     * Clears the whole preferences.
     *
     * <br />
     *
     * <b>Sample Usage ``Kotlin``</b>
     *
     * ``` kt
     * DPrefs.clearAllPrefs()
     * ```
     *
     * <br />
     *
     * <b>Sample Usage ``Java``</b>
     *
     * ``` java
     * DPrefs.INSTANCE.clearAllPrefs();
     * ```
     *
     * This is synonymous to dropping or deleting a complete table in sql database. Use with caution.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @see [DPrefs.initializeDPrefs]
     * */
    fun clearAllPrefs()

    /**
     * Checks if the key exists before in preference
     *
     * @param [key] The key to be checked
     * @return true if the key already exists or false if not
     * */
    fun doesKeyExists(key: String): Boolean = false
}