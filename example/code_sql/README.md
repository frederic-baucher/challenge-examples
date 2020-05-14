# What the sample contains
This sample contains a full implementation of a small sql challenge.

The sample challenge is about **implementing inner join**.

When the candidate will click on `Run` it will execute the request he has submitted.
When the candidate will click on `Submit` it will execute the request he has submitted and compare it with the result of the execution of the request in success folder.

The first one should only run the candidate code, while the second one will verify if the candidat has the correct answer, comparing the success result to the template result mostly.


# Check-list
0. Set a beautifil thumbnail.png image for your challenge.
1. Modify the sample code in the **service/db/entries** to create the schema and fill your tables with initial data
2. Update the template files within the **template** folder which will be sent to your candidates as a codebase
3. Update the success files provided to the candidate when the mission will be solved.
4. Change the **challenge.yaml** descriptor to match your challenge settings: description, xp, label, etc.
5. Changes the target in **challenge.yaml** and the properties in **app/src/main/resources/db.properties** to match with the sql success and template filename.
6. Update the docs **briefing**, **hint1**, and **hint2**. You can also provide translation under **fr/** for instance.


# Test your challenge with [Dcli](https://github.com/deadlock-resources/dcli):
```bash
#examples/code_sql/ > dcli run
#examples/code_sql/ > dcli solve
```

