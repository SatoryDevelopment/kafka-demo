### Kafka-demo

## Purpose of the demo
The idea of this demo is to setup 
a small spring boot application with 
an open REST endpoint to which you can
send a message to (ex. with Postman) and
then that message gets sent with Kafka Producer
and also received by Kafka Consumer in this app.

## Setup
1. Position yourself in terminal in "/support" path where docker-compose.yml is.
2. Run "docker-compose up -d".
3. Run the application.
4. Send a request with Postman or other sending services. 
URL: `localhost:8080/message/send`
HTTP method: `POST`
5. Check for messages in the application for successfully sent message.
