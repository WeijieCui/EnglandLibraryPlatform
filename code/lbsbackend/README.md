# Library Brrowing Service Backend
### README

Library Brrowing Service(LBS) is a website service providing borrowing, renewing, reserving service. 
This service is the backend service of LBS. 

For more detail, see the chart below:
<img src="..\..\document/LibraryBorrowingService/architecture/lbs_architecture.png" width="1000"/>

### DOCUMENT STRUCTURE

- gradle: gradle wrapper
- sql: sql for initial database and initial basic data
- src: codes, resources, tests
- build.gradle: manage packages
- README.md

### PREPARATION

To prepare:

- Please provide a JAVA-17 environment. 
- Please provide a mysql service and run the initial database and initial basic data sql in sql file.

### INSTALLATION

To install, `cd code/lbsbackend` `./gradlew build`
### USING

To run, `cd src/main/java/com/example.lbsbackend` `java LbsbackendApplication.java`

### DEPLOYMENT

Waiting...