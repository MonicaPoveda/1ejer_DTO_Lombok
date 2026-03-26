FROM maven:3.9-amazoncorretto-21 AS build
WORKDIR /app
COPY Veterinaria/ .
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine-jdk
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /api-v1.jar
ENTRYPOINT ["java","-jar","api-v1.jar"]