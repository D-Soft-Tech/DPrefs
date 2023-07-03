package com.dsofttech.dprefs.utils

import com.dsofttech.dprefs.data.TestObject

internal object Utils {

    fun getSampleObject(): TestObject =
        TestObject("Adebayo Oloyede", "1234", 32, true)

    fun getSampleObject2(): TestObject =
        TestObject("John Smith", "5678", 30, false)
}
