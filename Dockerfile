FROM openjdk:11
ARG JAR_FILE=target/app-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

#docker build -t dockerimage .
#docker run -p 8080:8080 dockerimage