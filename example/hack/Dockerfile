FROM maven:3.6.3-jdk-11
WORKDIR /
COPY app/ /usr/src/app/
WORKDIR /usr/src/app
# Tokens will be stored here
RUN mkdir tokens
# Compile sources
RUN mvn clean install
# Move running jar in the parent folder
RUN mv target/hack-sql-injection.jar .
# Compile side-project sources
CMD ["./start.sh"]