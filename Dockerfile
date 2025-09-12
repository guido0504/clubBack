# ---- Build ----
FROM maven:3.9.8-eclipse-temurin-21 AS build
WORKDIR /workspace
COPY . .

# Compila el módulo que contiene el pom (newLevel)
RUN mvn -f clubBack/pom.xml -DskipTests clean package
# (equivalente: WORKDIR /workspace/newLevel && mvn -DskipTests clean package)

# ---- Run ----
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiá el jar generado por el módulo newLevel
COPY --from=build /workspace/clubBack/target/*.jar app.jar

# Memoria prudente para plan Free
ENV JAVA_TOOL_OPTIONS="-Xms256m -Xmx512m -XX:+UseSerialGC"

# Render inyecta $PORT
CMD ["sh","-c","java -Dserver.port=$PORT -jar app.jar"]
