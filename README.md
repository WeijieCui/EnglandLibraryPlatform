# EnglandLibraryPlatform
### README

England Library Platform(ELP) is a mock library management platform. 
It contains Library Borrowing Service, Library Center Service, Book Transfer Service,
and Scheduling Service. Book Transfer Service is used to communicate to other carriages,
for examples, overhead crane system, handling robots, express trucks, self-service counters.
In addition, some base services will be developed to support these business services, 
User Authorization Center(UAC), for example. 
<img src=".\document\EnglandLibraryPlatform\architecture\application_architecture.png" width="1200"/>

### DOCUMENT STRUCTURE

- code: all services codes
- document: architecture files, ui, database
- LICENSE
- README.md

### PREPARATION & INSTALLATION & USING

As shows above, this project contains several services. 
Every service has a detailed README.md instruction file.
To prepare, install and use these services, please see the detailed README.md file in /code/{project}/README.md.

### DEPLOYMENT
ELP was supposed to deploy and run in a Kubernetes environment.
The deployment architecture shows below:
<img src=".\document\EnglandLibraryPlatform\architecture\deployment_architecture.png">