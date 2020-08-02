FROM openjdk:12-alpine
VOLUME /tmp
ARG ENC_PASS
ENV JASYPT_PASS ${ENC_PASS}
ADD ./target/config-server-0.0.1-SNAPSHOT.jar config-server.jar 
ENTRYPOINT java -Djasypt.encryptor.password=${JASYPT_PASS} -jar /config-server.jar 