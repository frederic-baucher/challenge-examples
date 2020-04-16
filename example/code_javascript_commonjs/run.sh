#!/bin/bash

set -e
echo "Executing code"
node "src/app/$1.js"
echo "Done"