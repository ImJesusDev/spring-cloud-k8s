FROM openjdk:12-alpine
VOLUME /tmp
ADD eureka-server/target/eureka-server-0.0.1-SNAPSHOT.jar eureka-server.jar 
ENTRYPOINT ["java","-jar","/eureka-server.jar"]