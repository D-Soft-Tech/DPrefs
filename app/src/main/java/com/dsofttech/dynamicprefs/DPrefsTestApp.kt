package com.dsofttech.dynamicprefs

import android.app.Application
import DPrefs Instance.DPrefs

class DPrefsTestApp : Application() {
    override fun onCreate() {
        super.onCreate()
        DPrefs.initializeDPrefs(applicationContext)
    }
}
