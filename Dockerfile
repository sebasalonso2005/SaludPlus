# ===== Etapa de build =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copiamos primero el pom para cachear dependencias
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline

# Ahora el código
COPY src ./src
RUN mvn -q -DskipTests package

# ===== Etapa de runtime (ligera) =====
FROM eclipse-temurin:17-jre
WORKDIR /app

# Copiamos el jar generado
COPY --from=build /app/target/*.jar app.jar

# Render suele inyectar PORT; 8080 por defecto
ENV PORT=8080
EXPOSE 8080

# Forzamos a escuchar en 0.0.0.0 y en $PORT
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","/app/app.jar"]
