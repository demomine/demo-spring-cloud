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

#   Spring Cloud Config
##  依赖
```
<dependency>
            <groupId>org.springframework.cloud</groupId>
            <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
```

##  配置
1.  使用本地仓库
```
创建本地仓库
$ cd $HOME
$ mkdir config-repo
$ cd config-repo
$ git init .
$ echo info.foo: bar > application.properties
$ git add -A .
$ git commit -m "Add application.properties"

添加配置
spring.cloud.config.server.git.uri: file://${user.home}/config-repo
```

2.  使用git仓库
```
访问地址: http://configserveraddress/{git branch}/${search path}/{filename}
```

3.  配置详解
baseDir
>   GIT做文件系统，文件都会被clone到本地文件系统中，默认这些文件会被放置到以config-repo-为前缀的系统临时目录，在 linux 上应该是 /tmp/config-repo-目录，如果你遇到了不可预知的问题出现，你可以通过设置spring.cloud.config.server.git.basedir参数值为非系统临时目录。

##  常见问题
1.  Cannot pull from remote null, the working tree is not clean
>   仓库还有未提交的东西,git仓库全部提交 或者 使用 force-pull