#!/bin/sh
set -e
echo "Compiling java code"
cd src/main/java/
javac -Xmaxerrs 1 -classpath "./jar/*:." $(find ./* | grep \\.java)
echo "Executing code"
java -Xms32m -Xmx64m -classpath "./jar/*:." app/$1
echo "Done"
