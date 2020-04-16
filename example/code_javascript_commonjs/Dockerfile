FROM node:13-alpine
WORKDIR /
COPY src src
COPY run.sh /
RUN chmod +x run.sh
ENTRYPOINT ["sh", "/run.sh"]
