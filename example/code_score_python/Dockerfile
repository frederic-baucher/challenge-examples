FROM python:3.8-slim
WORKDIR /
COPY src src
COPY run.sh /
RUN chmod +x run.sh
RUN pip install --extra-index-url http://nexus.takima.io/repository/pypi-internal/simple --trusted-host nexus.takima.io deadlock-mission-client
ENTRYPOINT ["/run.sh"]
