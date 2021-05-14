FROM adoptopenjdk/openjdk11:latest

ADD target/desafio-pauta.jar desafio-pauta.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "desafio-pauta.jar"]