FROM adoptopenjdk/openjdk11

VOLUME /container-volume
ADD target/*.jar registry.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /registry.jar" ]
EXPOSE 7070