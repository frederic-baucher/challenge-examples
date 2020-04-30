#!/bin/sh
# Script runned before building Docker image

# Download all dependencies of the project to put them into the Docker image via Dockerfile
mvn -B dependency:copy-dependencies -DoutputDirectory=jar
