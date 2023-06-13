package com.dsofttech.dprefs.domanin

import android.content.Context

class DPrefs(private val context: Context) : DPrefsSharedPrefsManagerContract {
    override fun putString(key: String, value: String) {
        TODO("Not yet implemented")
    }

    override fun putInt(key: String, value: Int) {
        TODO("Not yet implemented")
    }

    override fun putBoolean(key: String, value: Boolean) {
        TODO("Not yet implemented")
    }

    override fun getString(key: String, defaultValue: String): String {
        TODO("Not yet implemented")
    }

    override fun getInt(key: String, defaultValue: Int): Int {
        TODO("Not yet implemented")
    }

    override fun getBoolean(key: String, defaultValue: Boolean?): Boolean? {
        TODO("Not yet implemented")
    }

    override fun <T> putObject(key: String, value: T) {
        TODO("Not yet implemented")
    }

    override fun <T> getObject(key: String, type: T): T? {
        TODO("Not yet implemented")
    }

    override fun removePref(key: String) {
        TODO("Not yet implemented")
    }

    override fun clearAllPrefs() {
        TODO("Not yet implemented")
    }
}
