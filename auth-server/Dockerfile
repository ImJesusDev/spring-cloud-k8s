FROM openjdk:12-alpine
VOLUME /tmp
ADD auth-server/target/auth-server-0.0.1-SNAPSHOT.jar auth-server.jar 
ENTRYPOINT ["java","-jar","/auth-server.jar"]