package com.dsofttech.dprefs.enums

/**
 * Provides default values for DPrefsManager return values
 *
 * @author Adebayo Oloyede
 * @since 1.0.0 <br /> (June, 2023)
 * @param [value] This is the default value that a particular [DPrefsDefaultValue] provides
 * @see [https://www.linkedin.com/in/adebayo-oloyede]
 * @see [https://github.com/D-Soft-Tech]
 * */
enum class DPrefsDefaultValue(val value: Any) {
    /**
     * Provides `""`, i.e empty [String]
     * */
    DEFAULT_VALUE_STRING(""),

    /**
     * Provides "-1111111" as the default [Int] value
     * */
    DEFAULT_VALUE_INT(-1111111),

    /**
     * Provides "false" as the default [Boolean] value
     * */
    DEFAULT_VALUE_BOOLEAN(false),

    /**
     * Provides "-0.1000001F" as the default [Float] value
     * */
    DEFAULT_VALUE_FLOAT(-0.1000001F),

    /**
     * Provides "-1111111L" as the default [Long] value
     * */
    DEFAULT_VALUE_LONG(-1111111L),

    /**
     * Provides "-0.1000001" as the default [Double] value
     * */
    DEFAULT_VALUE_DOUBLE(-0.1000001),
}
