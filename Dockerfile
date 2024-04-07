FROM openjdk:21
VOLUME /tmp
EXPOSE 8761
ARG JAR_FILE=eureka-server/build/libs/eureka-server-1.0.jar
ADD ${JAR_FILE} eureka-server-1.0.jar
ENTRYPOINT ["java","-jar","/eureka-server-1.0.jar"]

FROM openjdk:21
VOLUME /tmp
EXPOSE 8081
ARG JAR_FILE=order-service/build/libs/order-service-1.0.jar
ADD ${JAR_FILE} order-service-1.0.jar
ENTRYPOINT ["java","-jar","/order-service-1.0.jar"]

FROM openjdk:21
VOLUME /tmp
EXPOSE 8082
ARG JAR_FILE=inventory-service/build/libs/inventory-service-1.0.jar
ADD ${JAR_FILE} inventory-service-1.0.jar
ENTRYPOINT ["java","-jar","/inventory-service-1.0.jar"]

FROM openjdk:21
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=gateway-service/build/libs/gateway-service-1.0.jar
ADD ${JAR_FILE} gateway-service-1.0.jar
ENTRYPOINT ["java","-jar","/gateway-service-1.0.jar"]
