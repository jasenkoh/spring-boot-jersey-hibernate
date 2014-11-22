<h2>RESTfull web services with Spring Boot, Jersey and hibernate using PostgreSQL database (Java configuration).</h2>

<b>Technologies:</b>
<ul>
<li>Java 8</li>
<li>Maven 3</li>
<li>Spring Boot 1.1.9.RELEASE</li>
<li>Jersey 2.7</li>
<li>Hibernate 4</li>
<li>PostgreSQL</li>
<ul>

<br/>

<p>To test, first execute SQL query located at resources folder against jersey-demo database and populate with some dummy data.</p>
<p>Update credentials in SqlInitialization class</p>
<pre>
dataSource.setUsername("your-username");
dataSource.setPassword("your-password");
</pre>
<br/>
<pre>
mvn clean package && mvn spring-boot:run
or
mvn clean package && java -jar target/spring-boot-jersey-hibernate-1.0-SNAPSHOT.jar
</pre>
<p>Go to: localhost:8080/products</p>
