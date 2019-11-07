#include "Target.h"

void main() {
}

int fibonacci(int n) {
    if (n == 1 || n == 0) {
        return 1;
    } else {
        return success_fibonacci(n - 1) + success_fibonacci(n - 2);
    }
}