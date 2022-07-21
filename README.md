# xQuiz Application
:dart: Application to digitalize the recruitment process during the xHub events :tickets:
### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#web)
* [Spring Cloud Contract](https://spring.io/projects/spring-cloud-contract)
* [Lombok](https://projectlombok.org/features/all)

## Requirements

For building and running the application you need:

- [JDK 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html)
- [Maven 3](https://maven.apache.org)

## Project Setup

```sh 
SSH: git@gitlab.com:xhub-org/p/xquiz/backend.git
HTTPS: https://gitlab.com/xhub-org/p/xquiz/backend.git
cd backend
mvn clean compile
mvn spring-boot:run
```

## Database Setup

`````yaml
url: ${DATABASE_URL:jdbc:postgresql://localhost:5432/xQuiz_db}
username: ${DATABASE_USER:postgres}
password: ${DATABASE_PASSWORD:root}
platform: postgres
`````

## Swagger documentation

```sh
http://localhost:8080/api/swagger-ui.html
```

xHub Team

Made by :hearts: