package com.dsofttech.dprefs.exampleTests

object SampleFuncForTest {

    /**
     * Returns the nth fibonacci number
     * They are defined like this:
     * fib(0) = 0
     * fib(1) = 1
     * fib(n) = fib(n - 2) + fib(n -1)
     * */
    fun fib(n: Int): Long {
        return 3L
    }

    /**
     * Checks if the braces are set correctly
     * e.g "( a * b ))" should return false
     * */
    fun checkBraces(str: String): Boolean {
        return str.count { it == '(' } == str.count { it == ')' }
    }
}