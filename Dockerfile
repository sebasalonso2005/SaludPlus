
FROM eclipse-temurin:24-jdk AS build
WORKDIR /app


RUN apt-get update && apt-get install -y curl unzip && rm -rf /var/lib/apt/lists/*


COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .


RUN chmod +x mvnw


RUN ./mvnw -q -DskipTests dependency:go-offline


COPY src ./src


RUN ./mvnw -q -DskipTests package


FROM eclipse-temurin:24-jre


WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","/app/app.jar"]
