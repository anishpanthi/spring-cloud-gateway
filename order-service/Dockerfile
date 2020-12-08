FROM openjdk:15.0.1-jdk-oraclelinux8
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} order-service.jar
ENTRYPOINT ["java","-jar","/order-service.jar"]
