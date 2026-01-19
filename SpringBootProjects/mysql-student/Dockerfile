FROM eclipse-temurin:25

LABEL maintainer="paltamojeet@gmail.com"

WORKDIR /app

COPY target/mysql-student-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8888

ENTRYPOINT ["java","-jar","/app/app.jar"]