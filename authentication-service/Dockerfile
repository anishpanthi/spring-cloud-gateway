FROM openjdk:15.0.1-jdk-oraclelinux8
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} gateway.jar
ENTRYPOINT ["java","-jar","/gateway.jar"]
