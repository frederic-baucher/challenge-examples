# What the sample contains
This sample contains a full implementation of a small JavaScript challenge.

The sample challenge is about **implementing Fibonacci**.

When the candidate will click on `Run` the `src/app/Run.java` will be executed.
When the candidate will click on `Submit` the `src/app/Solve.java` will be executed.

The first one should only run the candidate code, while the second one will verify if the candidat has the correct answer, comparing the success result to the template result mostly.

# Specification used

To execute JavaScript code outside of a browser, challenges will be ran in **Node.js** docker image.
So, written codes must be **CommonJS**-compliant.

Additionally, this allows you to split your code in multiple files.
```javascript
// other.module.js
function log(message) {
    console.log(message);
}
module.exports = { log };

// main.js
const utils = require('./other.module');
utils.log('hello world');
```

# Check-list
0. Set a beautifil thumbnail.png image for your challenge.
1. Modify the sample code in the **src/** directory to implement your own challenge
2. Update the template files within the **src/template** which will be sent to your candidates as a codebase
3. Update the success files provided to the candidate when the mission will be solved.
4. Change the **challenge.yaml** descriptor to match your challenge settings: description, xp, label, etc.
5. Update the docs **briefing**, **hint1**, and **hint2**. You can also provide translation under **fr/** for instance.


# Test your challenge with [Dcli](https://github.com/deadlock-resources/dcli):
```bash
#examples/code_javascript_commonjs > dcli run
#examples/code_javascript_commonjs > dcli solve
```

