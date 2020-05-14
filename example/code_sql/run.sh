#!/bin/bash
set -e
echo "Initializing DB..."
./wait-for-it.sh db:5432 -t 120 -q && echo "Ready" && java -jar app/target/app-0.1.0-jar-with-dependencies.jar $1
