#!/bin/bash
set -e
echo "Compiling kotlin code"
cd src/main/kotlin
kotlinc app/*.kt template/*.kt success/*.kt -include-runtime -d Fibo.jar
echo "Executing code"
java -jar -Xms32m -Xmx64m Fibo.jar $1
echo "Done"
