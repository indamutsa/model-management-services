FROM adoptopenjdk/openjdk11

VOLUME /container-volume
ADD target/*.jar auth-app.jar

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /auth-app.jar" ]
EXPOSE 8000