FROM openjdk:17
EXPOSE 8080
ADD target/ecommerceth.jar ecommerceth.jar
ENTRYPOINT ["java","-jar","/ecommerceth.jar"]