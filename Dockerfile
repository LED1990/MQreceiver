FROM alpine/git AS git
WORKDIR /home/aplikacja/reciever
RUN git clone https://github.com/LED1990/MQsender.git

EXPOSE 9092
ADD /target/activeMqReceiver-1.0-SNAPSHOT.jar mqReciever.jar
ENTRYPOINT ["java", "-jar", "mqSender.jar"]