FROM openjdk:15.0.1-jdk-oraclelinux8
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} eureka-server.jar
ENTRYPOINT ["java","-jar","/eureka-server.jar"]
