FROM openjdk:8-jdk-slim
WORKDIR /
COPY src src
# Add all dependency jars
ADD jar src/main/java/jar
COPY run.sh /
RUN chmod +x run.sh
ENTRYPOINT ["/run.sh"]