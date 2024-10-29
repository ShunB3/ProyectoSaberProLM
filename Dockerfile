
FROM openjdk:17
COPY "./target/PruebaSaberPRO-1.jar" "app.jar"
EXPOSE 8021
ENTRYPOINT [ "java", "-jar", "app.jar" ]
