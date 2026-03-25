FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

RUN cp target/*.jar app.jar

CMD ["java","-jar","app.jar"]