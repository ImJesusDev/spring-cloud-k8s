FROM openjdk:12-alpine
VOLUME /tmp
ADD zuul-server/target/zuul-server-0.0.1-SNAPSHOT.jar zuul-server.jar 
ENTRYPOINT ["java","-jar","/zuul-server.jar"]