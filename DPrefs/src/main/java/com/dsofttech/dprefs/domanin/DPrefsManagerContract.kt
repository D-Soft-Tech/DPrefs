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
 * @since 1.0.0 <br /> (June, 2023)
 *
 * @see [https://www.linkedin.com/in/adebayo-oloyede/]
 * @see [https://github.com/D-Soft-Tech]
 * */
internal interface DPrefsManagerContract {
    /**
     * Saves a preference value of type [String]
     *
     * <br />
     *
     * <b><em>Sample Usage</em></b>
     * ```
     * val stringToSave = "The string you want to save"
     * val stringKey = "STRING_KEY
     * DPrefs.putString(stringKey, stringToSave)
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
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getInt] method call
     * @param [value] This is the exact string value that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putInt(key: String, value: Int)

    /**
     * Saves a preference value of type [Boolean]
     *
     * @param [key] This is the uniqueId with which the preference value will be saved. this is also what should be used to retrieve the saved value from preference by passing it to [getBoolean] method call
     * @param [value] This is the boolean value that you want to save into preference.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putBoolean(key: String, value: Boolean)

    /**
     * Saves a preference value of type [Float]
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getFloat] method call
     * @param [value] This is the exact float value that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putFloat(key: String, value: Float)

    /**
     * Saves a preference value of type [Long]
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getLong] method call
     * @param [value] This is the exact Long value that you want to save into preferences.
     * @throws [DPrefsNotInitializedException] if the library has not been initialized.
     * @throws [DPrefsKeyAlreadyExistsException] if the key already exists in preferences.
     * @see [DPrefs.initializeDPrefs]
     * @see [DPrefsException]
     * */
    fun putLong(key: String, value: Long)

    /**
     * Saves a preference value of type [Double]
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
