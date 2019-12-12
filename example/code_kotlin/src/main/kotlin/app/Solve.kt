package app

import template.Fibonacci
import kotlin.system.exitProcess

class Solve {
    companion object {
        fun main() {
            val min: Int = 0
            val max: Int = 20

            try {
                for (n in min until max) {
                    val userValue = Fibonacci.fibonacci(n.toLong())
                    val expectedValue = success.Fibonacci.fibonacci(n.toLong())
                    Logger.logCurrentTest(userValue, n.toLong())
                    if (expectedValue != userValue) {
                        Logger.logNoMatch(expectedValue)
                        exitProcess(1)
                    }
                }
            } catch(exception: RuntimeException) {
                Logger.logException(exception)
                exitProcess(1)
            }
        }
    }
}
