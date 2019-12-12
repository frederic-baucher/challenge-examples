package app

class Logger {
    companion object {
        fun logCurrentTest(received: Long, n: Long): Unit =
            System.err.println("> fibonacci($n) = $received")

        fun logNoMatch(expected: Long): Unit =
                System.err.println("""
                    ----------------------------------------------------
                    The result does not match the expected value: $expected
                    ----------------------------------------------------
                """.trimIndent())

        fun logException(exception: Exception): Unit =
                System.err.println("""
                    ----------------------------------------------------
                    An error occurred during runtime.
                    Details:
                    ${exception.message}
                """.trimIndent())

        fun logException(throwable: Throwable): Unit {
            System.err.println("""
                    ----------------------------------------------------
                    Something bad happened!
                    ${throwable.message}
                """.trimIndent())
            throwable.printStackTrace()
            System.err.println("----------------------------------------------------")
        }

        fun logSuccess(): Unit =
                println("""
                    Everything went well, good job!
                    ----------------------------------------------------
                """.trimIndent())
    }
}
