# realiHomeTask
PreRequisites:
- Java 8
- maven 3.6.3 (might work with lower version)
  >> mvn com.github.eirslett:frontend-maven-plugin:1.7.6:install-node-and-npm -DnodeVersion="v10.16.0"
Steps to run:
 >> Go to https://github.com/haimgil/realiHomeTask and clone project 
 >> mvn spring-boot:run
 >>Use Postman to run:
  I. POST localhost:8080/api/v0/upload
      Requires form-data body:
      key: file value: listing-details.csv
 II. curl --location --request GET 'localhost:8080/api/v0/listings' (import to postman as raw)
    ** As of now, without filtering.
 
 NOTES:
 * BE written in java with Spring-boot
