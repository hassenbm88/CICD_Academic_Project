#FROM maven:3.8.2-jdk-8

#WORKDIR /spring-app
#COPY . .
#RUN mvn clean install

#CMD mvn spring-boot:run



#FROM openjdk:8

#EXPOSE 8091
#WORKDIR /app

#COPY target/spring-app.jar /app/spring-app.jar

#COPY src/main/resources/application.properties /app

#ENTRYPOINT ["java","-jar","spring-app.jar", "-Dspring.config.location=", "/app/application.properties"]


FROM openjdk:8

#EXPOSE 8091
WORKDIR /app

COPY target/tpAchatProject-1.0.jar /app/tpAchatProject-1.0.jar

COPY src/main/resources/application.properties /app

ENTRYPOINT ["java","-jar","tpAchatProject-1.0.jar", "-Dspring.config.location=", "/app/application.properties"]