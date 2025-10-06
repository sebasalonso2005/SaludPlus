# ===== Build con JDK 24 y Maven Wrapper =====
FROM eclipse-temurin:24-jdk AS build
WORKDIR /app

# Herramientas mínimas para que mvnw descargue Maven
RUN apt-get update && apt-get install -y curl unzip && rm -rf /var/lib/apt/lists/*

# Copiamos wrapper y pom primero para cachear deps
COPY .mvn/ .mvn/
COPY mvnw .
COPY pom.xml .

# Permisos para el wrapper
RUN chmod +x mvnw

# Pre-descargar dependencias (cache)
RUN ./mvnw -q -DskipTests dependency:go-offline

# Ahora el código
COPY src ./src

# Compilar (si tu proyecto necesita --release 24, maven-compiler lo tomará del pom)
RUN ./mvnw -q -DskipTests package

# ===== Runtime (JRE 24 si existe, si no, JDK 24) =====
# Algunas distribuciones aún no publican 24-jre; si falla, usa 24-jdk aquí también.
FROM eclipse-temurin:24-jre
# Si la etiqueta 24-jre no existe en tu registry, cambia a:
# FROM eclipse-temurin:24-jdk

WORKDIR /app
COPY --from=build /app/target/*.jar app.jar

ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-Dserver.port=${PORT}","-jar","/app/app.jar"]
