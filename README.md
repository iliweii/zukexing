apache 反向代理

```
<VirtualHost *:80>
   ServerName zukexing.com
   ServerAlias zukexing.com
   ProxyRequests off
   <Proxy *>
     Order deny,allow
     Allow from all
   </Proxy>
   ProxyPass / http://127.0.0.1:8082/
 </VirtualHost>
```

修改hosts文件
```
127.0.0.1 zukexing.com
```

application.yml
```
server:
  port: 8082

spring:
  profiles:
    active: dev
  mvc:
    static-path-pattern: /static/**
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://localhost:3306/zukexing?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8
    username: root
    password:
```