FROM adoptopenjdk/openjdk11

VOLUME /container-volume
COPY target/*.jar transform.jar

# Make these folder so that we can have a temporally buffer folder
# where we will process the data and dispose them after
RUN mkdir -p src/main/resources/artifacts/models
RUN mkdir -p src/main/resources/artifacts/metamodels
RUN mkdir -p src/main/resources/artifacts/script

#This file help  us delete previous transformed target model
RUN touch  src/main/resources/artifacts/filenames.txt

ENTRYPOINT ["java", "-jar", "/transform.jar"]
EXPOSE 8085