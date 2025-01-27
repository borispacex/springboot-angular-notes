# TECNOLOGIAS
Para la ejecución del proyecto utilizaremos Docker creando contenedores para el despligue utilizando estas 3 tecnologias:

- SpringBoot 3.0.6 - (Puerto 8080)
- Angular 13.3.0 - (Puerto 4200)
- PostgreSQL 12 - (Puerto 5432)

## BACKEND (SpringBoot)
Opción 1 (Tener Instalado Maven)
```
mvn clean package -DskipTests
```
Opción 2
```
./mvnw clean package -DskipTests
```

Ir a la ruta
- http://localhost:8080/

## FRONTEND (Angular)
Ir a la ruta
- http://localhost:4200/

## DOCKER
Ejecutar el comando para levantar proyecto utilizando Docker
```
docker-compose up -d
```
