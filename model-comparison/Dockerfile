FROM adoptopenjdk/openjdk11

VOLUME /container-volume
COPY target/*.jar comparison.jar

# Create these folder so that we can have a temporally buffer incoming files
# We process the data and dispose them after
RUN mkdir -p src/main/resources/artifacts/models
RUN mkdir -p src/main/resources/artifacts/script

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /comparison.jar"]
EXPOSE 8088
