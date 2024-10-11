FROM eclipse-temurin:23-alpine
VOLUME /tmp
EXPOSE 8080
ENV PROFILE=dev
ARG JAR_FILE=target/GerenciamentoTrafego-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar

ENTRYPOINT ["java","-Dspring.profiles.active=${PROFILE}","-jar","/app.jar"]