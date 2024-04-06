FROM maven:latest
WORKDIR /app
COPY src /app/src
COPY pom.xml /app
RUN mvn clean install -DskipTests=true
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/grocery-management.jar"]