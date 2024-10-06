# Medicine Search (med-search) 
## Java + Spring Boot + Gradle
Demo project to demonstrate docker skill.

# Getting Started
1. [Code repository](https://github.com/Ananth-SePi/med-search)
2. [Image repository](https://hub.docker.com/r/ananthpitchiah/med-search)
3. [CI/CD pipeline](https://github.com/Ananth-SePi/med-search/actions)

### Pre-requisites
1. JDK 17
2. Docker

After checking out the code from the repository, to generate docker image,
```shell
# In Linux system,
gradlew buildDockerImage

# In Windows system,
gradlew.bat buildDockerImage
```
You could also pull this service's docker image in the above mentioned docker registry simply with the below command,
```shell
docker pull <image-name>:<tag-name>
```
For example,
```shell
docker pull med-search:1.0.0
```

To run this application, we should make sure the 2 dependent services are up & running. Those services are,
1. database server (postgres)
2. cache server (redis)

To simplify these dependent services availability, this project extends a support to use docker compose file where we mention all the inter related services within the same network to communicate with.

To run the services with docker compose file,
```shell
docker compose up -d
```
tag -d starts the containers in the background and leaves them running. We can check the logs by using,
```shell
docker logs -f <service-name/pod-name>
```

### Reference Documentation
For further reference, please consider the following sections:

* [Official Gradle documentation](https://docs.gradle.org)
* [Spring Boot Gradle Plugin Reference Guide](https://docs.spring.io/spring-boot/3.3.3/gradle-plugin)
* [Create an OCI image](https://docs.spring.io/spring-boot/3.3.3/gradle-plugin/packaging-oci-image.html)
* [Coroutines section of the Spring Framework Documentation](https://docs.spring.io/spring/docs/6.1.12/spring-framework-reference/languages.html#coroutines)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web)
* [Docker Compose Support](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#features.docker-compose)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#using.devtools)
* [Mustache](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)
* [Spring Boot Actuator](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#actuator)
* [Prometheus](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#actuator.metrics.export.prometheus)
* [Resilience4J](https://docs.spring.io/spring-cloud-circuitbreaker/docs/current/reference/html/#configuring-resilience4j-circuit-breakers)
* [Spring Data Reactive Redis](https://docs.spring.io/spring-boot/docs/3.3.3/reference/htmlsingle/index.html#data.nosql.redis)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Building a RESTful Web Service with Spring Boot Actuator](https://spring.io/guides/gs/actuator-service/)
* [Messaging with Redis](https://spring.io/guides/gs/messaging-redis/)

### Additional Links
These additional references should also help you:

* [Gradle Build Scans – insights for your project's build](https://scans.gradle.com#gradle)

### Docker Compose support
This project contains a Docker Compose file named `compose.yaml`.
In this file, the following services have been defined:

* postgres: [`postgres:latest`](https://hub.docker.com/_/postgres)
* redis: [`redis:latest`](https://hub.docker.com/_/redis)

Please review the tags of the used images and set them to the same as you're running in production.

