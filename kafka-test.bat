@echo off
set KAFKA_CONTAINER=code-quarkus-irham-kafka-1

echo Sending message to Kafka input-topic...

echo {"userId":"u01","action":"login","timestamp":"2025-07-01T10:00:00Z"} | docker exec -i %KAFKA_CONTAINER% kafka-console-producer --broker-list localhost:9092 --topic input-topic

echo {"userId":"u02","action":"logout","timestamp":"2025-07-01T11:00:00Z"} | docker exec -i %KAFKA_CONTAINER% kafka-console-producer --broker-list localhost:9092 --topic input-topic

echo ✅ Done!
pause
