FROM adoptopenjdk/openjdk11

RUN mkdir -p /app
WORKDIR /app

VOLUME /container-volume
COPY target/*.jar transform-atl.jar
COPY . .

# Create these folder so that we can have a temporally buffer incoming files
# We process the data and dispose them after
RUN mkdir -p src/main/resources/artifacts/models
RUN mkdir -p src/main/resources/artifacts/metamodels
RUN mkdir -p src/main/resources/artifacts/script

#This file help  us delete previous transformed target model
RUN touch  src/main/resources/artifacts/filenames.txt

ENV JAVA_OPTS=""

ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app/transform-atl.jar"]
EXPOSE 8185
