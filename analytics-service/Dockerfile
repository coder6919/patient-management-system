#building application using maven
FROM maven:3.9.12-eclipse-temurin-25 AS builder

WORKDIR /app

#Copy pom.xml
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:25-jre-alpine AS runner
WORKDIR /app

COPY --from=builder ./app/target/analytics-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4002

ENTRYPOINT ["java", "-jar", "app.jar"]