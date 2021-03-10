FROM adoptopenjdk/openjdk11

VOLUME /container-volume
COPY target/*.jar query.jar

# Create these folder so that we can have a temporally buffer incoming files
# We process the data and dispose them after
RUN mkdir -p src/main/resources/artifacts/models
RUN mkdir -p src/main/resources/artifacts/metamodels
RUN mkdir -p src/main/resources/artifacts/script

ENTRYPOINT ["java", "-jar", "/query.jar"]
EXPOSE 8087
