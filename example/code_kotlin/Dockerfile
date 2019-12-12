FROM zenika/kotlin:1.3-jdk11-slim
WORKDIR /
COPY src src
COPY run.sh /
RUN chmod u+x run.sh
ENTRYPOINT ["/run.sh"]
