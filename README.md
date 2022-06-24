# kube-messaging
Demonstrating messaging on kubernetes

# Sequence of deployment:
1. zookeeper/kafka - via helm deployment
2. producer - This will create a new topic and wait for http request for a message to relay.
3. consumer - This will subscribe to the topic and wait for messages.  Once received, it prints to stdout.
4. load test - Optionally, to send a message manually - connect to a pod running in the namespace and execute:
```
curl -X POST http://producer:8080/kafka/publish -d message="This is a test"
```

If you have Istio or another service mesh installed, you should be able to visualize the traffic being published and retrieved from the Kafka broker.

![messaging-kafka-istio](https://user-images.githubusercontent.com/2113400/168189796-b03c2384-9551-4906-8460-be9b473d3e53.png)
