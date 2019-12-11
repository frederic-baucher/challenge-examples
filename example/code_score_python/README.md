# Python Mission Score example
The following mission will return a specific score instead of just returning if the tests went well or not.
Within the `challenge.yaml` you can find the details about the score:  
```
  score:
    min: 0 # default min score, can be omitted
    minToValidate: 90
    max: 100 # default max score, can be omitted
```

Instead of exit the mission with a code you are able to give the result you want to assign to the user:
`Mission.done(score)` within `./src/main/python/Solve.py`.


# Check-list
0. Set a beautiful thumbnail.png image for your challenge.
1. Modify the sample code in the **src/** directory to implement your own challenge
2. Update the template files within the **src/main/java/template** which will be sent to your candidates as a codebase
3. Update the success files provided to the candidate when the mission will be solved.
4. Change the **challenge.yaml** descriptor to match your challenge settings: description, xp, label, etc.
5. Update the docs **briefing**, **hint1**, and **hint2**. You can also provide translation under **fr/** for instance.
