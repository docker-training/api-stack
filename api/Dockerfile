FROM gradle:jdk10 as build
WORKDIR /home/gradle/project
COPY build.gradle .
COPY src ./src
USER root
RUN gradle build

FROM openjdk:10-jre-slim
COPY --from=build /home/gradle/project/build/libs/gs-rest-service-0.1.0.jar /gs-rest-service-0.1.0.jar
ENTRYPOINT java -jar /gs-rest-service-0.1.0.jar


