FROM openjdk:8-jdk-slim
WORKDIR /
COPY src src
COPY run.sh /
ARG CLIENT_VERSION=1.0.6
ADD http://nexus.takima.io/service/rest/v1/search/assets/download?maven.groupId=io.deadlock&maven.artifactId=deadlock-mission-client&version=${CLIENT_VERSION}&maven.extension=jar&maven.classifier src/main/java/deadlock-mission-client.jar
RUN chmod +x run.sh
ENTRYPOINT ["/run.sh"]
