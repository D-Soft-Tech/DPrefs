package com.dsofttech.dprefs.exampleTests

import com.dsofttech.dprefs.exampleTests.SampleFuncForTest.checkBraces
import com.google.common.truth.Truth.assertThat
import org.junit.Test

class SampleFuncForTestTest {
    /***********************************
     * Check Braces Test cases
     ***********************************/
    @Test
    fun `extra opening brace precedes string returns false`() {
        val input = "((a + b)"
        val result = checkBraces(input)
        assertThat(result).isFalse()
    }

    @Test
    fun `extra closing brace ends string returns false`() {
        val input = "((a + b)))"
        val result = checkBraces(input)
        assertThat(result).isFalse()
    }

    @Test
    fun `extra brace within string returns false`() {
        val input = "(a ) b)"
        val result = checkBraces(input)
        assertThat(result).isFalse()
    }

    @Test
    fun `no extra brace returns true`() {
        val input = "(a ) b)"
        val result = checkBraces(input)
        assertThat(result).isFalse()
    }

    /***********************************
     * Fibonacci Test cases
     ***********************************/
}
