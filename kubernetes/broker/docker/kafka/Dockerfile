FROM python:alpine

ENV KAFKA_VERSION 2.8.0
ENV SCALA_VERSION 2.13

RUN apk add --no-cache --virtual=.build-dependencies wget ca-certificates && \
    apk add --no-cache bash curl openssh openjdk8-jre

RUN wget -q https://dlcdn.apache.org/kafka/${KAFKA_VERSION}/kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz

RUN tar -zxvf kafka_${SCALA_VERSION}-${KAFKA_VERSION}.tgz -C /usr/local && \
    ln -s /usr/local/kafka_${SCALA_VERSION}-${KAFKA_VERSION} /usr/local/kafka

COPY startup.sh /usr/local/kafka/bin

RUN chmod 755 /usr/local/kafka/bin/startup.sh

EXPOSE 9092

ENTRYPOINT ["/usr/local/kafka/bin/startup.sh"]

