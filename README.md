# Netflix-Ribbon-Projects

This project have 2 services apart from Eureka Server-

1. Account-Service
2. Ribbon-Client

Both the services (& their instances ) are registered with Eureka Server. 

Account Service fetches the data from DB & Ribbon-Client Service makes use of Netflix-Feign-Client to talk to Account Service.

Ribbon-Client Service distributes the load among the available instances of Account-Service.

https://gifs.com/embed/netflix-ribbon-load-balancing-nxLDOR









