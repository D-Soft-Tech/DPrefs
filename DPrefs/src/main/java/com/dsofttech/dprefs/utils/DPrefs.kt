package com.dsofttech.dprefs.utils

import android.content.Context
import com.dsofttech.dprefs.domanin.DPrefsManager
import com.dsofttech.dprefs.domanin.DPrefsManagerContract
import com.dsofttech.dprefs.utils.exceptions.DPrefsKeyAlreadyExistsException
import com.dsofttech.dprefs.utils.exceptions.DPrefsNotInitializedException

/**
 * Creates and exposes an instance of [DPrefsManagerContract]
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 * @see [https://www.linkedin.com/in/adebayo-oloyede]
 * @see [https://github.com/D-Soft-Tech]
 * */
object DPrefs : DPrefsManagerContract {
    /**
     * An instance of [DPrefsManagerContract]
     * */
    private lateinit var dPrefs: DPrefsManagerContract

    /**
     * Creates the instance of [DPrefsManager]
     *
     * Call this in the onCreate callback method of the application class and pass it the applicationContext
     *
     * @param [context] specifies the scope i.e the [Context] in which the instance of [DPrefs] is available in the project. Use the Application Context
     * */
    fun initializeDPrefs(context: Context) {
        dPrefs = DPrefsManager(context)
    }

    override fun putString(key: String, value: String) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putString(key, value)
    }

    override fun putInt(key: String, value: Int) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putInt(key, value)
    }

    override fun putBoolean(key: String, value: Boolean) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putBoolean(key, value)
    }

    override fun putFloat(key: String, value: Float) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putFloat(key, value)
    }

    override fun putLong(key: String, value: Long) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putLong(key, value)
    }

    override fun putDouble(key: String, value: Double) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putDouble(key, value)
    }

    override fun <T> putObject(key: String, value: T) {
        isDPrefsInitializedAndDoesKeyNotExist(key)
        dPrefs.putObject(key, value)
    }

    override fun getString(key: String, defaultValue: String): String =
        dPrefs.getString(key, defaultValue)

    override fun getInt(key: String, defaultValue: Int): Int =
        dPrefs.getInt(key, defaultValue)

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        dPrefs.getBoolean(key, defaultValue)

    override fun getFloat(key: String, defaultValue: Float?): Float =
        dPrefs.getFloat(key, defaultValue)

    override fun getLong(key: String, defaultValue: Long): Long =
        dPrefs.getLong(key, defaultValue)

    override fun getDouble(key: String, defaultValue: Double): Double =
        dPrefs.getDouble(key, defaultValue)

    override fun <T> getObject(key: String, type: T): T? =
        dPrefs.getObject(key, type)

    override fun removePref(key: String) {
        dPrefs.removePref(key)
    }

    override fun clearAllPrefs() {
        dPrefs.clearAllPrefs()
    }

    /**
     * Checks if the library has been initialized and if the supplied [key] does not exist in preference before
     * @param [key] The name with which the preference value is to be saved.
     * @throws [DPrefsNotInitializedException]
     * @throws [DPrefsKeyAlreadyExistsException]
     * */
    private fun isDPrefsInitializedAndDoesKeyNotExist(key: String) {
        if (!this::dPrefs.isInitialized) {
            throw DPrefsNotInitializedException()
        }
        if (dPrefs.doesKeyExists(key)) {
            throw DPrefsKeyAlreadyExistsException()
        }
    }
}
