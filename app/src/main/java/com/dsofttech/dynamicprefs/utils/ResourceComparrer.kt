package com.dsofttech.dynamicprefs.utils

import android.content.Context
import androidx.annotation.StringRes

class ResourceComparrer {

    fun compareString(context: Context, @StringRes resId: Int, string: String): Boolean {
        return context.getString(resId) == string
    }
}
