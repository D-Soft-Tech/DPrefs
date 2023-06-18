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
 *
 * [Linkedin Profile](https://www.linkedin.com/in/adebayo-oloyede)
 *
 * [Github Profile](https://www.github.com/D-Soft-Tech)
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
     * <b>Sample Usage </b>
     * ```
     *
     * class DPrefsTestApp : Application() {
     *      override fun onCreate() {
     *          super.onCreate()
     *          DPrefs.initializeDPrefs(applicationContext)
     *      }
     * }
     *
     * ```
     *
     * @param [context] specifies the scope i.e the [Context] in which the instance of [DPrefs] is available in the project.
     *
     * Use the Application Context
     *
     * @sample [com.dsofttech.dprefs].[DPrefsTestApp].[onCreate]
     * */
    fun initializeDPrefs(context: Context) {
        dPrefs = DPrefsManager(context)
    }

    override fun putString(key: String, value: String) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putString(key, value)
    }

    override fun putInt(key: String, value: Int) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putInt(key, value)
    }

    override fun putBoolean(key: String, value: Boolean) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putBoolean(key, value)
    }

    override fun putFloat(key: String, value: Float) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putFloat(key, value)
    }

    override fun putLong(key: String, value: Long) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putLong(key, value)
    }

    override fun putDouble(key: String, value: Double) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putDouble(key, value)
    }

    override fun <T> putObject(key: String, value: T) {
        isDPrefsInitialized()
        doesKeyNotExist(key)
        dPrefs.putObject(key, value)
    }

    override fun getString(key: String, defaultValue: String): String {
        isDPrefsInitialized()
        return dPrefs.getString(key, defaultValue)
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        isDPrefsInitialized()
        return dPrefs.getInt(key, defaultValue)
    }

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean {
        isDPrefsInitialized()
        return dPrefs.getBoolean(key, defaultValue)
    }

    override fun getFloat(key: String, defaultValue: Float?): Float {
        isDPrefsInitialized()
        return dPrefs.getFloat(key, defaultValue)
    }

    override fun getLong(key: String, defaultValue: Long): Long {
        isDPrefsInitialized()
        return dPrefs.getLong(key, defaultValue)
    }

    override fun getDouble(key: String, defaultValue: Double): Double {
        isDPrefsInitialized()
        return dPrefs.getDouble(key, defaultValue)
    }

    override fun <T> getObject(key: String, type: T): Any? {
        isDPrefsInitialized()
        return dPrefs.getObject(key, type)
    }

    override fun removePref(key: String) {
        isDPrefsInitialized()
        dPrefs.removePref(key)
    }

    override fun clearAllPrefs() {
        isDPrefsInitialized()
        dPrefs.clearAllPrefs()
    }

    /**
     * Checks if the library has been initialized before attempting to use it
     * @throws [DPrefsNotInitializedException]
     * */
    private fun isDPrefsInitialized() {
        if (!this::dPrefs.isInitialized) {
            throw DPrefsNotInitializedException()
        }
    }

    /**
     * Checks if the supplied [key] does not exist in preference before
     * @param [key] The name with which the preference value is to be saved.
     * @throws [DPrefsKeyAlreadyExistsException]
     * */
    private fun doesKeyNotExist(key: String) {
        if (dPrefs.doesKeyExists(key)) {
            throw DPrefsKeyAlreadyExistsException()
        }
    }
}
