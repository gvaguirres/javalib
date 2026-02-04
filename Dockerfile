FROM eclipse-temurin:25-jre-alpine
#Copy simple server from host to image
COPY target/classes/org/example/socket/SimpleServer.class /app/org/example/socket/SimpleServer.class
ENTRYPOINT ["java", "-classpath", "/app", "org.example.socket.SimpleServer"]