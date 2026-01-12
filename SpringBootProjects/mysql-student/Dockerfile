FROM eclipse-temurin:25

LABEL mentainer="paltamojeet@gmail.com"

WORKDIR /app

COPY target/mysql-student-0.0.1-SNAPSHOT.jar /app/mysqlstudent.jar

ENTRYPOINT ["java", "-jar", "mysqlstudent.jar"]