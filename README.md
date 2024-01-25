# Automatic Unit Test Cases Generation

This project aims to build a web application to generate unit tests for a given code snippet by leveraging power of large language models (LLM).

Most new machine learning models are made with Python and its usual tools. This project also wants to show how to put these Python models into a Java Spring Boot app using`Jep`.

The project uses API's provided by `cohere` to use a generative pretrained model.

## Requirements

### Core

- [Java 17](https://download.oracle.com/java/17/latest/jdk-17_windows-x64_bin.exe)
- [Maven 3.9](https://maven.apache.org)
- [NPM](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)

### Frameworks
- [spring boot](http://projects.spring.io/spring-boot/)
- [Jep](https://github.com/ninia/jep)
- [react](https://react.dev/)
- [axios](https://axios-http.com/)

## Running the application locally
### Java
 - Execute `main` method in the `com.bje.testweaver.TestWeaverApplication` class from your IDE.
 - Use [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) as

```shell
mvn spring-boot:run
```
This will start the java server at [http://localhost:8080](http://localhost:8080).

### React
- Execute npm command as :
```shell
npm start
```
This will start the react application at [http://localhost:3000]((http://localhost:3000)) in development mode.
