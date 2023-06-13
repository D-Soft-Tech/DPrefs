package com.dsofttech.dprefs.domanin // ktlint-disable filename

import com.dsofttech.dprefs.models.enums.DPrefsDefaultValue

/**
 * @author dsoftTech https://www.linkedin.com/in/adebayo-oloyede
 * @since 1.0.0 year 2023
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
     * @param [key] This is the uniqueId with which the preference value will be saved, this is also what should be used to retrieve the saved value from preference by passing it to getInt() method call
     * @param [value] This is the exact preference that you want to save into preferences
     * */
    fun putInt(key: String, value: Int)

    /**
     * Retrieves a preference value of type String that had previously been saved into preferences
     *
     * @param [key] This is the uniqueId with which the preference value was saved
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * */
    fun getString(
        key: String,
        defaultValue: String = DPrefsDefaultValue.DEFAULT_VALUE_STRING.value,
    ): String

    /**
     * Retrieves a preference value of type Int that had previously been saved into preferences
     *
     * @param [key] This is the uniqueId with which the preference value was saved
     * @param [defaultValue] This is the value that will be returned in the event that no preference value exists for the provided [key]
     * */
    fun getInt(key: String, defaultValue: Int = DPrefsDefaultValue.DEFAULT_VALUE_INT.code): Int

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
