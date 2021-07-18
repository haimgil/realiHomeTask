# realiHomeTask
PreRequisites:
- Java 11
- maven 3.6.3 (might work with lower version)

Steps to run:
 > * Go to https://github.com/haimgil/realiHomeTask and clone project
 > * run: mvn package
 > * run: mvn spring-boot:run
 
Use Postman to run:
  > GET localhost:8080/api/v0/listings?min_price=100000&max_price=200000&min_bed=2&max_bed=2&min_b
  ath=2&max_bath=2
> * May either, use or not any query parameters
 
 NOTES:
 * BE written in java with Spring-boot
 * Data stored in jpa repository. I tried to adopt the datastore but encountered some issues that prevented it, unfortunately. This something that I would keep investigating for implementing it with datasotore. 
