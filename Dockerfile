FROM maven:latest
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean install
