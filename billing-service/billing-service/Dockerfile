#building application using maven
FROM maven:3.9.12-eclipse-temurin-25 AS builder

WORKDIR /app

#Copy pom.xml
COPY pom.xml .

RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

RUN mvn clean package

FROM eclipse-temurin:25-jre-alpine AS runner
WORKDIR /app

COPY --from=builder ./app/target/billing-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4001
#gRPC Server port
EXPOSE 9001

ENTRYPOINT ["java", "-jar", "app.jar"]