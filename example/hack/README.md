# What the sample contains
This sample contains a full implementation of a hacking challenge.

The sample challenge is about **sql injection**.

We have a web application giving access in read mode to a list of cats and giving the possibility to add comments on each cats.
You can access to a html view of these cats through the following url: /index.html
All the statics resources are under (app/src/main/resources/static)
The server uses SpringBoot, with spring-boot-starter-web and spring-boot-starter-jdbc.
The database is a H2 in memory database. (see (app/pom.xml))
It uses JDBCTemplate for executing queries, but there is a security breach with the one responsible for adding a comment to cat.
This query is built manually instead of using JDBCTemplate prepared statement solution, which makes it vulnerable to SQL injection attack.
The goal of this challenge is to use this breach to remove all cats from the database.
If the database is indeed empty after adding a comment, a token is sent back to the user (see #CatService.addCatComment).  
The program has to read it under /tmp/token.
The user will have to enter it in the deadlock interface.

There is one Docker container per user, means one token per container.

# Check-list
0. Set a beautifil thumbnail.png image for your challenge.
1. Write a web application which can be hacked. You can use other stack than java/maven but you'll have to adapt the Dockerfile
1. Modify your app to return the content of the file (/tmp/deadlock/token/tokens) when the user has succeeded the hacking challenge
3. Update the success files provided to the candidate when the mission will be solved.
4. Change the **challenge.yaml** descriptor to match your challenge settings: url, description, xp, label, etc.
5. Update the docs **briefing**, **hint1**, and **hint2**. You can also provide translation under **fr/** for instance.


# Test your challenge with [Dcli](https://github.com/deadlock-resources/dcli):
```bash
#example/hack/ > dcli run
```

