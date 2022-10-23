FROM openjdk:slim
COPY target/tpAchatProject-1.0.0-SNAPSHOT.jar spring-app.jar
ENTRYPOINT ["java","-jar","/spring-app.jar"]
