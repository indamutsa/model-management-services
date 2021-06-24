FROM adoptopenjdk/openjdk11

VOLUME /container-volume
COPY target/*.jar merge.jar

# Create these folder so that we can have a temporally buffer for incoming files
# We process the data and dispose them after
RUN mkdir -p src/main/resources/artifacts/models
RUN mkdir -p src/main/resources/artifacts/script

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /merge.jar"]
EXPOSE 8084
