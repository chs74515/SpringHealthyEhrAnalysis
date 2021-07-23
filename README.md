# SpringHealthyEhrAnalysis
A Spring Boot Application with a Thymeleaf Frontend. Java + Spring Boot framework. MVC and Data transfer Object Design Pattern DTOD), Using an open source REST client - Spring REST template. 
Configured dependencies via Maven, connected to the appropriate endpoint and printed out, by state and in descending order, the percentage of hospitals that support basic EHR notes for a specific year (2014). Containerization of the app and deployment done with Docker Hub. 
#### HEALTHisWEALTH :) JAVAEE DOCKER  

Building this project:

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.6/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.6/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.5.0/reference/htmlsingle/#boot-features-developing-web-applications)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)

### To build docker image
mvn clean spring-boot:build-image  

### To run docker container
docker run -p 8080:8080 calebogb/healthit-ehr-service:0.0.1-SNAPSHOT

### Important URLs
1. Table view - the list of percentages of hospitals that are supported by basic EHR notes 
   http://localhost:8080/ehr/pct-basic
   
2. Json response - the list of percentages of hospitals that are supported by basic EHR notes 
   http://localhost:8080/api/ehr-data/pct-hospital-basic-ehr
