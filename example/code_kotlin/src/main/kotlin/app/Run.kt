package app

import template.Fibonacci

class Run {
    companion object {
        fun main() {
            try {
                Fibonacci.main()
            } catch (exception: RuntimeException) {
                Logger.logException(exception)
            }
        }
    }
}
