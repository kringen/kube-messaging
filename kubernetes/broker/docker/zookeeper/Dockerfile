FROM python:alpine

ENV ZOOKEEPER_VERSION 3.7.0
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64
ENV ZK_HOME /usr/local/zookeeper

RUN apk add --no-cache --virtual=.build-dependencies wget ca-certificates && \
    apk add --no-cache bash curl openssh openjdk8-jre

RUN wget -q https://dlcdn.apache.org/zookeeper/zookeeper-${ZOOKEEPER_VERSION}/apache-zookeeper-${ZOOKEEPER_VERSION}-bin.tar.gz

RUN tar -zxvf apache-zookeeper-${ZOOKEEPER_VERSION}-bin.tar.gz -C /usr/local && \
    mv /usr/local/apache-zookeeper-${ZOOKEEPER_VERSION}-bin/conf/zoo_sample.cfg /usr/local/apache-zookeeper-${ZOOKEEPER_VERSION}-bin/conf/zoo.cfg && \
    ln -s /usr/local/apache-zookeeper-${ZOOKEEPER_VERSION}-bin /usr/local/zookeeper

RUN mkdir -p $ZK_HOME/data

RUN sed  -i "s|/tmp/zookeeper|$ZK_HOME/data|g" $ZK_HOME/conf/zoo.cfg && \
    sed -i -r 's|#(log4j.appender.ROLLINGFILE.MaxBackupIndex.*)|\1|g' $ZK_HOME/conf/log4j.properties && \
    sed -i -r 's|#autopurge|autopurge|g' $ZK_HOME/conf/zoo.cfg

# 2181 : Client Port
# 2888 : Server Port
# 3888 : Leader Election Port
EXPOSE 2181 2888 3888

WORKDIR $ZK_HOME