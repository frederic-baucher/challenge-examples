const Logger = require('./logger');
const Fibonacci = require('../template/fibonacci');

/**
 * Method executed when user click on `Run` button.
 */
function run() {
    try {
        Fibonacci.main();
    } catch (exception) {
        Logger.logException(exception);
    }
}

run();