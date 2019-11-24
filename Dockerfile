FROM alpine/git AS git
WORKDIR /home/aplikacja/reciever
RUN git clone https://github.com/LED1990/MQreceiver.git

FROM maven:3.6.0-jdk-8-slim AS build
WORKDIR /home/aplikacja/reciever
COPY --from=git /home/aplikacja/reciever/MQreceiver/src /home/aplikacja/reciever/src
COPY --from=git /home/aplikacja/reciever/MQreceiver/pom.xml /home/aplikacja/reciever
RUN mvn -f /home/aplikacja/reciever/pom.xml clean install

FROM openjdk:8-jre-alpine
WORKDIR /home/aplikacja/reciever
COPY --from=build /home/aplikacja/reciever/target/MqSender-spring-boot.jar /home/aplikacja/reciever
EXPOSE 9092
ENTRYPOINT ["java", "-jar","MqReciever-spring-boot.jar"]
