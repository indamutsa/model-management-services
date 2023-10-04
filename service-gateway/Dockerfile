FROM adoptopenjdk/openjdk11

COPY target/*.jar gateway.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /gateway.jar" ]
EXPOSE 7500