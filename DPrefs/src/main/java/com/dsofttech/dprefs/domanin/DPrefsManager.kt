package com.dsofttech.dprefs.domanin

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys
import com.dsofttech.dprefs.enums.DPrefsDefaultValue
import com.dsofttech.dprefs.utils.DPrefsConstants.D_PREFS_FILE_NAME
import com.google.gson.Gson

/**
 * An instance of [DPrefsManagerContract].
 * And provides implementation details for all it's contracts
 *
 * @author Adebayo Oloyede
 * @param [context] from [Context], provides the context in which this class should be available. Always provide application context if possible.
 *
 * @since 1.0.0 <br /> (June, 2023)
 *
 * [Github](https://github.com/D-Soft-Tech/DPrefs)
 *
 * [LinkedIn](https://www.linkedin.com/in/adebayo-oloyede)
 *
 * */
internal class DPrefsManager(private val context: Context) : DPrefsManagerContract {
    /**
     * From [SharedPreferences] and Handles all the shared preferences transactions
     * */
    private val dSharedPrefs: SharedPreferences

    /**
     * From [Gson] and handles object serialization and deserialization
     * */
    private val gson: Gson = Gson()

    init {
        dSharedPrefs = getEncryptedSharedPrefs(context)
    }

    override fun putString(key: String, value: String) {
        dSharedPrefs.edit().putString(key, value).apply()
    }

    override fun putInt(key: String, value: Int) {
        dSharedPrefs.edit().putInt(key, value).apply()
    }

    override fun putBoolean(key: String, value: Boolean) {
        dSharedPrefs.edit().putBoolean(key, value).apply()
    }

    override fun putFloat(key: String, value: Float) {
        dSharedPrefs.edit().putFloat(key, value).apply()
    }

    override fun putLong(key: String, value: Long) {
        dSharedPrefs.edit().putLong(key, value).apply()
    }

    override fun putDouble(key: String, value: Double) {
        dSharedPrefs.edit().putString(key, value.toString()).apply()
    }

    override fun getString(key: String, defaultValue: String): String =
        dSharedPrefs.getString(key, defaultValue)
            ?: DPrefsDefaultValue.DEFAULT_VALUE_STRING.value as String

    override fun getInt(key: String, defaultValue: Int): Int =
        dSharedPrefs.getInt(key, defaultValue)

    override fun getBoolean(key: String, defaultValue: Boolean): Boolean =
        dSharedPrefs.getBoolean(key, defaultValue)

    override fun getFloat(key: String, defaultValue: Float?): Float =
        dSharedPrefs.getFloat(
            key,
            defaultValue ?: DPrefsDefaultValue.DEFAULT_VALUE_FLOAT.value as Float,
        )

    override fun getLong(key: String, defaultValue: Long): Long =
        dSharedPrefs.getLong(key, defaultValue)

    override fun getDouble(key: String, defaultValue: Double): Double {
        val stringDouble = dSharedPrefs.getString(key, defaultValue.toString())
        return stringDouble?.toDoubleOrNull()
            ?: DPrefsDefaultValue.DEFAULT_VALUE_DOUBLE.value as Double
    }

    override fun <T> putObject(key: String, value: T) {
        dSharedPrefs.edit().putString(key, gson.toJson(value)).apply()
    }

    override fun <T> getObject(key: String, type: T): Any? =
        getObject<Any>(key, dSharedPrefs, gson)

    override fun removePref(key: String) {
        dSharedPrefs.edit().remove(key).apply()
    }

    override fun clearAllPrefs() {
        dSharedPrefs.edit().clear().apply()
    }

    /**
     * [getObject] from [DPrefsManagerContract]
     *
     * @param [key] The key with which the object was saved, same as key in [DPrefsManagerContract.getObject]
     * @param [sharedPreferences] from [dSharedPrefs]
     * @param [T] the object that was saved
     * @see [DPrefsManagerContract.putObject]
     * */
    private inline fun <reified T> getObject(
        key: String,
        sharedPreferences: SharedPreferences,
        gson: Gson,
    ): T? =
        sharedPreferences.getString(key, DPrefsDefaultValue.DEFAULT_VALUE_STRING.value as String?)
            ?.let {
                gson.fromJson(it, T::class.java)
            }

    /**
     * Creates the preferences instance
     *
     * @param [context] specifies the scope in the application where this instance should be available. Pass it the applicationContext.
     * @return [SharedPreferences] The preference object that is created
     * */
    private fun getEncryptedSharedPrefs(context: Context): SharedPreferences {
        val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
        return EncryptedSharedPreferences.create(
            D_PREFS_FILE_NAME,
            masterKeyAlias,
            context,
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM,
        )
    }

    override fun doesKeyExists(key: String): Boolean =
        dSharedPrefs.contains(key)
}
