
# Test-App

The project is based on a small web service which uses the following technologies:

 -Java 1.8

 -Spring Boot

 -Database Mysql (script schema.sql under resources folder for database initialization)*

 -Maven
 
 -The architecture of the web service is built with the following components:

   **DataTransferObjects: Objects which are used for outside communication via the API
   
   **Controller: Implements the processing logic of the web service, parsing of parameters and validation of in- and outputs.
   
   **Service: Implements the business logic and handles the access to the DataAccessObjects.
   
   **DomainObjects: Functional Objects which might be persisted in the database.
## Installation
For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven 4](https://maven.apache.org)
## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com.example.demo.DemoApplication` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```
## How to start the app
You should be able to start the example application by executing com.example.demo.DemoApplication, which starts a webserver on port 8080 (http://localhost:8080).
## Useful commands
Useful curl commands to test.
1. curl "http://localhost:8080/workflow/api/getWorkflowsByName/workflow1"
2. curl "http://localhost:8080/workflow/api/getWorkflowsByCategories?ids=1,2"
3. curl "http://localhost:8080/workflow/api/getWorkflowsByStatus/true"
4. curl "http://localhost:8080/workflow/category/api/getAllWorkflowCategories"
