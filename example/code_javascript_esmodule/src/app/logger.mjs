/**
 * Simple logger class
 * You can use it to log useful information for the user.
 */
export class Logger {

    static logTest(received, n) {
        console.log("----------------------------------------------------");
        console.log("> fibonacci(" + n + ") = " + received);
        console.log("----------------------------------------------------");
    }

    static logSuccess() {
        console.log("----------------------------------------------------");
        console.log("Everything went well!");
        console.log("----------------------------------------------------");
    }

    static logFail(expected, received, ...input) {
        const inputs = input.length ? "[" + input.join(",") + "]" : "";

        console.error("----------------------------------------------------");
        console.error("> fibonacci(" + inputs + ") = " + received);
        console.error("> Expected = " + expected);
        console.error("Received value is not correct.");
        console.error("Try again.");
    }

    static logException(exception) {
        console.error("----------------------------------------------------");
        console.error("An error occurred during runtime.");
        console.error(exception);
        console.error("----------------------------------------------------");
    }
}
