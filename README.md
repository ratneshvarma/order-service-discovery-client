# order-service-discovery-client
 - add spring-cloud-starter-netflix-eureka-client dependency to create discovery server
 - enable @EnableEurekaClient on main class
 - register service with eureka server (see application.yaml)
 - run eureka server and open dashboard(http://localhost:8761/) to see all registered service 	
 - run item-service-discovery-client application so that service apis available(http://localhost:8081/items)
 - run order-service-discovery-client application so that service apis available(http://localhost:8082/orders/1)<br>
    * order-service-discovery-client consuming item-service-discovery-client using resttemplate and load balanced so when there are more then 1 instance of item-service-discovery-client discovery load balancer library decides which instance to be use to call api randamly
    * we can create multiple instance locally to test load balancing
       - java -Dserver.port=8084 -jar item-service-discovery-client.0.0.1-SNAPSHOT.jar