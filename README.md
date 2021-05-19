# scd-pauta-api


## Pré requisitos
- #### Maven
````
mvn -v

Apache Maven 3.5.2
````
- #### Docker

````
docker -v

Docker version 19.03.13, build 4484c46
  ````

- #### docker-compose

````
docker-compose -v

docker-compose version 1.27.4, build unknown
  ````


- #### Java 11
````
java -version

openjdk version "11.0.9.1" 2020-11-04
OpenJDK Runtime Environment AdoptOpenJDK (build 11.0.9.1+1)
OpenJDK 64-Bit Server VM AdoptOpenJDK (build 11.0.9.1+1, mixed mode)
````

## Ambiente Linux

### Executar os testes automatizados:

````
mvn test -P dev
````
### Empacotar dependencias
```
mvn package -DskipTests
``` 
### Construir imagem 
```
docker build -t desafio-pauta .
``` 
### Subir stack
```
docker-compose -f docker-compose.yml up -d
``` 

## Ambiente Windows

### Executar os testes automatizados:

````
mvn test -P dev
````
### Empacotar dependencias
```
mvn package -DskipTests
``` 
### Construir imagem
```
docker build -t desafio-pauta .
``` 
### Subir stack
```
docker-compose -f docker-compose.yml up -d
``` 

# Swagger
http://localhost:8080/swagger-ui/

# Postman
### link com requisicoes da api :
https://www.postman.com/collections/da2fa27c38f8f4e995c9

# Versionamento:
###Atenção no parâmetro no header da requisição :

```
Api-Version = 1
```

### Cadastrar Pauta

```
POST http://localhost:8080/pautas

{
  "titulo": "titulo da pauta"
}
``` 

### Abrir Sessão

```
POST http://localhost:8080/pautas/abrir

{
    "id_pauta": 1,
    "minutos": 4
}

OU

{
    "id_pauta": 1,
}
```
### Votar em uma pauta
```
POST http://localhost:8080/votos

{
    "id_pauta": 1,
    "id_cooperado": 1,
    "cpf": "10338927425",
    "voto": "Sim"
}
``` 

### Consultar resultado da pauta
```
GET http://localhost:8080/resultados/{id}
``` 



