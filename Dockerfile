FROM maven:3.9.9-eclipse-temurin-21 AS build

WORKDIR /spring
COPY . .
RUN mvn clean install -DskipTests

CMD mvn spring-boot:run -DskipTests
