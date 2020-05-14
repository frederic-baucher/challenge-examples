FROM postgres:10-alpine

COPY entries /docker-entrypoint-initdb.d

ENV POSTGRES_PASSWORD=no-passwd
ENV PGDATA /var/lib/postgresql/datap-in-image
RUN mkdir -p "$PGDATA" && chown -R postgres:postgres "$PGDATA" && chmod 777 "$PGDATA" # this 777 will be replaced by 700 at runtime (allows semi-arbitrary "--user" values)

#Dissect the upstream Dockerfile and its docker-entrypoint.sh as explained in details here (https://stackoverflow.com/questions/54992342/populating-postgres-docker-image-during-building-not-running)
RUN set -x \
  && cp ./docker-entrypoint.sh ./docker-entrypoint-init-only.sh \
  && sed -ri '/exec "\$@"/d' ./docker-entrypoint-init-only.sh \
  && ./docker-entrypoint-init-only.sh postgres \
  && rm ./docker-entrypoint-initdb.d/*.sql ./docker-entrypoint-init-only.sh