FROM openjdk:8-jdk-alpine

RUN mkdir /tcw
WORKDIR /tcw

VOLUME [ "/tcw" ]

CMD ./gradlew bootRun