const Logger = require('./logger');
const success = require('../success/fibonacci');
const template = require('../template/fibonacci');

/**
 * Method executed when user click on `Submit` button.
 * It must test if the user has reach or not the solution
 * with many tests.
 * Also have to exit(1) if something is wrong
 * And exit(0) if everything was fine.
 */
function solve() {
    const min = 0, max = 20;

    try {
        // Simple tests to verify user entry.
        for (let n = min; n < max; n++) {
            const userValue = template.process(n);
            const expectedValue = success.process(n);

            Logger.logTest(userValue, n);

            if (userValue !== expectedValue) {
                Logger.logFail(expectedValue, userValue, n);
                process.exit(1);
            }
        }
        // all test passed successfully
        Logger.logSuccess();
    } catch (exception) {
        Logger.logException(exception);
        process.exit(1);
    }
}

solve();