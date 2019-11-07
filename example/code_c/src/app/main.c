#include <stdio.h>
#include <string.h>
#include "Target.h"
#include "Logger.h"


int success_fibonacci(int n) {
    if (n == 1 || n == 0) {
        return 1;
    } else {
        return success_fibonacci(n - 1) + success_fibonacci(n - 2);
    }
}


int main(int argc, char *argv[]) {
    // user result
    if (strcmp(argv[1], "Solve") == 0) {
        // User clicked on `Submit` button, we must verify it code.
        printf("Running tests..\n");
        // Simple tests to verify user entry.
        for (int n = 0; n < 20; n++) {
            int expected = success_fibonacci(n);
            int userResult = fibonacci(n);
            log_test(userResult, n);
            if (expected != userResult) {
                log_no_match(expected);
                return 1;
            }
        }
        log_success();
    } else {
        // User clicked on `Run` button
        printf("Running main method..\n");
        run();
    }

    return 0;
}