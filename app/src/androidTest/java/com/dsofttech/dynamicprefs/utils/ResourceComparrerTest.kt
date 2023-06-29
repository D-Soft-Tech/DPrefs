package com.dsofttech.dynamicprefs.utils

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.dsofttech.dynamicprefs.R
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class ResourceComparrerTest {
    private lateinit var resourceComparrer: ResourceComparrer
    private lateinit var context: Context

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()
        resourceComparrer = ResourceComparrer()
    }

    @Test
    fun stringFromResourceIsSameAsInputString_returnsTrue() {
        val result = resourceComparrer.compareString(context, R.string.app_name, "DynamicPrefs")
        assertThat(result).isTrue()
    }

    @Test
    fun stringFromResourceIsDifferentFromInputString_returnsFalse() {
        val result = resourceComparrer.compareString(context, R.string.app_name, "Dynamic Prefs")
        assertThat(result).isFalse()
    }
}
