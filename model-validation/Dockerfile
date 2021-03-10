FROM adoptopenjdk/openjdk11

VOLUME /container-volume
COPY target/*.jar validate.jar

# Make these folder so that we can have a temporally buffer folder
# where we will process the data and dispose them after
RUN mkdir -p src/main/resources/artifacts/models
RUN mkdir -p src/main/resources/artifacts/metamodels
RUN mkdir -p src/main/resources/artifacts/script

ENTRYPOINT ["java", "-jar", "/validate.jar"]
EXPOSE 8086