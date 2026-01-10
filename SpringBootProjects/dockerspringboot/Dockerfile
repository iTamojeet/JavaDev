FROM eclipse-temurin:25

LABEL mentainer="paltamojeet@gmail.com"

WORKDIR /app

COPY target/dockerspringboot-0.0.1-SNAPSHOT.jar /app/dockernew.jar

ENTRYPOINT ["java", "-jar", "dockernew.jar"]