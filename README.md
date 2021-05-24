# Rest-Json-Quickstart Project

## Getting Started
Wellcome to my Project with Rest-Json API with the Quarkus FrameWork related to Java. This project is a "Rest-Json-Quickstart Project" 
where I put the things that I've been learning about the tutorials of Quarkus related to creation of a API in Quarkus

## Guides that I Followed:
https://quarkus.io/guides/rest-json
<br>
And and OpenWebinas Course about Quarkus.

### This project is done related to the Quarkus Guide content of REST-JSON, obviously there are more things to add. But the main goal is done.

[![status application](https://img.shields.io/badge/status-stable-brightgreen)](URL_Proyecto)

<!--Logos-->

<br>

<img src="./doc/img/quarkus-logo.png" width="180px">

<br>

<img src="./doc/img/java.png" width="180px">

<br>

<img src="./doc/img/apache_maven.png" width="180px">

<br>

<img src="./doc/img/logocifp.png" width="180px">


## Tabla de Contenidos

1. [Tecnologías Usadas](#tecnologias-usadas)
1. [Reflexiones](#reflexiones)
1. [Licencia](#licencia)
1. [Detalles Quarkus](#detalles-quarkus)

---

## Tecnologías Usadas

- Java JDK 11
- Maven
- Visual Studio Code
- IntelliJ
- Git
- Docker
- Quarkus



**[⬆ back to top](#tabla-de-contenidos)**


---

## Reflexiones
### Que has mejorado con este proyecto?


**[⬆ back to top](#tabla-de-contenidos)**


---



## Licencia

MIT License

Copyright (c) 2021 Mateo Garcia Gonzalez

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.


**[⬆ back to top](#tabla-de-contenidos)**

---


## Autor
Mateo Garcia Gonzalez



---

# Detalles Quarkus
## getting-started project

This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

## TIP Creating a native executable
Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/getting-started-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.html.

## Provided examples

### RESTEasy JAX-RS example

REST is easy peasy with this Hello World RESTEasy resource.

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

**[⬆ back to top](#tabla-de-contenidos)**

---