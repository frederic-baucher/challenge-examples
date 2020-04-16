#include <iostream>
#include "Target.h"
#include "Logger.h"
#include <cstring>

using namespace std;


int success_fibonacci(int n) {
    if (n == 1 || n == 0) {
        return n;
    } else {
        return success_fibonacci(n - 1) + success_fibonacci(n - 2);
    }
}


int main(int argc, char *argv[]) {
    try {
        // user result
        Target target = Target();

        if (strcmp(argv[1], "Solve") == 0) {
            // User clicked on `Submit` button, we must verify it code.

            cout << "Running tests.." << endl;
            // Simple tests to verify user entry.
            for (int n = 0; n < 20; n++) {
                int expected = success_fibonacci(n);
                int userResult = target.fibonacci(n);

                Logger::log(userResult, n);
                if (expected != userResult) {
                    Logger::log_no_match(expected);
                    return 1;
                }
            }
            Logger::log_success();
        } else {
            // User clicked on `Run` button
            cout << "Running main method.." << endl;
            target.main();
        }
    } catch (const std::exception& e) {
        Logger::log_exception(e);
        return 1;
    }
    return 0;
}