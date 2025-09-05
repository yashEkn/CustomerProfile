# ---- Build stage ----
FROM maven:3.9.8-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -DskipTests dependency:resolve
COPY src ./src
RUN mvn -q -DskipTests package

# ---- Runtime stage ----
FROM eclipse-temurin:17-jdk
WORKDIR /app
COPY --from=build /app/target/java-mysql-demo-1.0.0.jar app.jar
ENTRYPOINT ["java","-jar","/app/app.jar"]
