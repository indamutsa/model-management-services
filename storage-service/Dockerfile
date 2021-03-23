FROM adoptopenjdk/openjdk11

VOLUME /container-volume
COPY target/*.jar storage.jar

ENTRYPOINT ["java", "-jar", "/storage.jar"]
EXPOSE 8089