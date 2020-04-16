package success

class Fibonacci {
    companion object {
        fun fibonacci(n: Long): Long =
                when (n) {
                    0L, 1L -> n
                    else -> fibonacci(n - 1) + fibonacci(n - 2)
                }
    }
}
