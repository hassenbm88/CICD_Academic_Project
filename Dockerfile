#FROM maven as build

#WORKDIR /spring-app
#COPY . .
#RUN mvn clean install

#FROM openjdk:11.0
#WORKDIR /spring-app
#COPY --from=build /spring-app/target/Uber.jar /spring-app/
#EXPOSE 9090
#CMD ["java","-jar","Uber.jar"]
#CMD mvn spring-boot:run
FROM openjdk:11
EXPOSE 8082
ADD target/devops_cicd.jar devops_cicd.jar
ENTRYPOINT ["java","-jar","devops_cicd.jar"]