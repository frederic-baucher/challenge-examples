FROM registry.e-biz.fr/apuret/deadlock-public/ocaml:1.0
WORKDIR /
COPY src src
COPY run.sh /

RUN chmod +x run.sh
ENTRYPOINT ["/bin/sh", "/run.sh"]