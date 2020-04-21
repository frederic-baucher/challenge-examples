import { Logger } from './logger.mjs';
import { Fibonacci } from '../template/fibonacci.mjs';

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