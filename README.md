#RESTfull web services with Spring Boot, Jersey and hibernate using tomcat PostgreSQL JNDI database.

##Technologies
* Java 7
* Maven 3
* Spring Boot 1.2.7.RELEASE
* Jersey 2.7
* Hibernate 4
* Guava
* PostgreSQL
* Tomcat 8 with jndi

##Architecture

```
Restful request > Jersey > Service > DAO > Tomcat > Database
```

###To change jndi setting. Update the application.yml</p>
```
spring:
  datasource:
    jndi-name: [your jndi data source]
```

###It is able to be run by embeded tomcat on external J2EE server</p>
```
mvn clean package && mvn spring-boot:run
```
###Go to: localhost:8080/products


