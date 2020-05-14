FROM maven:3.6-jdk-11-slim
WORKDIR /
COPY app/ /app/
COPY run.sh /
COPY services/db/wait-for-it.sh /
RUN chmod +x run.sh
RUN chmod +x wait-for-it.sh
WORKDIR /app
RUN mvn clean compile assembly:single
VOLUME "mavenRepo:/root/.m2"
WORKDIR /
COPY success success
COPY template template

ENTRYPOINT ["./run.sh"]