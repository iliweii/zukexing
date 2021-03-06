## 租客行APP前端界面

**租客行-共享式租房APP**

前端界面项目地址  https://github.com/iliweii/zukexing-app

后端项目地址         https://github.com/iliweii/zukexing

数据库文件为`zukexing.sql`

### 配置

apache 反向代理

```conf
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

```yml
server:
  port: 8082 # 修改端口

spring:
  profiles:
    active: dev
  mvc:
    static-path-pattern: /static/**
  datasource:
    driver-class-name: org.mariadb.jdbc.Driver
    type: com.alibaba.druid.pool.DruidDataSource
    url: jdbc:mysql://localhost:3306/zukexing?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8 # 修改url
    username: root # 修改用户名
    password: # 修改密码
  servlet:
    multipart:
      max-file-size: 200MB #单个文件上传大小
      max-request-size: 600MB #连续上传文件大小

mybatis:
  # MyBatis解析设置
  mapper-locations: classpath:mapping/*Mapping.xml
  type-aliases-package: com.zukexing.pojo

file:
    path1: "C:\\Users\\chall\\Documents\\eclipse-workspace2\\zukexing\\src\\main\\resources\\static\\image\\avater\\" #修改存储路径
    path2: "C:\\Users\\chall\\Documents\\eclipse-workspace2\\zukexing\\src\\main\\resources\\static\\image\\house\\"
```

### 背景

当前租房体系日益成熟化、固定化，线下以房屋中介为主，房东可以将房子全权交给中介管理，缺点是高昂的中介服务费和较低的收益；线上以各大厂商的软件为主，比如美团、携程、飞猪、艺龙、58同城等消费类APP涵盖着这类业务，也比如安居客、链家、贝壳等专门服务房产行业的APP也涵盖着这类业务。他们业务繁多，尤其对于租房这一项都没有提出较好的解决方案，个人发布的房源无人问津，造成房屋空置，资源浪费的现象。

目前APP服务向专门类方向发展，聚合类APP虽然好用但是功能过于复杂。近几年共享理念非常受欢迎，比如共享单车，共享充电宝等等市场已经成熟，共享汽车行业正在蓬勃发展。租房也可以结合共享理念退出共享式租房APP。通过便捷的方式完成预订、入住，自行打扫房间的方式完成一次租住过程。房东也只需要动动手指，设定允许租出的时间段，发布房源，即可获得收益。无论你是想整年出租，还是某段时间内房屋是空置的，都可以选择出租。这样免去了大量繁琐的手续阶段，节省时间，最大化利用房屋价值，防止房屋空置，还能带来收益。

共享式租房APP命名为租客行，意为租客可以很方便的完成租住房屋过程。

### 需求总体介绍

对于用户，通过租客行APP可以自由浏览、选择、预订房屋，选择合适的时间段，预订并提交订单，支付押金和房费。预订房屋需要完成实名认证。用户可以提前一段时间获得平台自动生成的房屋密码，通过密码可以进入房屋。用户在租住完成之间完成房屋打扫、清理工作，然后实时录制不少于30ｓ的视频并提交，通过审核后退还押金，完成整个入住流程。

对于房东，发布房屋需要实名认证。想要出租房屋，首先房东需要通过平台购置专用的云密码锁。之后填写房屋信息，选择房屋可出租的时间段，并将房屋和云密码锁绑定即可完成发布。房东不定时对房屋检查并提交检查记录可以提高房屋排名。

其他身份，包括审核员、管理员等角色。审核员用于审核用户提交退房视频。退房视频没有问题，退还押金，若退房视频模糊，无法辨别等问题，审核员需要亲自入房审核，这个过程需要从用户押金中扣除部分审核服务费用。若最终审核不通过，则不退还押金。管理员对整体系统进行管理。

### 系统目录结构

系统分为租客行APP和后台系统。其中租客行APP目录结构包括manifests系统配置文件夹，java文件夹下，pojo为实体类文件夹，ui为安卓activity活动类文件夹。Res为资源文件夹，下面drawable存放图片资源，font存放字体资源，layout存放布局文件，menu存放菜单布局，mipmap存放应用启动图标，values存放静态配置文件。

后台系统中，api为接口文件夹，存放用于安卓请求数据的接口文件，controller为访问控制层文件夹，存放请求页面的类文件，dao为数据库访问层，存放数据库访问层接口文件，pojo中存放实体类文件，service为业务逻辑层文件夹，存放业务逻辑层接口文件，其中impl为实现类文件夹，存放业务逻辑层实现类文件。

在resources资源文件夹中，mapping文件夹用于存放数据库访问层实现文件，使用了Mybatis技术，static为静态资源文件，其中image下avater用于存放用户头像图片，house用于存放房源图片，templates为网页文件夹，存放网页文件。

### 总结

租客行APP融合共享理念，打破传统租房难题，能让租客和房东都受益。APP中使用了不少的列表展示，即Listview，通过继承并实现其适配器，并设计列表单个项目的布局，王城整个列表的展示。APP中使用了定位功能，是根据高德地图的接口实现的，向接口请求并获取数据来获取用户当前位置以及天气信息。租客行设计为APP+后端模式，之间使用json数据进行交互，使用了Gson工具来生成和解析json数据。APP中的图片使用了Glide工具加载，并且带有图片缓存效果，默认图片设置，大大减轻工作量。APP中使用了SharedPreferences技术存储用户数据，对于用于更新个人资料的情况，现在本地对SharedPreferences中存储的数据进行更新，再将数据异步提交到服务器，这样以来让用户感觉不到卡顿，优化用户体验。对于服务协议和隐私政策，使用Webview加载界面，界面放在服务器端，配合缓存优化用户体验。在提交订单页面使用了日期选择器DatePickerDialog和时间选择器TimePickerDialog，方便用户选择入住和退房日期。在验证码验证界面，发送验证码功能中，为避免用户故意重复发送验证码，使用Handler技术和Runnable技术结合制作子线程延时器，到达一定时间后释放操作。

在制作租客行APP中遇到了很多困难，很多问题需要去寻找解决答案。很多时候都是无功而返。在主页中曾设计左右翻页浏览不同类别的房源列表，分别是推荐、时钟住、短期住和长期租，使用了view pager技术，但通过适配器怎么都加载不出数据，怀疑是view pager和fragment冲突，最后也没解决，于是取消了这个功能。在上传头像中，通过APP本身去打开本地文件上传头像，但上传后无法加载，原因是后台使用spring boot无法热加载，通过网上办法解决后，发现热加载是自动重启项目，而重启过程中所有请求都无法接受，直到项目最后也没能解决此问题。原设计方案包含消息界面，希望能发送实时消息，对方接收到并能收到提醒，由于时间原因本功能还未动手，也是一大遗憾。

通过本项目，我学会了很多。平时作业中制作的小项目都没有想这么多，只想着通过课堂技术，亦或者怎么简单怎么来完成小作业，平时学的知识也不太多。直到做大项目的时候，从产生租客行APP想法开始，就遇到了重重困难，但不断地学习过程让我成长了很多，我学会了基本的APP设计，尽管设计过程很不规范，但是让我正式步入了移动应用开发的门槛。我相信以后要学习的还有很多很多，我也会保持初心，尽力的走下去。