FROM maven:3.8.2-jdk-8

WORKDIR /spring-app
COPY . .
RUN mvn clean install

CMD mvn spring-boot:run

FROM openjdk:slim
COPY target/tpAchatProject-1.0.0-SNAPSHOT.jar spring-app.jar
ENTRYPOINT ["java","-jar","/spring-app.jar"]
