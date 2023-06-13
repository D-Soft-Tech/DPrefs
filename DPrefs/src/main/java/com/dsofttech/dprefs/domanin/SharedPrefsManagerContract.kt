package com.dsofttech.dprefs.domanin // ktlint-disable filename

import com.dsofttech.dprefs.models.enums.DPrefsDefaultValue

/**
 * An interface that defines all the contracts that can be performed by this preferences library
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 *
 * @see [LinkedinProfile](https://www.linkedin.com/in/adebayo-oloyede/ "Adebayo Oloyede")
 * @see [GitHubProfile](https://github.com/D-Soft-Tech)
 * */
interface DPrefsSharedPrefsManagerContract {
    /**
     * Saves a preference value of type String
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getString] method call
     * @param [value] This is the exact preference that you want to save into preferences
     * */
    fun putString(key: String, value: String)

    /**
     * Saves a preference value of type Int
     *
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to [getInt] method call
     * @param [value] This is the exact preference that you want to save into preferences
     * */
    fun putInt(key: String, value: Int)

    /**
     * Saves a preference value of type boolean
     *
     * @param [key] This is the uniqueId with which the preference value will be saved. this is also what should be used to retrieve the saved value from preference by passing it to [getBoolean] method call
     * @param [value] This is the boolean value that you want to save into preference
     * */
    fun putBoolean(key: String, value: Boolean)

    /**
     * Retrieves a preference value of type [String] that had previously been saved into preferences
     *
     * @param [key] This is the uniqueId with which the preference value was saved by the [putString] method
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return [String] which is the saved value, if the value does not exist in preferences it returns [defaultValue] passed to it or empty string if [defaultValue] is not set.
     * */
    fun getString(
        key: String,
        defaultValue: String = DPrefsDefaultValue.DEFAULT_VALUE_STRING.value,
    ): String

    /**
     * Retrieves a preference value of type [Int] that had previously been saved into preferences
     *
     * @param [key] This is the uniqueId with which the preference value was saved by [putInt]
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * @return [Int] which is the saved value , if the value does not exist in preferences it returns [defaultValue] passed to it or empty string i.e [DPrefsDefaultValue.DEFAULT_VALUE_INT.code] if [defaultValue] is not set.
     * */
    fun getInt(key: String, defaultValue: Int = DPrefsDefaultValue.DEFAULT_VALUE_INT.code): Int

    /**
     * Retrieves a preference value of type [Boolean] that had previously been saved into preferences
     *
     * @param [key] This is the uniqueId with which the preference value was saved by [putBoolean]
     * @param [defaultValue] A nullable [Boolean] that will be returned in the event that no preference value exists for the provided [key]
     * @return [Boolean] which is the saved value , if the value does not exist in preferences it returns [defaultValue] passed to it or null if [defaultValue] is not set.
     * */
    fun getBoolean(key: String, defaultValue: Boolean? = null): Boolean?

    /**
     * Save an object as a preference
     *
     * @param [key] This is the uniqueId with which the object [value] will be saved, this is also what the saved object will be accessed by from preference by passing it to [getObject] method call
     * @param [value] This is the object that you want to save into preference
     * */
    fun <T> putObject(key: String, value: T)

    /**
     * Retrieves an object from preferences.
     *
     * @param [key] The key with which you want to get the object from the preferences. <br />
     * Note. This is also the key with which the object was saved.
     * @param [type] This is the type of the object you want to retrieve from the preferences. <br />
     * Note. This is also the type you must have saved initially.
     * @return An object of type [T] which was saved or null if no value exists for the [key]
     * @see [putObject]
     * */
    fun <T> getObject(key: String, type: T): T?

    /**
     * Removes a preference value.
     *
     * Removes a preference value that had previously been saved into preferences.
     * Note, the preference value that you are targeting to remove by this can be of any type
     * @param [key] This is the uniqueId with which the preference value was saved
     * */
    fun removePref(key: String)

    /**
     * Clears the whole preferences.
     *
     * This is synonymous to dropping or deleting a complete table in sql database. Use with caution.
     * */
    fun clearAllPrefs()
}
