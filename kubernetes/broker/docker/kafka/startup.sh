#!/bin/bash

# Replace the hostname with current IP address in server.properties.
CURRENT_IP=$(hostname -i)
sed -i "s/#advertised.listeners=PLAINTEXT:\/\/your.host.name/advertised.listeners=PLAINTEXT:\/\/$CURRENT_IP/g" /usr/local/kafka/config/server.properties

# Replace zookeeper hostname with service

ZOOKEEPER_SERVICE="zookeeper"
ZOOKEEPER_PORT="2181"
sed -i "s/zookeeper.connect=localhost:2181/zookeeper.connect=$ZOOKEEPER_SERVICE:$ZOOKEEPER_PORT/g" /usr/local/kafka/config/server.properties

# Start up Kafka
/usr/local/kafka/bin/kafka-server-start.sh /usr/local/kafka/config/server.properties
