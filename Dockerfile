# Estágio de construção
FROM maven:3.9-eclipse-temurin-23 AS build
WORKDIR /app

# Copia o pom.xml e o código-fonte para a imagem
COPY pom.xml .
COPY src ./src

# Executa o Maven para compilar o projeto
RUN mvn clean package -DskipTests

# Estágio de execução
FROM eclipse-temurin:23-alpine
VOLUME /tmp
EXPOSE 8080
ENV PROFILE=dev
ARG JAR_FILE=target/GerenciamentoTrafego-0.0.1-SNAPSHOT.jar

# Copia o JAR gerado do estágio de construção
COPY --from=build /app/target/GerenciamentoTrafego-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=${PROFILE}","-jar","/app.jar"]
