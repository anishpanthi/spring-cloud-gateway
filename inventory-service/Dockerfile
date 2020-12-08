FROM openjdk:15.0.1-jdk-oraclelinux8
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} inventory-service.jar
ENTRYPOINT ["java","-jar","/inventory-service.jar"]
