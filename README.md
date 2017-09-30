# spring cloud 项目列表
##  Spring Cloud Config
##  Spring Cloud Netflix
##  Spring Cloud Bus
##  spring-cloud-cloudfoundry
##  Spring Cloud Cloud Foundry Service Broker
##  Spring Cloud Cluster
##  Spring Cloud Consul
##  Spring Cloud Security
##  Spring Cloud Sleuth
##  Spring Cloud Data Flow
##  Spring Cloud Stream
##  Spring Cloud Stream App Starters
##  Spring Cloud Task
##  Spring Cloud Task App Starters
##  Spring Cloud Zookeeper
##  Spring Cloud Connectors
##  Spring Cloud Starters
##  Spring Cloud CLI
##  Spring Cloud Contract

#   Spring Cloud Netflix
##  Service Discovery client
1.  依赖
```
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-netflix-eureka-client</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-commons</artifactId>
</dependency>
```
2.  配置

##  Service Discovery server

3.  问题
The replica size seems to be empty. Check the route 53 DNS Registry
>
##  Circuit Breaker
1.  依赖
```
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-actuator</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix</artifactId>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
</dependency>
```
2.  配置
```
@EnableHystrixDashboard
@EnableHystrix
```
3.访问地址
```
配置地址 http://localhost:8333/hystrix
监控地址 http://localhost:8333/application/hystrix.stream
```
3.  注意事项
>   如果配置 ribbon 确保hystrix超时时间要比ribbon重试时间要长

##  Turbine
1.  依赖

2.  配置
```
turbine.app-config参数指定了需要收集监控信息的服务名；
turbine.cluster-name-expression 参数指定了集群名称为default，当我们服务数量非常多的时候，可以启动多个Turbine服务来构建不同的聚合集群，而该参数可以用来区分这些不同的聚合集群，同时该参数值可以在Hystrix仪表盘中用来定位不同的聚合集群，只需要在Hystrix Stream的URL中通过cluster参数来指定；
turbine.combine-host-port参数设置为true，可以让同一主机上的服务通过主机名与端口号的组合来进行区分，默认情况下会以host来区分不同的服务，这会使得在本地调试的时候，本机上的不同服务聚合成一个服务来统计。
```
##  Declarative REST Client
##  Client Side Load Balancer
##  External Configuration
##  Router and Filter

