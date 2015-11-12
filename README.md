<h2>RESTfull web services with Spring Boot, Jersey and hibernate using tomcat PostgreSQL JNDI database.</h2>

<b>Technologies:</b>
<ul>
<li>Java 7</li>
<li>Maven 3</li>
<li>Spring Boot 1.2.7.RELEASE</li>
<li>Jersey 2.7</li>
<li>Hibernate 4</li>
<li>Guava</li>
<li>PostgreSQL</li>
<li>Tomcat 8 with jndi</li>
<ul>

<br/>

<p>To change jndi setting. Update the application.yml</p>
<pre>
spring:
  datasource:
    jndi-name: [your jndi data source]
</pre>
<br/>

<p>It is able to be run by embeded tomcat on external J2EE server</p>
<pre>
mvn clean package && mvn spring-boot:run
</pre>
<p>Go to: localhost:8080/products</p>
