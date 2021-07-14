# realiHomeTask
PreRequisites:
- Java 8
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
