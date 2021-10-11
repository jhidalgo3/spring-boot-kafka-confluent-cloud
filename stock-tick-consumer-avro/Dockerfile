FROM openjdk:11.0-jre

ARG JAR=*.jar

RUN groupadd -r java && useradd --no-log-init -r -g java app
USER app

VOLUME /tmp
COPY $JAR app.jar

EXPOSE 8080

VOLUME /tmp
ENV JAVA_OPTS=""
ENTRYPOINT exec java -agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=9999 -jar /app.jar
