#include "Target.h"

// Executed when you Run your code
void Target::main() {
}

int Target::fibonacci(int n) {
    if (n == 1 || n == 0) {
        return 1;
    } else {
        return success_fibonacci(n - 1) + success_fibonacci(n - 2);
    }
}