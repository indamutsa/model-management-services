FROM adoptopenjdk/openjdk11

COPY target/*.jar storage.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /storage.jar" ]
EXPOSE 8089