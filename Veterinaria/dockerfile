FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY .. .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests
RUN cp target/*.jar app.jar


ENTRYPOINT ["java","-jar","app.jar"]