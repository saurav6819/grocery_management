FROM maven:latest AS MVN_BUILD
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean install -DskipTests=true

FROM openjdk:17.0

COPY --from=MVN_BUILD /app/target/grocery-management.jar /app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]