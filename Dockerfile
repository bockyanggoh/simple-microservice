FROM --platform=linux/amd64 maven:3.8.1-openjdk-11-slim AS builder
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM --platform=linux/amd64 openjdk:11.0.10-jre-slim-buster
ENV JAVA_OPTS=""
ENV SPRING_PROFILES_ACTIVE="qa"
EXPOSE 9998
WORKDIR /app
RUN apt-get update && apt-get upgrade
COPY  --from=builder /app/target/*.jar microservice.jar

RUN chgrp -R 0 /app \
&& chmod -R g=u /app

RUN ls .
ENTRYPOINT exec java -jar /app/microservice.jar $@