#!/bin/bash
set -e
echo "Compiling java code"
cd src/main/java
javac -Xmaxerrs 1 -classpath "./deadlock-mission-client.jar:." app/*.java
echo "Executing code"
java -Xms32m -Xmx64m -classpath "./deadlock-mission-client.jar:." app/$1
echo "Done"
