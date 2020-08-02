FROM openjdk:12-alpine
VOLUME /tmp
EXPOSE 9411
ADD ./zipkin.jar zipkin-server.jar 
ENTRYPOINT ["java","-jar","/zipkin-server.jar"]