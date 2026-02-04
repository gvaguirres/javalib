FROM maven:3-eclipse-temurin-25-alpine AS build
#det körs automatiskt en build på alla copy rad
WORKDIR /build
COPY src/ src/
COPY pom.xml pom.xml
RUN mvn compile


FROM eclipse-temurin:25-jre-alpine
COPY --from=build /build/target/classes/org/example/socket/SimpleServer.class /app/org/example/socket/SimpleServer.class
ENTRYPOINT ["java", "-classpath", "/app", "org.example.socket.SimpleServer"]