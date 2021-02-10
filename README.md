# Netflix-Ribbon-Projects

This project have 2 services apart from Eureka Server-

1. Account-Service
2. Ribbon-Client

Both the services (& their instances ) are registered with Eureka Server. 

Account Service fetches the data from DB & Ribbon-Client Service makes use of Netflix-Feign-Client to talk to Account Service.

Ribbon-Client Service distributes the load among the available instances of Account-Service.

![github](https://user-images.githubusercontent.com/69712875/107475074-8e823b80-6b99-11eb-85ca-d977d09b1522.mp4)





