FROM openjdk:21
VOLUME /tmp
EXPOSE 8761
ARG JAR_FILE=eureka-server/build/libs/eureka-server-1.0.jar
ADD ${JAR_FILE} eureka-server-1.0.jar
ENTRYPOINT ["java","-jar","/eureka-server-1.0.jar"]
