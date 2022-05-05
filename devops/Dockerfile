FROM openjdk:11-jdk-slim

VOLUME /tmp

RUN apk add --update bash

ADD ./build/libs/*.jar /app/app.jar

CMD java -jar /app/app.jar $APP_OPTIONS

RUN sh -c 'touch /app.jar'
EXPOSE 8088
ENTRYPOINT exec java -jar ${JAVA_OPTS} /app.jar
