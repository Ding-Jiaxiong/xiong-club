### 面试熊 Club 社区项目



![Logo配色图](./assets/Logo配色图.png)



#### 0. 项目截图



##### 0.1 前端



###### 【登录页面】



![image-20240818181231865](./assets/image-20240818181231865.png)



###### 【刷题模块】



- 首页

![image-20240818181454455](./assets/image-20240818181454455.png)



- 题目详情

![image-20240818181545939](./assets/image-20240818181545939.png)





- 出题界面



![image-20240818181811229](./assets/image-20240818181811229.png)



> todo: 查大类接口自己改过，这里查不出标签了，问题已定位



###### 【练题模块】



- 专项练习选择



![image-20240818182008694](./assets/image-20240818182008694.png)



- 正在做题



![image-20240818182032519](./assets/image-20240818182032519.png)



- 交卷



![image-20240818182058565](./assets/image-20240818182058565.png)



- 答案解析



![image-20240818182126119](./assets/image-20240818182126119.png)





###### 【熊圈模块】



-  发布帖子



![image-20240818182241668](./assets/image-20240818182241668.png)



- 树状评论



![image-20240818182312384](./assets/image-20240818182312384.png)





###### 【个人中心】



- 个人信息



![image-20240818182351334](./assets/image-20240818182351334.png)



- 我的点赞



![image-20240818182409766](./assets/image-20240818182409766.png)



##### 0.2 后端



![image-20240818181427571](./assets/image-20240818181427571.png)



#### 1. 项目简介



##### 1.1 项目启动会



一个从 0 到 1 的社区项目【业务】



想法：

- 一个社区。社区里面我希望面向所有的程序员群体，提供一个交流，学习，招聘等等的程序员圈子。
- 交流的模块，类似脉脉这种圈子的概念
- 提供很多的面试题的学习
- 不止有题目，可以类似牛客网这样，来进行练习的题目的过程
- 模拟面试



![image-20240812125600633](./assets/image-20240812125600633.png)



##### 1.2 技术选型



- **分析的原则点**
    - 用户量预期多少？
        - 200人同时在线访问社区
        - 后期火了，我预测千人在线
    - 数据体量预期多少？
        - 题目数据
        - 练题数据
        - 博客数据
        - 文件的数据
        - 交流群的数据
        - 用户行为的一些数据
    - 服务器投入预期多少？
        - 4C8G业务服务
            - 前期人少，后端前端公用一个服务器
        - 4C8G中间件服务
- 后端
    - 框架
        - spring
        - springmvc
        - mybatis plus【以上 SSM 】
        - springboot【阿里云版本脚手架：https://start.aliyun.com/】
            - redisstarter
            - mongodbstarter
            - mybatisplusstarter
            - esstarter
            - ...
        - springcloud alibaba【微服务】
            - nacos
            - gateway
            - openfeign
        - satoken【鉴权】
    - 数据库
        - mysql
    - 实时流
        - websocket
    - 分布式任务调度
        - xxljob
    - 流程编排
        - asynctool
    - 缓存
        - redis
        - guava【本地缓存】
    - mq
        - rocketmq（推荐）
    - 分布式事务
        - 基于mq实现的消息驱动柔性事务 最终一致性
    - 搜索引擎
        - elastcsearch
    - 前端负载转发
        - nginx
    - 部署集成
        - Jenkins
    - 全文检索
        - elasticsearch
    - 文件存储
        - minio
    - 其他的一些
        - easyexcel
        - freemarker
- 前端



项目基调：前后端分离，一个对接用户的 C 端项目。



##### 1.3 开发工具选型



- 后端：IDEA
- 前端：我直接用 Webstorm 了
- 项目管理：GitHub
- 包依赖：Maven
- 数据库：MySQL 5.7【我直接 上 8】
- 数据库图形化工具：Navicat
- 接口管理工具：`ApiPost 7` 【我直接 postman】
- Redis ：我直接 Another
- 表建模：元数建模
- 原型设计：Axure 8
- 原型组件库：ant design
- node：`18.18.0`
- 代码生成器：easycode 【IDEA 插件】还有mybatis 的插件



#### 2. 项目开发流程【第一期】



##### 2.1 刷题模块功能规划 & 原型设计



###### 2.1.1 产品的功能模块



![image-20240812131714409](./assets/image-20240812131714409.png)



###### 2.1.2 研发功能模块拆分



![image-20240812131741758](./assets/image-20240812131741758.png)



###### 2.1.3 原型的设计



选型：`axure` + `antdesign` 的组件库



![image-20240812132354996](./assets/image-20240812132354996.png)



载入元件库

![image-20240812132533711](./assets/image-20240812132533711.png)



![image-20240812132622091](./assets/image-20240812132622091.png)



- 刷题首页

  ![image-20240812132023682](./assets/image-20240812132023682.png)

- 题目的详情

  ![image-20240812132044406](./assets/image-20240812132044406.png)



##### 2.2 刷题模块数据表设计



这个用到了 PDManer



![image-20240812132858657](./assets/image-20240812132858657.png)





![image-20240812132910563](./assets/image-20240812132910563.png)



新建了一个项目



![image-20240812133012797](./assets/image-20240812133012797.png)



数据模型：



![image-20240812133357649](./assets/image-20240812133357649.png)



![image-20240812133446233](./assets/image-20240812133446233.png)



![image-20240812133512315](./assets/image-20240812133512315.png)



![image-20240812133533873](./assets/image-20240812133533873.png)



![image-20240812133549019](./assets/image-20240812133549019.png)





![image-20240812133606823](./assets/image-20240812133606823.png)



![image-20240812133622060](./assets/image-20240812133622060.png)



![image-20240812133637470](./assets/image-20240812133637470.png)



其实还有一张 mapping， 总图里面漏掉了



![image-20240812134056985](./assets/image-20240812134056985.png)



整个的数据库表建模数据模型：



![image-20240812133916279](./assets/image-20240812133916279.png)





##### 2.3 项目架构设计



###### 2.3.1 传统的项目



![image-20240812134402556](./assets/image-20240812134402556.png)

- controller
- biz
- service
- dao





###### 2.3.2 现有的架构



![image-20240812130113995](./assets/image-20240812130113995.png)



##### 2.4 DDD思想启蒙 & 架构设计原理



req->dto->do->bo->entity->po





![image-20240812130810437](./assets/image-20240812130810437.png)



> 说实话，没听懂



##### 2.5 安装 Dcoker & Docker 拉取 MySQL 镜像



这里用的京东云



![image-20240812135310052](./assets/image-20240812135310052.png)



直接创建轻量云主机



这里暂且上了一个 2核8G 的



![image-20240812135601341](./assets/image-20240812135601341.png)



价格其实我觉得都差不多【试试吧，玩玩儿 京东云】



![image-20240812135836264](./assets/image-20240812135836264.png)



就这了



![image-20240812135852883](./assets/image-20240812135852883.png)



![image-20240812135931686](./assets/image-20240812135931686.png)





我用的 xterminal



![image-20240812140105764](./assets/image-20240812140105764.png)



改了下密码，直接干进去吧



![image-20240812140352548](./assets/image-20240812140352548.png)



传新服务器



安装 Docker，



```shell
yum install -y yum-utils device-mapper-persistent-data lvm2
```



![image-20240812140546968](./assets/image-20240812140546968.png)





```
yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```



![image-20240812140818140](./assets/image-20240812140818140.png)



```
yum install docker-ce docker-ce-cli containerd.io -y 
```



![image-20240812141142115](./assets/image-20240812141142115.png)



真的不快



![image-20240812141358898](./assets/image-20240812141358898.png)



安装完成直接启动



```
systemctl start docker
```



![image-20240812141423563](./assets/image-20240812141423563.png)



```
systemctl enable docker
docker version 
docker images
```



![image-20240812141512758](./assets/image-20240812141512758.png)



鸡翅用 的24， 我这 26 肯定够了



还是装 `5.7` 吧



```
docker pull mysql:5.7
```



![image-20240812141645037](./assets/image-20240812141645037.png)



经典问题果然出现了，拉不下来，配一个阿里云的镜像源



![image-20240812141847640](./assets/image-20240812141847640.png)



重启，再试一次



![image-20240812141945153](./assets/image-20240812141945153.png)



还是不行



![image-20240812142125488](./assets/image-20240812142125488.png)



又换了一个源 https://github.com/DaoCloud/public-image-mirror



![image-20240812142144067](./assets/image-20240812142144067.png)





感谢



![image-20240812142236635](./assets/image-20240812142236635.png)



创建一些数据卷



```
mkdir -p /home/service/mysql/data 
mkdir -p /home/service/mysql/conf
cd /home/service/mysql/conf

touch my.cnf

贴入：
[mysqld]
user=mysql
character-set-server=utf8
default_authentication_plugin=mysql_native_password
default-time_zone = '+8:00'
[client]
default-character-set=utf8
[mysql]
default-character-set=utf8
```



![image-20240812142513842](./assets/image-20240812142513842.png)



创建容器



```
docker run -p 3306:3306 --name mysql -v /home/service/mysql/logs:/logs -v /home/service/mysql/data:/mysql_data -e MYSQL_ROOT_PASSWORD=123456 -d mysql:5.7
```



![image-20240812142610928](./assets/image-20240812142610928.png)



进入

```
docker exec -it mysql bash 

mysql -uroot -p 
```



![image-20240812142648357](./assets/image-20240812142648357.png)





没问题，开个防火墙用可视化链接



![image-20240812142803641](./assets/image-20240812142803641.png)



![image-20240812142834999](./assets/image-20240812142834999.png)



![image-20240812142845287](./assets/image-20240812142845287.png)



4 个送的，比 8 少一点



##### 2.6 数据库表建立



![image-20240812143232251](./assets/image-20240812143232251.png)



直接运行 SQL 脚本



![image-20240812143244618](./assets/image-20240812143244618.png)



在这里 copy 的，但是这里是有一些问题的，不能直接用，这里直接贴了给的 SQL 文件



###### 2.6.1 题目分类表



```sql
DROP TABLE IF EXISTS `subject_category`;
CREATE TABLE `subject_category`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `category_name` varchar(16) DEFAULT NULL COMMENT '分类名称',
    `category_type` tinyint(2) DEFAULT NULL COMMENT '分类类型',
    `image_url`     varchar(64) DEFAULT NULL COMMENT '图标连接',
    `parent_id`     bigint(20) DEFAULT NULL COMMENT '父级id',
    `created_by`    varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time`  datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`   datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`    tinyint(1) DEFAULT '0' COMMENT '是否删除 0: 未删除 1: 已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='题目分类';
```



###### 2.6.2 题目标签表



```sql
DROP TABLE IF EXISTS `subject_label`;
CREATE TABLE `subject_label`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `label_name`   varchar(32) DEFAULT NULL COMMENT '标签分类',
    `sort_num`     int(11) DEFAULT NULL COMMENT '排序',
    `category_id`  varchar(50) DEFAULT NULL,
    `created_by`   varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COMMENT='题目标签表';
```





###### 2.6.3 题目关系表



```sql
DROP TABLE IF EXISTS `subject_mapping`;
CREATE TABLE `subject_mapping`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_id`   bigint(20) DEFAULT NULL COMMENT '题目id',
    `category_id`  bigint(20) DEFAULT NULL COMMENT '分类id',
    `label_id`     bigint(20) DEFAULT NULL COMMENT '标签id',
    `created_by`   varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) DEFAULT NULL COMMENT '修改人',
    `update_time`  datetime    DEFAULT NULL COMMENT '修改时间',
    `is_deleted`   int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=536 DEFAULT CHARSET=utf8 COMMENT='题目分类关系表';
```



###### 2.6.4 题目信息表



```sql
DROP TABLE IF EXISTS `subject_info`;
CREATE TABLE `subject_info`
(
    `id`                bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_name`      varchar(128) DEFAULT NULL COMMENT '题目名称',
    `subject_difficult` tinyint(4) DEFAULT NULL COMMENT '题目难度',
    `settle_name`       varchar(32)  DEFAULT NULL COMMENT '出题人名',
    `subject_type`      tinyint(4) DEFAULT NULL COMMENT '题目类型 1单选 2多选 3判断 4简答',
    `subject_score`     tinyint(4) DEFAULT NULL COMMENT '题目分数',
    `subject_parse`     varchar(512) DEFAULT NULL COMMENT '题目解析',
    `created_by`        varchar(32)  DEFAULT NULL COMMENT '创建人',
    `created_time`      datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`         varchar(32)  DEFAULT NULL COMMENT '修改人',
    `update_time`       datetime     DEFAULT NULL COMMENT '修改时间',
    `is_deleted`        int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=327 DEFAULT CHARSET=utf8 COMMENT='题目信息表';
```





###### 2.6.5 单选题



```sql
DROP TABLE IF EXISTS `subject_radio`;
CREATE TABLE `subject_radio`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_id`     bigint(20) DEFAULT NULL COMMENT '题目id',
    `option_type`    tinyint(4) DEFAULT NULL COMMENT 'a,b,c,d',
    `option_content` varchar(128) DEFAULT NULL COMMENT '选项内容',
    `is_correct`     tinyint(2) DEFAULT NULL COMMENT '是否正确',
    `created_by`     varchar(32)  DEFAULT NULL COMMENT '创建人',
    `created_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32)  DEFAULT NULL COMMENT '修改人',
    `update_time`    datetime     DEFAULT NULL COMMENT '修改时间',
    `is_deleted`     int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='单选题信息表';
```





###### 2.6.6 多选题



```sql
DROP TABLE IF EXISTS `subject_multiple`;
CREATE TABLE `subject_multiple`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_id`     bigint(20) DEFAULT NULL COMMENT '题目id',
    `option_type`    bigint(4) DEFAULT NULL COMMENT '选项类型',
    `option_content` varchar(64) DEFAULT NULL COMMENT '选项内容',
    `is_correct`     tinyint(2) DEFAULT NULL COMMENT '是否正确',
    `created_by`     varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time`   datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='多选题信息表';
```





###### 2.6.7 判断题



```sql
DROP TABLE IF EXISTS `subject_judge`;
CREATE TABLE `subject_judge`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_id`   bigint(20) DEFAULT NULL COMMENT '题目id',
    `is_correct`   tinyint(2) DEFAULT NULL COMMENT '是否正确',
    `created_by`   varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='判断题';
```





###### 2.6.8 简答题



```sql
DROP TABLE IF EXISTS `subject_brief`;
CREATE TABLE `subject_brief`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_id`     int(20) DEFAULT NULL COMMENT '题目id',
    `subject_answer` text COMMENT '题目答案',
    `created_by`     varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time`   datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=280 DEFAULT CHARSET=utf8 COMMENT='简答题';
```





一共 8 个



![image-20240812144347123](./assets/image-20240812144347123.png)



这个建模实在是鸡肋，鸡翅又在改表结构了



![image-20240812144831457](./assets/image-20240812144831457.png)



字符集暂时就这样吧



##### 2.7 Git仓库及代码骨架建立



我这儿用GitHub



![image-20240812145025583](./assets/image-20240812145025583.png)



![image-20240812145048209](./assets/image-20240812145048209.png)



换成 `-` ，以前踩过一个大坑



![image-20240812145110097](./assets/image-20240812145110097.png)





这里我直接用 IDEA 新建项目了



![image-20240812145441573](./assets/image-20240812145441573.png)



看了一下源码结构，分了很多模块，然后根就是 club ，JDK 版本用的 `1.8`



![image-20240812145557782](./assets/image-20240812145557782.png)



直接这样创建就行了，每个子工程才是一个 Maven 模块



![image-20240812145625568](./assets/image-20240812145625568.png)



甚至可以把这个 src 直接删了



![image-20240812145702200](./assets/image-20240812145702200.png)



直接关联到远程仓库



![image-20240812145743885](./assets/image-20240812145743885.png)



![image-20240812145817229](./assets/image-20240812145817229.png)



这样就行了

第一个 module ，刷题模块，甚至不是 springboot 工程，就是普通 Maven 模块



![image-20240812150040608](./assets/image-20240812150040608.png)



直接这样就行了



![image-20240812150129184](./assets/image-20240812150129184.png)



加一些东西，SRC 也可以直接干掉了



![image-20240812150253040](./assets/image-20240812150253040.png)



再新建模块



api 模块：



![image-20240812150344137](./assets/image-20240812150344137.png)





![image-20240812150513406](./assets/image-20240812150513406.png)



这就是 api 对外接口层了



下一个，application 应用层



![image-20240812150720043](./assets/image-20240812150720043.png)



![image-20240812150732927](./assets/image-20240812150732927.png)





下一个 domain 领域层



![image-20240812150830501](./assets/image-20240812150830501.png)



infra 基础措施层



![image-20240812150906153](./assets/image-20240812150906153.png)



starter  启动层



![image-20240812150958796](./assets/image-20240812150958796.png)



common 公共层



![image-20240812151036927](./assets/image-20240812151036927.png)



整体就是这样了，这其实就是个小的微服务



##### 2.8 代码骨架优化及二次回顾



api 层不要 resources



![image-20240812151429796](./assets/image-20240812151429796.png)



把本项目所有对外提供的接口放在这里面



starter 启动层， 不要 test ，无关任何业务，纯启动以及聚合当前包的能力



![image-20240812151525018](./assets/image-20240812151525018.png)



infra 基础措施层，关注自身底层交互的层



![image-20240812151741527](./assets/image-20240812151741527.png)



domain 层，关注领域能力



![image-20240812151910968](./assets/image-20240812151910968.png)



common 公共层



![image-20240812152133794](./assets/image-20240812152133794.png)



> 鸡翅老哥肯定还要改，视频里面这些模块一个全包都没有



application 应用层里面又建了三个新工程



![image-20240812152250392](./assets/image-20240812152250392.png)



![image-20240812152310296](./assets/image-20240812152310296.png)



![image-20240812152327961](./assets/image-20240812152327961.png)



这整个 application 负责接入数据





![image-20240812152513931](./assets/image-20240812152513931.png)



这就是 DDD 吗，炸裂





##### 2.9 项目结构调整



就是规整包名，我就说它要改吧



api 模块，其实这个项目用不到



![image-20240812152759367](./assets/image-20240812152759367.png)



starter 层



![image-20240812152851542](./assets/image-20240812152851542.png)



infra 层



![image-20240812153048479](./assets/image-20240812153048479.png)



domain 层



![image-20240812153144077](./assets/image-20240812153144077.png)





common 层



![image-20240812153236680](./assets/image-20240812153236680.png)





application 层



![image-20240812153521308](./assets/image-20240812153521308.png)





##### 2.10 SpringBoot 集成



居然用 `2.4.2`  的版本，，， 不能接受



![image-20240812154638934](./assets/image-20240812154638934.png)



我直接上 `2.7.6` 了



然后指定了仓库



![image-20240812154818549](./assets/image-20240812154818549.png)



这个感觉不是很有必要



然后就是 starter 层



![image-20240812155219404](./assets/image-20240812155219404.png)



来一个启动类



![image-20240812155434325](./assets/image-20240812155434325.png)



直接启动试试



![image-20240812155448043](./assets/image-20240812155448043.png)



8080 直接跑起来了



##### 2.11 应用层初探 & SpringMVC 集成



application 的 controller 层



![image-20240812155734608](./assets/image-20240812155734608.png)



这样就可以开始创建 controller  了



![image-20240812160121112](./assets/image-20240812160121112.png)



测试接口，然后在 starter 模块引入这个包



![image-20240812160535143](./assets/image-20240812160535143.png)



直接启动试试



![image-20240812160603461](./assets/image-20240812160603461.png)



没问题



##### 2.12 MySQL、Druid、Mybatis集成



在 infra 层



首先是依赖



![image-20240812161240736](./assets/image-20240812161240736.png)



这里数据库是 5.7 的，居然上了 8 的连接



![image-20240812162059706](./assets/image-20240812162059706.png)



这里用的 easycode 代码生成器，以防万一，我也用吧



![image-20240812162517922](./assets/image-20240812162517922.png)



![image-20240812162536901](./assets/image-20240812162536901.png)



先来这个分类表



![image-20240812162818804](./assets/image-20240812162818804.png)



![image-20240812162948250](./assets/image-20240812162948250.png)



dao 换到 mapper 下了



pageable 相关的东西全部删掉



![image-20240812163317370](./assets/image-20240812163317370.png)



不报错就行



在 starter 里面引入一下这个模块



![image-20240812163501629](./assets/image-20240812163501629.png)



写一下扫描



![image-20240812163606623](./assets/image-20240812163606623.png)



配置一下数据源



![image-20240812164354679](./assets/image-20240812164354679.png)



测试一下，记得在controller 层引入这个 infra 模块



![image-20240812164151916](./assets/image-20240812164151916.png)



启动测试一下



![image-20240812164420490](./assets/image-20240812164420490.png)



数据库肯定连上了



整两条数据

```sql
INSERT INTO `subject_category`
VALUES ('1', '后端', '1', 'https://image/category.icon', '0', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', null,
        null, '0');
INSERT INTO `subject_category`
VALUES ('2', '缓存', '2', 'https://image/category.icon', '1', 'oYA4HtwGJEsLio6pGrhx5Hzv9XD0', '2024-02-28 03:21:09', null,
        null, '0');
```



![image-20240812164709456](./assets/image-20240812164709456.png)



试试



![image-20240812165156534](./assets/image-20240812165156534.png)



没问题，查出来了



##### 2.13 基于Druid配置文件加密



![image-20240812165419683](./assets/image-20240812165419683.png)



这个地方是明文的，很明显，不安全



![image-20240812165523023](./assets/image-20240812165523023.png)



来一个工具类



![image-20240812165704186](./assets/image-20240812165704186.png)



公钥私钥都出来了





![image-20240812170048232](./assets/image-20240812170048232.png)



再试一次



![image-20240812170237129](./assets/image-20240812170237129.png)



可以，这样就在代码里面隐藏了我们的数据库密码



![image-20240812170301811](./assets/image-20240812170301811.png)



而且不影响使用



##### 2.14 分层架构的业务开发演示



这里



![image-20240812170603939](./assets/image-20240812170603939.png)



这里其实有点问题



![image-20240812170643514](./assets/image-20240812170643514.png)



就包括最后的源码中，其实并没有用到 plus，炸裂，这里我打算自己改一下了，用 `Mybatis X` 来生成代码



![image-20240812170757606](./assets/image-20240812170757606.png)



![image-20240812171432923](./assets/image-20240812171432923.png)



这样就行了，我还引入了 lombok，这个后面鸡翅也引入了，依赖放在 common 里面了







试试



![image-20240812171855443](./assets/image-20240812171855443.png)



没问题，能用



而且这 ... 不想这样写，直接上一个 Swagger 接口文档先



![image-20240812173048437](./assets/image-20240812173048437.png)



集成完毕



![image-20240812173103704](./assets/image-20240812173103704.png)



没毛病



common 里面加了 依赖



![image-20240812173848555](./assets/image-20240812173848555.png)



在 infra 里面引一下



![image-20240812174254755](./assets/image-20240812174254755.png)



![image-20240812174610202](./assets/image-20240812174610202.png)



其实这里不受影响就好了



这里换到了 domain 层，来调，domain 层关注领域能力，在这层去调 infra 基础设施层



先引包



![image-20240812175151303](./assets/image-20240812175151303.png)



![image-20240812175843178](./assets/image-20240812175843178.png)



domain 中 实现了一个插入方法



然后在 controller 想去调用



![image-20240812175942370](./assets/image-20240812175942370.png)



先引进来，然后【这里说到一个东西，用infra 还是 domain，都可以的】



先封装一个通用返回



![image-20240812181219514](./assets/image-20240812181219514.png)



![image-20240812181732386](./assets/image-20240812181732386.png)



这里其实已经能用了，但是现在要加上日志的处理



![image-20240812181940255](./assets/image-20240812181940255.png)



先测试一下



![image-20240812182000200](./assets/image-20240812182000200.png)



直接在 swagger 里面进行调试了



![image-20240812182122167](./assets/image-20240812182122167-1723458082620-1.png)



随便整一个



![image-20240812182514871](./assets/image-20240812182514871.png)



我这里没插进去



![image-20240812182924266](./assets/image-20240812182924266.png)



改了一下， 字段没对上，再试一次



![image-20240812183021325](./assets/image-20240812183021325.png)



再试一次，不知道为什么，我生成的代码没有按照驼峰



我改成和鸡翅一样的了

![image-20240812192712376](./assets/image-20240812192712376.png)



成功了



![image-20240812192931293](./assets/image-20240812192931293.png)



我后面又改回去了



![image-20240812193508687](./assets/image-20240812193508687.png)



![image-20240812193527982](./assets/image-20240812193527982.png)



改成真正意义上的plus ，还是成功了，因为我执行了 clean，然后重新运行 ，就离谱



![image-20240812193807357](./assets/image-20240812193807357.png)



还加了一些 plus 的配置，成功了



##### 2.15 日志log4j2集成



放 common 里，还有一个 JSON 解析的



![image-20240813142336871](./assets/image-20240813142336871.png)



common 不用引了，我们在infra 里面引了，controller 又引了 infra ，所以依赖传递



在 controller 加一个日志打印



![image-20240813142737952](./assets/image-20240813142737952.png)



这里可以打印 DTO 长什么样子



![image-20240813142800722](./assets/image-20240813142800722.png)



这里可以看到 BO 是什么样子，最后那层就不加了，我这儿是用的 plus



还要有个配置文件



![image-20240813143133234](./assets/image-20240813143133234.png)



加载



![image-20240813143230925](./assets/image-20240813143230925.png)



还要把 boot 带的那个排除一下



![image-20240813143523160](./assets/image-20240813143523160.png)



重启试试





![image-20240813143550773](./assets/image-20240813143550773.png)



启动成功，这下插入试试



![image-20240813143712583](./assets/image-20240813143712583.png)



![image-20240813143721080](./assets/image-20240813143721080.png)



日志也都出来了，当然也可以使用 AOP 来做切面编程



##### 2.16 precondions的参数校验



第一种是用 guava



![image-20240813144117133](./assets/image-20240813144117133.png)



还有 commons-lang



![image-20240813144343521](./assets/image-20240813144343521.png)



修改 controller，在后端做一次校验



![image-20240813144425711](./assets/image-20240813144425711.png)



效果：



![image-20240813144944283](./assets/image-20240813144944283.png)



没问题



##### 2.17 刷题模块分类接口定义



分类模块

分类的概念是面试题的大类。其中我们有两种概念，一种是岗位分类，例如后端，前端，测试。一种是岗位下细分的分类，比如后端下细分，框架，并发，集合等等。



- 新增分类【已做】

- 查询分类

  ![image-20240813145944508](./assets/image-20240813145944508.png)

- 查询大类下分类

  ![image-20240813150343235](./assets/image-20240813150343235.png)

- 查询分类及标签

  ![image-20240813150511348](./assets/image-20240813150511348.png)



设计了半天的接口，没有上代码，



当然可以直接在一个接口中全部搞出来



![image-20240813150721700](./assets/image-20240813150721700.png)



不知道为啥硬要分这么多期



##### 2.18 题目列表及详情接口定义



题目分为单选，多选，判断，简单，四种数据类型，在设计数据的时候，我们去拆分成了题目的主表和其他对应的表来做。



按照原型图设计了一下请求参数和响应



- 查询题目列表

  ![image-20240813151144256](./assets/image-20240813151144256.png)

  ![image-20240813151225607](./assets/image-20240813151225607.png)

- 查询题目详情

  ![image-20240813151405632](./assets/image-20240813151405632.png)

  ![image-20240813151425044](./assets/image-20240813151425044.png)





##### 2.19 分类接口开发



![image-20240813153214757](./assets/image-20240813153214757.png)



![image-20240813153152468](./assets/image-20240813153152468.png)



这里为啥不用 querymapper 呢，而且你一直说你业务不熟练，那你还卖课 ... 



##### 2.20 根据岗位查询分类接口开发



![image-20240813153435112](./assets/image-20240813153435112.png)



![image-20240813153749768](./assets/image-20240813153749768.png)



换了一下错误的日志，



试一下，啥也不传



![image-20240813153816864](./assets/image-20240813153816864.png)



带上分类 ID，是这个 parent_id



![image-20240813153928889](./assets/image-20240813153928889.png)



没问题



##### 2.21 标签及题目接口定义



这里莫名其妙就多了一个更新接口，好好好



哈哈哈，其实他还没做



![image-20240813160158298](./assets/image-20240813160158298.png)





还有删除分类接口



![image-20240813160227017](./assets/image-20240813160227017.png)



新增标签也写了【看错了，是定义】



题目标签：

- 新增标签

  ![image-20240813160255347](./assets/image-20240813160255347.png)

- 更新标签

  ![image-20240813160327037](./assets/image-20240813160327037.png)

- 删除标签

  ![image-20240813160342287](./assets/image-20240813160342287.png)

- 根据分类查询标签

  ![image-20240813160355762](./assets/image-20240813160355762.png)



题目模块：

- 新增题目

  ![image-20240813160405680](./assets/image-20240813160405680.png)

- 查询题目列表

  ![image-20240813160422942](./assets/image-20240813160422942.png)

- 查询题目详情

  ![image-20240813160430909](./assets/image-20240813160430909.png)







##### 2.22 分类模块接口开发



更新分类接口



![image-20240813154450071](./assets/image-20240813154450071.png)



我自己加上试试 





![image-20240813154552819](./assets/image-20240813154552819.png)



![image-20240813154558852](./assets/image-20240813154558852.png)



删除分类接口



应该是逻辑删除



![image-20240813154815125](./assets/image-20240813154815125.png)



![image-20240813154850711](./assets/image-20240813154850711.png)



没问题



![image-20240813154859997](./assets/image-20240813154859997.png)



好了



![image-20240813161019502](./assets/image-20240813161019502.png)



我是直接用了 plus 的实现，直接removebyId，哈哈哈哈



这里把分类模块全部接口都测了一遍，没啥问题



![image-20240813163828177](./assets/image-20240813163828177.png)



那个时间说的是之后会处理



##### 2.23 标签基础模块开发



![image-20240813164113029](./assets/image-20240813164113029.png)



就是这张表，直接代码生成器



![image-20240813164534767](./assets/image-20240813164534767.png)



这里没用 鸡翅那个，还是用的 `mybatis -X` 【easycode 不喜欢】



新建controller ，这里我还是选择了用 plus 的方式，直接写了增删改 三个接口



![image-20240813170052338](./assets/image-20240813170052338.png)



![image-20240813170203568](./assets/image-20240813170203568.png)



其实标签字段可以直接用 json 字段存啊，



![image-20240813170326609](./assets/image-20240813170326609.png)



对这个关系表也动一个代码生成器



##### 2.24 分类下标签接口开发



![image-20240813170658729](./assets/image-20240813170658729.png)



代码生成完成，实现之前的那个接口，分类下查出所有标签那个接口



![image-20240813172807428](./assets/image-20240813172807428.png)



##### 2.25 接口测试



标签接口就大致完成，完整测试一下



新增标签



![image-20240813173117360](./assets/image-20240813173117360.png)



![image-20240813173129344](./assets/image-20240813173129344.png)



没问题，多来几个

![image-20240813173311167](./assets/image-20240813173311167.png)



更新标签



![image-20240813173359147](./assets/image-20240813173359147.png)



没问题



删除标签



![image-20240813173457545](./assets/image-20240813173457545.png)



没问题



查询分类下标签



给 mapping 做点数据



![image-20240813174201332](./assets/image-20240813174201332.png)



然后查一下



![image-20240813174222070](./assets/image-20240813174222070.png)



没问题



##### 2.26 新增题目接口开发（题目映射处理）



新增题目接口



![image-20240813175531671](./assets/image-20240813175531671.png)



还是先生成基础代码，五个表全部生成，题目信息、单选、多选、简答、判断



![image-20240813175919545](./assets/image-20240813175919545.png)



![image-20240813175924926](./assets/image-20240813175924926.png)



![image-20240813180248416](./assets/image-20240813180248416.png)



依然是 plus 的形式



还是 controller 直接开始



![image-20240813192454896](./assets/image-20240813192454896.png)



这里的实现上了策略和工厂模式



![image-20240813192626211](./assets/image-20240813192626211.png)



info 主表的插入其实就这样就行了，但是还有四种类型的题目，也要插入



![image-20240813195936676](./assets/image-20240813195936676.png)



【这里没有测试】，讲得真的烂，视频也杂乱，【 网盘第 33 集 和 32 集的结尾是重复的】





##### 2.27 分页处理封装



入参



![image-20240813200522681](./assets/image-20240813200522681.png)



返回实体



![image-20240813200628515](./assets/image-20240813200628515.png)



这里居然没有用 mybatis-plus 的分页插件





##### 2.28 题目列表开发



![image-20240813201339067](./assets/image-20240813201339067.png)



日志改了一下



##### 2.29 查询题目信息接口开发



![image-20240813203437639](./assets/image-20240813203437639.png)



太随意了，不写就不写



##### 2.30 新增题目接口测试



新增单选题目



```
{
  "categoryIds": [
        4,
        5
   ],
  "labelIds": [
      2, 
      3
   ],
  "optionList": [
    {
      "isCorrect": 1,
      "optionContent": "自动的",
      "optionType": 1
    },
    {
      "isCorrect": 0,
      "optionContent": "其实是用配置文件",
      "optionType": 2
    }
  ],
  "subjectDifficult": 1,
  "subjectName": "SpringBoot自动装配原理是什么？",
  "subjectParse": "题目解析",
  "subjectScore": 2,
  "subjectType": 1
}
```



![image-20240813204602581](./assets/image-20240813204602581.png)



创建成功



数据库

![image-20240813204657927](./assets/image-20240813204657927.png)



![image-20240813204737805](./assets/image-20240813204737805.png)



有点小问题，对应的问题 id 没插进来，还有默认的未删除也没有生效



看下mapping



![image-20240813204857964](./assets/image-20240813204857964.png)



这设计的 ... 一言难尽



![image-20240813205142714](./assets/image-20240813205142714.png)



这里我可以直接不传就可以自动设置了



![image-20240813205229256](./assets/image-20240813205229256.png)



mapping 这里也是



![image-20240813205330344](./assets/image-20240813205330344.png)



多选也是



![image-20240813205745388](./assets/image-20240813205745388.png)



还加上了事务注解



然后就是那个关联的题目 id



![image-20240813210037854](./assets/image-20240813210037854.png)



plus 框架会设置上去，我们直接拿就行了



再试一次

![image-20240813210221452](./assets/image-20240813210221452.png)



插入成功，看看数据库



题目信息



![image-20240813210237043](./assets/image-20240813210237043.png)



单选题目表



![image-20240813210248269](./assets/image-20240813210248269.png)



关系表



![image-20240813210306731](./assets/image-20240813210306731.png)



没问题



新增多选题



![image-20240813210807076](./assets/image-20240813210807076.png)



就是正确答案两个都设置成 1 了，当然这只是个例子，数据库，改一下题目类型为 2 就行，忘记改了艹



![image-20240813211308832](./assets/image-20240813211308832.png)



再来一次，数据库



![image-20240813211329838](./assets/image-20240813211329838.png)





![image-20240813211337885](./assets/image-20240813211337885.png)



关联题目 id 是 2



关系表



![image-20240813211351543](./assets/image-20240813211351543.png)



没问题



插入判断题目



![image-20240813211751284](./assets/image-20240813211751284.png)



成功，数据库



![image-20240813211821362](./assets/image-20240813211821362.png)



判断题版

![image-20240813211834602](./assets/image-20240813211834602.png)



直接就插进来了



![image-20240813211847032](./assets/image-20240813211847032.png)



关系表也没有问题



新增简答题：



![image-20240813212150304](./assets/image-20240813212150304.png)



报错了



![image-20240813212318864](./assets/image-20240813212318864.png)



有地方空指针了



![image-20240813212519208](./assets/image-20240813212519208.png)



type 写错了，写成 6 了，没这种题目，再试一次



![image-20240813212545373](./assets/image-20240813212545373.png)



OK，数据库



![image-20240813212559432](./assets/image-20240813212559432.png)



题目表没问题



![image-20240813212611488](./assets/image-20240813212611488.png)



没问题



![image-20240813212650759](./assets/image-20240813212650759.png)



关系表，有一点问题，这个简答他自己的 id 居然从5开始的



![image-20240813212843443](./assets/image-20240813212843443.png)



感觉是这种原因



![image-20240813212858105](./assets/image-20240813212858105.png)



因为这儿的 id 也不是 4，可以手动改 了【算了，不用关心了，之前有误操作】



![image-20240813213915911](./assets/image-20240813213915911.png)



我发现一个问题，截断表、重建表都没用



![image-20240813214751725](./assets/image-20240813214751725.png)



没救了，truncate 也不行



![image-20240813215135659](./assets/image-20240813215135659.png)



绝了



![image-20240813215934545](./assets/image-20240813215934545.png)



我把这儿手动置空了一下就行了，离谱，没看懂，它好像直接把题目 id 拿过来继承了



![image-20240813220203045](./assets/image-20240813220203045.png)



这样肯定也行，之前那个转换，把 题目 id 一块拿过来了



![image-20240813220334820](./assets/image-20240813220334820.png)



没毛病



##### 2.31 jacksonconverter初探 & 查询题目列表测试



![image-20240813220848998](./assets/image-20240813220848998.png)



我这儿的分页倒是直接就返回了【鸡翅那报了错，然后说加上一个配置】



![image-20240814094709054](./assets/image-20240814094709054.png)



这样可以避免外面传空参时直接报错的问题



![image-20240814094839279](./assets/image-20240814094839279.png)



没影响，但是如果我把 type 条件去掉



![image-20240814095431916](./assets/image-20240814095431916.png)



会查出来 5 个，前两个是一毛一样的



![image-20240814095534565](./assets/image-20240814095534565.png)



看出来了， mapping 表里面有两条脏数据，这下可以了



##### 2.32 空值全局处理



![image-20240814095651132](./assets/image-20240814095651132.png)



其实我这里并没有出现鸡翅的问题



![image-20240814095726882](./assets/image-20240814095726882.png)



这样就行了，直接在配置类里面配置【但是鸡翅的还是没有把标签信息带上的】



##### 2.33 查询题目测试



简答题



![image-20240814100504330](./assets/image-20240814100504330.png)



 判断题



![image-20240814100608707](./assets/image-20240814100608707.png)



答案也查出来了



单选



![image-20240814100637761](./assets/image-20240814100637761.png)



只有一个正确答案

多选



![image-20240814100700526](./assets/image-20240814100700526.png)



多个正确答案【没问题】



##### 2.34 SQL拦截器自动翻译



其实这个我之前就已经做了



![image-20240814101021974](./assets/image-20240814101021974.png)



看日志



![image-20240814101120072](./assets/image-20240814101120072.png)



现在要做的是对这些问号进行一些处理，让查询更直观



在 infra 层



![image-20240814101321969](./assets/image-20240814101321969.png)



![image-20240814101355556](./assets/image-20240814101355556.png)



注入



![image-20240814101437299](./assets/image-20240814101437299.png)



之前那个 yml 配置就可以不要了，直接重启看看



![image-20240814101518311](./assets/image-20240814101518311.png)



![image-20240814101633246](./assets/image-20240814101633246.png)



现在的日志



![image-20240814101651006](./assets/image-20240814101651006.png)



没毛病啊



##### 2.35 域名购买



![image-20240814101902376](./assets/image-20240814101902376.png)



买一个吧



![image-20240814102530740](./assets/image-20240814102530740.png)



先搞一个信息模板



![image-20240814102614632](./assets/image-20240814102614632.png)



当然我之前已经搞过了



直接注册域名



![image-20240814102643665](./assets/image-20240814102643665.png)



![image-20240814102734440](./assets/image-20240814102734440.png)



就这了



![image-20240814102802312](./assets/image-20240814102802312.png)



直接买了，这玩意儿首年都便宜，他就是一个解析的作用





![image-20240814102855419](./assets/image-20240814102855419.png)





##### 2.36 传统部署形式



到现在刷题模块貌似就差不多了



![image-20240814103529898](./assets/image-20240814103529898.png)



这里又开始讲得稀碎了，这个插件我选择了和我springboot 一样的版本 `2.7.6`



直接 clean 然后 install 



![image-20240814103717576](./assets/image-20240814103717576.png)



就出了一个这个东西，先试试在本地运行 `java -jar` 命令



![image-20240814103901259](./assets/image-20240814103901259.png)



没问题，下面是自动部署的方式



##### 2.37 CICD jenckins 实现自动打包持续集成



`docker search jenkins`



![image-20240814104202579](./assets/image-20240814104202579.png)



拉取镜像 `docker pull jenkins/jenkins:lts` 





![image-20240814104340607](./assets/image-20240814104340607.png)



这个就相当慢了



![image-20240814104744150](./assets/image-20240814104744150.png)



等拉下来



![image-20240814105107784](./assets/image-20240814105107784.png)



启动容器：



要先有一个 java 环境



```
yum install -y java-1.8.0-openjdk.x86_64
```



![image-20240814105212187](./assets/image-20240814105212187.png)



![image-20240814105222225](./assets/image-20240814105222225.png)



然后启动Jenkins 容器



```docker
docker run -d -u root -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home -v /etc/localtime:/etc/localtime --name jenkins jenkins/jenkins:lts
```



![image-20240814105424968](./assets/image-20240814105424968.png)



开个端口



![image-20240814105403662](./assets/image-20240814105403662.png)





访问



![image-20240814105514156](./assets/image-20240814105514156.png)



![image-20240814105622528](./assets/image-20240814105622528.png)



复制过去



![image-20240814105655500](./assets/image-20240814105655500.png)



![image-20240814105711420](./assets/image-20240814105711420.png)



初始化工作



![image-20240814105727919](./assets/image-20240814105727919.png)



安装推荐的插件



![image-20240814105840229](./assets/image-20240814105840229.png)



等他安装就行了



感觉还要在Linux 上搞一个 Maven



![image-20240814110711058](./assets/image-20240814110711058.png)



随便整了一下



![image-20240814110725357](./assets/image-20240814110725357.png)



![image-20240814110221844](./assets/image-20240814110221844.png)



进来了

![image-20240814110816229](./assets/image-20240814110816229.png)



保存并完成



![image-20240814110835580](./assets/image-20240814110835580.png)



保存并完成



![image-20240814110849367](./assets/image-20240814110849367.png)



开始使用



![image-20240814110904759](./assets/image-20240814110904759.png)



哇哦



直接整一个 item 项目



![image-20240814111134903](./assets/image-20240814111134903.png)





![image-20240814111153242](./assets/image-20240814111153242.png)





![image-20240814111456974](./assets/image-20240814111456974.png)



保存



![image-20240814111619715](./assets/image-20240814111619715.png)







回到仪表盘



![image-20240814111639936](./assets/image-20240814111639936.png)





![image-20240814111656169](./assets/image-20240814111656169.png)



直接开始构建



![image-20240814111710873](./assets/image-20240814111710873.png)



![image-20240814111747294](./assets/image-20240814111747294.png)



这里是直接报错了



![image-20240814112129715](./assets/image-20240814112129715.png)



感觉就是拉不下来



![image-20240814113017196](./assets/image-20240814113017196.png)



试了好多次



![image-20240814113032017](./assets/image-20240814113032017.png)



卡在拉代码，擦



![image-20240814113144831](./assets/image-20240814113144831.png)



再试，我把 `https` 改成 `http`  了，太慢了，可能是我把那个图片也传上去了



![image-20240814113340561](./assets/image-20240814113340561.png)



丢，还是连不上【有没有可能是因为 GitHub 它就是连接不上，试试 Gitee，好久没用了】



![image-20240814115236663](./assets/image-20240814115236663.png)



看看这次效果怎么说



![image-20240814115331564](./assets/image-20240814115331564.png)



这次就成功了，离谱，果然是GitHub的原因



![image-20240814115409762](./assets/image-20240814115409762.png)



而且就放在这里了，还要配置一下构建



![image-20240814115631564](./assets/image-20240814115631564.png)



试试



![image-20240814115735146](./assets/image-20240814115735146.png)



额



![image-20240814115800364](./assets/image-20240814115800364.png)



行，直接拷贝一份过去就行



![image-20240814120102607](./assets/image-20240814120102607.png)



![image-20240814120122675](./assets/image-20240814120122675.png)



这里面就有了， `/var/jenkins_home/apache-maven-3.9.8`



![image-20240814120304656](./assets/image-20240814120304656.png)



![image-20240814120339704](./assets/image-20240814120339704.png)



再试一次



![image-20240814120420699](./assets/image-20240814120420699.png)



![image-20240814120627236](./assets/image-20240814120627236.png)



它是在说找不到 pom



![image-20240814120801379](./assets/image-20240814120801379.png)



再试一次



![image-20240814120818504](./assets/image-20240814120818504.png)



可以了，开始构建了，在下jar 包



![image-20240814121046949](./assets/image-20240814121046949.png)



一次成功，厉害了



![image-20240814121208645](./assets/image-20240814121208645.png)



而且放到了我们的 Maven 仓库里面【虽然我并没有找到】



![image-20240814121412100](./assets/image-20240814121412100.png)



但是确实是打包成功了，试试直接启动



![image-20240814121520518](./assets/image-20240814121520518.png)



没问题，也可以启动成功，尝试调用一下接口，开个端口



![image-20240814121658086](./assets/image-20240814121658086.png)



试试



![image-20240814121950550](./assets/image-20240814121950550.png)



没问题，



![image-20240814122025529](./assets/image-20240814122025529.png)



服务器这边也出日志了，当然现在还是我们手动启动的，下面就要上脚本来配合了





##### 2.38 Jenkins配合shell实现自动部署



![image-20240814122505447](./assets/image-20240814122505447.png)



就我们再次执行这个构建，它会自己去拉新的代码的



![image-20240814122531457](./assets/image-20240814122531457.png)



直接也是成功了



![image-20240814122559861](./assets/image-20240814122559861.png)



没问题，确实是最新的



![image-20240814122629466](./assets/image-20240814122629466.png)



而且最新的 jar 包 也打出来了，当然我这里是刚刚手动把项目停掉了



![image-20240814122748926](./assets/image-20240814122748926.png)



现在就没有，我们现在要做的，是在构建的时候让项目自动也跑起来 



![image-20240814122938900](./assets/image-20240814122938900.png)



在 clean 和 install 完成后，执行脚本



这里要配置一下 SSH 服务器



![image-20240814123137768](./assets/image-20240814123137768.png)



先下一个这个插件



![image-20240814123204356](./assets/image-20240814123204356.png)



![image-20240814123211423](./assets/image-20240814123211423.png)



完成之后，返回



![image-20240814123248819](./assets/image-20240814123248819.png)





![image-20240814123411353](./assets/image-20240814123411353.png)



这里新增一个



![image-20240814123528555](./assets/image-20240814123528555.png)



就真实想部署项目的服务器 ip



![image-20240814131055679](./assets/image-20240814131055679.png)



这里要输入服务器的密码



![image-20240814131432418](./assets/image-20240814131432418.png)



测试链接成功就行，保存



再回来



![image-20240814131527801](./assets/image-20240814131527801.png)



这下就可以执行 ssh 命令了



![image-20240814131634775](./assets/image-20240814131634775.png)



这里用了一大段脚本呢



![image-20240814131756116](./assets/image-20240814131756116.png)





```shell
cp /var/jenkins_home/workspace/xiong-club-subject/xiong-club-subject/xiong-club-starter/target/xiong-club-starter.jar /var/jenkins_home/jar/
#!/bin/bash
APP_NAME=xiong-club-starter.jar
LOG_NAME=xiong-club-starter.log

pid=`ps -ef | grep $APP_NAME | grep -v grep|awk '{print $2}'`

function is_exist(){
pid=`ps -ef | grep $APP_NAME | grep -v grep|awk '{print $2}'`
if [ -z ${pid} ]; then
String="notExist"
echo $String
else
String="exist"
echo $String
fi
}

str=$(is_exist)
if [ ${str} = "exist" ]; then
echo " 检测到已经启动的程序，pid 是 ${pid} "
kill -9 $pid
else
echo " 程序没有启动了 "
echo "${APP_NAME} is not running"
fi

str=$(is_exist)
if [ ${str} = "exist" ]; then
echo "${APP_NAME} 已经启动了. pid=${pid} ."
else
source /etc/profile
BUILD_ID=dontKillMe
nohup java -Xms300m -Xmx300m -jar /var/jenkins_home/jar/$APP_NAME   >$LOG_NAME 2>&1 &
echo "程序已重新启动..."
fi
```



保存，再试一次，试试



![image-20240814131916764](./assets/image-20240814131916764.png)





![image-20240814131939884](./assets/image-20240814131939884.png)



构建成功了，看看有没有跑起来



![image-20240814131956920](./assets/image-20240814131956920.png)



确实是复制过去了



![image-20240814132012519](./assets/image-20240814132012519.png)



厉害了，跑起来了，后台启动的



试试接口



![image-20240814132048912](./assets/image-20240814132048912.png)



没问题，这样就完成了全自动了，我超



![image-20240814132223910](./assets/image-20240814132223910.png)



厉害，这就是自动部署



##### 2.39 docker 安装 minio



【搭建自己的 oos 服务器】



```
docker search minio
```



![image-20240814132422872](./assets/image-20240814132422872.png)



```
docker pull minio/minio
```



![image-20240814132527678](./assets/image-20240814132527678.png)



这里又要等一下了



![image-20240814132707633](./assets/image-20240814132707633.png)



OK，直接启动容器



```
docker run -p 9000:9000 -p 9090:9090 \
 --name minio \
 -d --restart=always \
 -e "MINIO_ACCESS_KEY=minioadmin" \
 -e "MINIO_SECRET_KEY=minioadmin" \
 -v /mydata/minio/data:/data \
 minio/minio server \
 /data --console-address ":9090" -address ":9000"
```



![image-20240814133002604](./assets/image-20240814133002604.png)



开个端口：



![image-20240814133024246](./assets/image-20240814133024246.png)



9090 也要开应该



![image-20240814133119609](./assets/image-20240814133119609.png)





![image-20240814133136331](./assets/image-20240814133136331.png)





![image-20240814133142071](./assets/image-20240814133142071.png)



出来了



![image-20240814133220155](./assets/image-20240814133220155.png)



密码就是之前设置那个



![image-20240814133233863](./assets/image-20240814133233863.png)



这样就直接进来了，这和 阿里云 oos 还是很像的，当然我们要通过代码来操作这个东西



##### 2.40 oss 服务抽取思想以及模块开发



就是要单独做一个服务



新的 Maven 模块



![image-20240814133614332](./assets/image-20240814133614332.png)



![image-20240814133711285](./assets/image-20240814133711285.png)



这个就是我们专门的对象存储服务，对外提供接口就行了



加依赖



![image-20240814134035662](./assets/image-20240814134035662.png)



这个服务跑在 4000 端口



![image-20240814134232942](./assets/image-20240814134232942.png)



能跑起来就行



![image-20240814134400755](./assets/image-20240814134400755.png)



加上 minio  的依赖

新增配置类



![image-20240814134429779](./assets/image-20240814134429779.png)



工具类



![image-20240814134652704](./assets/image-20240814134652704.png)



##### 2.41 minio 初步测试



![image-20240814135434472](./assets/image-20240814135434472.png)



启动试试，随便创建一个桶先



![image-20240814135555334](./assets/image-20240814135555334.png)



![image-20240814135559667](./assets/image-20240814135559667.png)



调用接口



![image-20240814135659565](./assets/image-20240814135659565.png)



没问题





##### 2.42 oss 模块扩展 & 传统 service & 抽取 fileService & 适配器模式详解与改造



这里用到适配器模式了，之前是用到原始的接口然后每种 oss 服务都去搞一个实现类，



先抽取出 fileService 



![image-20240814140802241](./assets/image-20240814140802241.png)



![image-20240814140813465](./assets/image-20240814140813465.png)



如果改成 aliyun



![image-20240814141008347](./assets/image-20240814141008347.png)



当然这是返回的死的，



![image-20240814141022661](./assets/image-20240814141022661.png)



我们没有用 阿里云的 oss，适配器就是为了封装适配各种接口，解决可能存在的不兼容的问题





##### 2.43 Docker 安装 nacos 及动态配置



![image-20240814141845011](./assets/image-20240814141845011.png)



现在的问题，虽然有了适配器，但是想要切换，还是得来改这个 `yml` 文件，nacos 就可以作为一个配置中心



来吧，安装



```
docker search nacos
```



![image-20240814142121882](./assets/image-20240814142121882.png)



我这小 8 G 感觉都要不够用了 



```
docker pull nacos/nacos-server
```



![image-20240814142256907](./assets/image-20240814142256907.png)



等待完成



![image-20240814142436122](./assets/image-20240814142436122.png)



启动容器



```
docker run -d \
  --name nacos \
  --privileged  \
  --cgroupns host \
  --env JVM_XMX=256m \
 --env MODE=standalone \
  --env JVM_XMS=256m \
  -p 8848:8848/tcp \
  -p 9848:9848/tcp \
  --restart=always \
  -w /home/nacos \
  nacos/nacos-server
```



![image-20240814142521648](./assets/image-20240814142521648.png)



开个端口 8848 



![image-20240814142336045](./assets/image-20240814142336045.png)



访问一下啊

![image-20240814142731471](./assets/image-20240814142731471.png)



没问题

新建一个 配置



![image-20240814142853080](./assets/image-20240814142853080.png)



就在 public 下



![image-20240814142942260](./assets/image-20240814142942260.png)



直接发布



![image-20240814142957936](./assets/image-20240814142957936.png)



这样就存下来了



##### 2.44 nacos 实现属性动态切换



加入依赖



![image-20240814143228943](./assets/image-20240814143228943.png)



单体就用这个，之后换微服务还会换



还要一个日志



![image-20240814143427114](./assets/image-20240814143427114.png)



之前都写错了，我们用的 `2.7.6 `



![image-20240814143452022](./assets/image-20240814143452022.png)



这里也是



配置一下

![image-20240814143747041](./assets/image-20240814143747041.png)



测试一下



![image-20240814144055872](./assets/image-20240814144055872.png)



其实日志都能看见，已经连上了



![image-20240814144132685](./assets/image-20240814144132685.png)



这个读取到的就是我们 nacos 配置中心里面的配置了，在界面重新发布



![image-20240814144232161](./assets/image-20240814144232161.png)



![image-20240814144236363](./assets/image-20240814144236363.png)



![image-20240814144242145](./assets/image-20240814144242145.png)



直接再次请求



![image-20240814144321576](./assets/image-20240814144321576.png)



擦，我的没刷新，噢噢噢噢，还要开一个 9848 的端口



![image-20240814145638932](./assets/image-20240814145638932.png)



再试一次

现在配置中心是 



![image-20240814145700990](./assets/image-20240814145700990.png)



![image-20240814145735163](./assets/image-20240814145735163.png)



这次没问题了，直接改成 minio 试试



![image-20240814145801258](./assets/image-20240814145801258.png)



直接再请求



![image-20240814145815171](./assets/image-20240814145815171.png)



成功了, 蛙趣



##### 2.45 nacos 实现 bean 动态加载



现在的问题是值虽然能动态改变了，但是加载的实现类，就是我们那个适配器没变啊



![image-20240814150226488](./assets/image-20240814150226488.png)



这就解决这个问题，现在就要换依赖了

 

![image-20240814150426100](./assets/image-20240814150426100.png)



这里我随便上了一个要新不新的版本，先用着吧，有问题再说



![image-20240814150935815](./assets/image-20240814150935815.png)

感觉上一个 



![image-20240814151136595](./assets/image-20240814151136595.png)



官方也没有写 2.7 用啥版本，差不多就得了，上个 2021 的我觉得差不多



![image-20240814151233894](./assets/image-20240814151233894.png)



就决定是你了！ 别让我失望



新建配置文件



![image-20240814151818583](./assets/image-20240814151818583.png)



![image-20240814151753952](./assets/image-20240814151753952.png)



application 中留这些就行了



并且新建一个配置



![image-20240814151733452](./assets/image-20240814151733452.png)



![image-20240814151739365](./assets/image-20240814151739365.png)



![image-20240814151908359](./assets/image-20240814151908359.png)



这两个地方加上注解



![image-20240814152334238](./assets/image-20240814152334238.png)



好，还是让我失望了



![image-20240814152412718](./assets/image-20240814152412718.png)



换成这个再试一次



![image-20240814154227780](./assets/image-20240814154227780.png)



东搞西搞还是被我搞出来了



![image-20240814154307989](./assets/image-20240814154307989.png)



没问题，我直接修改配置文件看看会不会刷新 bean



![image-20240814154345159](./assets/image-20240814154345159.png)



日志明显动了一下啊



![image-20240814154406620](./assets/image-20240814154406620.png)



牛逼！！！！卧槽！！！！



![image-20240814154942916](./assets/image-20240814154942916.png)



我又改回来了，没毛病



![image-20240814155121741](./assets/image-20240814155121741.png)



确实是有一个监听在的



##### 2.46 标签业务改动



要涉及到和分类做交互，之前其实我没有删



![image-20240814155744867](./assets/image-20240814155744867.png)



就这个东西，我用的 plus ，就没改啥东西



不知道改了些啥，启动刷题服务测试一下



![image-20240814160240444](./assets/image-20240814160240444.png)



其实就是要把这个给加上了



![image-20240814161214429](./assets/image-20240814161214429.png)



新增成功，看看分类 id 有没有带上



![image-20240814161254195](./assets/image-20240814161254195.png)



没问题，带上了，之前新增的时候没有带上这个



查询的时候



![image-20240814161754851](./assets/image-20240814161754851.png)



![image-20240814161811032](./assets/image-20240814161811032.png)



还是要改一下接口，之前实现那个逻辑是根据 mapping 匹配来查的



![image-20240814161934569](./assets/image-20240814161934569.png)



1 没有匹配的，当然查不出来了，如果查 4 



![image-20240814162000304](./assets/image-20240814162000304.png)



4 就能出2 和 3 的标签



所以现在又在改代码了，改完之后，如果直接 查 1



![image-20240814163637235](./assets/image-20240814163637235.png)



没问题，直接把 MySQL 查出来了



![image-20240814163653725](./assets/image-20240814163653725.png)





##### 2.47 阿里云脚手架工具



https://start.aliyun.com/



![image-20240814163752730](./assets/image-20240814163752730.png)



讲了下怎么通过这个来帮忙减少版本冲突，



![image-20240814164001133](./assets/image-20240814164001133.png)



嗦嘎，之前我强行试出来的 



![image-20240814164024765](./assets/image-20240814164024765.png)



这个版本对应关系就肯定没问题的



![image-20240814164053517](./assets/image-20240814164053517.png)



我强行试出来的，6666



##### 2.48 登录鉴权框架初探



https://gitee.com/dromara/sa-token，用的这个



![image-20240814164328118](./assets/image-20240814164328118.png)





##### 2.49 鉴权设计-RBAC模型讲解



RBAC 模型（role-based access control）

非常成熟的安全的模型概念，基于角色帮助我们把授权和用户的访问控制来做结合。

User（用户）用户就是指我们的系统使用者。

PerMission（权限）用户我们对系统的操作，访问哪些东西，可以操作写入操作等等。实际的例子，比如新增题目。

Role（角色）我们去把一组的权限，去做集合，就得到了角色。

核心思想其实就是把角色和权限做关联，实现整体的一个灵活访问，提高我们的系统的安全性和管理型。基于这个模型，我们的开发速度还有粒度的粗细也都是十分好控制的。

优点：

灵活，安全，简化管理。



![image-20240814164458134](./assets/image-20240814164458134.png)



###### 2.49.1 RBAC-0 模型



用户和角色是一个多对多的关系，角色和权限也是一个多对多关系。



###### 2.49.2 RBAC-1 模型



多了一个继承的概念。

比如一个业务部门，经理，主管，营业员。主管的权限肯定不能大于经理，营业员不能大于主管。

子角色的范围一定会小于父角色。



###### 2.49.3 RBAC-2 模型



角色互斥，基数约束，先决条件等等。

角色互斥：同一个用户，不能被分配到复制的角色，比如说，你是一个采购，那你就不能分配销售。

基数约束：一个角色分配的用户数量是有限的。比如有一个公司的架构师，最多只能有三个。

先决条件：你 想获得架构师的角色，那你必然得先是一个资深工程师的角色。



**权限**



他的含义其实是非常广泛的，可以是菜单，页面，字段，数据。

菜单权限：

页面权限：

字段权限：

数据权限：

操作权限：



**用户组**



平台的用户基数非常大，角色也非常的多，如果说我给每个用户都操作一下角色，就非常的麻烦。我们其实抽象一层，组的概念，把同类的用户，放在一起，直接拥有相同的权限。

非常有益于减少工作量，一些管理方面也非常合适。用户组抽象到实际中，其实就是部门啊，科室啊。





##### 2.50 鉴权数据模型设计



用户信息表



![image-20240814164934798](./assets/image-20240814164934798.png)



角色表



![image-20240814165002265](./assets/image-20240814165002265.png)



用户角色表



![image-20240814165018708](./assets/image-20240814165018708.png)



权限表



![image-20240814165030876](./assets/image-20240814165030876.png)



角色权限关联表



![image-20240814165044676](./assets/image-20240814165044676.png)



关系图



![image-20240814165224129](./assets/image-20240814165224129.png)



##### 2.51 鉴权微服务架构设计



又开一个新模块



![image-20240814165608126](./assets/image-20240814165608126.png)



xiong-club-auth：这个服务承载了我们所有的基础数据源。他不管鉴权，只管数据相关的持久化操作以及业务操作，提供出各种各样的权限相关的接口。

nacos：将 auth 服务以及 subject 服务都注册到上面。内部进行调用，不对外暴露。通过 nacos 实现我们的服务发现。

gateway（网关）：网关层会对外提供服务，内部实现路由，鉴权。整体我们采取 token 的方式来与前端进行交互。由网关来决定当前用户是否可以操作到后面的业务逻辑。



![image-20240814165709864](./assets/image-20240814165709864.png)



来吧，新模块，gateway 服务



![image-20240814170229004](./assets/image-20240814170229004.png)



![image-20240814170237849](./assets/image-20240814170237849.png)



##### 2.52 鉴权数据表建立



用户表

```sql
DROP TABLE IF EXISTS `auth_user`;
CREATE TABLE `auth_user`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_name`    varchar(32)  DEFAULT NULL COMMENT '用户名称/账号',
    `nick_name`    varchar(32)  DEFAULT NULL COMMENT '昵称',
    `email`        varchar(32)  DEFAULT NULL COMMENT '邮箱',
    `phone`        varchar(32)  DEFAULT NULL COMMENT '手机号',
    `password`     varchar(64)  DEFAULT NULL COMMENT '密码',
    `sex`          tinyint(2) DEFAULT NULL COMMENT '性别',
    `avatar`       varchar(255) DEFAULT NULL COMMENT '头像',
    `status`       tinyint(2) DEFAULT NULL COMMENT '状态 0启用 1禁用',
    `introduce`    varchar(255) DEFAULT NULL COMMENT '个人介绍',
    `ext_json`     varchar(255) DEFAULT NULL COMMENT '特殊字段',
    `created_by`   varchar(32)  DEFAULT NULL COMMENT '创建人',
    `created_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32)  DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0' COMMENT '是否被删除 0未删除 1已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户信息表';
```



用户角色关联表



```sql
DROP TABLE IF EXISTS `auth_user_role`;
CREATE TABLE `auth_user_role`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `user_id`      bigint(20) DEFAULT NULL COMMENT '用户id',
    `role_id`      bigint(20) DEFAULT NULL COMMENT '角色id',
    `created_by`   varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色表';
```



角色表



```sql
DROP TABLE IF EXISTS `auth_role`;
CREATE TABLE `auth_role`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT,
    `role_name`    varchar(32) DEFAULT NULL COMMENT '角色名称',
    `role_key`     varchar(64) DEFAULT NULL COMMENT '角色唯一标识',
    `created_by`   varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time` datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0' COMMENT '是否被删除 0未删除 1已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```



角色权限关联表



```sql
DROP TABLE IF EXISTS `auth_role_permission`;
CREATE TABLE `auth_role_permission`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `role_id`       bigint(20) DEFAULT NULL COMMENT '角色id',
    `permission_id` bigint(20) DEFAULT NULL COMMENT '权限id',
    `created_by`    varchar(32) DEFAULT NULL COMMENT '创建人',
    `created_time`  datetime    DEFAULT NULL COMMENT '创建时间',
    `update_by`     varchar(32) DEFAULT NULL COMMENT '更新人',
    `update_time`   datetime    DEFAULT NULL COMMENT '更新时间',
    `is_deleted`    int(11) DEFAULT '0',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色权限关联表';
```





权限表



```sql
DROP TABLE IF EXISTS `auth_permission`;
CREATE TABLE `auth_permission`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT,
    `name`           varchar(64)  DEFAULT NULL COMMENT '权限名称',
    `parent_id`      bigint(20) DEFAULT NULL COMMENT '父id',
    `type`           tinyint(4) DEFAULT NULL COMMENT '权限类型 0菜单 1操作',
    `menu_url`       varchar(255) DEFAULT NULL COMMENT '菜单路由',
    `status`         tinyint(2) DEFAULT NULL COMMENT '状态 0启用 1禁用',
    `show`           tinyint(2) DEFAULT NULL COMMENT '展示状态 0展示 1隐藏',
    `icon`           varchar(128) DEFAULT NULL COMMENT '图标',
    `permission_key` varchar(64)  DEFAULT NULL COMMENT '权限唯一标识',
    `created_by`     varchar(32)  DEFAULT NULL COMMENT '创建人',
    `created_time`   datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32)  DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```



![image-20240814170934688](./assets/image-20240814170934688.png)



OK



##### 2.53 鉴权功能设计



###### 2.53.1 用户基础模块



- 新增用户
- 修改用户
- 删除用户
- 用户启用
- 用户禁用
- 用户密码加密
- 新增角色
- 修改角色
- 删除角色
- 角色与用户的关联



###### 2.53.2 权限基础模块



- 新增权限
- 修改权限
- 删除权限
- 权限禁用与启用
- 权限的展示与隐藏
- 权限与角色关联





###### 2.53.3 登录注册模块



**注册用户与验证**



1、短信的方式，通过向手机号发送验证码，来实现用户的验证并登录（考虑的成本是短信的费用）

2、邮箱的注册登录。

用户注册的时候，留一个邮箱，我们往邮箱里通过邮箱服务器发送一个链接，用户点击之后，实现一个激活，激活成功之后就完成了注册。（0 成本，坏处这种发送的邮件很容易进垃圾箱）

3、个人公众号模式（个人开发者无公司的，比较适合使用，0 成本）

用户登录的时候，弹出我们的这个公众号的码。扫码后，用户输入我们提示的验证码。可以随机比如说 nadbuge，通过我们的公众号对接的回调。能拿到一定的信息，用户的 openId。进而记录用户的信息

4、企业的服务号（必须要有营业执照，自己玩的不上线的话，也可以用测试号）

好处就是不仅打通了各种回调，而且还能拿到用户的信息。



**登录功能**



传统的 pc 形式，都是登录之后，写入 cookie。前端再次请求的时候，带着 cookie 一个身份识别就可以完成认证。坏处是什么？小程序呀，app 呀，其实是没有 cookie 这个概念的。为了更好的扩展，我们就直接选择 token的模式。token 放入 header 来实现用户身份的识别与鉴权。



**踢人下线**

发现风险用户，可以通过后台直接把用户踢掉，禁止其再访问，token 也可以直接置为失效的形式。



**集成Redis**



如果说我们选择了 token，然后不做 token 的保存，服务重启呀，分布式微服务啊，数据是无法共享并且会产生丢失问题，所以用 redis 来存储一些信息，实现共享。



**自定义我们的 token 风格和前缀**



比如正常的 token 可能是 uuid，我们可以选择其他形式

然后就是 token 的前端的传递，也可以去定义前缀，固定前缀才生效。



**记住我**



当我们去勾选记住我的时候，下次登录就自动实现了。

前后端分离，没有 token 的时候，必然会产生无法实现的问题，我们就选择在前端的 localstorage 来做。



###### 2.53.4 网关统一鉴权



校验权限，校验用户的角色等等的东西，我们就放在网关里面统一去做。

不放在网关，导致我们的每个微服务，全要引入的鉴权的框架，不断的去写重复的代码。

数据的权限获取产生问题：

1、网关直接对接数据库，实现查询

2、redis 中获取数据，获取不到的时候还是要像第一种一样去数据库里查。

3、redis 中获取缓存，没有的话，从 auth 服务里面获取相关的信息。

4、直接从 redis 读取。





##### 2.54 auth微服务建立及抽取思想思考



![image-20240814172052625](./assets/image-20240814172052625.png)



全新干



![image-20240814172125662](./assets/image-20240814172125662.png)



![image-20240814172207340](./assets/image-20240814172207340.png)



![image-20240814172311553](./assets/image-20240814172311553.png)



![image-20240814172416676](./assets/image-20240814172416676.png)



![image-20240814172618197](./assets/image-20240814172618197.png)



![image-20240814172641685](./assets/image-20240814172641685.png)



![image-20240814172813352](./assets/image-20240814172813352.png)



> 手快了



![image-20240814173007983](./assets/image-20240814173007983.png)



![image-20240814173030254](./assets/image-20240814173030254.png)



![image-20240814173059511](./assets/image-20240814173059511.png)



大概就是这样，离谱



现在要把这个给跑起来，依赖拿过来



![image-20240814173257236](./assets/image-20240814173257236.png)



就是仿照之前的 subject ，复制粘贴



![image-20240814173434193](./assets/image-20240814173434193.png)



![image-20240814173529050](./assets/image-20240814173529050.png)



又删了 俩



![image-20240814173700062](./assets/image-20240814173700062.png)



俩配置文件，直接粘

然后就是其他模块的一些东西，依赖啥啥啥的，直接粘贴



![image-20240814174917467](./assets/image-20240814174917467.png)



![image-20240814175158718](./assets/image-20240814175158718.png)



没啥问题，那个mapper 是还没有建，所以，这就是基础骨架



再来一个究极 common 模块【后面听说会做，】



![image-20240814175617080](./assets/image-20240814175617080.png)



这个名字应该区分开，下面的应该都加上 subject ，没错，最后源码也没改



##### 2.55 satoken实现登录及token机制



加依赖

```xml
        <!-- sa-token 依赖-->
        <dependency>
            <groupId>cn.dev33</groupId>
            <artifactId>sa-token-spring-boot-starter</artifactId>
            <version>1.37.0</version>
        </dependency>
```





![image-20240814175855955](./assets/image-20240814175855955.png)



配置



![image-20240814180043524](./assets/image-20240814180043524.png)



来一个 controller 



![image-20240814180530442](./assets/image-20240814180530442.png)



试试



![image-20240814180617982](./assets/image-20240814180617982.png)



回车



![image-20240814180656910](./assets/image-20240814180656910.png)



不好意思，我是都加了一个 api 前缀



![image-20240814180716668](./assets/image-20240814180716668.png)



不对，忘记引入了



![image-20240814180822463](./assets/image-20240814180822463.png)



再来一次



![image-20240814180855878](./assets/image-20240814180855878.png)



哇哦， 试试登录



![image-20240814180920336](./assets/image-20240814180920336.png)



成功，试试另一个



![image-20240814181358418](./assets/image-20240814181358418.png)



没问题，我又试了一次



如果我们换成非浏览器



![image-20240814181618047](./assets/image-20240814181618047.png)



这样就不行了，我们的 postman 不吃 cookie 这套，除非我们自己加上



![image-20240814181742764](./assets/image-20240814181742764.png)



这样就是 true，但是我们要用的就是 一种无 Cookie 模式：https://sa-token.cc/doc.html#/up/not-cookie



![image-20240814181844166](./assets/image-20240814181844166.png)



我们需要做的就是 在 headers 中自己加东西



![image-20240814182038336](./assets/image-20240814182038336.png)



![image-20240814182224256](./assets/image-20240814182224256.png)



再试一次



![image-20240814182405843](./assets/image-20240814182405843.png)



请求登录后，然后再去无状态的访问登录状态



![image-20240814182541493](./assets/image-20240814182541493.png)



这玩意儿已经种上了



![image-20240814182620614](./assets/image-20240814182620614.png)



重启服务器，变为 false，这里还是变成有 Cookie 的形式了 



总之意思就是说，我们可以自己做一个 header 参数，带着 token 去请求



![image-20240814182957070](./assets/image-20240814182957070.png)



加个前缀



![image-20240814183321731](./assets/image-20240814183321731.png)



![image-20240814183407493](./assets/image-20240814183407493.png)



登录后， 如果 satoken 不加前缀



![image-20240814183429806](./assets/image-20240814183429806.png)



就不行，得加上前缀



![image-20240814183501022](./assets/image-20240814183501022.png)



没毛病



##### 2.56 gateway网关统一鉴权规划及思想



总之就是要在网关层 gateway 去做， 包括 auth 也一层，和鉴权没关系，auth 这层就是去和数据库做交互



【别把鉴权 和 业务 强耦合】



![image-20240814184021776](./assets/image-20240814184021776.png)



体会这张图



##### 2.57 微服务注册到 nacos



拿 oss 开刀，对着阿里的脚手架，对原先的依赖重新处理一下啊



![image-20240814184758369](./assets/image-20240814184758369.png)



鸡翅用的 2.4.2 ，我用的 2.7.6 

想把这个服务注册到 nacos， 就改下配置文件就行了



![image-20240814185033109](./assets/image-20240814185033109.png)



试试，启动 oss 服务



![image-20240814185103741](./assets/image-20240814185103741.png)



看看 nacos

![image-20240814185118599](./assets/image-20240814185118599.png)



没问题



![image-20240814185546253](./assets/image-20240814185546253.png)



详情也有



##### 2.58 SpringCloudGateway搭建及路由配置



配置依赖



![image-20240814190946546](./assets/image-20240814190946546.png)



![image-20240814190953494](./assets/image-20240814190953494.png)



端口 5000 



![image-20240814191024688](./assets/image-20240814191024688.png)



然后就是大头了，全是按照配置实现的过滤啥啥啥的



![image-20240814193903481](./assets/image-20240814193903481.png)



然后就是启动类



![image-20240814194016102](./assets/image-20240814194016102.png)



直接启动试试



![image-20240814194056138](./assets/image-20240814194056138.png)



把web 依赖删掉，还有日志也不能要



![image-20240814194147085](./assets/image-20240814194147085.png)



![image-20240814194224480](./assets/image-20240814194224480.png)



出来了，看看服务列表



![image-20240814194303047](./assets/image-20240814194303047.png)



没问题，俩服务



之前我们是直接访问的4000



![image-20240814194345725](./assets/image-20240814194345725.png)



这下改成 5000 



![image-20240814194443712](./assets/image-20240814194443712.png)



其实服务已经找到了，但是请求过程出现了问题，加上 负载均衡依赖



![image-20240814194549436](./assets/image-20240814194549436.png)



重启再试一次



![image-20240814194658456](./assets/image-20240814194658456.png)



没毛病，这就转发成功了





##### 2.59 鉴权微服务及刷题微服务注册到nacos



从 oss 复制粘贴就行了



![image-20240814195147060](./assets/image-20240814195147060.png)



注意，是贴在 starter 里面



![image-20240814195421106](./assets/image-20240814195421106.png)



有这些就行



改配置文件



![image-20240814195512181](./assets/image-20240814195512181.png)



auth 服务



![image-20240814195621712](./assets/image-20240814195621712.png)



直接启动



![image-20240814195644663](./assets/image-20240814195644663.png)



没问题



![image-20240814195656654](./assets/image-20240814195656654.png)



auth 服务也上来了，还有就是 subject 服务



这里稍微改了一下 oss ，把那个 dev 改回去了，不然不太整齐



![image-20240814200105128](./assets/image-20240814200105128.png)



下一个 subject 服务，这里我顺便把之前那个 knife4j 给删掉了，之后如果需要可以直接在网关层直接做一个总的



![image-20240814200416459](./assets/image-20240814200416459.png)



还改了下端口



![image-20240814200622849](./assets/image-20240814200622849.png)



这个模块名，我们后面再改吧，现在看不出来是题目服务



![image-20240814200710343](./assets/image-20240814200710343.png)



配置文件



启动吧



![image-20240814200757547](./assets/image-20240814200757547.png)



服务列表

![image-20240814200811346](./assets/image-20240814200811346.png)



没问题

把其他网关转发路径都配上



![image-20240814201016676](./assets/image-20240814201016676.png)



直接重启一下网关服务，测试一下



![image-20240814201128023](./assets/image-20240814201128023.png)



之前的接口正常是能用的,直接 改成 5000试试



![image-20240814201205002](./assets/image-20240814201205002.png)



也没有问题，但是url看着不太好看，重了



再试试 auth



![image-20240814201252039](./assets/image-20240814201252039.png)



也没有问题，这就全部打通了



##### 2.60 Docker 安装 Redis



```
docker search redis
docker pull redis
```



![image-20240814201535667](./assets/image-20240814201535667.png)



![image-20240814201619792](./assets/image-20240814201619792.png)



https://redis.io/docs/latest/operate/oss_and_stack/management/config/：在这里面搞一个 redis 的配置文件



直接整了一个 7.2 的



![image-20240814201941072](./assets/image-20240814201941072.png)



另存为，放到服务器上



![image-20240814202456742](./assets/image-20240814202456742.png)



这里是直接下载的鸡翅的：`https://lark-assets-prod-aliyun.oss-cn-hangzhou.aliyuncs.com/yuque/0/2023/conf/29413969/1698584659695-36fd651d-44ca-4bec-ae1c-17dced7d5a3a.conf?OSSAccessKeyId=LTAI4GKnqTWmz2X8mzA1Sjbv&Expires=1723639739&Signature=OpQV49AFAPDVTvVXpOXms4hRcss%3D&response-content-disposition=attachment%3Bfilename*%3DUTF-8%27%27redis.conf`



启动容器

```
启动命令
docker run -p 6379:6379 --name redis -v /data/redis/redis.conf:/etc/redis/redis.conf  -v /data/redis/data:/data -d redis redis-server /etc/redis/redis.conf --appendonly yes
```



![image-20240814202659333](./assets/image-20240814202659333.png)



redis 也跑起来了



开个端口，6379 



![image-20240814202555562](./assets/image-20240814202555562.png)





连接一下，



![image-20240814202826043](./assets/image-20240814202826043.png)



7.4 ，我尼玛，最新的





##### 2.61 gateway网关基于redis实现分布式会话



网关服务加上依赖



![image-20240814203047677](./assets/image-20240814203047677.png)



配置文件配置



![image-20240814203227107](./assets/image-20240814203227107.png)



然后就是 鉴权那边，是直接放到了 controller 下面，后面又要搬动



![image-20240814203930445](./assets/image-20240814203930445.png)



auth 的配置文件



![image-20240814204045977](./assets/image-20240814204045977.png)



加上 redis 的配置



来吧，启动一下啊，重启 auth



![image-20240814204209489](./assets/image-20240814204209489.png)



好，直接登录



![image-20240814204311561](./assets/image-20240814204311561.png)



成功返回

带上这个值，请求是否登录那个



![image-20240814204354341](./assets/image-20240814204354341.png)



没问题，如果不带



![image-20240814204412287](./assets/image-20240814204412287.png)



就是false



![image-20240814204438584](./assets/image-20240814204438584.png)



而且 redis 里面已经有数据了



下面就要做一些鉴权



![image-20240814204907471](./assets/image-20240814204907471.png)



虽然现在还是假的

还有一个过滤器



![image-20240814205345929](./assets/image-20240814205345929.png)



做个实验，重启网关



![image-20240814205446492](./assets/image-20240814205446492.png)



目前这个带上还是能直接调的，如果在网关



![image-20240814205650691](./assets/image-20240814205650691.png)



还是能够直接调的



![image-20240814205705763](./assets/image-20240814205705763.png)



因为登录接口我们排除了，如果匹配不上



![image-20240814205745480](./assets/image-20240814205745480.png)



![image-20240814205822395](./assets/image-20240814205822395.png)



还是可以访问到，擦，没生效



![image-20240814210023468](./assets/image-20240814210023468.png)



还是能够成功，没蓝下来，其实是拦下来了，但是后面的校验通过，因为 postman，带上 cookie 了



换一个校验



![image-20240814210202225](./assets/image-20240814210202225.png)



再试一次



![image-20240814210227528](./assets/image-20240814210227528.png)



拦住了，但是这里发现这个 b 又改了不知道哪里的代码，我的是看不懂的样子，



![image-20240814210402071](./assets/image-20240814210402071.png)



他的是这样的，但是确实是拦下来了，现在我确实要放开 登录这个接口



![image-20240814210602180](./assets/image-20240814210602180.png)



这样就放过去了



直接用网关判断是否登录



![image-20240814210849879](./assets/image-20240814210849879.png)



直接 500 了，配一下解析



![image-20240814210932790](./assets/image-20240814210932790.png)



这个配置给网关层也加上，重启再试一次



![image-20240814211034378](./assets/image-20240814211034378.png)



是有效了，但是无此角色，哦哦哦， 我没返回异常处理方法



![image-20240814211350336](./assets/image-20240814211350336.png)



这样就行了



![image-20240814211433124](./assets/image-20240814211433124.png)



没毛病



下面终于可以上真格的了



![image-20240814211518486](./assets/image-20240814211518486.png)



试试



![image-20240814211613860](./assets/image-20240814211613860.png)



这样就能通过校验，因为我们配置那里返回了死的 admin



![image-20240814211646424](./assets/image-20240814211646424.png)



如果尝试调用 增加题目的接口



![image-20240814211827520](./assets/image-20240814211827520.png)



没有这个权限



![image-20240814211839397](./assets/image-20240814211839397.png)



没问题，如果我们给他这个权限



![image-20240814211920321](./assets/image-20240814211920321.png)



再试一次



![image-20240814212021652](./assets/image-20240814212021652.png)



直接就成功了，因为有这个权限



![image-20240814212040390](./assets/image-20240814212040390.png)



![image-20240814212057450](./assets/image-20240814212057450.png)



确实插进去了，插入的一个简答题



![image-20240814212131480](./assets/image-20240814212131480.png)

![image-20240814212158109](./assets/image-20240814212158109.png)



关系表也没问题



##### 2.62 gateway 实现全局异常处理



![image-20240814212439859](./assets/image-20240814212439859.png)



这种错误都是直接抛出 500 ，这个不是我们搞的



![image-20240814213127743](./assets/image-20240814213127743.png)



![image-20240814213326381](./assets/image-20240814213326381.png)



这里就不用要了



试试



![image-20240814213406802](./assets/image-20240814213406802.png)



没问题



![image-20240814213420100](./assets/image-20240814213420100.png)



这里鸡翅的没抛出来 ... 



![image-20240814213609167](./assets/image-20240814213609167.png)



因为我们这里这样写了



![image-20240814213709076](./assets/image-20240814213709076.png)



这里不抛也行



![image-20240814213733115](./assets/image-20240814213733115.png)



没毛病，后面他就要抛了





##### 2.63 gateway实现redis拉取权限信息



![image-20240814214004187](./assets/image-20240814214004187.png)



这儿要换成真的了



配置类：

![image-20240814214210520](./assets/image-20240814214210520.png)



工具类：



![image-20240814214255049](./assets/image-20240814214255049.png)



目的就是可读性更好，对 template 的再次封装



直接修改



![image-20240814215148045](./assets/image-20240814215148045.png)



这样就能改这边了



![image-20240814215410713](./assets/image-20240814215410713.png)



就算 token 正确，但是没有拿到这样的权限，因为 redis 里面确实没有数据



![image-20240814215511968](./assets/image-20240814215511968.png)



起码它确实是走了这里，下一步肯定就是要在用户登录后，给它写进去



> 这里补了一集，为什么重写redistemplate，是在另一个项目里面，一个脚手架项目，没啥说的，就是 原始的redistemplate 可读性不高，再次封装一次
>
> ![image-20240814220240425](./assets/image-20240814220240425.png)





##### 2.64 用户模块开发



直接代码生成，这个是要放在 auth 的 infra 里面



![image-20240814220555472](./assets/image-20240814220555472.png)



五个表，直接全部生成



![image-20240814220618652](./assets/image-20240814220618652.png)



![image-20240814220627578](./assets/image-20240814220627578.png)



直接 plus 形式再现



![image-20240814221050095](./assets/image-20240814221050095.png)



生成完成

这下就可以改 controller 了



先来一个注册接口



![image-20240815094354660](./assets/image-20240815094354660.png)



试试



![image-20240815094739723](./assets/image-20240815094739723.png)



直接发送



![image-20240815094748467](./assets/image-20240815094748467.png)



看看数据库



![image-20240815094842734](./assets/image-20240815094842734.png)



没啥问题，插进来了，【当然之后还有逻辑，建立角色关联啥的，还要刷入 redis】



先写修改用户



![image-20240815095302483](./assets/image-20240815095302483.png)



![image-20240815095607304](./assets/image-20240815095607304.png)



数据库



![image-20240815095617174](./assets/image-20240815095617174.png)



没问题



![image-20240815095910399](./assets/image-20240815095910399.png)



当然是逻辑删除



![image-20240815095948954](./assets/image-20240815095948954.png)



数据库



![image-20240815095958974](./assets/image-20240815095958974.png)



没问题



用户启用 / 禁用，其实就是复用了 update 那个方法，不过我们自己传入status 就行



![image-20240815100402870](./assets/image-20240815100402870.png)



现在是 0 



![image-20240815100455525](./assets/image-20240815100455525.png)



直接试试



![image-20240815100511575](./assets/image-20240815100511575.png)



看看数据库



![image-20240815100522437](./assets/image-20240815100522437.png)



没问题，改回 0 ，



![image-20240815100535180](./assets/image-20240815100535180.png)



就行了



##### 2.65 常见加密方式 & 密码加密



![image-20240815100918371](./assets/image-20240815100918371.png)

数据库如果说存储明文的密码是非常的危险的，一旦被攻击啊，或者数据泄漏，用户的信息疯狂的暴露出去，黑客什么都能干，这是非常不行，所以我们要做加密，让黑客即使拿到了密码信息， 也不知道原始的密码，就登录不成功。



###### 2.65.1 加密的方式



**摘要加密**

md5，sha1，sha256

摘要主要就是哈希值，通过我们的散列的算法。摘要的概念主要是验证完整性和唯一性，不管我们的密码是多长啊，或者多复杂的啊，得到的值都是固定长度。

摘要加密有一定的风险。123456 用 md5 加密。他其实是固定的，大家也可以到一些网站有反解密。



**对称加密**

们约定了一个密钥。这个密钥一定要好好保存，不能泄漏，一旦泄漏就可以进行想你想的解密了。

加密的过程：密码+密钥 生成

解密的过程：密文+密钥 反解

密钥一定一定要做好其中的保存。

常见的对称加密的算法：AES，DES，3DESC，SM4



**非对称加密**

一个公钥，一个私钥。

公钥去加密，私钥去解密。

私钥去加密，公钥去解密。

常见的算法：RSA，ECC，国密的 SM2

算法的时性能上，差一点，加密的数量没有对称加密快。



**加盐**

摘要算法比如 md5，光加密 123456，结果都是一样的，如果是破解的库里正好有这个 md5 就很容易知道逆向是 123456。来一手加盐。盐是随机的字符串，他来与原密码进行一波二次加密。这样获取到的很难破解出来。



> 我们要用微信登录，用这玩意儿干毛 ... ，密码都用不上



![image-20240815101606928](./assets/image-20240815101606928.png)



再来注册一个，我直接截断 了



![image-20240815101729925](./assets/image-20240815101729925.png)



数据库



![image-20240815101741626](./assets/image-20240815101741626.png)



加完盐破解就很难了



##### 2.66 角色模块开发



这里还是生成，之前我们全做了



来一个 controller 



![image-20240815102320953](./assets/image-20240815102320953.png)



新建角色



![image-20240815102933955](./assets/image-20240815102933955.png)



修改角色、删除角色



![image-20240815103214430](./assets/image-20240815103214430.png)



测试

【新增角色】

![image-20240815103337674](./assets/image-20240815103337674.png)



![image-20240815103345771](./assets/image-20240815103345771.png)



【修改角色】



![image-20240815103400447](./assets/image-20240815103400447.png)



![image-20240815103407734](./assets/image-20240815103407734.png)



【删除角色】

![image-20240815103413853](./assets/image-20240815103413853.png)



![image-20240815103529036](./assets/image-20240815103529036.png)



没问题



![image-20240815103539508](./assets/image-20240815103539508.png)



记得这个注解



##### 2.67 用户角色关联



其实就是 userid 和 roleid 关联，插入那张关系表就行



![image-20240815103837800](./assets/image-20240815103837800.png)



在注册的逻辑里面



![image-20240815104811189](./assets/image-20240815104811189.png)



试试，直接注册一个新用户



![image-20240815105121283](./assets/image-20240815105121283.png)



![image-20240815105129381](./assets/image-20240815105129381.png)



看看 用户角色表



![image-20240815105145422](./assets/image-20240815105145422.png)



没问题，id 为 2 的用户拥有了 id 为 1的角色



![image-20240815105208923](./assets/image-20240815105208923.png)



就这个，下面就该是权限了



##### 2.68 权限模块开发



基础代码已经生成了



直接 controller 起手



新增权限



![image-20240815110044507](./assets/image-20240815110044507.png)



更新权限、删除权限



![image-20240815110632709](./assets/image-20240815110632709.png)



直接测试一下



【新增权限】

马德，show 是关键字啊



![image-20240815111742561](./assets/image-20240815111742561.png)



这样应该就行了



![image-20240815111812332](./assets/image-20240815111812332.png)



数据库



![image-20240815111825570](./assets/image-20240815111825570.png)



没问题



【更新权限】

![image-20240815111937181](./assets/image-20240815111937181.png)



更新成功



![image-20240815111949491](./assets/image-20240815111949491.png)



没问题



【删除权限】



![image-20240815112007042](./assets/image-20240815112007042.png)



![image-20240815112017059](./assets/image-20240815112017059.png)



没问题



【启用禁用权限】

其实还是复用更新接口



![image-20240815112121204](./assets/image-20240815112121204.png)





![image-20240815112131523](./assets/image-20240815112131523.png)





【展示、不展示权限】



![image-20240815112213444](./assets/image-20240815112213444.png)



![image-20240815112227706](./assets/image-20240815112227706.png)



没问题



##### 2.69 角色权限关联开发



![image-20240815112457681](./assets/image-20240815112457681.png)



其实就是这张表，要俩东西就行



还是那个生成器，之前就做了，还是一个 controller 起手



![image-20240815112618927](./assets/image-20240815112618927.png)





新增角色权限关联关系



![image-20240815112911018](./assets/image-20240815112911018.png)



试试



![image-20240815113456884](./assets/image-20240815113456884.png)



加了一些权限

![image-20240815113512333](./assets/image-20240815113512333.png)



把1、2、3 的权限和 id 为 1 的角色绑定



![image-20240815113712465](./assets/image-20240815113712465.png)



看看数据库



![image-20240815113921707](./assets/image-20240815113921707.png)



没问题



##### 2.70 缓存与数据一致性问题



辩证两个情况

1、直接和缓存做交互，完全信任缓存

2、和缓存做交互，如果缓存没有，则去和数据库查



![image-20240815114305086](./assets/image-20240815114305086.png)



根据以上的流程没有问题，但是当数据变更的时候，如何把缓存变到最新，是我们下面要讨论的问题。



###### 2.70.1 更新了数据库，再更新缓存

假设数据库更新成功，缓存更新失败，在缓存失效和过期的时候，读取到的都是老数据缓存。



###### 2.70.2 更新缓存，更新数据库



缓存更新成功了，数据库更新失败，是不是读取的缓存的都是错误的。



【以上两种，全都不推荐。】



###### 2.70.3 先删除缓存，再更新数据库



有一定的使用量。即使数据库更新失败。缓存也可以会刷。

存在的问题是什么？

高并发情况下！！

比如说有两个线程，一个是 A 线程，一个是 B 线程。

A 线程把数据删了，正在更新数据库，这个时候 B 线程来了，发现缓存没了，又查数据，又放入缓存。缓存里面存的就一直是老数据了。

**延迟双删。**更新完数据库之后，我再删一次。



###### 2.70.4 扩展思路



【1】消息队列补偿

删除失败的缓存，作为消息打入 mq，mq 消费者进行监听，再次进行重试刷缓存。



【2】canal

监听数据库的变化，做一个公共服务，专门来对接缓存刷新。优点业务解耦，业务太多冗余代码复杂度。





##### 2.71 网关与auth微服务缓存打通



还是改注册那儿 domain 实现的地方



![image-20240815130407675](./assets/image-20240815130407675.png)



试一下



![image-20240815130458987](./assets/image-20240815130458987.png)



缓存先清空



![image-20240815130628916](./assets/image-20240815130628916.png)



![image-20240815130647186](./assets/image-20240815130647186.png)



成功之后



![image-20240815130657831](./assets/image-20240815130657831.png)



用户添加完成



![image-20240815130727592](./assets/image-20240815130727592.png)



![image-20240815130733203](./assets/image-20240815130733203.png)



这说明，章鱼哥是个普通用户，它的权限就是我们绑的那些普通用户的权限



![image-20240815130809998](./assets/image-20240815130809998.png)



用户角色关系也建好了



这下就可以回到网关层做校验了



![image-20240815131333460](./assets/image-20240815131333460.png)



试试，在网关层登录



![image-20240815131442036](./assets/image-20240815131442036.png)



四个服务全上来了



直接判断是否登录



![image-20240815131546723](./assets/image-20240815131546723.png)



无权限



先用网关登录

![image-20240815131608655](./assets/image-20240815131608655.png)



登录成功，用这个 token 再试一次 判断



![image-20240815131649203](./assets/image-20240815131649203.png)



还是无权限，登录那儿写死了



![image-20240815131736367](./assets/image-20240815131736367.png)



![image-20240815131801176](./assets/image-20240815131801176.png)



再试一次



![image-20240815131918637](./assets/image-20240815131918637.png)



再来判断



![image-20240815132046134](./assets/image-20240815132046134.png)



确实从缓存中拿到那个 key 对应的数据了



![image-20240815132247064](./assets/image-20240815132247064.png)



这里是判断admin，我们还没弄，试试判断权限的接口



![image-20240815132351842](./assets/image-20240815132351842.png)



比如这个



![image-20240815132427744](./assets/image-20240815132427744.png)



![image-20240815132542615](./assets/image-20240815132542615.png)



在这儿停一下



![image-20240815132907244](./assets/image-20240815132907244.png)



我这里不太对， 它还是去拿的角色



![image-20240815133431107](./assets/image-20240815133431107.png)



![image-20240815133437150](./assets/image-20240815133437150.png)



我把这儿先注掉了，因为章鱼哥有这个权限，所以新增题目成功了



![image-20240815133511034](./assets/image-20240815133511034.png)



这样就相当于打通了



##### 2.72 登录开发初探



某信（为啥叫某信，是为了课程过审）我们整体采取个人号的登录模式，选取某信号的 openId 作为用户的唯一标识！



![image-20240815134246270](./assets/image-20240815134246270.png)

整体流程：用户扫公众号码。然后发一条消息：验证码。我们通过 api 回复一个随机的码。存入 redis

redis 的主要结构，就是 openId 加验证码

用户在验证码框输入之后，点击登录，进入我们的注册模块，同时关联角色和权限。就实现了网关的统一鉴权。

用户就可以进行操作，用户可以根据个人的 openId 来维护个人信息。

用户登录成功之后，返回 token，前端的所有请求都带着 token 就可以访问拉。



**服务设计**



开一个新的服务，叫我们的 xiong-club-wechat。专门用于对接某信的 api 和微信的消息的回调。

回调：关注公众号，发送验证码

通过 nacos 注册中心来调用我们的 auth 服务，来实现用户的注册。

另一种扩展方案，wechat 和 auth 不直接交互。

通过 mq 来做。wechat 接收回调后，反向发出 mq。自身的 auth 来订阅 mq 进行消费。



##### 2.73 公众号开发文档解析



https://developers.weixin.qq.com/doc/offiaccount/Getting_Started/Overview.html



![image-20240815135055323](./assets/image-20240815135055323.png)



就这个东西



![image-20240815135308453](./assets/image-20240815135308453.png)





![image-20240815135430691](./assets/image-20240815135430691.png)



我们要去申请一个测试号



![image-20240815135458897](./assets/image-20240815135458897.png)



申请一个就行



##### 2.74 公众号验签开发



新模块



![image-20240815135742811](./assets/image-20240815135742811.png)



![image-20240815135822439](./assets/image-20240815135822439.png)



基础依赖 和 oss 差不多



![image-20240815140019033](./assets/image-20240815140019033.png)



留了一些



先把这个服务跑起来



![image-20240815140249575](./assets/image-20240815140249575.png)



端口 是 3012 



![image-20240815140327486](./assets/image-20240815140327486.png)



直接启动



![image-20240815140359071](./assets/image-20240815140359071.png)



没问题



![image-20240815140455357](./assets/image-20240815140455357.png)



没问题

接下来就是真格的



![image-20240815141013114](./assets/image-20240815141013114.png)



先看看这个接口



![image-20240815141228904](./assets/image-20240815141228904.png)



![image-20240815141247603](./assets/image-20240815141247603.png)



拿得到 就行，下面是内网穿透



##### 2.75 内网穿透natapp



https://natapp.cn/



![image-20240815141531358](./assets/image-20240815141531358.png)



![image-20240815141713479](./assets/image-20240815141713479.png)



没用过，但是早有耳闻



![image-20240815141806321](./assets/image-20240815141806321.png)





![image-20240815141903983](./assets/image-20240815141903983.png)



还要下载一个客户端



![image-20240815142042644](./assets/image-20240815142042644.png)





一分钟快速使用教程：https://natapp.cn/article/natapp_newbie



直接运行

![image-20240815142315668](./assets/image-20240815142315668.png)



这样运行



![image-20240815142419059](./assets/image-20240815142419059.png)



![image-20240815142507238](./assets/image-20240815142507238.png)



连不上啊，搜了一下，不能用校园网 ... 



![image-20240815142849094](./assets/image-20240815142849094.png)



先试试改这个，不行，直接换成手机热点试试



![image-20240815143541262](./assets/image-20240815143541262.png)



再试一次



![image-20240815143644367](./assets/image-20240815143644367.png)



手机热点也不行

![image-20240815143750190](./assets/image-20240815143750190.png)



网线已经拔了





![image-20240815143817130](./assets/image-20240815143817130.png)



网线一拔就行了，



` http://6rynpt.natappfree.cc -> 127.0.0.1:3012 `



这个送了一个域名，直接替换



![image-20240815144025611](./assets/image-20240815144025611.png)



![image-20240815144033901](./assets/image-20240815144033901.png)



一点毛病都没有，直接穿透了



![image-20240815144126599](./assets/image-20240815144126599.png)



直接访问，手机访问也都没问题，妙哇



##### 2.76 监听用户行为 & 自动回复消息



可以把这个域名和token 填入我们那个测试



![image-20240815144630168](./assets/image-20240815144630168.png)



还要来一个 post 请求



![image-20240815145644485](./assets/image-20240815145644485.png)



这样我们对那个测试号的关注取关操作，都能够被我们的后台给捕获到



比如说我们再给这个公众号发送一条消息



![image-20240815145943851](./assets/image-20240815145943851.png)



是可以直接捕捉到的



我们现在需要做的就是别人关注了我们的公众号，然后给公共号发一个 “验证码”，公众号可以返回给用户一个验证码进行登录操作



开干



##### 2.77 消息事件监听 & 策略模式解耦



通过 msgType 来进行判断实现



一个枚举



![image-20240815154803029](./assets/image-20240815154803029.png)



然后就是整个的实现，包括还要把验证码放到 redis 里面



![image-20240815161951701](./assets/image-20240815161951701.png)



手机上其实也收到了



![309c8b3fc850d1006e2a2898f625bd3](./assets/309c8b3fc850d1006e2a2898f625bd3.jpg)





没问题，关注事件和消息事件分开处理，下面就是和登录接口打通





##### 2.78 公共号登录验证码逻辑



当前的效果



![image-20240815162711727](./assets/image-20240815162711727.png)



redis 中存的是



![image-20240815162730614](./assets/image-20240815162730614.png)



键就是验证码，值是用户的一个标识



![image-20240815162755067](./assets/image-20240815162755067.png)



![image-20240815162818754](./assets/image-20240815162818754.png)



5 分钟，300 s 有效



现在去改写 登录逻辑



![image-20240815162957050](./assets/image-20240815162957050.png)



![image-20240815163134419](./assets/image-20240815163134419.png)



试试



![image-20240815163850353](./assets/image-20240815163850353.png)



没问题，看下这个用户注册了没



![image-20240815163919994](./assets/image-20240815163919994.png)



也加上了



角色

![image-20240815164013864](./assets/image-20240815164013864.png)



也默认给了他一个普通用户，这里改一下吧，增加一个管理员角色



![image-20240815164100184](./assets/image-20240815164100184.png)



其实这里我觉得应该在登录那儿也把那个往 redis 里面写那个加上



![image-20240815165203915](./assets/image-20240815165203915.png)



当然功能确实已经打通了





##### 2.79 一期项目如何写在简历及亮点描述



到这里，一期就算完成了，主要做了刷题、登录鉴权的相关功能



![image-20240815165547378](./assets/image-20240815165547378.png)





![image-20240815165713916](./assets/image-20240815165713916.png)



##### 2.80 前端 nodejs 安装



看看，版本用的 18.18 ，我这里就用 nvm 直接下载一个吧



![image-20240815165900646](./assets/image-20240815165900646.png)



再来一个



![image-20240815170250273](./assets/image-20240815170250273.png)



装 pnpm



这里有一个前端项目的源码



![image-20240815170417349](./assets/image-20240815170417349.png)





`npm install pnpm -g`



![image-20240815170515069](./assets/image-20240815170515069.png)



![image-20240815170531813](./assets/image-20240815170531813.png)



换个源 `pnpm config set registry https://registry.npmmirror.com/`



![image-20240815170657735](./assets/image-20240815170657735.png)



##### 2.81 前端及后端整体部署



![image-20240815170859696](./assets/image-20240815170859696.png)



我直接 webstorm 打开看看



![image-20240815171047315](./assets/image-20240815171047315.png)



来吧，安装依赖，`pnpm install`



![image-20240815171228220](./assets/image-20240815171228220.png)



![image-20240815172201188](./assets/image-20240815172201188.png)



启动吧



![image-20240815172242469](./assets/image-20240815172242469.png)





5173 端口，现在要换成我们的后端接口



每一个服务都单独打出来，然后扔到服务器上，炸裂，死在前端的代码





![image-20240815184851900](./assets/image-20240815184851900.png)



顶多跑成这样了，后面好像还改了请求的代码的，继续做吧



登录页面



![image-20240815185240442](./assets/image-20240815185240442.png)



将就吧



不对，就是真的部署上去了 ... 还是要改一下



先做着走吧，没办法



通过了再说【这里先向后面做着】



其实不太对

![image-20240815211852260](./assets/image-20240815211852260.png)



这个地方，这里多了俩模块，都还没做呢，脑裂



【回来了】，我拿到了 前端代码，并且回退到了 和 鸡翅 一样的版本



![image-20240815225455818](./assets/image-20240815225455818.png)



试一下吧



![image-20240815225658062](./assets/image-20240815225658062.png)



安装依赖



![image-20240815225729932](./assets/image-20240815225729932.png)



先把后端的 4 个 jar 包打出来



![image-20240815231933448](./assets/image-20240815231933448.png)



全部扔到服务器上





![image-20240815232028194](./assets/image-20240815232028194.png)



完事儿后挨个儿启动



先网关吧



![image-20240815232648054](./assets/image-20240815232648054.png)





![image-20240815232721777](./assets/image-20240815232721777.png)



OK



![image-20240815232753660](./assets/image-20240815232753660.png)



我本地还有一个

题目：

![image-20240815232908210](./assets/image-20240815232908210.png)



auth



![image-20240815233019753](./assets/image-20240815233019753.png)



没问题

最后一个微信 ，跑在 80 端口



![image-20240815233056369](./assets/image-20240815233056369.png)



![image-20240815233106541](./assets/image-20240815233106541.png)



没问题，还要改一下那个



![image-20240815233123630](./assets/image-20240815233123630.png)



这里要改成自己的服务器 ip，后面有域名了可以再改



![image-20240815233226114](./assets/image-20240815233226114.png)



试试吧，本地先停掉，我知道了，网关层有问题



我老是登录不过去



![image-20240815235347017](./assets/image-20240815235347017.png)



这里有个权限校验



![image-20240815235704818](./assets/image-20240815235704818.png)



卧槽，终于出来了，网关问题卡我，炸裂，我就应该看看日志的



![image-20240816100037126](./assets/image-20240816100037126.png)



头像那些也都出来了



![image-20240816100047939](./assets/image-20240816100047939.png)







##### 2.82 一期细节优化



1、分类和标签的性能优化，一次性查询出来，组装成树结构

2、去出题的按钮的权限交互。用户登录成功后，返回给前端，当前用户的相关权限。前端存到本地 localstorage 里面，进行按钮级别的前端交互。对于一些敏感的写操作，后端也应该提供一些权限接口

3、退出功能，token 失效的功能

4、个人信息页面的查询功能。

5、上传头像的功能

6、每次注册的时候，相同的 openId 要做校验。



##### 2.83 重复注册问题



![image-20240815212303316](./assets/image-20240815212303316.png)



这里改一下就行了



##### 2.84 个人信息查询



![image-20240815212820919](./assets/image-20240815212820919.png)



测试一下



![image-20240815213053939](./assets/image-20240815213053939.png)



没问题，这样就能直接拿到了



##### 2.85 用户退出



其实 satoken 已经帮我们实现得很好了



![image-20240815213337399](./assets/image-20240815213337399.png)



试试



![image-20240815213800475](./assets/image-20240815213800475.png)



现在还是已登录



![image-20240815213816896](./assets/image-20240815213816896.png)



直接成功，看看 redis



![image-20240815213849236](./assets/image-20240815213849236.png)



> 不能加双引号



![image-20240815214218668](./assets/image-20240815214218668.png)



redis 里面的数据会直接移除掉

![image-20240815214507503](./assets/image-20240815214507503.png)



妙啊



##### 2.86 上传头像



oss 服务里面我们可以自己做一个接口了



![image-20240815214420893](./assets/image-20240815214420893.png)



minio 还活着



![image-20240815214642217](./assets/image-20240815214642217.png)



试试



![image-20240815214805750](./assets/image-20240815214805750.png)



配置中心 没问题



![image-20240815215511973](./assets/image-20240815215511973.png)



直接没问题



![image-20240815215555358](./assets/image-20240815215555358.png)



能传



##### 2.87 分类题目数量更新



分类里面的接口



dto 加上数量

![image-20240815220206745](./assets/image-20240815220206745.png)

bo 也要加



![image-20240815220234028](./assets/image-20240815220234028.png)



OK，



![image-20240815220551986](./assets/image-20240815220551986.png)



注意要 clean 一下



![image-20240815221030184](./assets/image-20240815221030184.png)



当然 0 是因为数据库里面没有这三个分类的题目

![image-20240815221118943](./assets/image-20240815221118943.png)



查个 2，不是不是，是数据库的问题，没有这样的数据



![image-20240815221652617](./assets/image-20240815221652617.png)



没问题



##### 2.88 分类标签性能优化



一次性查出来【分类和标签的性能优化，一次性查询出来，组装成树结构】



直接新建一个接口



![image-20240815222218422](./assets/image-20240815222218422.png)



这个要再加一个



![image-20240815224217648](./assets/image-20240815224217648.png)



这里还挺超前，直接重启试试



![image-20240815224542472](./assets/image-20240815224542472.png)



查出分类的同时，标签也拿到了



##### 2.89 用户权限获取



之前就写了 增删改



![image-20240816101902008](./assets/image-20240816101902008.png)



直接加一个接口



![image-20240816102238579](./assets/image-20240816102238579.png)



重启试试



![image-20240816102557526](./assets/image-20240816102557526.png)



调用成功了

但是我现在这个用户没有任何权限



![image-20240816102817513](./assets/image-20240816102817513.png)



前端这儿也过不去，改库看看



不对，是从 redis 里面拿的，现在 redis 里面根本没有，我要改一下登录的逻辑，登录的时候要把 权限也写进去【因为现在的逻辑是从 redis 里面拿这个人的权限】



先不动他这个逻辑，我现在重新注册了一下



![image-20240816105638069](./assets/image-20240816105638069.png)



缓存里面就会放入权限信息和角色信息，现在我再去获取



![image-20240816105726533](./assets/image-20240816105726533.png)



这样就能拿到了

![image-20240816105742464](./assets/image-20240816105742464.png)



前端也能点过去了



##### 2.90 利用minio的mc突破图片权限



minio 有效期只有 7 天



先是去简化了一波 url 

![image-20240816110512050](./assets/image-20240816110512050.png)



这个东西访问不了



![image-20240816110605979](./assets/image-20240816110605979.png)



要用这个东西



![image-20240816110652372](./assets/image-20240816110652372.png)



没有权限



一个一个来



![image-20240816110808256](./assets/image-20240816110808256.png)



直接启动容器



```
docker run -it --entrypoint=/bin/sh minio/mc
```



![image-20240816110833270](./assets/image-20240816110833270.png)



直接进去了，执行命令



```
mc config host add <ALIAS> <YOUR-S3-ENDPOINT> <YOUR-ACCESS-KEY> <YOUR-SECRET-KEY> [--api API-SIGNATURE]

mc config host add minio http://116.196.77.213:9000 YyCL6ZvDyiashaqYebNO MPna3sBxaGYXqEBRYrDYaCzSS1OXHB1DOJ70WEAq
```



![image-20240816110943332](./assets/image-20240816110943332.png)



这玩意儿要创建成自己的



![image-20240816111039813](./assets/image-20240816111039813.png)



执行这个命令



![image-20240816111102141](./assets/image-20240816111102141.png)



成功添加



```
mc ls minio
```



![image-20240816111123457](./assets/image-20240816111123457.png)



```
mc anonymous
```



![image-20240816111234791](./assets/image-20240816111234791.png)



卡在 100 % 了



这个好像就是开启一个匿名访问



```
mc anonymous set download minio/xiongclub
```



![image-20240816111755187](./assets/image-20240816111755187.png)



这个好像是开启下载权限



![image-20240816111830916](./assets/image-20240816111830916.png)



确实可以下载了



![image-20240816111908952](./assets/image-20240816111908952.png)



访问也没问题了， 可以了，再传一张试试



![image-20240816111956176](./assets/image-20240816111956176.png)



直接把这个 url 设置成头像



![image-20240816112027305](./assets/image-20240816112027305.png)



没问题，就这样，但是更新有点问题，那个 id 没带上，更新不了【后面应该会处理的】



![image-20240816113438614](./assets/image-20240816113438614.png)



对吧，这个 bo 也没有 id



![image-20240816113657844](./assets/image-20240816113657844.png)



发现问题了，他写的是根据用户名更新，我是直接调的 plus 的方法



我换成他那样写吧



![image-20240816113956997](./assets/image-20240816113956997.png)



再试一次



![image-20240816114607436](./assets/image-20240816114607436.png)



成功，我太厉害了





#### 3. 项目开发流程【第二期】



在这之前，我要去造一些数据，题目数量还是太少



直接用了鸡翅的

![image-20240816131722379](./assets/image-20240816131722379.png)



将就着用吧，后面再加也行



##### 3.1 功能规划



###### 3.1.1 搜索功能



全文检索，技术选型 es。

安装 es。

xxl-job 定时任务，去做一个数据同步，全量数据导入

es 全文检索，做高亮





###### 3.1.2 点赞



自己点赞过的，这里肯定要有一个点赞过的 icon 的一个标识

后面的数量，意味着这道题目被多少个人点过赞。

如何去防刷点赞。疯狂的点赞，取消点赞。前端配合防抖，后端的点赞数量放到 redis 里面。数据库的持久化，可以通过定时任务来定时的刷新同步。



###### 3.1.3 我的点赞



展示，我们当前当过赞的所有的数据，来进行一波展示。



###### 3.1.4 收藏



原理上和我们的点赞其实是差不多的。



###### 3.1.5 我的收藏



展示我的收藏



###### 3.1.6 纠错



纠错当用户发现题目有问题，错误的话，就可以通过这个方式，来进行反馈，管理员



###### 3.1.7 快速刷题



加一个上一题，下一题。



###### 3.1.8 贡献榜



按照我的周维度，月维度，来做数据的存储。zset。和 redis 做大量的交互。【出题】



###### 3.1.9 feign 的微服务间调用

微服务之间的逻辑调用。这个就用 feign 了。



###### 3.1.10 打通用户上下文



配合 threadlocal，基于 token 来实现用户信息的上下文传递。



###### 3.1.11 二级缓存的使用



这个我们的这个点赞里面可以去引入





##### 3.2 futuretask 多线程优化分类查询



![image-20240816132604629](./assets/image-20240816132604629.png)



现在的痛点就是这里，现在完全是个同步的过程



![image-20240816132809705](./assets/image-20240816132809705.png)



加上线程池，这里没跟着做，最后会改成工厂来自定义实现



![image-20240816133412142](./assets/image-20240816133412142.png)



现在同步方式执行的方法， 执行时间为 242 ms



第一次优化



用默认线程工厂



![image-20240816133720475](./assets/image-20240816133720475.png)



拒绝策略是 callerrunpolicy

改代码

![image-20240816135042369](./assets/image-20240816135042369.png)



看看现在的时间



![image-20240816142146048](./assets/image-20240816142146048.png)



手敲的，看看效果



![image-20240816142222358](./assets/image-20240816142222358.png)



写错了改一下



![image-20240816142401048](./assets/image-20240816142401048.png)



确实是快了，但是没鸡翅明显，这是一种实现





##### 3.3 completablefuture实现多线程优化



![image-20240816143057948](./assets/image-20240816143057948.png)



看看



![image-20240816143244382](./assets/image-20240816143244382.png)



写错了



![image-20240816143250619](./assets/image-20240816143250619.png)



好



还是能查出来





##### 3.4 自定义线程工厂实现



![image-20240816143433498](./assets/image-20240816143433498.png)



然后改线程池的配置



![image-20240816143545137](./assets/image-20240816143545137.png)



就这样就行



再来测试一下



加个日志先



![image-20240816143648327](./assets/image-20240816143648327.png)



这里笔者多了空指针

![image-20240816144234022](./assets/image-20240816144234022.png)



在这里加个判空，再试一次



![image-20240816144252551](./assets/image-20240816144252551.png)



日志





![image-20240816144312941](./assets/image-20240816144312941.png)



##### 3.5 线程池到底设置多少数量



这个吃透，面试咔咔乱杀，配合视频

可能很多人都看到过一个线程数设置的理论：

1. CPU 密集型的程序 - 核心数 + 1
2. I/O 密集型的程序 - 核心数 * 2

不会吧，不会吧，真的有人按照这个理论规划线程数？



###### 3.5.1 线程数和CPU利用率的小测试



抛开一些操作系统，计算机原理不谈，说一个基本的理论（不用纠结是否严谨，只为好理解）：



**一个CPU核心，单位时间内只能执行一个线程的指令**

那么理论上，我一个线程只需要不停的执行指令，就可以跑满一个核心的利用率。

来写个死循环空跑的例子验证一下：

**测试环境：AMD Ryzen 5 3600, 6 - Core, 12 - Threads**

```
public class CPUUtilizationTest{
 public static void main(String[] args){
 //死循环，什么都不做
 while(true){
 }
 }}
```



运行这个例子后，来看看现在CPU的利用率：





![image-20240816144718219](./assets/image-20240816144718219.png)



从图上可以看到，我的3号核心利用率已经被跑满了

那基于上面的理论，我多开几个线程试试呢？



```
public class CPUUtilizationTest{
 public static void main(String[] args){
 for(int j =0; j <6; j++){
 new Thread(newRunnable(){
 @Override
 public void run(){
 while(true){
 }
 }
 }).start();
 }
 }}
```



此时再看CPU利用率，1/2/5/7/9/11 几个核心的利用率已经被跑满：

那如果开12个线程呢，是不是会把所有核心的利用率都跑满？答案一定是会的：



![image-20240816144741871](./assets/image-20240816144741871.png)



如果此时我把上面例子的线程数继续增加到24个线程，会出现什么结果呢？



![image-20240816144752839](./assets/image-20240816144752839.png)



从上图可以看到，CPU利用率和上一步一样，还是所有核心100%，不过此时负载已经从11.x增加到了22.x（load average解释参考https://scoutapm.com/blog/understanding-load-averages），说明此时CPU更繁忙，线程的任务无法及时执行。



现代CPU基本都是多核心的，比如我这里测试用的AMD 3600，6核心12线程（超线程），我们可以简单的认为它就是12核心CPU。那么我这个CPU就可以同时做12件事，互不打扰。

如果要执行的线程大于核心数，那么就需要通过操作系统的调度了。操作系统给每个线程分配CPU时间片资源，然后不停的切换，从而实现“并行”执行的效果。

但是这样真的更快吗？从上面的例子可以看出，**一个线程**就可以把**一个核心**的利用率跑满。如果每个线程都很“霸道”，不停的执行指令，不给CPU空闲的时间，并且同时执行的线程数大于CPU的核心数，就会导致操作系统**更频繁的执行切换线程执行**，以确保每个线程都可以得到执行。



不过切换是有代价的，**每次切换会伴随着寄存器数据更新，内存页表更新等操作**。虽然一次切换的代价和I/O操作比起来微不足道，但如果线程过多，线程切换的过于频繁，甚至在单位时间内切换的耗时已经大于程序执行的时间，就会导致CPU资源过多的浪费在上下文切换上，而不是在执行程序，得不偿失。



上面死循环空跑的例子，有点过于极端了，正常情况下不太可能有这种程序。



大多程序在运行时都会有一些 I/O操作，可能是读写文件，网络收发报文等，这些 I/O 操作在进行时时需要等待反馈的。比如网络读写时，需要等待报文发送或者接收到，在这个等待过程中，线程是等待状态，CPU没有工作。此时操作系统就会调度CPU去执行其他线程的指令，这样就完美利用了CPU这段空闲期，提高了CPU的利用率。

上面的例子中，程序不停的循环什么都不做，CPU要不停的执行指令，几乎没有啥空闲的时间。如果插入一段I/O操作呢，I/O 操作期间 CPU是空闲状态，CPU的利用率会怎么样呢？先看看单线程下的结果：



```
public class CPUUtilizationTest{
 public static void main(String[] args)throws InterruptedException{
 for(int n =0; n <1; n++){
 new Thread(newRunnable(){
 @Override
 public void run(){
 while(true){
 //每次空循环 1亿 次后，sleep 50ms，模拟 I/O等待、切换
 for(int i =0; i <100_000_000l; i++){ 
 }
 try{
 Thread.sleep(50);
 }
 catch(InterruptedException e){
 e.printStackTrace();
 }
 }
 }
 }).start();
 }
 }}
```



![image-20240816144819189](./assets/image-20240816144819189.png)



哇，唯一有利用率的9号核心，利用率也才50%，和前面没有sleep的100%相比，已经低了一半了。现在把线程数调整到12个看看：



单个核心的利用率60左右，和刚才的单线程结果差距不大，还没有把CPU利用率跑满，现在将线程数增加到18：



![image-20240816144831189](./assets/image-20240816144831189.png)



此时单核心利用率，已经接近100%了。由此可见，当线程中有 I/O 等操作不占用CPU资源时，操作系统可以调度CPU可以同时执行更多的线程。

现在将I/O事件的频率调高看看呢，把循环次数减到一半，50_000_000，同样是18个线程：



![image-20240816144846679](./assets/image-20240816144846679.png)



此时每个核心的利用率，大概只有70%左右了。



###### 3.5.2 线程数和CPU利用率的小总结



上面的例子，只是辅助，为了更好的理解线程数/程序行为/CPU状态的关系，来简单总结一下：

1. 一个极端的线程（不停执行“计算”型操作时），就可以把单个核心的利用率跑满，多核心CPU最多只能同时执行等于核心数的“极端”线程数
2. 如果每个线程都这么“极端”，且同时执行的线程数超过核心数，会导致不必要的切换，造成负载过高，只会让执行更慢
3. I/O 等暂停类操作时，CPU处于空闲状态，操作系统调度CPU执行其他线程，可以提高CPU利用率，同时执行更多的线程
4. I/O 事件的频率频率越高，或者等待/暂停时间越长，CPU的空闲时间也就更长，利用率越低，操作系统可以调度CPU执行更多的线程



###### 3.5.3 线程规划的公式



前面的铺垫，都是为了帮助理解，现在来看看书本上的定义。《Java 并发编程实战》介绍了一个线程数计算的公式：



![image-20240816144940053](./assets/image-20240816144940053.png)



如果希望程序跑到CPU的目标利用率，需要的线程数公式为：



![image-20240816144949661](./assets/image-20240816144949661.png)



公式很清晰，现在来带入上面的例子试试看：

如果我期望目标利用率为90%（多核90），那么需要的线程数为：

核心数12 * 利用率0.9 * (1 + 50(sleep时间)/50(循环50_000_000耗时)) ≈ 22

现在把线程数调到22，看看结果：



![image-20240816145002913](./assets/image-20240816145002913.png)



现在CPU利用率大概80+，和预期比较接近了，由于线程数过多，还有些上下文切换的开销，再加上测试用例不够严谨，所以实际利用率低一些也正常。

把公式变个形，还可以通过线程数来计算CPU利用率：



![image-20240816145012751](./assets/image-20240816145012751.png)





线程数22 / (核心数12 * (1 + 50(sleep时间)/50(循环50_000_000耗时))) ≈ 0.9

虽然公式很好，但在真实的程序中，**一般很难获得准确的等待时间和计算时间，因为程序很复杂，不只是“计算”**。一段代码中会有很多的内存读写，计算，I/O 等复合操作，精确的获取这两个指标很难，所以光靠公式计算线程数过于理想化。



###### 3.5.4 真实程序中的线程数



那么在实际的程序中，或者说一些Java的业务系统中，线程数（线程池大小）规划多少合适呢？

**先说结论：没有固定答案，先设定预期，比如我期望的CPU利用率在多少，负载在多少，GC频率多少之类的指标后，再通过测试不断的调整到一个合理的线程数**



比如一个普通的，SpringBoot 为基础的业务系统，默认Tomcat容器+HikariCP连接池+G1回收器，如果此时项目中也需要一个业务场景的多线程（或者线程池）来异步/并行执行业务流程。



此时我按照上面的公式来规划线程数的话，误差一定会很大。因为此时这台主机上，已经有很多运行中的线程了，Tomcat有自己的线程池，HikariCP也有自己的后台线程，JVM也有一些编译的线程，连G1都有自己的后台线程。这些线程也是运行在当前进程、当前主机上的，也会占用CPU的资源。



**所以受环境干扰下，单靠公式很难准确的规划线程数，一定要通过测试来验证。**



流程一般是这样：

1. 分析当前主机上，有没有其他进程干扰
2. 分析当前JVM进程上，有没有其他运行中或可能运行的线程
3. 设定目标
4. 目标CPU利用率 - 我最高能容忍我的CPU飙到多少？
5. 目标GC频率/暂停时间 - 多线程执行后，GC频率会增高，最大能容忍到什么频率，每次暂停时间多少？
6. 执行效率 - 比如批处理时，我单位时间内要开多少线程才能及时处理完毕
7. ……
8. 梳理链路关键点，是否有卡脖子的点，因为如果线程数过多，链路上某些节点资源有限可能会导致大量的线程在等待资源（比如三方接口限流，连接池数量有限，中间件压力过大无法支撑等）
9. 不断的增加/减少线程数来测试，按最高的要求去测试，最终获得一个“满足要求”的线程数**

**而且而且而且！不同场景下的线程数理念也有所不同：**

1. Tomcat中的maxThreads，在Blocking I/O和No-Blocking I/O下就不一样
2. Dubbo 默认还是单连接呢，也有I/O线程（池）和业务线程（池）的区分，I/O线程一般不是瓶颈，所以不必太多，但业务线程很容易称为瓶颈
3. Redis 6.0以后也是多线程了，不过它只是I/O 多线程，“业务”处理还是单线程

**所以，不要纠结设置多少线程了。没有标准答案，一定要结合场景，带着目标，通过测试去找到一个最合适的线程数。**

可能还有同学可能会有疑问：“我们系统也没啥压力，不需要那么合适的线程数，只是一个简单的异步场景，不影响系统其他功能就可以”

很正常，很多的内部业务系统，并不需要啥性能，稳定好用符合需求就可以了。那么我的推荐的线程数是：**CPU核心数**



###### 3.5.5 附录



**Java 获取CPU核心数**

Runtime.getRuntime().availableProcessors()//获取逻辑核心数，如6核心12线程，那么返回的是12

**Linux 获取CPU核心数**

\# 总核数 = 物理CPU个数 X 每颗物理CPU的核数 # 总逻辑CPU数 = 物理CPU个数 X 每颗物理CPU的核数 X 超线程数

\# 查看物理CPU个数cat /proc/cpuinfo|grep"physical id"|sort|uniq|wc-l

\# 查看每个物理CPU中core的个数(即核数)cat /proc/cpuinfo|grep"cpu cores"|uniq

\# 查看逻辑CPU的个数cat /proc/cpuinfo|grep"processor"|wc-l



##### 3.6 用户上下文打通架构及详细设计



###### 3.6.1 链路流程



![image-20240816145329763](./assets/image-20240816145329763.png)



###### 3.6.2 详细设计



![image-20240816145407078](./assets/image-20240816145407078.png)



##### 3.7 gateway网关拦截自定义header



![image-20240816145716830](./assets/image-20240816145716830.png)



这里还没做完，还要直接上一个 拦截器



![image-20240816150623765](./assets/image-20240816150623765.png)



登录拦截器



![image-20240816150816507](./assets/image-20240816150816507.png)



设置上下文，这样就把 LoginId 放到 ThreadLocal 中了



一个工具类

![image-20240816151031839](./assets/image-20240816151031839.png)



![image-20240816151145399](./assets/image-20240816151145399.png)



直接试试效果【这里前面没做对】



![image-20240816151905803](./assets/image-20240816151905803.png)



网关这里是这样的，这样做了之后，我们的request 就会都多一个 header



![image-20240816152358616](./assets/image-20240816152358616.png)



拿这个做测试



![image-20240816152413413](./assets/image-20240816152413413.png)



其实已经拦下来了



![image-20240816152708121](./assets/image-20240816152708121.png)



请求的这个接口



![image-20240816152751215](./assets/image-20240816152751215.png)



走下去，loginId 确实就直接拿到了，

![image-20240816152818238](./assets/image-20240816152818238.png)



确实是我的



![image-20240816153106484](./assets/image-20240816153106484.png)



在接口那儿再停一下



![image-20240816153220766](./assets/image-20240816153220766.png)



没毛病，它把这个塞进来了

![image-20240816153352280](./assets/image-20240816153352280.png)



这就是我的 username 



![image-20240816153409967](./assets/image-20240816153409967.png)



没问题



##### 3.8 基于threadlocal实现上下文传递



这下我们可以自己整一个拦截器来处理这个 loginId



![image-20240816153640118](./assets/image-20240816153640118.png)



![image-20240816153647796](./assets/image-20240816153647796.png)



![image-20240816153734158](./assets/image-20240816153734158.png)



看看能不能拿到先



![image-20240816153758476](./assets/image-20240816153758476.png)



没问题，拿到了，拿到之后就可以存下来了，放到我们的上下文中



![image-20240816153846812](./assets/image-20240816153846812.png)



之前这个地方就不用管了



![image-20240816153924368](./assets/image-20240816153924368.png)



这下我们可以在任何地方去拿到这个 loginId



![image-20240816154029808](./assets/image-20240816154029808.png)



这里加了一个工具类，我们就可以在需要的地方去拿到这个 loginId，对外使用



![image-20240816154212151](./assets/image-20240816154212151.png)



还是刚刚那个位置，这下我就不用从 request 里面拿，直接用这个工具类



试试



![image-20240816154310351](./assets/image-20240816154310351.png)



没有任何毛病，拿到了，这样上下文就打通了



##### 3.9 服务器中挖矿病毒解决



这里鸡哥是解决了一个线上问题，服务器中病毒了



![image-20240816154520837](./assets/image-20240816154520837.png)



CPU 异常飙升，排查，top 命令



![image-20240816154610278](./assets/image-20240816154610278.png)





##### 3.10 openFeign的意义



openfeign 是 spring cloud 搞出来的一个升级版，netflix 的 feign 这个不维护了。

openfeign 他就是声明式的 webservice 的客户端，使用 feign，编写调用更加的简单，主要打上注解就可以进行一个调用。



```
String responese = service.hello();
```



一行代码直接搞定。

feign 就帮助我们把 http 的调用编的非常的容易和方便，他整体的实现就是利用了 resttemplate 对 http 的一个封装。

feign 通过注解的方式配置之后，就可以完成接口的自动绑定，那我们调用 feign 的时候就像掉接口一样，内置负载。内部封装了 ribbon。





##### 3.11 微服务之间的feign调用



之前 预留的 api 层，一直没写，现在开搞



比如说我在刷题的 domain 要调获取用户信息的接口，我们现在就要把 auth 服务这个能力放到 api 里面



引依赖



![image-20240816155534022](./assets/image-20240816155534022.png)



用户服务 feign



![image-20240816160040423](./assets/image-20240816160040423.png)



这下在 controller 层就可以引入 这个 api 



![image-20240816160211349](./assets/image-20240816160211349.png)



![image-20240816160404580](./assets/image-20240816160404580.png)



现在这些接口里面用的 result 就是 api 层的 result 了，common 已经搬过去了，是切过去 了



![image-20240816160542319](./assets/image-20240816160542319.png)



我丢，回到 题目模块，我想用这个服务，直接引 api 就行了



![image-20240816160908908](./assets/image-20240816160908908.png)



![image-20240816161058762](./assets/image-20240816161058762.png)



测试一下



![image-20240816161320263](./assets/image-20240816161320263.png)



启动类加一个注解



![image-20240816161344736](./assets/image-20240816161344736.png)



试试

![image-20240816161549809](./assets/image-20240816161549809.png)



这样才对，改了一下，真炸裂



![image-20240816161727880](./assets/image-20240816161727880.png)



爆了一个一样的错，要指定一下扫包



![image-20240816161816183](./assets/image-20240816161816183.png)



再试一次



![image-20240816161846659](./assets/image-20240816161846659.png)



调一下，记得加上 token 



![image-20240816162226819](./assets/image-20240816162226819.png)



超，失败了



![image-20240816162318786](./assets/image-20240816162318786.png)



用户名给错了



![image-20240816162429251](./assets/image-20240816162429251.png)



过是过来了



![image-20240816162449785](./assets/image-20240816162449785.png)



查的也是这个



![image-20240816162515556](./assets/image-20240816162515556.png)



就是没查出来



额



![image-20240816162554386](./assets/image-20240816162554386.png)



有点问题，我直接调用也拿不到



通是通了，但是这个接口有毛病，不知道为啥【好像后面会处理，好像是因为我们处理了一下啊】



![image-20240816163332340](./assets/image-20240816163332340.png)



赋值好像有问题



![image-20240816163527819](./assets/image-20240816163527819.png)



好，转换出问题



![image-20240816163709044](./assets/image-20240816163709044.png)



重新构建了还是不行



![image-20240816163834723](./assets/image-20240816163834723.png)



我把原本的那个删掉了，引入了 auth api 里面的那个，再试一次



![image-20240816163907560](./assets/image-20240816163907560.png)



这下赋值上了





![image-20240816164118910](./assets/image-20240816164118910.png)



这个地方，要改一下，前面都改了，艹



![image-20240816164207708](./assets/image-20240816164207708.png)



注册中心也加了一个 

再试一次



![image-20240816164420644](./assets/image-20240816164420644.png)



这次没问题了，查出来了，改了服务名又不说，干鸡毛



##### 3.12 openFeign拦截器实现微服务上下文打通



![image-20240816164740222](./assets/image-20240816164740222.png)



把之前做那个上下文处理和拦截器都放到 了 auth 这边



![image-20240816164845013](./assets/image-20240816164845013.png)



config 把这个也加上，现在想看的东西是，这边 auth 也加上了，原本题目微服务那边我们做那个东西可以直接拿到 loginId，现在通过 feign 调用 auth查询个人信息，看看能不能也拿到 loginId





![image-20240816165212340](./assets/image-20240816165212340.png)



这里来个断点，我们再试一次



![image-20240816165310232](./assets/image-20240816165310232.png)



效果非常明显，auth 这边拿不到，说明什么，丢失了



![image-20240816165436303](./assets/image-20240816165436303.png)



当然查还是能够查出来，但是 那个 loginId 确实搞丢了

那么我们就要在 subject 服务这边再来一个拦截器【即 调用方 来做这个东西】



![image-20240816165716410](./assets/image-20240816165716410.png)



再注入一下啊

![image-20240816165901469](./assets/image-20240816165901469.png)



再试一次



![image-20240816165805951](./assets/image-20240816165805951.png)



还是在 auth 那边给个断点



![image-20240816165950897](./assets/image-20240816165950897.png)



效果非常明显，这次拿到了 之前丢失 的 loginId



这样链路传输，就完全打通了， 6666 





##### 3.13 guava本地缓存使用



![image-20240816170231065](./assets/image-20240816170231065.png)



就这些东西，其实变化较少，可以加一波缓存，让它访问更快



![image-20240816170314248](./assets/image-20240816170314248.png)



其实就是这个接口



![image-20240816170418458](./assets/image-20240816170418458.png)



调用的这里的这个方法



![image-20240816170729821](./assets/image-20240816170729821.png)



加一个最简单的本地缓存



![image-20240816170851271](./assets/image-20240816170851271.png)



直接抽成一个方法



简单修改传递参数

![image-20240816170944119](./assets/image-20240816170944119.png)



![image-20240816171247808](./assets/image-20240816171247808.png)



来吧，试试效果



![image-20240816171522261](./assets/image-20240816171522261.png)



sql 都在打印，马德我就说有问题



![image-20240816171643049](./assets/image-20240816171643049.png)



擦， 再试一次



![image-20240816171732199](./assets/image-20240816171732199.png)



第一次走了 sql



![image-20240816171748498](./assets/image-20240816171748498.png)



第二次还是走了sql



![image-20240816171818736](./assets/image-20240816171818736.png)



放错了，再来一次



![image-20240816171910189](./assets/image-20240816171910189.png)



第一次 1s ，走了 sql



![image-20240816171928479](./assets/image-20240816171928479.png)



还是走了 sql



![image-20240816172131873](./assets/image-20240816172131873.png)



我第三次好像就走缓存了，离谱【不对不对，我又重启试了一次，确实是两次就行】



##### 3.14 函数式编程+泛型实现本地缓存工具



优化之前写的东西



抽一个工具类



![image-20240816172516456](./assets/image-20240816172516456.png)



一个缓存工具类



![image-20240816172903098](./assets/image-20240816172903098.png)



试试



![image-20240816172942452](./assets/image-20240816172942452.png)



第一次走 sql

![image-20240816173007219](./assets/image-20240816173007219.png)



第二次不走 sql，方便，工具类，泛型





##### 3.15 全文检索功能设计



技术选型：elasticsearch。

我们的目的是，网站现在整体的题目预计会到好几百，方便咱们的用户快速的搜索到自己想看的内容。



###### 3.15.1 实现形式



同步的实现方式： 新增题目->MYSQL->es



![image-20240816173310328](./assets/image-20240816173310328.png)







异步 mq 的实现方式：mysql 存储完后，发送 mq。



![image-20240816173321221](./assets/image-20240816173321221.png)



异步 canal 方式：监听 mysql 变更的 binlog，实现 es 的存储。



![image-20240816173332953](./assets/image-20240816173332953.png)



先做同步的实现



##### 3.16 es 初步介绍



全称 elasticsearch。

隶属于 elsastic stack。[官网地址：https://www.elastic.co/cn/](https://www.elastic.co/cn/)



![image-20240816173541934](./assets/image-20240816173541934.png)



其中包含我们的 elasticsearch，kibana，beats，logstash。（ELK）。

es 主要是对数据进行搜索，分析，倒排。他是一个开源的高扩展的分布式全文搜索引擎。近实时的搜索。扩展性高。处理 PB 级别的数据。

为什么不用 mysql 做呢？

es 的特点：

1、搜索的数据对象大量的非结构化的文本

2、倒排索引

3、每个字段都可以被索引和搜索

4、近实时分析，还可以做聚合，支持各种查询



##### 3.17 es基础概念



###### 3.17.1 全文检索



比如我们的数据分为结构化和非结构化。非结构化数据，相当于是全文数据，文本，文档，图片啊。

搜索方式有两种：

1、顺序扫描

2、全文的搜索：帮助我们把非结构化数据的关键词进行提取，或者变成结构化，然后就可以按照一定的数据结构来记性搜索。每个词都帮我们建立一个索引，会标志出其中文本的出现次数和位置。



###### 3.17.2 倒排索引



```
我是经典鸡翅  id为1
我是程序员鸡翅 id为2
```



拆词！

我，是，经典，鸡翅

我，是，程序员，鸡翅

| 关键词 | 文档 id | 出现频次 | 出现位置 |
| ------ | ------- | -------- | -------- |
| 我     | 1,2     | 2        | 1        |
| 是     | 1,2     | 2        | 2        |
| 经典   | 1       | 1        | 3        |
| 鸡翅   | 1,2     | 2        | 5        |
| 程序员 | 2       | 1        | 6        |



###### 3.17.3 Index 索引



相对应与我们的关系数据库的 database。

作为我们的数据的最上面的一层。他是由索引名称，分片。有索引之后，放入文档。

一个 es 可以创建多个索引。



###### 3.17.4 Type类型



类型其实对应于索引来说内部的逻辑分区，一个索引内部可以对应一个或多个类型。类型当做是个文档的预定义，对应于数据库中的表



###### 3.17.5 Document 文档



文档就是真正存储数据的东西，这里面存了我们真正的内容，一般是 json 格式的数据。每个文档有一个类型和 id，每个文档由多个字段组成。



###### 3.17.6 es 概念上与数据库的对应关系



| es              | mysql      |
| --------------- | ---------- |
| Index           | Database   |
| Type            | Table      |
| Document        | 行数据 row |
| field           | 列         |
| mapping         | schema     |
| dsl             | sql        |
| get 形式的 http | select     |



##### 3.18 docker安装es & 图形化es



```
yum install -y yum-utils device-mapper-persistent-data lvm2

docker search elasticsearch

docker pull elasticsearch:7.3.1

docker run -d --name elasticsearch -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node"  -e ES_JAVA_OPTS="-Xms1024m -Xmx1024m" 3d3aa92f641f
```



启动成功之后，访问http://ip:9200/



![image-20240816174036812](./assets/image-20240816174036812.png)



![image-20240816174049339](./assets/image-20240816174049339.png)



![image-20240816174114074](./assets/image-20240816174114074.png)



慢慢拉



![image-20240816174916879](./assets/image-20240816174916879.png)



直接启动



![image-20240816174936940](./assets/image-20240816174936940.png)



访问一下啊



![image-20240816174957557](./assets/image-20240816174957557.png)



没问题



还有一个就是 一个插件，es-head，没听过诶



![image-20240816175309035](./assets/image-20240816175309035.png)



直接用 浏览器加载这个





![image-20240816175429275](./assets/image-20240816175429275.png)





![image-20240816175447292](./assets/image-20240816175447292.png)



固定到工具栏



![image-20240816175516978](./assets/image-20240816175516978.png)



连接上看看

![image-20240816175533327](./assets/image-20240816175533327.png)





![image-20240816175553544](./assets/image-20240816175553544.png)



不错不错，不用 装 kibana 也能用了



##### 3.19 http调用es熟悉操作



接口文档：



![image-20240816175733498](./assets/image-20240816175733498.png)



试试吧



创建索引

![image-20240816175925338](./assets/image-20240816175925338.png)

![image-20240816175944548](./assets/image-20240816175944548.png)

查看索引情况

![image-20240816180205010](./assets/image-20240816180205010.png)



查看单个索引

![image-20240816180233357](./assets/image-20240816180233357.png)



删除索引

![image-20240816180317290](./assets/image-20240816180317290.png)



![image-20240816180323634](./assets/image-20240816180323634.png)



创建文档

![image-20240816180455966](./assets/image-20240816180455966.png)

![image-20240816180526993](./assets/image-20240816180526993.png)



查看文档

![image-20240816180602238](./assets/image-20240816180602238.png)



删除文档

![image-20240816180643578](./assets/image-20240816180643578.png)



![image-20240816180650082](./assets/image-20240816180650082.png)



![image-20240816180710598](./assets/image-20240816180710598.png)



创建映射

![image-20240816180938744](./assets/image-20240816180938744.png)



查看映射

![image-20240816181022023](./assets/image-20240816181022023.png)



![image-20240816181048275](./assets/image-20240816181048275.png)



查看所有的文档

![image-20240816181207393](./assets/image-20240816181207393.png)



匹配文档

![image-20240816181240935](./assets/image-20240816181240935.png)



特定字段匹配文档

![image-20240816181309425](./assets/image-20240816181309425.png)



精准匹配

![image-20240816181339980](./assets/image-20240816181339980.png)



原生分词器分词



![image-20240816181417369](./assets/image-20240816181417369.png)





##### 3.20 es分词及ik中文分词器使用



我是经典鸡翅

es 原生的分词器。中国人要用中国分词器

分词器分的好，搜索的东西才展现的好。



插件地址：https://github.com/medcl/elasticsearch-analysis-ik/releases/download/v7.3.1/elasticsearch-analysis-ik-7.3.1.zip



解压后，上传到服务器 的 ik 文件夹下面

```
mkdir /soft/ik

进入容器内部
docker exec -it elasticsearch /bin/bash
cd plugins
mkdir ik

回到外部
docker cp /soft/ik/. e4569b178fb1:/usr/share/elasticsearch/plugins/ik

重启es
```





![image-20240816181751840](./assets/image-20240816181751840.png)



甩到 服务器上



![image-20240816181928379](./assets/image-20240816181928379.png)



哦哦，要解压



![image-20240816182136557](./assets/image-20240816182136557.png)



![image-20240816182417480](./assets/image-20240816182417480.png)



试试



![image-20240816182505971](./assets/image-20240816182505971.png)



没问题



##### 3.21 spring-data-es来操作es存储



传统代码操作



加依赖

![image-20240816183037215](./assets/image-20240816183037215.png)



先来一个实体类



![image-20240816183610955](./assets/image-20240816183610955.png)



再来个接口



![image-20240816183829952](./assets/image-20240816183829952.png)



就这样就行了



![image-20240816184051040](./assets/image-20240816184051040.png)



一个操作接口

再来个实现类



![image-20240816185001226](./assets/image-20240816185001226.png)



实现了创建索引的接口,试试



![image-20240816185055438](./assets/image-20240816185055438.png)



配置文件改一下啊，做一个测试接口试试



![image-20240816185244829](./assets/image-20240816185244829.png)



直接调一下，看看有没有问题



![image-20240816185417887](./assets/image-20240816185417887.png)



发送



![image-20240816185452926](./assets/image-20240816185452926.png)



先把原本这个干掉



![image-20240816185510267](./assets/image-20240816185510267.png)



调用



![image-20240816185527400](./assets/image-20240816185527400.png)



没报错



![image-20240816185537339](./assets/image-20240816185537339.png)



确实创建成功了，我为什么不用加 loginId,，马德



mapping 信息：

![image-20240816185756502](./assets/image-20240816185756502.png)



也都没问题



剩下的我就没做了，只是一个演示，后面用不上

艹，还是做一下吧



创建文档

![image-20240816190728603](./assets/image-20240816190728603.png)





试试

![image-20240816191039014](./assets/image-20240816191039014.png)



调用结果



![image-20240816191203206](./assets/image-20240816191203206.png)



调用成功



![image-20240816191227450](./assets/image-20240816191227450.png)



只插了一个 ... 



![image-20240816191244072](./assets/image-20240816191244072.png)

id 错了，写冲了



![image-20240816191305806](./assets/image-20240816191305806.png)



再来一次



![image-20240816191421551](./assets/image-20240816191421551.png)



没问题



再来一个查询



![image-20240816192038673](./assets/image-20240816192038673.png)



试试



![image-20240816192058485](./assets/image-20240816192058485.png)



调用结果



![image-20240816192149687](./assets/image-20240816192149687.png)



没问题



当然这算 search，试试直接 findall 



![image-20240816192608490](./assets/image-20240816192608490.png)



试试



![image-20240816192857788](./assets/image-20240816192857788.png)



写错了



![image-20240816193017196](./assets/image-20240816193017196.png)



没问题



这就是基础的实现



##### 3.22 设计自定义封装es



我们希望的一个目的

1、有自己的封装好的工具

2、集群，索引等等都要兼容的配置的概念

3、不想用 data 的这种方式，不够扩展



![image-20240816193640171](./assets/image-20240816193640171.png)



整体基于 es 的原生的 client 来去做。





##### 3.23 自定义封装集群es连接统一管理



添加依赖



![image-20240816194427396](./assets/image-20240816194427396.png)



starter 都不要了



来吧



集群类



![image-20240816194701279](./assets/image-20240816194701279.png)



配置类



![image-20240816194735992](./assets/image-20240816194735992.png)



这样就要修改一下配置文件了



![image-20240816195306045](./assets/image-20240816195306045.png)



索引类



![image-20240816195335001](./assets/image-20240816195335001.png)



封装请求类



![image-20240816195429243](./assets/image-20240816195429243.png)



源数据：



![image-20240816195554492](./assets/image-20240816195554492.png)



自定义工具类



![image-20240816195832979](./assets/image-20240816195832979.png)



直接启动看看，能不能链接上



![image-20240816202059364](./assets/image-20240816202059364.png)



没问题【上上节的代码要全部干掉【要么直接注了，要么直接删了】，因为没那个依赖了】



##### 3.24 封装es常用操作



连接有了，这下就是各种 api 的封装



![image-20240816203759991](./assets/image-20240816203759991.png)



新增、更新、批量新增 ...



##### 3.25 新增题目同步到es



![image-20240816204259278](./assets/image-20240816204259278.png)



差不多就是这么些个数据

字段名：



![image-20240816204350650](./assets/image-20240816204350650.png)





编写接口，之前都是闹着玩儿的



![image-20240816204433347](./assets/image-20240816204433347.png)



清空接口



![image-20240816204931815](./assets/image-20240816204931815.png)



然后去插入题目那个服务



![image-20240816205259460](./assets/image-20240816205259460.png)



先把之前的索引删掉

![image-20240816205340661](./assets/image-20240816205340661.png)





直接在这个可视化界面建一个



![image-20240816205424288](./assets/image-20240816205424288.png)



![image-20240816205432223](./assets/image-20240816205432223.png)



成功



创建 mapping 就用 postman



![image-20240816205558878](./assets/image-20240816205558878.png)



![image-20240816205622391](./assets/image-20240816205622391.png)



没问题

直接重启项目



![image-20240816205820494](./assets/image-20240816205820494.png)



集群也连接上了，来，插入一个新题目



![image-20240816205850321](./assets/image-20240816205850321.png)



当前所有还没有数据



![image-20240816210143218](./assets/image-20240816210143218.png)



插入成功了，看看es



![image-20240816210207741](./assets/image-20240816210207741.png)



没问题，直接进来了



![image-20240816210240663](./assets/image-20240816210240663.png)



数据库也插进来了



![image-20240816210320658](./assets/image-20240816210320658.png)



改一下 mapping 关系，



![image-20240816210408164](./assets/image-20240816210408164.png)



改成这样



![image-20240816210417940](./assets/image-20240816210417940.png)



前端也能够看见了



![image-20240816210433546](./assets/image-20240816210433546.png)



再来一个数据，一会儿要做高亮



![image-20240816210924230](./assets/image-20240816210924230.png)



![image-20240816210936217](./assets/image-20240816210936217.png)



没问题，es 插进去了



![image-20240816211235893](./assets/image-20240816211235893.png)



![image-20240816211241584](./assets/image-20240816211241584.png)



这样就看得见 MySQL 这道题了



##### 3.26 实现带高亮的网站全文检索



![image-20240816211546111](./assets/image-20240816211546111.png)



然后还要新增一个接口



![image-20240816211749229](./assets/image-20240816211749229.png)



试试

![image-20240816211836837](./assets/image-20240816211836837.png)



因为现在 es 中只有两条数据



![image-20240816211858942](./assets/image-20240816211858942.png)



接口测试

![image-20240816214943340](./assets/image-20240816214943340.png)



![image-20240816211913178](./assets/image-20240816211913178.png)



点击可以直接跳转到题目详情



![image-20240816211931602](./assets/image-20240816211931602.png)



【后面肯定要把所有题目都同步到 es  的】



##### 3.27 手写mybatis拦截器自动填充数据



又在 动代码了，大改



![image-20240816215438519](./assets/image-20240816215438519.png)



先动了这俩



![image-20240816215618527](./assets/image-20240816215618527.png)



然后 controller 那儿的登录拦截器 ，判断一下，不为空才放入上下文



现在想的是做一个拦截器，然后自动加上一些字段



![image-20240816215756813](./assets/image-20240816215756813.png)



比如这种字段



在 infra 里面做



![image-20240816215958575](./assets/image-20240816215958575.png)



加一个新的拦截器



试试效果



> 其实我觉得这个没有必要吧，MySQL 可以直接设置，创建时间就是新增时间，修改MySQL 也能直接做到，当然加入创建用户还是可以的



![image-20240816220342485](./assets/image-20240816220342485.png)



重启试试，直接新增一个题目吧



![image-20240816220747738](./assets/image-20240816220747738.png)



成功，看看数据库



![image-20240816220820058](./assets/image-20240816220820058.png)



没问题，用户是我，然后创建时间也是当前时间



![image-20240816221008411](./assets/image-20240816221008411.png)



但是mapping 表还是没有



![image-20240816221024414](./assets/image-20240816221024414.png)



简答表都成功了



![image-20240816221833624](./assets/image-20240816221833624.png)



又试了一次



![image-20240816221850553](./assets/image-20240816221850553.png)



mapping 表还是不行

![image-20240816221913275](./assets/image-20240816221913275.png)



题目表没问题

![image-20240816221924783](./assets/image-20240816221924783.png)



简答表也没问题



![image-20240816221948815](./assets/image-20240816221948815.png)



当然有了这个东西，

![image-20240816222002628](./assets/image-20240816222002628.png)



我可以直接在这里设置，试试



![image-20240816222300299](./assets/image-20240816222300299.png)



再试一次



![image-20240816222403910](./assets/image-20240816222403910.png)



![image-20240816222415743](./assets/image-20240816222415743.png)



简答表没问题



![image-20240816222429059](./assets/image-20240816222429059.png)



题目表没问题



![image-20240816222443019](./assets/image-20240816222443019.png)



mapping 表没问题！！！！！,我是我的神！打通了就是牛逼



当然评论区也有大哥给出了新的解决方案

![image-20240816223702681](./assets/image-20240816223702681.png)



试试

![image-20240816223810819](./assets/image-20240816223810819.png)



插入成功, 看看数据库

![image-20240816223831119](./assets/image-20240816223831119.png)



![image-20240816223840200](./assets/image-20240816223840200.png)



这两个本来就行，主要是 mapping 的批量插入



![image-20240816223910877](./assets/image-20240816223910877.png)



6，真行了



##### 3.28 排行榜功能设计



排行榜一般来说分为两种，实时的，非实时的。



###### 3.28.1 实时的方案



**数据库统计**

现在数据库里面的 createby 字段。用户的标识是唯一的，那我直接通过 group by 的形式统计 count。

select count(1),create_by from subject_info group by create_by limit 0,5;

数据量比较小，并发也比较小。这种方案是 ok 的。保证可以走到索引，返回速度快，不要产生慢 sql。

在数据库层面加一层缓存，接受一定的延时性。



**redis 的 sorted set**



有序集合，不允许重复的成员，然后每一个 key 都会包含一个 score 分数的概念。redis 根据分数可以帮助我们做从小到大，和从大到小的一个处理。

有序集合的 key 不可重复，score 重复。

它通过我们的一个哈希表来实现的，添加，删除，查找，复杂度 o(1) ，最大数量是 2 32 次方-1.

- zadd

- zrange

- zincrby

- zscore

这种的好处在于，完全不用和数据库做任何的交互，纯纯的通过缓存来做，速度非常快，要避免一些大 key 的问题。



###### 3.28.2 非实时



定时任务 xxl-job

统计数据库的数据形式，帮助我们统计完成后，直接写入缓存。缓存的外部的交互展示。





##### 3.29 传统数据库实现排行榜



直接新建一个接口



![image-20240817093328741](./assets/image-20240817093328741.png)



![image-20240817095755191](./assets/image-20240817095755191.png)



![image-20240817095738051](./assets/image-20240817095738051.png)



自己写 mapper 实现



试试



![image-20240817100657645](./assets/image-20240817100657645.png)



sql 能泡出来，哈哈，全是我创建的

直接重启



![image-20240817101733878](./assets/image-20240817101733878.png)



有点问题，应该封装的时候



![image-20240817101958559](./assets/image-20240817101958559.png)



其实用户信息已经拿到了



![image-20240817102104640](./assets/image-20240817102104640.png)



这里也已经拿到哦了



![image-20240817102128281](./assets/image-20240817102128281.png)



哦哦，我知道了，那个转换的问题，要重新 install 一下，



再试一次次

![image-20240817102301598](./assets/image-20240817102301598.png)



这次就出来了，看看前端



![image-20240817102320943](./assets/image-20240817102320943.png)



额，应该设置成 Nick



![image-20240817102350859](./assets/image-20240817102350859.png)



再试一次



![image-20240817102500133](./assets/image-20240817102500133.png)



没问题， 17 道题都我出的



![image-20240817102518457](./assets/image-20240817102518457.png)



OK，这就是传统 数据库的实现



##### 3.30 基于redis的zset实现排行榜



还是 domain 层



![image-20240817103210035](./assets/image-20240817103210035.png)



加上

然后就是工具类和配置类



![image-20240817103347357](./assets/image-20240817103347357.png)



这下就修改实现类



先是出题那里



![image-20240817103824581](./assets/image-20240817103824581.png)



同步到 es 后，还要放入 redis，岂不是又要那啥，插了才能获取数据

出一道题，数量才加1，我这里直接改redis 了



![image-20240817104054597](./assets/image-20240817104054597.png)



重启试试，插个题先



![image-20240817104355846](./assets/image-20240817104355846.png)



看看 redis ，这里还查不了



![image-20240817104456620](./assets/image-20240817104456620.png)



但是前端确实已经改了，我只有一道了，不对忘了配置 redis了 



![image-20240817104658622](./assets/image-20240817104658622.png)



再试一次，这次用的 0 库



![image-20240817104823869](./assets/image-20240817104823869.png)



看看 redis 



![image-20240817104840785](./assets/image-20240817104840785.png)



没问题，我直接手动改成 19



![image-20240817104911846](./assets/image-20240817104911846.png)



看看前端



![image-20240817104927301](./assets/image-20240817104927301.png)



没问题



##### 3.31 点赞与收藏功能设计



点赞与收藏的逻辑是非常一样的，我们这里就选取点赞功能来给大家做开发。

按照我们的鸡翅 club 的设计，点赞业务其实涉及几个方面，一、我们肯定要知道一个题目被多少人点过赞，还要知道，每个人他点赞了哪些题目。

点赞的业务特性，频繁。用户一多，时时刻刻都在进行点赞啊，收藏啊等等处理，如果说我们采取传统的数据库的模式啊，这个交互量是非常大的，很难去抗住这个并发问题，所以我们采取 redis 的方式来做。

查询的数据交互，我们可以和 redis 直接来做，持久化的数据，通过数据库查询即可，这个数据如何去同步到数据库，我们就采取的定时任务 xxl-job 定期来刷数据。



![image-20240817105353389](./assets/image-20240817105353389.png)



记录的时候三个关键信息，点赞的人，被点赞的题目，点赞的状态。

我们最终的数据结构就是 hash，string 类型。

hash，存到一个键里面，键里是一个 map，他又分为 hashkey 和 hashval。

hashkey，subjectId:userId，val 就存的是点赞的状态 1 是点赞 0 是不点赞。

string 类型 key subjectId，val 即使我们的题目被点赞的数量

string 类型。key subjectId:userId.



###### 3.31.1 数据库的设计



![image-20240817105704267](./assets/image-20240817105704267.png)



###### 3.31.2 新增点赞



直接操作 redis

存 hash，存数量，存点赞的人与题目的 key。



###### 3.31.2 取消点赞



上面的反逻辑，数量会-1，hash 里面的状态会更新，点赞人与题目关联的 key 会被删除



###### 3.32.3 查询当前题目被点赞的数量



直接与 redis 交互，读题目的被点赞数量的 key



###### 3.32.4 查询当前题目被当前用户是否点过赞



直接查 redis 就可以了。



###### 3.32.5 我的点赞



直接查数据库做分页逻辑的展示。



数据表：

```sql
DROP TABLE IF EXISTS `subject_liked`;
CREATE TABLE `subject_liked`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `subject_id`   bigint(20) DEFAULT NULL COMMENT '题目id',
    `like_user_id` varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '点赞人id',
    `status`       int(11) DEFAULT NULL COMMENT '点赞状态 1点赞 0不点赞',
    `created_by`   varchar(32) CHARACTER SET utf8  DEFAULT NULL COMMENT '创建人',
    `created_time` datetime                        DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) CHARACTER SET utf8  DEFAULT NULL COMMENT '修改人',
    `update_time`  datetime                        DEFAULT NULL COMMENT '修改时间',
    `is_deleted`   int(11) DEFAULT '0',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uniq_like` (`subject_id`,`like_user_id`) USING BTREE COMMENT '点赞唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='题目点赞表';
```







##### 3.32 代码生成器使用



这里是用到 鸡哥给的生成器

我先直接全部搬过来



![image-20240817111614639](./assets/image-20240817111614639.png)



![image-20240817112405556](./assets/image-20240817112405556.png)



这也是鸡哥做的另一个 starter ，要搞进来



![image-20240817112434476](./assets/image-20240817112434476.png)





![image-20240817112505472](./assets/image-20240817112505472.png)



直接 全部copy 过来



它下面有一个子模块叫 `easy-gen-code-spring-boot-starter`



![image-20240817112611861](./assets/image-20240817112611861.png)



![image-20240817112746009](./assets/image-20240817112746009.png)



![image-20240817113058958](./assets/image-20240817113058958.png)



包名全部都要改



![image-20240817113519509](./assets/image-20240817113519509.png)



全部改完，install 一下啊



![image-20240817113539503](./assets/image-20240817113539503.png)



这边就可以 引入了



![image-20240817113654889](./assets/image-20240817113654889.png)



一首歌的时间，完成，来吧直接运行



![image-20240817113729836](./assets/image-20240817113729836.png)



配置我觉得都没啥毛病



![image-20240817113754586](./assets/image-20240817113754586.png)



好，好好



![image-20240817113812957](./assets/image-20240817113812957.png)



再来



![image-20240817113834160](./assets/image-20240817113834160.png)



成功了



![image-20240817113853056](./assets/image-20240817113853056.png)



都在这里了



地方和名字不太对，重新来一次



![image-20240817114037706](./assets/image-20240817114037706.png)



改这里



![image-20240817114121392](./assets/image-20240817114121392.png)



再试一次



![image-20240817114134260](./assets/image-20240817114134260.png)



这里也要改一下啊



![image-20240817114158121](./assets/image-20240817114158121.png)



![image-20240817114212066](./assets/image-20240817114212066.png)



还有这个



![image-20240817114238622](./assets/image-20240817114238622.png)



再来一次



![image-20240817114306518](./assets/image-20240817114306518.png)



成功



![image-20240817114336960](./assets/image-20240817114336960.png)



66666 ，直接放进来了



![image-20240817114409815](./assets/image-20240817114409815.png)



包名好像有些问题



![image-20240817114523371](./assets/image-20240817114523371.png)



这里我就手动改一下了，顺便看看生成了一些什么东西



![image-20240817114624371](./assets/image-20240817114624371.png)



要自己导一下包



![image-20240817114732931](./assets/image-20240817114732931.png)



都改一下啊



![image-20240817114905043](./assets/image-20240817114905043.png)



这里确实暂时没找到，哪里改包名，可以一直 build， 哪里报错改哪里



![image-20240817115011857](./assets/image-20240817115011857.png)



不是很多，改完就行了，我还是想找一下哪儿 改包名



![image-20240817115148680](./assets/image-20240817115148680.png)



看见了，这些vm 肯定都要改，包名才能对，这里我已经改完了，看看后面还用不用吧



![image-20240817115417659](./assets/image-20240817115417659.png)



看还有没有机会吧，这样就 OK了



![image-20240817115622078](./assets/image-20240817115622078.png)



启动也没问题



##### 3.33 点赞功能开发



要调整一下生成的代码



![image-20240817115709877](./assets/image-20240817115709877.png)



![image-20240817120211676](./assets/image-20240817120211676.png)



然后是业务处理



![image-20240817120350453](./assets/image-20240817120350453.png)



我们要和 redis 交互，肯定不会这么简单，这些东西也都用不到，



![image-20240817121009314](./assets/image-20240817121009314.png)



试试吧



![image-20240817121058931](./assets/image-20240817121058931.png)



注意，题目服务用的 redis 是 0 库



![image-20240817121116970](./assets/image-20240817121116970.png)



这里面之前已经存了 贡献排行榜的信息



![image-20240817121433809](./assets/image-20240817121433809.png)



成功，看看数据库，redis 



![image-20240817121506437](./assets/image-20240817121506437.png)



多了三个键值对



![image-20240817121523495](./assets/image-20240817121523495.png)



没问题，如果再发一次



![image-20240817121656248](./assets/image-20240817121656248.png)



![image-20240817121736234](./assets/image-20240817121736234.png)



我这儿有点问题，噢噢噢噢，要改状态



![image-20240817121824568](./assets/image-20240817121824568.png)



这里重新来一遍，先只有一个点赞先



![image-20240817121907658](./assets/image-20240817121907658.png)



点赞完成



![image-20240817121929940](./assets/image-20240817121929940.png)



设置成 0 取消点赞



![image-20240817121946125](./assets/image-20240817121946125.png)



![image-20240817121952526](./assets/image-20240817121952526.png)



数量为 0， 第三个键消失，



![image-20240817122005516](./assets/image-20240817122005516.png)



关系也变为 0 个

没问题



##### 3.34 题目详情增加点赞数据



来吧，增加题目返回的属性



![image-20240817122243632](./assets/image-20240817122243632.png)



> 下面那个出错是我用了前端试试看看，但是后端还没写好，



BO 也要加



![image-20240817122455581](./assets/image-20240817122455581.png)



修改获取题目信息那儿的接口



![image-20240817122632495](./assets/image-20240817122632495.png)



把这俩数据加上



![image-20240817123238793](./assets/image-20240817123238793.png)



试试



先 clean 一下，因为我们又改了那些个 o，转换可能会有问题



就还是之前那个查询题目详情的接口



![image-20240817123957638](./assets/image-20240817123957638.png)



![image-20240817123943513](./assets/image-20240817123943513.png)



报错了，这个字段没有

![image-20240817124533999](./assets/image-20240817124533999.png)



这个原本的实体类也要加上吧？



![image-20240817124648262](./assets/image-20240817124648262.png)



加上试试，应该是不用加的，重新 install 一下【源码里面没加】



![image-20240817125350056](./assets/image-20240817125350056.png)



我知道问题了，又是我用了框架的问题，我这儿是原生的方法啊，鸡哥是自己写的



![image-20240817125447709](./assets/image-20240817125447709.png)



来吧，自己实现一下这个方法



![image-20240817125640751](./assets/image-20240817125640751.png)



这样绝逼就没问题了，再试一次



![image-20240817125742077](./assets/image-20240817125742077.png)



没问题，这次出来了，但是我明明给  1 这个点了啊



![image-20240817125803712](./assets/image-20240817125803712.png)



没点，忘了，取消了，点一个试试



![image-20240817125858336](./assets/image-20240817125858336.png)



![image-20240817125910333](./assets/image-20240817125910333.png)



再查一次



![image-20240817125925706](./assets/image-20240817125925706.png)



没毛病,直接看看前端



![image-20240817125953279](./assets/image-20240817125953279.png)



妙啊



##### 3.35 xxljob定时任务集成



###### 3.35.1 官方文档



官方文档：https://www.xuxueli.com/xxl-job/#%E3%80%8A%E5%88%86%E5%B8%83%E5%BC%8F%E4%BB%BB%E5%8A%A1%E8%B0%83%E5%BA%A6%E5%B9%B3%E5%8F%B0XXL-JOB%E3%80%8B



![image-20240817132530764](./assets/image-20240817132530764.png)





###### 3.35.2 技术交流

https://www.xuxueli.com/page/community.html



![image-20240817132630737](./assets/image-20240817132630737.png)







###### 3.35.3 特性



- 1、简单：支持通过 Web 页面对任务进行 CRUD 操作，操作简单，一分钟上手；
- 2、动态：支持动态修改任务状态、启动 / 停止任务，以及终止运行中任务，即时生效；
- 3、调度中心 HA（中心式）：调度采用中心式设计，“调度中心” 自研调度组件并支持集群部署，可保证调度中心 HA；
- 4、执行器 HA（分布式）：任务分布式执行，任务 "执行器" 支持集群部署，可保证任务执行 HA；
- 5、注册中心：执行器会周期性自动注册任务，调度中心将会自动发现注册的任务并触发执行。同时，也支持手动录入执行器地址；
- 6、弹性扩容缩容：一旦有新执行器机器上线或者下线，下次调度时将会重新分配任务；
- 7、路由策略：执行器集群部署时提供丰富的路由策略，包括：第一个、最后一个、轮询、随机、一致性 HASH、最不经常使用、最近最久未使用、故障转移、忙碌转移等；
- 8、故障转移：任务路由策略选择 "故障转移" 情况下，如果执行器集群中某一台机器故障，将会自动 Failover 切换到一台正常的执行器发送调度请求。
- 9、阻塞处理策略：调度过于密集执行器来不及处理时的处理策略，策略包括：单机串行（默认）、丢弃后续调度、覆盖之前调度；
- 10、任务超时控制：支持自定义任务超时时间，任务运行超时将会主动中断任务；
- 11、任务失败重试：支持自定义任务失败重试次数，当任务失败时将会按照预设的失败重试次数主动进行重试；其中分片任务支持分片粒度的失败重试；
- 12、任务失败告警；默认提供邮件方式失败告警，同时预留扩展接口，可方便的扩展短信、钉钉等告警方式；
- 13、分片广播任务：执行器集群部署时，任务路由策略选择 "分片广播" 情况下，一次任务调度将会广播触发集群中所有执行器执行一次任务，可根据分片参数开发分片任务；
- 14、动态分片：分片广播任务以执行器为维度进行分片，支持动态扩容执行器集群从而动态增加分片数量，协同进行业务处理；在进行大数据量业务操作时可显著提升任务处理能力和速度。
- 15、事件触发：除了 "Cron 方式" 和 "任务依赖方式" 触发任务执行之外，支持基于事件的触发任务方式。调度中心提供触发任务单次执行的 API 服务，可根据业务事件灵活触发。
- 16、任务进度监控：支持实时监控任务进度；
- 17、Rolling 实时日志：支持在线查看调度结果，并且支持以 Rolling 方式实时查看执行器输出的完整的执行日志；
- 18、GLUE：提供 Web IDE，支持在线开发任务逻辑代码，动态发布，实时编译生效，省略部署上线的过程。支持 30 个版本的历史版本回溯。
- 19、脚本任务：支持以 GLUE 模式开发和运行脚本任务，包括 Shell、Python、NodeJS、PHP、PowerShell 等类型脚本；
- 20、命令行任务：原生提供通用命令行任务 Handler（Bean 任务，"CommandJobHandler"）；业务方只需要提供命令行即可；
- 21、任务依赖：支持配置子任务依赖，当父任务执行结束且执行成功后将会主动触发一次子任务的执行，多个子任务用逗号分隔；
- 22、一致性：“调度中心” 通过 DB 锁保证集群分布式调度的一致性，一次任务调度只会触发一次执行；
- 23、自定义任务参数：支持在线配置调度任务入参，即时生效；
- 24、调度线程池：调度系统多线程触发调度运行，确保调度精确执行，不被堵塞；
- 25、数据加密：调度中心和执行器之间的通讯进行数据加密，提升调度信息安全性；
- 26、邮件报警：任务失败时支持邮件报警，支持配置多邮件地址群发报警邮件；
- 27、推送 maven 中央仓库：将会把最新稳定版推送到 maven 中央仓库，方便用户接入和使用；
- 28、运行报表：支持实时查看运行数据，如任务数量、调度次数、执行器数量等；以及调度报表，如调度日期分布图，调度成功分布图等；
- 29、全异步：任务调度流程全异步化设计实现，如异步调度、异步运行、异步回调等，有效对密集调度进行流量削峰，理论上支持任意时长任务的运行；
- 30、跨语言：调度中心与执行器提供语言无关的 RESTful API 服务，第三方任意语言可据此对接调度中心或者实现执行器。除此之外，还提供了 “多任务模式” 和 “httpJobHandler” 等其他跨语言方案；
- 31、国际化：调度中心支持国际化设置，提供中文、英文两种可选语言，默认为中文；
- 32、容器化：提供官方 docker 镜像，并实时更新推送 dockerhub，进一步实现产品开箱即用；
- 33、线程池隔离：调度线程池进行隔离拆分，慢任务自动降级进入 "Slow" 线程池，避免耗尽调度线程，提高系统稳定性；
- 34、用户管理：支持在线管理系统用户，存在管理员、普通用户两种角色；
- 35、权限控制：执行器维度进行权限控制，管理员拥有全量权限，普通用户需要分配执行器权限后才允许相关操作；



这里直接把那个工程 download 下来了，但是我觉得我们是不是用不到



稳一手看看【这是本地学习的形式】



后面会用docker 安装 xxljob



修改配置文件



![image-20240817133309826](./assets/image-20240817133309826.png)



这两集感觉顺序不太好



把依赖加上先



![image-20240817133414670](./assets/image-20240817133414670.png)



配置

![image-20240817133459385](./assets/image-20240817133459385.png)



这里我就不启动了，我本地没装



![image-20240817133754254](./assets/image-20240817133754254.png)



一个 job ， 同步点赞数据



一会儿 docker 装上了再说



![image-20240817133955795](./assets/image-20240817133955795.png)



这里简单演示了一下，就是能够定时的去调度我们提前定义好的工作



【回来了 ，那个数据库得建上】



![image-20240817134714781](./assets/image-20240817134714781.png)



就是初始化这个调度数据库



![image-20240817134752388](./assets/image-20240817134752388.png)



下载下来



![image-20240817134906751](./assets/image-20240817134906751.png)



就这个东西，执行一下就行，



![image-20240817134938190](./assets/image-20240817134938190.png)



嗯，语句也有



![image-20240817135047616](./assets/image-20240817135047616.png)



没问题



![image-20240817135142248](./assets/image-20240817135142248.png)



建出来就行，等着后面用那个 docker 



##### 3.36 docker安装xxljob



```
docker search xxl-job
docker pull xuxueli/xxl-job-admin:2.4.0
```



![image-20240817134237615](./assets/image-20240817134237615.png)



直接拉



![image-20240817134311207](./assets/image-20240817134311207.png)





![image-20240817134349126](./assets/image-20240817134349126.png)



等待完成



![image-20240817134420652](./assets/image-20240817134420652.png)



来吧，启动

```
docker run  -d \
        -p 8088:8088\
        -v /tool/xxl-job/logs:/data/applogs \
        -v /tool/xxl-job/application.properties:/xxl-job/xxl-job-admin/src/main/resources/application.properties \
        -e PARAMS="--server.port=8088\
        --spring.datasource.url=jdbc:mysql://116.196.77.213:3306/xxl_job?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&serverTimezone=Asia/Shanghai \
        --spring.datasource.username=root \
        --spring.datasource.password=19991012" \
        --name xxl-job-admin  \
xuxueli/xxl-job-admin:2.4.0
```



意思是那个 xxl_job 的数据库还是得建，行、【这里在前面补上一些提示】



来了



![image-20240817135207638](./assets/image-20240817135207638.png)





直接启动容器



![image-20240817135356618](./assets/image-20240817135356618.png)



开个端口



![image-20240817135317073](./assets/image-20240817135317073.png)



访问一下



http://116.196.77.213:8088/xxl-job-admin/toLogin



这个密码和账户，admin / 123456



![image-20240817135541335](./assets/image-20240817135541335.png)



![image-20240817135602550](./assets/image-20240817135602550.png)



这样就进来了

![image-20240817135620722](./assets/image-20240817135620722.png)



有一个送的任务，要修改一下配置文件了



先试试之前的那个，输出 123456 那个



![image-20240817135847867](./assets/image-20240817135847867.png)



在界面新增



![image-20240817135932699](./assets/image-20240817135932699.png)



保存



![image-20240817135945151](./assets/image-20240817135945151.png)



![image-20240817140131961](./assets/image-20240817140131961.png)



我这里把 9999 也打开了



![image-20240817140220349](./assets/image-20240817140220349.png)



先就这样启动看看



![image-20240817140357428](./assets/image-20240817140357428.png)



这里不对，应该写成本地，等跑在服务器再改成 服务器公网 ip



![image-20240817140506836](./assets/image-20240817140506836.png)



直接爆了，clean 了一下，重启



![image-20240817140802611](./assets/image-20240817140802611.png)



没问题，进来了



![image-20240817140829964](./assets/image-20240817140829964.png)



看看界面



![image-20240817140842541](./assets/image-20240817140842541.png)



没问题，这样就上来了



来一个任务



![image-20240817141004866](./assets/image-20240817141004866.png)



在这里新增



![image-20240817141134062](./assets/image-20240817141134062.png)



每秒一次



![image-20240817141146133](./assets/image-20240817141146133.png)



任务代码



![image-20240817141228876](./assets/image-20240817141228876.png)



重启一下

![image-20240817141338350](./assets/image-20240817141338350.png)



执行器没问题



![image-20240817141356340](./assets/image-20240817141356340.png)



日志清掉先

![image-20240817141417548](./assets/image-20240817141417548.png)



直接执行一次



![image-20240817141430756](./assets/image-20240817141430756.png)



看看日志



![image-20240817141458442](./assets/image-20240817141458442.png)



我的没打印  ... 擦

![image-20240817141900050](./assets/image-20240817141900050.png)



执行失败了



![image-20240817141925099](./assets/image-20240817141925099.png)



这个 ip 不太对吧，感觉这样写就是 docker 去调本地，但是本地没有这个任务，所以执行失败了



![image-20240817142153740](./assets/image-20240817142153740.png)



对，和我想的一样，刷题服务要跑在服务器上了才行



##### 3.37 redis的hash扫描同步点赞数据



这里我还是在本地跑一个吧，这一集也是在本地演示的



![image-20240817142455105](./assets/image-20240817142455105.png)



数据库我就不用变了



![image-20240817142544665](./assets/image-20240817142544665.png)



这里改一下就行



![image-20240817142602688](./assets/image-20240817142602688.png)



让他跑在 8088 端口



![image-20240817142634433](./assets/image-20240817142634433.png)



启动成功，访问一下



![image-20240817142700505](./assets/image-20240817142700505.png)



这下就是本地的



![image-20240817142728324](./assets/image-20240817142728324.png)



数据库用的同一个，所以任务和执行器都还在，这下我再泡一下

![image-20240817142749588](./assets/image-20240817142749588.png)



![image-20240817142803213](./assets/image-20240817142803213.png)



这次就打印出来了，甚至不用改配置文件



![image-20240817142826747](./assets/image-20240817142826747.png)



这里还是改一下吧

我们直接启动这个任务，我们设置的是每秒执行一次



![image-20240817142947516](./assets/image-20240817142947516.png)



没问题，每秒打印一次



这下其实就是修改这个任务真正要做的事儿



![image-20240817143046120](./assets/image-20240817143046120.png)



停止后，这边就不会输出了



![image-20240817143223563](./assets/image-20240817143223563.png)



批量插入到数据库就行



![image-20240817143556704](./assets/image-20240817143556704.png)



试试，直接重启



![image-20240817143633221](./assets/image-20240817143633221.png)



现在redis 里面的数据是只有这一条，看看执行任务能不能插到数据库里面



![image-20240817143708544](./assets/image-20240817143708544.png)



数据库的 like 表现在还是空的



![image-20240817143800385](./assets/image-20240817143800385.png)



执行一次

![image-20240817143808831](./assets/image-20240817143808831.png)



![image-20240817143814245](./assets/image-20240817143814245.png)



其实我已经看见sql 语句了，直接看数据表吧



![image-20240817143844588](./assets/image-20240817143844588.png)



没问题，插进来了



![image-20240817143924026](./assets/image-20240817143924026.png)



redis 中的第一个那个键值对也被干掉了，因为我们已经存到数据库里面了



##### 3.38 我的点赞功能开发



就是查一下，然后



![image-20240817144158461](./assets/image-20240817144158461.png)



在这个里面进行一个展示

加一个接口就行



![image-20240817144801203](./assets/image-20240817144801203.png)



![image-20240817144751625](./assets/image-20240817144751625.png)



![image-20240817145414577](./assets/image-20240817145414577.png)





直接启动试试



![image-20240817145655394](./assets/image-20240817145655394.png)



没问题，这样直接就查出来了



直接看看前端



![image-20240817145850609](./assets/image-20240817145850609.png)



这里还要细改一下，题目名称应该展示到这里



![image-20240817150123244](./assets/image-20240817150123244.png)



bo 这里加一个字段



![image-20240817150136760](./assets/image-20240817150136760.png)



每个都设置上

再看一次



![image-20240817150240719](./assets/image-20240817150240719.png)



dto 忘了，再来一次



![image-20240817150314842](./assets/image-20240817150314842.png)



没问题，前端



![image-20240817150337000](./assets/image-20240817150337000.png)



没问题



![image-20240817150353489](./assets/image-20240817150353489.png)



点击也能直接跳转到详情页



##### 3.39 快速刷题功能开发



其实就是加一个上一题、下一题

![image-20240817150552656](./assets/image-20240817150552656.png)



这个地方，修改查询题目详情那个接口就行

dto：



![image-20240817150732758](./assets/image-20240817150732758.png)



![image-20240817150807762](./assets/image-20240817150807762.png)



bo 里面也要加上

然后就是修改实现类了



![image-20240817151112273](./assets/image-20240817151112273.png)



试试，又改了实体，重新 clean 一下啊



![image-20240817151550543](./assets/image-20240817151550543.png)



第一道题没有上衣提提

试试 查 2 



![image-20240817151622826](./assets/image-20240817151622826.png)



没问题，看看前端



![image-20240817151757097](./assets/image-20240817151757097.png)



前端有点问题，它发请求没有带上 分类 id 和 标签 id



![image-20240817151941017](./assets/image-20240817151941017.png)



看了下，这里是注释掉了



![image-20240817152015128](./assets/image-20240817152015128.png)



放开试试，不行，感觉不对



![image-20240817152343935](./assets/image-20240817152343935.png)



就是这里，没有带上我们现在这个接口需要的参数，先往后面做着



这一集开始的时候，好像前端就不是很对，先往下走，至少接口确实已经实现了



##### 3.40 纠错功能说明



这里没细说，就让看源码 ... 额



![image-20240817152947886](./assets/image-20240817152947886.png)



看了下前端代码， 这个组件 1 已经没有使用了，它里面才有纠错的功能，![image-20240817153035027](./assets/image-20240817153035027.png)



试试换成这个，



![image-20240817153134846](./assets/image-20240817153134846.png)



额，算了，这也不是我的工作



##### 3.41 二期项目简历如何写及简历亮点



![image-20240817153449883](./assets/image-20240817153449883.png)



这些不变

在一期的基础上



![image-20240817153534718](./assets/image-20240817153534718.png)



增加



![image-20240817153552441](./assets/image-20240817153552441.png)

![image-20240817153612331](./assets/image-20240817153612331.png)



加粗版



![image-20240817153633937](./assets/image-20240817153633937.png)



好好好



#### 4. 项目开发流程【第三期】



##### 4.1 功能规划



![image-20240817153751625](./assets/image-20240817153751625.png)



把练题功能做掉



###### 4.1.1 练题主页面

练题的模式，我们一般来说，有专项练习，有模拟套卷，还可以选择未完成的。



![image-20240817153847892](./assets/image-20240817153847892.png)



选完套卷或者自定义专项之后，涉及题目的一个抽取，组卷。一般单选 10 道，多选 5 道，判断五道。

肯定用户需要知道当前是多少道题，是什么类型的题，计时器。

展示我们的答题的题目，来供大家选择。

标记一下

提前交卷，展示题目的未答的状态和答完的状态等等。



![image-20240817153900785](./assets/image-20240817153900785.png)





交卷后，应该干什么？

肯定要知道做对了那些题。技能图谱来展示我的六边形。

答案解析



![image-20240817153922302](./assets/image-20240817153922302.png)



![image-20240817153935253](./assets/image-20240817153935253.png)





##### 4.2 练题主页原型设计



分类

![image-20240817154151756](./assets/image-20240817154151756.png)



套题



![image-20240817154159796](./assets/image-20240817154159796.png)





##### 4.3 练题练习原型设计



![image-20240817154208457](./assets/image-20240817154208457.png)





##### 4.4 交卷及答案解析原型设计



![image-20240817154219539](./assets/image-20240817154219539.png)



![image-20240817154226267](./assets/image-20240817154226267.png)



##### 4.5 练习套卷数据库建模



题卷表



![image-20240817154911799](./assets/image-20240817154911799.png)





套卷题目明细表



![image-20240817155016548](./assets/image-20240817155016548.png)





##### 4.6 练习题目数据库建模



练习情况表



![image-20240817155122796](./assets/image-20240817155122796.png)



练题情况明细表



![image-20240817155142438](./assets/image-20240817155142438.png)





关联



![image-20240817155201970](./assets/image-20240817155201970.png)



##### 4.7 数据库表建立



套题信息表



```sql
DROP TABLE IF EXISTS `practice_set`;
CREATE TABLE `practice_set`
(
    `id`                  bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `set_name`            varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '套题名称',
    `set_type`            int(11) DEFAULT NULL COMMENT '套题类型 1实时生成 2预设套题',
    `set_heat`            int(11) DEFAULT NULL COMMENT '热度',
    `set_desc`            varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '套题描述',
    `primary_category_id` bigint(20) DEFAULT NULL COMMENT '大类id',
    `created_by`          varchar(32) CHARACTER SET utf8   DEFAULT NULL COMMENT '创建人',
    `created_time`        datetime                         DEFAULT NULL COMMENT '创建时间',
    `update_by`           varchar(32) CHARACTER SET utf8   DEFAULT NULL COMMENT '更新人',
    `update_time`         datetime                         DEFAULT NULL COMMENT '更新时间',
    `is_deleted`          int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='套题信息表';
```



套卷内容表



```sql
DROP TABLE IF EXISTS `practice_set_detail`;
CREATE TABLE `practice_set_detail`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `set_id`       bigint(20) NOT NULL COMMENT '套题id',
    `subject_id`   bigint(20) DEFAULT NULL COMMENT '题目id',
    `subject_type` int(11) DEFAULT NULL COMMENT '题目类型',
    `created_by`   varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '创建人',
    `created_time` datetime                       DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32) CHARACTER SET utf8 DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime                       DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='套题内容表';
```



练习表

```sql
DROP TABLE IF EXISTS `practice_info`;
CREATE TABLE `practice_info`
(
    `id`              bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `set_id`          bigint(20) DEFAULT NULL COMMENT '套题id',
    `complete_status` int(11) DEFAULT NULL COMMENT '是否完成 1完成 0未完成',
    `time_use`        varchar(32) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '用时',
    `submit_time`     datetime                        DEFAULT NULL COMMENT '交卷时间',
    `correct_rate`    decimal(10, 2)                  DEFAULT NULL COMMENT '正确率',
    `created_by`      varchar(32) CHARACTER SET utf8  DEFAULT NULL COMMENT '创建人',
    `created_time`    datetime                        DEFAULT NULL COMMENT '创建时间',
    `update_by`       varchar(32) CHARACTER SET utf8  DEFAULT NULL COMMENT '更新人',
    `update_time`     datetime                        DEFAULT NULL COMMENT '更新时间',
    `is_deleted`      int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='练习表';
```



练习详情表



```sql
DROP TABLE IF EXISTS `practice_detail`;
CREATE TABLE `practice_detail`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `practice_id`    bigint(20) DEFAULT NULL COMMENT '练题id',
    `subject_id`     bigint(20) DEFAULT NULL COMMENT '题目id',
    `subject_type`   int(11) DEFAULT NULL COMMENT '题目类型',
    `answer_status`  int(11) DEFAULT NULL COMMENT '回答状态',
    `answer_content` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '回答内容',
    `created_by`     varchar(32) CHARACTER SET utf8  DEFAULT NULL COMMENT '创建人',
    `created_time`   datetime                        DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32) CHARACTER SET utf8  DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime                        DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='练习详情表';
```



![image-20240817155842800](./assets/image-20240817155842800.png)



建立完成



##### 4.8 架构设计



`xiong-club-practice`



![image-20240817160044068](./assets/image-20240817160044068.png)



##### 4.9 练题微服务架构搭建



传新的模块



![image-20240817160216777](./assets/image-20240817160216777.png)



然后就是照着之前的 auth 那样，整



![image-20240817160346081](./assets/image-20240817160346081.png)



api 模块



![image-20240817160416354](./assets/image-20240817160416354.png)



![image-20240817160959006](./assets/image-20240817160959006.png)





server 模块



![image-20240817161036407](./assets/image-20240817161036407.png)



![image-20240817162017918](./assets/image-20240817162017918.png)



引了一堆依赖



![image-20240817162915226](./assets/image-20240817162915226.png)



这里我用 3013 了，因为微信那个服务还在本地穿透着



![image-20240817163054356](./assets/image-20240817163054356.png)



就是说，直接 copy 了很多之前的东西放过来，启动试试



![image-20240817163234112](./assets/image-20240817163234112.png)



直接爆掉



![image-20240817163414176](./assets/image-20240817163414176.png)



再来一次

![image-20240817163849291](./assets/image-20240817163849291.png)



这里要移除掉一个，依赖冲突了



![image-20240817164329923](./assets/image-20240817164329923.png)



不是排除的问题，我把这个版本提上去 就启动成功了



![image-20240817164350654](./assets/image-20240817164350654.png)



试试那个 接口



![image-20240817164531897](./assets/image-20240817164531897.png)



没问题



##### 4.10 彩蛋：彩色日志



![image-20240817164630721](./assets/image-20240817164630721.png)



现在的日志都是黑白的



源码没给啊



![image-20240817165224863](./assets/image-20240817165224863.png)



![image-20240817170004006](./assets/image-20240817170004006.png)



一般，代码放这里



```
        <property name="LOG_PATTERN" value="%highlight{%d{yyyy-MM-dd HH:mm:ss.SSS} | %X{PFTID} | %highlight{%style{[%t]}{GREEN}} | %highlight{%style{%-5level}{BLUE}} | %highlight{%style{%logger{36}}{BOLD,MAGENTA}} | %highlight{%style{%msg}{CYAN}}%n}{GREEN}"/>
```





##### 4.11 练题功能设计



看了下前端页面【成品：http://jichiclub.com/practise-questions】



![image-20240817170356948](./assets/image-20240817170356948.png)















![image-20240817170410717](./assets/image-20240817170410717.png)





![image-20240817170429179](./assets/image-20240817170429179.png)













##### 4.12 专项练习开发



![image-20240817170529279](./assets/image-20240817170529279.png)





功能实现方式：

1、查询拥有单选，多选，判断的岗位

2、查询岗位下分类 

3、根据分类和类型查询题目



传新 controller 



![image-20240817170722374](./assets/image-20240817170722374.png)



第一个接口，获取专项练习内容



![image-20240817171302520](./assets/image-20240817171302520.png)



业务层



![image-20240817174544710](./assets/image-20240817174544710.png)



真顶 啊



直接重启看看前端

先测试一下

![image-20240817174748905](./assets/image-20240817174748905.png)



成功了，但是我数据库并没有数据，先放着，下一集就造





##### 4.13 如何debug调试程序



可以直接用到了出题那个前端页面



![image-20240817175133086](./assets/image-20240817175133086.png)





![image-20240817175150550](./assets/image-20240817175150550.png)



可以，我再加点标签和大类，不用加了，用的就是 后端、缓存、Redis



先来个单选



![image-20240817175351470](./assets/image-20240817175351470.png)



![image-20240817175536892](./assets/image-20240817175536892.png)



直接提交



![image-20240817175556689](./assets/image-20240817175556689.png)



让我康康数据库



![image-20240817175623122](./assets/image-20240817175623122.png)



单选表

![image-20240817175646267](./assets/image-20240817175646267.png)



















题目关系

![image-20240817175704126](./assets/image-20240817175704126.png)



label 是 redis，分类是 缓存，妙哇



![image-20240817175744727](./assets/image-20240817175744727.png)



确实插进去了，不错，前端加鸡腿

再来个多选



![image-20240817175958274](./assets/image-20240817175958274.png)





![image-20240817180006509](./assets/image-20240817180006509.png)



可以



![image-20240817180016237](./assets/image-20240817180016237.png)



加进来就行



![image-20240817180041182](./assets/image-20240817180041182.png)



就是没设置答案





再来个判断题



![image-20240817180150540](./assets/image-20240817180150540.png)



6， 我这还真恰好有 数据库和 MySQL，我去



![image-20240817180211797](./assets/image-20240817180211797.png)



![image-20240817180231125](./assets/image-20240817180231125.png)



没问题的



![image-20240817180244787](./assets/image-20240817180244787.png)



插了这三道



现在就可以调上一节那个接口了



![image-20240817180516893](./assets/image-20240817180516893.png)



没问题，看看前端



![image-20240817180737793](./assets/image-20240817180737793.png)



我直接改个库吧



![image-20240817180808798](./assets/image-20240817180808798.png)



我的分类就是这些，再来一次



![image-20240817181054576](./assets/image-20240817181054576.png)



这样就对了，之前那个标签和分类的那儿，库不对



解决了一下那个查数量的问题

看看前端，要先配个网关



![image-20240817185711193](./assets/image-20240817185711193.png)



![image-20240817185734758](./assets/image-20240817185734758.png)



重启下网关，看看前端



![image-20240817185832182](./assets/image-20240817185832182.png)



没问题，出来了



##### 4.14 开始练习功能设计



###### 4.14.1 功能过程



1、解析参数，校验

2、找到用户选择标签下面的题目，通过动态配置的设定，来去进行题目的选择。比如说选择 10 套，多选 6 道，判断 4 道。

3、存入我们的 practice_set,practice_set_detail

4、要根据选择的标签来做一波默认的套卷的名称。





##### 4.15 开始练习功能开发



好好好，刚一开始就结束了，擦

![image-20240817190643590](./assets/image-20240817190643590.png)



我现在肯定不行，我看看它要调啥接口



![image-20240817190711937](./assets/image-20240817190711937.png)



OK



![image-20240817191304159](./assets/image-20240817191304159.png)



实现类就复杂了



![image-20240817191401540](./assets/image-20240817191401540.png)



好好好，我就三个题



![image-20240817192616176](./assets/image-20240817192616176.png)



试试，重启，接口调用



![image-20240817193049438](./assets/image-20240817193049438.png)



这里我就要把 2-1 和 3-3 全部传了，因为我没那么多题

![image-20240817193114449](./assets/image-20240817193114449.png)



有题的就这两个分类，然后对应两个标签



![image-20240817193212899](./assets/image-20240817193212899.png)



成功，setId 为 1



看下数据库



![image-20240817193248884](./assets/image-20240817193248884.png)



没问题，这里那个是否删除不应该注，因为用的自己写的

一样一道



另一个表

![image-20240817193453417](./assets/image-20240817193453417.png)



没问题，这个接口就算完事儿了

我直接在前端试试



![image-20240817193619141](./assets/image-20240817193619141.png)



开始练习



![image-20240817193636343](./assets/image-20240817193636343.png)



没问题，确实进来了【后面当然还有逻辑，就不对】，看看数据库



![image-20240817193703945](./assets/image-20240817193703945.png)



没问题

![image-20240817193718383](./assets/image-20240817193718383.png)



而且加上了 created_by，没毛病





##### 4.16 获取题目练习题功能开发



就之前开始练习了，但是题目并没有拿到，哈哈，这下就做



![image-20240817194001149](./assets/image-20240817194001149.png)



还是一个新接口，因为套卷我们已经生成了，现在就是根据这个套卷去把题拿出来



![image-20240817194244761](./assets/image-20240817194244761.png)



实现类



![image-20240817195451270](./assets/image-20240817195451270.png)



重启，试试



![image-20240817200054512](./assets/image-20240817200054512.png)



没毛病



##### 4.17 获取练习题详情



上一节已经获取到了这套题的 list，这下要再把详情抓出来展示



新接口



![image-20240817201017471](./assets/image-20240817201017471.png)



![image-20240817201025437](./assets/image-20240817201025437.png)





![image-20240817205116280](./assets/image-20240817205116280.png)



没问题，这下可以看看前端了



![image-20240817205159947](./assets/image-20240817205159947.png)



又来出一道



![image-20240817205219543](./assets/image-20240817205219543.png)



没问题





##### 4.18 增加练习概念



![image-20240817205438099](./assets/image-20240817205438099.png)



![image-20240817205456605](./assets/image-20240817205456605.png)



对这两张表进行了解释



![image-20240817205601381](./assets/image-20240817205601381.png)



这两个额外加上



![image-20240817205712893](./assets/image-20240817205712893.png)



入参也加上这个练习 id，然后在 获取题目的时候加上一些逻辑



![image-20240817210018631](./assets/image-20240817210018631.png)



还有更新逻辑



![image-20240817210106072](./assets/image-20240817210106072.png)



试试，这个就是那个 练习 id



![image-20240817210135920](./assets/image-20240817210135920.png)



![image-20240817210158665](./assets/image-20240817210158665.png)









##### 4.19 提交试卷开发



新controller，新接口



![image-20240817210441564](./assets/image-20240817210441564.png)



第一个，提交练题情况



![image-20240817211554544](./assets/image-20240817211554544.png)







实现类



![image-20240817211840813](./assets/image-20240817211840813.png)



试试

我先给我那三个题看看正确答案，我记得出的时候没设置



单选

![image-20240817212228185](./assets/image-20240817212228185.png)



多选

![image-20240817212244901](./assets/image-20240817212244901.png)



判断

![image-20240817212254896](./assets/image-20240817212254896.png)



试试，我直接在前端页面做一遍，然后交一下啊



![image-20240817212320543](./assets/image-20240817212320543.png)



出题，肯定是这三道题，因为只有这三道题非简答



![image-20240817212343643](./assets/image-20240817212343643.png)



每道我都作对



![image-20240817212403119](./assets/image-20240817212403119.png)



![image-20240817212411341](./assets/image-20240817212411341.png)



就是这么牛，交卷



![image-20240817212430303](./assets/image-20240817212430303.png)



其实现在练习表里面已经有这条数据了 id 3，我现在交卷



![image-20240817212504148](./assets/image-20240817212504148.png)



好好好，正确题目 3 



再看数据库

![image-20240817212553440](./assets/image-20240817212553440.png)



状态已完成，耗时 1分钟 18s，但是正确率好像没对



![image-20240817212645658](./assets/image-20240817212645658.png)



交卷总体来说就是一个更新和批量插入的操作。



接着往下看【应该在后面，每题好像还没做】



##### 4.20 提交题目情况



感觉这两集放反了，每道题选择之后，没有更新我的练习详情



![image-20240817213043801](./assets/image-20240817213043801.png)



插进来了，没更新我选的什么



我就说，上一集有伏笔



新接口：

![image-20240817213219477](./assets/image-20240817213219477.png)



实现类



![image-20240817213316006](./assets/image-20240817213316006.png)



这下是真可以试试了



重启，再来一次



![image-20240817213710922](./assets/image-20240817213710922.png)



直接出题

![image-20240817213721631](./assets/image-20240817213721631.png)



先看看数据库



![image-20240817213739298](./assets/image-20240817213739298.png)



id 为 4



![image-20240817213757220](./assets/image-20240817213757220.png)



detail 还没有，来把第一题做了



![image-20240817213817246](./assets/image-20240817213817246.png)



看看数据库



![image-20240817213832937](./assets/image-20240817213832937.png)



时间更新了



![image-20240817213847568](./assets/image-20240817213847568.png)



这道题的选择情况也上来了



直接做完交了



![image-20240817213915773](./assets/image-20240817213915773.png)



看看数据库



![image-20240817213931221](./assets/image-20240817213931221.png)



正确率？？？？



![image-20240817213952889](./assets/image-20240817213952889.png)





应该还有伏笔，好像判断题的时候没对，状态也没对



##### 4.21 答题情况 - 每题得分开发



新接口

![image-20240817214245005](./assets/image-20240817214245005.png)



实现类



![image-20240817214340710](./assets/image-20240817214340710.png)



直接重启试试，再做一次



![image-20240817214528150](./assets/image-20240817214528150.png)



![image-20240817214539667](./assets/image-20240817214539667.png)



![image-20240817214545062](./assets/image-20240817214545062.png)



交一下啊

![image-20240817214615263](./assets/image-20240817214615263.png)



现在有这个数据了，我们直接调接口



![image-20240817214701927](./assets/image-20240817214701927.png)



全部交卷再看一次



![image-20240817214721739](./assets/image-20240817214721739.png)



接口



![image-20240817214733829](./assets/image-20240817214733829.png)



三个提交都进来了



![image-20240817214749249](./assets/image-20240817214749249.png)



果然，判断题没有得分，根据这三个字段就可以渲染最后的一个答题情况



我看看判断题为什么没有得分



![image-20240817215249120](./assets/image-20240817215249120.png)



打个断点我看看



![image-20240817215337935](./assets/image-20240817215337935.png)



我交了第一个单选题，就断在这里，

![image-20240817215414921](./assets/image-20240817215414921.png)



数据还没插入



![image-20240817215448430](./assets/image-20240817215448430.png)



我选的是 3 ，答案也是 3



![image-20240817215542270](./assets/image-20240817215542270.png)



放过去，这道题就是对 的



![image-20240817215601646](./assets/image-20240817215601646.png)



交了这道多选，又断在这儿



![image-20240817215635042](./assets/image-20240817215635042.png)



正确答案是 1 2 4



![image-20240817215700979](./assets/image-20240817215700979.png)



我答的也是 124 



![image-20240817215719341](./assets/image-20240817215719341.png)



没问题，这样就判这道题答对



放过去，

![image-20240817215743300](./assets/image-20240817215743300.png)



这道题也得分

,好，来了判断题



![image-20240817215807711](./assets/image-20240817215807711.png)



判断不能单个提交，只能点交卷



![image-20240817215833559](./assets/image-20240817215833559.png)



这里来个断点



![image-20240817215848774](./assets/image-20240817215848774.png)



交卷，停在这儿



![image-20240817215910322](./assets/image-20240817215910322.png)



这会儿判断题的结果还没写



![image-20240817220008456](./assets/image-20240817220008456.png)



这里直接判我只答对了 2 道题，肯定不行啊



![image-20240817220103842](./assets/image-20240817220103842.png)



![image-20240817220112477](./assets/image-20240817220112477.png)



判断题还没插进去，就给我算正确率了



![image-20240817220154734](./assets/image-20240817220154734.png)



题目差集这里还把 那道题给我拿出来了， 离谱【这样肯定 100 % 不了啊】



![image-20240817220326115](./assets/image-20240817220326115.png)



就这样我失去了 100 分，一会儿回来看，说不定后面会解决吧



##### 4.22 答题情况 - 答题详情开发



新接口



![image-20240817221217860](./assets/image-20240817221217860.png)



实现类



![image-20240817221318010](./assets/image-20240817221318010.png)



重启试试



![image-20240817221627366](./assets/image-20240817221627366.png)



我的答案没答，就离谱，按理说，交卷的时候，如果最后一道题选了，就应该提交，直接交卷，默认最后一道题没做



我看了下前端

![image-20240817221834295](./assets/image-20240817221834295.png)



我们点下一题的时候确实是会提交一下当前作答的题目



![image-20240817221927069](./assets/image-20240817221927069.png)



直接点击交卷，没有对最后一题进行提交，如果后面看看，没有进行处理的话，我可以在提交之前把最后那道题提交了再交卷





##### 4.23 评估报告开发



新接口



![image-20240817223622357](./assets/image-20240817223622357.png)



实现类



![image-20240817223657938](./assets/image-20240817223657938.png)



直接重启试试



我直接再做一次，当然可以对之前的练习搞一波先



![image-20240817224036755](./assets/image-20240817224036755.png)



对 6 这次练题请求一下吧



![image-20240817224102622](./assets/image-20240817224102622.png)



2 / 3 的正确率， MySQL 那道题错了，所有技能点 为 0；

我再做一次



![image-20240817224350768](./assets/image-20240817224350768.png)



还是不行



![image-20240817224411729](./assets/image-20240817224411729.png)



但是报告能出来





##### 4.24 练题榜开发



新接口



![image-20240817225658375](./assets/image-20240817225658375.png)



实现类



![image-20240817230210861](./assets/image-20240817230210861.png)



这里就是远程调用了



试试

![image-20240817230606818](./assets/image-20240817230606818.png)



这里启动直接报错了，找不到这个 bean，我引了那个包了，



![image-20240817231351001](./assets/image-20240817231351001.png)



想起来了，这个注解，再来一次



![image-20240817231434820](./assets/image-20240817231434820.png)



沃日，强无敌，试试



![image-20240817231510934](./assets/image-20240817231510934.png)



调用又有问题

![image-20240817231640709](./assets/image-20240817231640709.png)



看见了，auth 服务没注册上去 ... 



![image-20240817231700800](./assets/image-20240817231700800.png)



made , 怎么停了，再来一次



![image-20240817231927865](./assets/image-20240817231927865.png)



这里确实已经拿到了



![image-20240817232057523](./assets/image-20240817232057523.png)



没问题，看看前端



![image-20240817232149717](./assets/image-20240817232149717.png)





没问题，因为我就是做了 7 次



![image-20240817232213082](./assets/image-20240817232213082.png)







##### 4.25 放弃练习开发



新接口



![image-20240818092955766](./assets/image-20240818092955766.png)





实现类



![image-20240818093021464](./assets/image-20240818093021464.png)



重启试试



我直接在前端看效果



![image-20240818093133855](./assets/image-20240818093133855.png)



开始练习



![image-20240818093152120](./assets/image-20240818093152120.png)



![image-20240818093204208](./assets/image-20240818093204208.png)



套题已经出来了，如果我直接 x 掉不答了



![image-20240818093237595](./assets/image-20240818093237595.png)



info 里面也有记录了



![image-20240818093303927](./assets/image-20240818093303927.png)



我直接离开了



看看啥情况



![image-20240818093337062](./assets/image-20240818093337062.png)



好像无事发生



![image-20240818093346435](./assets/image-20240818093346435.png)



我直接调这个接口试试



![image-20240818093454947](./assets/image-20240818093454947.png)



放弃成功，看看数据库



![image-20240818093535752](./assets/image-20240818093535752.png)



语句也能看到效果了



![image-20240818093554172](./assets/image-20240818093554172.png)



直接（逻辑）删了





##### 4.26 模拟套题列表开发



新接口，就是预设的套题



![image-20240818093944345](./assets/image-20240818093944345.png)



实现类



![image-20240818094110609](./assets/image-20240818094110609.png)



直接重启，试试，直接看前端



![image-20240818094222812](./assets/image-20240818094222812.png)



我直接改库吧



![image-20240818094245931](./assets/image-20240818094245931.png)



我把第一个改为了模拟套卷，【预设套卷】，再看看



![image-20240818094310819](./assets/image-20240818094310819.png)



没问题，



![image-20240818094340438](./assets/image-20240818094340438.png)



![image-20240818094353996](./assets/image-20240818094353996.png)



没问题，这个点进去就能直接开做



接口：

![image-20240818094513243](./assets/image-20240818094513243.png)



没问题



##### 4.27 未完成列表开发



新接口



![image-20240818094808561](./assets/image-20240818094808561.png)



实现类



![image-20240818094820660](./assets/image-20240818094820660.png)



直接重启试试，看前端



![image-20240818094957236](./assets/image-20240818094957236.png)



没问题，其实这个就是去数据库查的



![image-20240818095038888](./assets/image-20240818095038888.png)







接口：

![image-20240818095408320](./assets/image-20240818095408320.png)



没问题



##### 4.28 mq入门



到这里，练习的整体业务算是完事儿 了



message queue，消息队列，主要的目的是提供一套从消息的生产，到存储，到消费的一整套全面的解决方案。



###### 4.28.1 mq用途



1、限流削峰

服务 A 1s 1000   mq，来中转， 服务 B 500qps

2、异步解耦

提交订单 -> 支付。-》订单列表

支付的回调消息来做订单相关的一些处理。

3、数据采集

实时的数据流采集，业务日志，用户行为监控





###### 4.28.2 常见的 mq



activemq：过时了。

rabbimtmq：基于语言 erlang

rocketmq：阿里的，java 开发的，开源的

kafaka：大数据量





##### 4.29 rocketmq 简介



RocketMQ是一个统一消息引擎、轻量级数据处理平台。 

RocketMQ是⼀款阿⾥巴巴开源的消息中间件。2016年11⽉28⽇，阿⾥巴巴向 Apache 软件基⾦会捐赠 

RocketMQ，成为 Apache 孵化项⽬。2017 年 9 ⽉ 25 ⽇，Apache 宣布 RocketMQ孵化成为 Apache 顶级项⽬（TLP ），成为国内⾸个互联⽹中间件在 Apache 的顶级项目



![image-20240818095835356](./assets/image-20240818095835356.png)



官网：https://rocketmq.apache.org/



**rocketmq 发展**



![image-20240818095913356](./assets/image-20240818095913356.png)



2007年，阿里开始五彩石项目，Notify作为项目中交易核心消息流转系统，应运而生。Notify系统是 RocketMQ的雏形。 

2010年，B2B大规模使用ActiveMQ作为阿里的消息内核。阿里急需一个具有海量堆积能力的消息系 统。 

2011年初，Kafka开源。淘宝中间件团队在对Kafka进行了深入研究后，开发了一款新的MQ，MetaQ。2012年，MetaQ发展到了v3.0版本，在它基础上进行了进一步的抽象，形成了RocketMQ，然后就将其 进行了开源。 

2015年，阿里在RocketMQ的基础上，又推出了一款专门针对阿里云上用户的消息系统Aliware MQ。 

2016年双十一，RocketMQ承载了万亿级消息的流转，跨越了一个新的里程碑。11⽉28⽇，阿⾥巴巴 向 Apache 软件基⾦会捐赠 RocketMQ，成为 Apache 孵化项⽬。 

2017 年 9 ⽉ 25 ⽇，Apache 宣布 RocketMQ孵化成为 Apache 顶级项⽬（TLP ），成为国内⾸个互联 ⽹中间件在 Apache 上的顶级项⽬。



> 这里之后又重复了，一期、二期的简历写法、项目面试题那些，我就跳过了







这里直接跳到 218 集，rocket mq 安装了，面试那些肯定就是自己看了

这里还是在第三期 里面



我还是稍微看看题目吧，罗列个点



其实就在文档里面：https://www.yuque.com/jingdianjichi/kwag7a/gx7ss0sg4fb5dgpw#GQ3YT



##### 4.30 项目面试题



###### 4.30.1 介绍一下你做的项目吧-校招版





###### 4.30.2 你认为这个项目的难点和亮点是什么





###### 4.30.3 说说你这个项目的架构情况





###### 4.30.4 你在这里主要负责哪些东西



###### 4.30.5 你的技术选型是怎么做的





###### 4.30.6 前后端开发模式是怎样的



###### 4.30.7 编写接口对接，应该注意什么



###### 4.30.8 刷题业务是怎么做的





###### 4.30.9 你其中用到的设计模式，有什么好处



###### 4.30.10 你的这个项目分层怎么做的



###### 4.30.11 这个项目如何进行上线



###### 4.30.12 数据库密码加解密怎么做的





###### 4.30.13 分类和标签业务怎么做的



###### 4.30.14 你封装了一些组件，都有什么



###### 4.30.15 自动部署怎么做的



###### 4.30.16 自动部署如何往多台服务器部署



###### 4.30.17 nacos动态配置原理



###### 4.30.18 搭建项目的包冲突和组件兼容怎么做的



###### 4.30.19 鉴权模型是如何设计的



###### 4.30.20 鉴权数据放到哪了



###### 4.30.21 为什么选择satoken作为权限框架



###### 4.30.22 token机制有什么好处



###### 4.30.23 gateway网关如何设计的



###### 4.30.24 分布式会话的鉴权在微服务中的是怎么做的



###### 4.30.25 gateway 如何实现的全局异常处理



###### 4.30.26 用户登录的密码加密



###### 4.30.27 缓存与数据一致性的理解



###### 4.30.28 如何对接公众号登录



###### 4.30.29 如何监听用户发给公众号的消息



###### 4.30.30 回调消息的验证校验是如何做的



###### 4.30.31 多线程你是在哪里用到的，咋用的





###### 4.30.32 自定义线程工厂的意义



###### 4.30.33 线程池的数量应该设置多少



###### 4.30.34 全局的用户上下文打通你是怎么做的



###### 4.30.35 微服务之间的数据交互是如何做的



###### 4.30.36 本地缓存在哪里使用的



###### 4.30.37 函数式编程配合泛型是为了解决什么问题



###### 4.30.38 全文检索怎么做的，有高亮吗



###### 4.30.39 封装的这个 es 工具有什么好处



###### 4.30.40 排行榜是如何设计



###### 4.30.41 点赞和收藏怎么设计的



###### 4.30.42 项目有用到定时任务吗？怎么做的



###### 4.30.43 你还有什么想要问我的吗





##### 4.31 rocketmq 安装



直接干

官网地址：https://rocketmq.apache.org/



这里我直接用了鸡哥的



![image-20240818101907919](./assets/image-20240818101907919.png)



甩到这儿了 



解压：

```
yum install unzip  可以解压zip包的依赖
unzip rocketmq-all-4.8.0-bin-release.zip
cd rocketmq-all-4.8.0-bin-release
cd bin
```



![image-20240818102104967](./assets/image-20240818102104967.png)



修改配置

```
vim runserver.sh
将其中的xmx，xms等进行修改256m，弄小一点，让服务器用
vim runbroker.sh
同理修改其中的xmx，xms等进行修改256m，弄小一点，让服务器用
```



![image-20240818102230219](./assets/image-20240818102230219.png)



![image-20240818102311101](./assets/image-20240818102311101.png)



启动

```
nohup sh mqnamesrv &
tail -f ~/logs/rocketmqlogs/namesrv.log
```





![image-20240818102410537](./assets/image-20240818102410537.png)



没问题

启动 broker

```
export NAMESRV_ADDR=localhost:9876
nohup sh mqbroker -n localhost:9876 &
tail -f ~/logs/rocketmqlogs/broker.log
```



![image-20240818102709898](./assets/image-20240818102709898.png)



这个文件夹手动建出来就行



![image-20240818102808233](./assets/image-20240818102808233.png)



![image-20240818102818837](./assets/image-20240818102818837.png)



这样就行了



![image-20240818102856529](./assets/image-20240818102856529.png)



还要一个

![image-20240818102917802](./assets/image-20240818102917802.png)



![image-20240818102925462](./assets/image-20240818102925462.png)



这样真行了



发送消息

```
sh tools.sh org.apache.rocketmq.example.quickstart.Producer

sh tools.sh org.apache.rocketmq.example.quickstart.Consumer
```



![image-20240818103240327](./assets/image-20240818103240327.png)



我这里报错了，还要改个配置**原因：rocketmq 配置文件默认设置的是内网地址，连接自然会失败。**



![image-20240818103404498](./assets/image-20240818103404498.png)



重启试试，要指定配置文件

```
nohup sh mqbroker -n localhost:9876 & 【之前的】

nohup bin/mqbroker -c conf/broker.conf &
```



![image-20240818104004761](./assets/image-20240818104004761.png)



还是不行

![image-20240818104128822](./assets/image-20240818104128822.png)



好像并没有启动成功，日

![image-20240818104517878](./assets/image-20240818104517878.png)



我这里换成了公网 ip 再试一次

![image-20240818104553909](./assets/image-20240818104553909.png)



还是连接不上， ... 

![image-20240818105118212](./assets/image-20240818105118212.png)



再试一次，

![image-20240818105255151](./assets/image-20240818105255151.png)



还是连接不上 ... 艹



【从这里隔断，我重来】



![image-20240818105449820](./assets/image-20240818105449820.png)



按照这个方法我试试

![image-20240818105557589](./assets/image-20240818105557589.png)



两个端口都开



```
nohup sh mqbroker -c /soft/rocketmq-all-4.8.0-bin-release/conf/broker.conf &
```



![image-20240818105831150](./assets/image-20240818105831150.png)



再试一次



![image-20240818105908552](./assets/image-20240818105908552.png)



还是失败了，

![image-20240818110043123](./assets/image-20240818110043123.png)



![image-20240818110115908](./assets/image-20240818110115908.png)



终于成功 了，消息发完，再消费一下啊

![image-20240818110216129](./assets/image-20240818110216129.png)



没问题， 可能是100 条，消费完就在这儿阻塞着，等待新消息生产出来



##### 4.32 rocketmq 的可视化



这里直接给到了一个压缩文件



![image-20240818110426971](./assets/image-20240818110426971.png)



试试吧



![image-20240818110530016](./assets/image-20240818110530016.png)



直接 idea 打开



![image-20240818110604501](./assets/image-20240818110604501.png)



修改配置文件



![image-20240818110700783](./assets/image-20240818110700783.png)



先等加载完成，在下 依赖



![image-20240818111049772](./assets/image-20240818111049772.png)



其实 docker 好像也行



![image-20240818111142319](./assets/image-20240818111142319.png)



就这两个地方要改

然后 install 出一个 jar 包，运行就行



![image-20240818111233163](./assets/image-20240818111233163.png)



6 分钟 了，哥



![image-20240818111346325](./assets/image-20240818111346325.png)



jdk 1.7 炸裂，我不用了，我用 docker 装一个



```
docker pull styletang/rocketmq-console-ng
```





![image-20240818111459875](./assets/image-20240818111459875.png)



着实有点慢

![image-20240818111713710](./assets/image-20240818111713710.png)



![image-20240818111834520](./assets/image-20240818111834520.png)



```
docker run -e "JAVA_OPTS=-Drocketmq.namesrv.addr=127.0.0.1:9876 -Dcom.rocketmq.sendMessageWithVIPChannel=false" -p 7777:7777 -t styletang/rocketmq-console-ng
```



完事儿后直接启动



![image-20240818111919015](./assets/image-20240818111919015.png)

... 这么还是前台启动的  。。。 

docker 没成功



换个命令

```
docker run -d --restart=always --name rmqadmin -e "JAVA_OPTS=-Drocketmq.namesrv.addr=116.196.77.213:9876 -Dcom.rocketmqsendMessageWithVIPChannel=false"  -p 7777:8080  styletang/rocketmq-console-ng
```



![image-20240818112521315](./assets/image-20240818112521315.png)



试试

![image-20240818112642570](./assets/image-20240818112642570.png)



一下就成功了

![image-20240818112718931](./assets/image-20240818112718931.png)



没问题，原来是 1000 条消息



##### 4.33 这里居然有个插曲 ... 一封信



好好，感人



##### 4.34 项目集成mq代码



要改配置了



###### 4.34.1 调整 rocketmq 的配置



```
先关闭broker，namesrv
sh mqshutdown broker
sh mqshutdown namesrv
进行配置文件调整
conf/broker.conf 
brokerIP1=116.196.77.213
重新启动
export NAMESRV_ADDR=116.196.77.213:9876
nohup sh mqnamesrv -n 116.196.77.213:9876 &
nohup sh mqbroker -n 116.196.77.213:9876 -c conf/broker.conf autoCreateTopicEnable=true &
```



![image-20240818113311629](./assets/image-20240818113311629.png)



先把依赖加上，用的刷题服务做实验



![image-20240818113527888](./assets/image-20240818113527888.png)



然后到 mq 层加依赖



![image-20240818113616179](./assets/image-20240818113616179.png)



依赖 domain 就行



然后是 starter 依赖



![image-20240818113717199](./assets/image-20240818113717199.png)



修改启动的配置文件



![image-20240818113817045](./assets/image-20240818113817045.png)



做一个发送实验

![image-20240818114103082](./assets/image-20240818114103082.png)



然后是消费



![image-20240818114305715](./assets/image-20240818114305715.png)



直接重启刷题服务

![image-20240818114514687](./assets/image-20240818114514687.png)



完事儿要把服务器那边弄好

```
先关闭broker，namesrv
sh mqshutdown broker
sh mqshutdown namesrv
进行配置文件调整
conf/broker.conf 
brokerIP1=117.72.14.166



重新启动
export NAMESRV_ADDR=192.168.75.128:9876
nohup sh mqnamesrv -n 192.168.75.128:9876 &
nohup sh mqbroker -n 192.168.75.128:9876 -c conf/broker.conf autoCreateTopicEnable=true &
```



![image-20240818114614017](./assets/image-20240818114614017.png)



![image-20240818114651250](./assets/image-20240818114651250.png)



都完成后，再重启一下啊



![image-20240818114742725](./assets/image-20240818114742725.png)



其实已经连接上了，接口测试一下



![image-20240818115059441](./assets/image-20240818115059441.png)



![image-20240818115114527](./assets/image-20240818115114527.png)



说没找到这个 topic 



![image-20240818115134031](./assets/image-20240818115134031.png)



改一下啊

![image-20240818115148713](./assets/image-20240818115148713.png)



再来一次



![image-20240818115237425](./assets/image-20240818115237425.png)



还是没有



clean ，一下， install 一下



![image-20240818115609213](./assets/image-20240818115609213.png)



还是不行



![image-20240818115647717](./assets/image-20240818115647717.png)



又改了下这儿，我感觉是我这个 topic 就没有创建成功



![image-20240818115722392](./assets/image-20240818115722392.png)



可视化界面也没有



![image-20240818115741984](./assets/image-20240818115741984.png)



对的，肯定是这个问题，



![image-20240818115838456](./assets/image-20240818115838456.png)



按理说应该是对的吧



![image-20240818115907674](./assets/image-20240818115907674.png)



试试

`sh bin/mqbroker -m`



![image-20240818115948645](./assets/image-20240818115948645.png)



这个 ip 好像有问题

![image-20240818120021303](./assets/image-20240818120021303.png)



我也加一个试试



![image-20240818120049688](./assets/image-20240818120049688.png)



重启一下namesrv 和 broker 



![image-20240818120158008](./assets/image-20240818120158008.png)





再是一次



![image-20240818120248121](./assets/image-20240818120248121.png)



还是不行，我手动创建一个 topic 试试



![image-20240818120321379](./assets/image-20240818120321379.png)



![image-20240818120349893](./assets/image-20240818120349893.png)



马德，压根儿没监测dao



![image-20240818120507442](./assets/image-20240818120507442.png)



broker 没有启动成功



![image-20240818120546749](./assets/image-20240818120546749.png)



应该是没有用到我们的配置文件



![image-20240818120637640](./assets/image-20240818120637640.png)



对吧，没有启动成功



![image-20240818120748175](./assets/image-20240818120748175.png)



换了个写法，这次应该是用到了，



![image-20240818120829134](./assets/image-20240818120829134.png)



先关掉我知道了



![image-20240818120843447](./assets/image-20240818120843447.png)



忘记换了，这不是我的 ip



```
先关闭broker，namesrv
sh mqshutdown broker
sh mqshutdown namesrv
进行配置文件调整
conf/broker.conf 
brokerIP1=116.196.77.213



重新启动
export NAMESRV_ADDR=116.196.77.213:9876
nohup sh mqnamesrv -n 116.196.77.213:9876 &
nohup sh mqbroker -n 116.196.77.213:9876 -c ../conf/broker.conf autoCreateTopicEnable=true &
```



![image-20240818120948613](./assets/image-20240818120948613.png)



made ，再来



![image-20240818121028036](./assets/image-20240818121028036.png)





![image-20240818121057380](./assets/image-20240818121057380.png)



这次绝逼没问题了



![image-20240818121108238](./assets/image-20240818121108238.png)



重启再来一次



![image-20240818121156344](./assets/image-20240818121156344.png)



发送成功了

![image-20240818121207576](./assets/image-20240818121207576.png)



牛逼！！！！卧槽！！！！！！！ 了



![image-20240818121245095](./assets/image-20240818121245095.png)



topic 这次才是创建成功了



##### 4.35 点赞业务优化为mq处理



改之前那个点赞的业务



![image-20240818121541646](./assets/image-20240818121541646.png)



![image-20240818121601255](./assets/image-20240818121601255.png)



之前的就是直接操作了 redis 



![image-20240818121634138](./assets/image-20240818121634138.png)



然后通过定时任务，把 redis 中的数据往 MySQL 去插，其实这个定时任务现在我都没开，哈哈哈哈，总之，我们现在要把这个业务（定时任务就不用了）直接 用 mq 来实现



![image-20240818122112084](./assets/image-20240818122112084.png)



发送就是这样，然后再弄个监听去消费就行了



![image-20240818122245126](./assets/image-20240818122245126.png)



在这儿去调一个业务，然后插入到MySQL



![image-20240818122315683](./assets/image-20240818122315683.png)



没问题，试试吧



![image-20240818122337191](./assets/image-20240818122337191.png)



现在点赞表就只有 我 对 1 的题目点赞



![image-20240818122400399](./assets/image-20240818122400399.png)



redis 里面也是

试试，这次我点  2



![image-20240818122451505](./assets/image-20240818122451505.png)



点赞成功



![image-20240818122514530](./assets/image-20240818122514530.png)



没问题，看看数据库



![image-20240818122525808](./assets/image-20240818122525808.png)



插进来了，看看redis 



![image-20240818122544703](./assets/image-20240818122544703.png)



没问题，我对 1 2 两道题的点赞记录，这就是 mq 的点赞业务改造



##### 4.36 分布式事务 - 2pc



###### 4.36.1 单体事务与分布式事务



事务是应用程序中一系列严密的操作，所有操作必须成功完成，否则在每个操作中所作的所有更改都会被撤消。也就是事务具有原子性，一个事务中的一系列的操作要么全部成功，要么一个都不做。事务应该具有 4 个属性：原子性、一致性、隔离性、持久性。这四个属性通常称为 ACID 特性。

分布式事务是指事务的参与者、支持事务的服务器、资源服务器以及事务管理器分别位于不同的分布式系统的不同节点之上。这里我们举个例子：例如在大型电商系统中，下单接口通常会扣减库存、减去优惠、生成订单 id, 而订单服务与库存、优惠、订单 id 都是不同的服务，下单接口的成功与否，不仅取决于本地的 db 操作，而且依赖第三方系统的结果，这时候分布式事务就保证这些操作要么全部成功，要么全部失败。

本质上来说，分布式事务就是为了保证不同个数据库的数据一致性。



###### 4.36.2 常见实现方式



【五种常见分布式事务的实现方式】



###### 4.36.3 一、2PC



两阶段提交（Two-phase Commit，2PC），通过引入协调者（Coordinator）来协调参与者的行为，并最终决定这些参与者是否要真正执行事务。有以下两个阶段



**准备阶段**

协调者询问参与者事务是否执行成功，参与者发回事务执行结果。



![image-20240818122859294](./assets/image-20240818122859294.png)







**提交阶段**



如果事务在每个参与者上都执行成功，事务协调者发送通知让参与者提交事务；否则，协调者发送通知让参与者回滚事务。

需要注意的是，在准备阶段，参与者执行了事务，但是还未提交。只有在提交阶段接收到协调者发来的通知后，才进行提交或者回滚。



![image-20240818122929300](./assets/image-20240818122929300.png)



优点： 

尽量保证了数据的强一致，实现成本较低，在各大主流数据库都有自己实现，对于MySQL是从5.5开始支持。

缺点:

（1）单点问题：协调者在整个流程中扮演的角色很关键，如果其宕机，比如在第一阶段已经完成，在第二阶段正准备提交的时候事务管理器宕机，参与者就会一直阻塞，导致数据库无法使用。

（2）同步阻塞：在准备就绪之后，参与者中的资源一直处于阻塞，直到提交完成，释放资源。

（3）数据不一致：两阶段提交协议虽然为分布式数据强一致性所设计，但仍然存在数据不一致性的可能，比如在第二阶段中，假设协调者发出了事务commit的通知，但是因为网络问题该通知仅被一部分参与者所收到并执行了commit操作，其余的参与者则因为没有收到通知一直处于阻塞状态，这时候就产生了数据的不一致性。

总的来说，XA协议比较简单，成本较低，但是其单点问题，以及不能支持高并发(由于同步阻塞)依然是其最大的弱点。





##### 4.37 分布式事务 - TCC



关于TCC（Try-Confirm-Cancel）的概念，最早是由Pat Helland于2007年发表的一篇名为《Life beyond Distributed Transactions:an Apostate’s Opinion》的论文提出。 TCC事务机制相比于上面介绍的，解决了其几个缺点: （1）解决了协调者单点，由主业务方发起并完成这个业务活动。业务活动管理器也变成多点，引入集群。 （2）同步阻塞：引入超时，超时后进行补偿，并且不会锁定整个资源，将资源转换为业务逻辑形式，粒度变小。 （3）数据一致性：有了补偿机制之后，由业务活动管理器控制一致性。

对于TCC的解释:

（1）Try阶段：尝试执行,完成所有业务检查（一致性）,预留必须业务资源（准隔离性）

（2）Confirm阶段：确认执行真正执行业务，不作任何业务检查，只使用Try阶段预留的业务资源，Confirm操作满足幂等性。要求具备幂等设计，Confirm失败后需要进行重试。

（3）Cancel阶段：取消执行，释放Try阶段预留的业务资源 Cancel操作满足幂等性Cancel阶段的异常和Confirm阶段异常处理方案基本上一致。

举个简单的例子：

如果你用100元买了一瓶水。 Try阶段:你需要向你的钱包检查是否够100元并锁住这100元，水也是一样的。

如果有一个失败，则进行cancel(释放这100元和这一瓶水)，如果cancel失败不论什么失败都进行重试cancel，所以需要保持幂等。

如果都成功，则进行confirm,确认这100元扣，和这一瓶水被卖，如果confirm失败无论什么失败则重试(会依靠活动日志进行重试)

对于TCC来说适合一些:

（1）强隔离性，严格一致性要求的活动业务。

（2）执行时间较短的业务。

缺点： 缺点还是比较明显的，在2,3步中都有可能失败。TCC属于应用层的一种补偿方式，所以需要程序员在实现的时候多写很多补偿的代码，在一些场景中，一些业务流程可能用TCC不太好定义及处理。





##### 4.38 分布式事务 - 本地消息表



此方案的核心是将需要分布式处理的任务通过消息日志的方式来异步执行。消息日志可以存储到本地文本、数据库或消息队列，再通过业务规则自动或人工发起重试。人工重试更多的是应用于支付场景，通过对账系统对事后问题的处理。



![image-20240818123134598](./assets/image-20240818123134598.png)



对于本地消息队列来说核心是把大事务转变为小事务。还是举上面用100元去买一瓶水的例子。

（1）当你扣钱的时候，你需要在你扣钱的服务器上新增加一个本地消息表，你需要把你扣钱和写入减去水的库存到本地消息表放入同一个事务(依靠数据库本地事务保证一致性。

（2）这个时候有个定时任务去轮询这个本地事务表，把没有发送的消息，扔给商品库存服务器，叫他减去水的库存，到达商品服务器之后这个时候得先写入这个服务器的事务表，然后进行扣减，扣减成功后，更新事务表中的状态。

（3）商品服务器通过定时任务扫描消息表或者直接通知扣钱服务器，扣钱服务器本地消息表进行状态更新。

（4）针对一些异常情况，定时扫描未成功处理的消息，进行重新发送，在商品服务器接到消息之后，首先判断是否是重复的，如果已经接收，在判断是否执行，如果执行在马上又进行通知事务，如果未执行，需要重新执行需要由业务保证幂等，也就是不会多扣一瓶水。

本地消息队列是BASE理论，是最终一致模型，适用于对一致性要求不高的。实现这个模型时需要注意重试的幂等。





##### 4.39 分布式事务 - MQ 事务



在RocketMQ中实现了分布式事务，实际上其实是对本地消息表的一个封装，将本地消息表移动到了MQ内部，下面简单介绍一下MQ事务。



![image-20240818123309215](./assets/image-20240818123309215.png)



基本流程如下: 第一阶段Prepared消息，会拿到消息的地址。

第二阶段执行本地事务。

第三阶段通过第一阶段拿到的地址去访问消息，并修改状态，消息接受者就能使用这个消息。

如果确认消息失败，在RocketMq Broker中提供了定时扫描没有更新状态的消息，如果有消息没有得到确认，会向消息发送者发送消息，来判断是否提交，在rocketmq中是以listener的形式给发送者，用来处理。



![image-20240818123322481](./assets/image-20240818123322481.png)



如果消费超时，则需要一直重试，消息接收端需要保证幂等。如果消息消费失败，这个就需要人工进行处理，因为这个概率较低，如果为了这种小概率时间而设计这个复杂的流程反而得不偿失





##### 4.40 分布式事务 - Saga 事务



Saga是30年前一篇数据库论文提到的一个概念。其核心思想是将长事务拆分为多个本地短事务，由Saga事务协调器协调，如果正常结束那就正常完成，如果某个步骤失败，则根据相反顺序一次调用补偿操作。 Saga的组成：

每个Saga由一系列sub-transaction Ti 组成 每个Ti 都有对应的补偿动作Ci，补偿动作用于撤销Ti造成的结果,这里的每个T，都是一个本地事务。 可以看到，和TCC相比，Saga没有“预留 try”动作，它的Ti就是直接提交到库。

Saga的执行顺序有两种：

T1, T2, T3, ..., Tn

T1, T2, ..., Tj, Cj,..., C2, C1，其中0 < j < n Saga定义了两种恢复策略：

向后恢复，即上面提到的第二种执行顺序，其中j是发生错误的sub-transaction，这种做法的效果是撤销掉之前所有成功的sub-transation，使得整个Saga的执行结果撤销。 向前恢复，适用于必须要成功的场景，执行顺序是类似于这样的：T1, T2, ..., Tj(失败), Tj(重试),..., Tn，其中j是发生错误的sub-transaction。该情况下不需要Ci。

这里要注意的是，在saga模式中不能保证隔离性，因为没有锁住资源，其他事务依然可以覆盖或者影响当前事务。

还是拿100元买一瓶水的例子来说，这里定义

T1=扣100元 T2=给用户加一瓶水 T3=减库存一瓶水

C1=加100元 C2=给用户减一瓶水 C3=给库存加一瓶水

我们一次进行T1,T2，T3如果发生问题，就执行发生问题的C操作的反向。 上面说到的隔离性的问题会出现在，如果执行到T3这个时候需要执行回滚，但是这个用户已经把水喝了(另外一个事务)，回滚的时候就会发现，无法给用户减一瓶水了。这就是事务之间没有隔离性的问题，可以看到saga模式没有隔离性的影响还是较大，可以参照华为的解决方案:从业务层面入手加入一 Session 以及锁的机制来保证能够串行化操作资源。也可以在业务层面通过预先冻结资金的方式隔离这部分资源， 最后在业务操作的过程中可以通过及时读取当前状态的方式获取到最新的更新。





##### 4.41 加餐有难度：线程编排工具asynctool 介绍



官网：https://gitee.com/jd-platform-opensource/asyncTool



###### 4.41.1 并行常见的场景



1、客户端请求服务端接口，该接口需要调用其他N个微服务的接口

譬如 请求我的购物车，那么就需要去调用用户的rpc、商品详情的rpc、库存rpc、优惠券等等好多个服务。同时，这些服务还有相互依赖关系，譬如必须先拿到商品id后，才能去库存rpc服务请求库存信息。 最终全部获取完毕后，或超时了，就汇总结果，返回给客户端。

2、并行执行N个任务，后续根据这1-N个任务的执行结果来决定是否继续执行下一个任务

如用户可以通过邮箱、手机号、用户名登录，登录接口只有一个，那么当用户发起登录请求后，我们需要并行根据邮箱、手机号、用户名来同时查数据库，只要有一个成功了，都算成功，就可以继续执行下一步。而不是先试邮箱能否成功、再试手机号……

再如某接口限制了每个批次的传参数量，每次最多查询10个商品的信息，我有45个商品需要查询，就可以分5堆并行去查询，后续就是统计这5堆的查询结果。就看你是否强制要求全部查成功，还是不管有几堆查成功都给客户做返回

再如某个接口，有5个前置任务需要处理。其中有3个是必须要执行完毕才能执行后续的，另外2个是非强制的，只要这3个执行完就可以进行下一步，到时另外2个如果成功了就有值，如果还没执行完，就是默认值。

3 需要进行线程隔离的多批次任务

如多组任务， 各组任务之间彼此不相关，每组都需要一个独立的线程池，每组都是独立的一套执行单元的组合。有点类似于hystrix的线程池隔离策略。

4 单机工作流任务编排



###### 4.41.2 并行场景之核心——任意编排



1 多个执行单元的串行请求



![image-20240818124105126](./assets/image-20240818124105126.png)



2 多个执行单元的并行请求



![image-20240818124115902](./assets/image-20240818124115902.png)



3 阻塞等待，串行的后面跟多个并行



![image-20240818124132379](./assets/image-20240818124132379.png)



4 阻塞等待，多个并行的执行完毕后才执行某个



![image-20240818124142447](./assets/image-20240818124142447.png)



5 串并行相互依赖



![image-20240818124154910](./assets/image-20240818124154910.png)



6 复杂场景



![image-20240818124205423](./assets/image-20240818124205423.png)





###### 4.41.3 并行场景可能存在的需求之——每个执行结果的回调



传统的Future、CompleteableFuture一定程度上可以完成任务编排，并可以把结果传递到下一个任务。如CompletableFuture有then方法，但是却无法做到对每一个执行单元的回调。譬如A执行完毕成功了，后面是B，我希望A在执行完后就有个回调结果，方便我监控当前的执行状况，或者打个日志什么的。失败了，我也可以记录个异常信息什么的。

此时，CompleteableFuture就无能为力了。

框架提供了这样的回调功能。并且，如果执行异常、超时，可以在定义这个执行单元时就设定默认值。



###### 4.41.4 并行场景可能存在的需求之——执行顺序的强依赖和弱依赖



如上图的4，B和C并发执行，最后是A。

有些场景下，我们希望B和C都执行完毕后，才能执行A，CompletableFuture里有个allOf(futures...).then()方法可以做到。

有些场景下，我们希望B或者C任何一个执行完毕，就执行A，CompletableFuture里有个anyOf(futures...).then()方法可以做到。

框架同样提供了类似的功能，通过设定wrapper里的addDepend依赖时，可以指定依赖的任务是否must执行完毕。如果依赖的是must要执行的，那么就一定会等待所有的must依赖项全执行完毕，才执行自己。

如果依赖的都不是must，那么就可以任意一个依赖项执行完毕，就可以执行自己了。

注意：这个依赖关系是有必须和非必须之分的，还有一个重要的东西是执行单元不能重复执行。譬如图4，如果B执行完毕，然后执行了A，此时C终于执行完了，然后也到了A，此时就会发现A已经在执行，或者已经完毕（失败），那么就不应该再重复执行A。

还有一种场景，如下图，A和D并行开始，D先执行完了，开始执行Result任务，此时B和C都还没开始，然后Result执行完了，虽然B和C都还没执行，但是已经没必要执行了。B和C这些任务是可以被跳过的，跳过的原则是他们的NextWrapper已经有结果了或者已经在执行了。我提供了checkNextWrapperResult方法来控制，当后面的任务已经执行了，自己还要不要执行的逻辑控制。当然，这个控制仅限于nextWrapper只有一个时才成立。



![image-20240818124244471](./assets/image-20240818124244471.png)

###### 4.41.5 并发场景可能存在的需求之——依赖上游的执行结果作为入参



譬如A-B-C三个执行单元，A的入参是String，出参是int，B呢它需要用A的结果作为自己的入参。也就是说A、B并不是独立的，而是有结果依赖关系的。

在A执行完毕之前，B是取不到结果的，只是知道A的结果类型。

那么，框架也支持这样的场景。可以在编排时，就取A的结果包装类，作为B的入参。虽然此时尚未执行，必然是空，但可以保证A执行完毕后，B的入参会被赋值。

在V1.3后，框架支持在worker的action的入参Map<String, WorkerWrapper>中获取任意一个执行单元的执行结果，当然，可以取其中的1个、多个执行结果作为自己的入参。Key就是在定义wrapper时通过id传进来的唯一id标识。详情demo可以查看test包下dependnew包案例。



###### 4.41.6 并发场景可能存在的需求之——全组任务的超时



一组任务，虽然内部的各个执行单元的时间不可控，但是我可以控制全组的执行时间不超过某个值。通过设置timeOut，来控制全组的执行阈值



###### 4.41.7 并发场景可能存在的需求之——高性能、低线程数



该框架全程无锁，不依靠线程锁来保证顺序。

创建线程量少。

![image-20240818124340262](./assets/image-20240818124340262.png)





如这样的，A会运行在B、C执行更慢的那个单元的线程上，而不会额外创建线程。



###### 4.41.8 asyncTool特点



解决任意的多线程并行、串行、阻塞、依赖、回调的并发框架，可以任意组合各线程的执行顺序，带全链路回调和超时控制。

其中的A、B、C分别是一个最小执行单元（worker），可以是一段耗时代码、一次Rpc调用等，不局限于你做什么。

该框架可以将这些worker，按照你想要的各种执行顺序，加以组合编排。最终得到结果。

并且，该框架为每一个worker都提供了执行结果的回调和执行失败后自定义默认值。譬如A执行完毕后，A的监听器会收到回调，带着A的执行结果（成功、超时、异常）。

根据你的需求，将各个执行单元组合完毕后，开始在主线程执行并阻塞，直到最后一个执行完毕。并且可以设置全组的超时时间。

该框架支持后面的执行单元以前面的执行单元的结果为自己的入参。譬如你的执行单元B的入参是ResultA，ResultA就是A的执行结果，那也可以支持。在编排时，就可以预先设定B或C的入参为A的result，即便此时A尚未开始执行。当A执行完毕后，自然会把结果传递到B的入参去。

快速开始 https://gitee.com/jd-platform-opensource/asyncTool/blob/master/QuickStart.md



![image-20240818124419976](./assets/image-20240818124419976.png)





##### 4.42 加餐有难度：asynctool的demo初探



新模块，实验用的



![image-20240818124613270](./assets/image-20240818124613270.png)



![image-20240818124821535](./assets/image-20240818124821535.png)



这就都是 JD 的源码，介绍



![image-20240818124928711](./assets/image-20240818124928711.png)



使用者最重要的接口



![image-20240818125008398](./assets/image-20240818125008398.png)



还有很多测试【后面慢慢看吧，这个东西高级的】



第三期结束【这里这个东西没细看，后面好像会和 练题业务整合到时候再说】



#### 5. 项目开发流程【第四期】



##### 5.1 熊圈前言



![image-20240818125421659](./assets/image-20240818125421659.png)



这个地方的实现



在第四期主要是带大家来实现鸡圈模块。首先恭喜看到第四期的小伙伴，基本上到这里，你的面试和技术栈已经很全了，完全可以放心出去面试了。【哇哦】



##### 5.2 数据库表设计



主要是实现如下功能

1、圈子的查询

2、动态的发布

3、评论与回复

4、websocket 的实时通知



###### 5.2.1 圈子相关



![image-20240818125726460](./assets/image-20240818125726460.png)



###### 5.2.2 动态发布



![image-20240818125755038](./assets/image-20240818125755038.png)



###### 5.2.3 评论与回复



![image-20240818125819805](./assets/image-20240818125819805.png)





###### 5.2.4 五张表



敏感词：

```sql
DROP TABLE IF EXISTS `sensitive_words`;
CREATE TABLE `sensitive_words`
(
    `id`         bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
    `words`      varchar(1024) DEFAULT NULL COMMENT '内容',
    `type`       int(11) DEFAULT '0' COMMENT '1=黑名单 2=白名单',
    `is_deleted` int(11) DEFAULT NULL COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='敏感词表';
```



圈子信息：

```sql
DROP TABLE IF EXISTS `share_circle`;
CREATE TABLE `share_circle`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '圈子ID',
    `parent_id`    bigint(20) NOT NULL COMMENT '父级ID,-1为大类',
    `circle_name`  varchar(16) NOT NULL COMMENT '圈子名称',
    `icon`         varchar(255) DEFAULT NULL COMMENT '圈子图片',
    `created_by`   varchar(32)  DEFAULT NULL COMMENT '创建人',
    `created_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32)  DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`),
    KEY            `idx_parent_id` (`parent_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='圈子信息';
```



评论及回复信息：

```sql
DROP TABLE IF EXISTS `share_comment_reply`;
CREATE TABLE `share_comment_reply`
(
    `id`             bigint(20) NOT NULL AUTO_INCREMENT COMMENT '评论ID',
    `moment_id`      int(11) NOT NULL COMMENT '原始动态ID',
    `reply_type`     int(11) NOT NULL COMMENT '回复类型 1评论 2回复',
    `to_id`          bigint(20) DEFAULT NULL COMMENT '评论目标id',
    `to_user`        varchar(32)   DEFAULT NULL COMMENT '评论人',
    `to_user_author` int(11) DEFAULT NULL COMMENT '评论人是否作者 1=是 0=否',
    `reply_id`       bigint(20) DEFAULT NULL COMMENT '回复目标id',
    `reply_user`     varchar(32)   DEFAULT NULL COMMENT '回复人',
    `replay_author`  int(11) DEFAULT NULL COMMENT '回复人是否作者 1=是 0=否',
    `content`        varchar(1024) DEFAULT NULL COMMENT '内容',
    `pic_urls`       varchar(1024) DEFAULT NULL COMMENT '图片内容',
    `created_by`     varchar(32)   DEFAULT NULL COMMENT '创建人',
    `created_time`   datetime      DEFAULT NULL COMMENT '创建时间',
    `update_by`      varchar(32)   DEFAULT NULL COMMENT '更新人',
    `update_time`    datetime      DEFAULT NULL COMMENT '更新时间',
    `is_deleted`     int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    `parent_id`      bigint(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY              `idx_moment_id` (`moment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='评论及回复信息';
```



消息表：

```sql
DROP TABLE IF EXISTS `share_message`;
CREATE TABLE `share_message`
(
    `id`           int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
    `from_id`      varchar(32) NOT NULL COMMENT '来自人',
    `to_id`        varchar(32) NOT NULL COMMENT '送达人',
    `content`      varchar(256) DEFAULT NULL COMMENT '消息内容',
    `is_read`      int(11) DEFAULT '0' COMMENT '是否被阅读 1是 2否',
    `created_by`   varchar(32)  DEFAULT NULL COMMENT '创建人',
    `created_time` datetime     DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32)  DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime     DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`),
    KEY            `idx_to_id` (`to_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='消息表';
```



动态信息：



```sql
DROP TABLE IF EXISTS `share_moment`;
CREATE TABLE `share_moment`
(
    `id`           bigint(20) NOT NULL AUTO_INCREMENT COMMENT '动态ID',
    `circle_id`    bigint(20) NOT NULL COMMENT '圈子ID',
    `content`      varchar(1024) DEFAULT NULL COMMENT '动态内容',
    `pic_urls`     varchar(1024) DEFAULT NULL COMMENT '动态图片内容',
    `reply_count`  int(11) NOT NULL DEFAULT '0' COMMENT '回复数',
    `created_by`   varchar(32)   DEFAULT NULL COMMENT '创建人',
    `created_time` datetime      DEFAULT NULL COMMENT '创建时间',
    `update_by`    varchar(32)   DEFAULT NULL COMMENT '更新人',
    `update_time`  datetime      DEFAULT NULL COMMENT '更新时间',
    `is_deleted`   int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
    PRIMARY KEY (`id`),
    KEY            `idx_circle_id` (`circle_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='动态信息';
```



直接创建出来



![image-20240818134057558](./assets/image-20240818134057558.png)



直接 逆向到 模型



![image-20240818134126093](./assets/image-20240818134126093.png)





##### 5.3 熊圈微服务搭建



新模块，和练题一样的三层就行



这里直接复制了 practice ... ，真怕出问题，来吧



![image-20240818134401918](./assets/image-20240818134401918.png)



改成熊 圈



![image-20240818134425125](./assets/image-20240818134425125.png)



然后在 idea 导入



![image-20240818134448303](./assets/image-20240818134448303.png)



把他作为一个模块导入



![image-20240818134536524](./assets/image-20240818134536524.png)



先改改



![image-20240818134607894](./assets/image-20240818134607894.png)



![image-20240818134650562](./assets/image-20240818134650562.png)



![image-20240818134731979](./assets/image-20240818134731979.png)



![image-20240818134822996](./assets/image-20240818134822996.png)



删删减减，api 就完成



![image-20240818134853754](./assets/image-20240818134853754.png)



![image-20240818134925202](./assets/image-20240818134925202.png)



![image-20240818134951296](./assets/image-20240818134951296.png)



![image-20240818135010098](./assets/image-20240818135010098.png)





![image-20240818135033842](./assets/image-20240818135033842.png)



端口 3014 



![image-20240818135133694](./assets/image-20240818135133694.png)



![image-20240818135231871](./assets/image-20240818135231871.png)





![image-20240818135354408](./assets/image-20240818135354408.png)



现在可以导入了



![image-20240818135422664](./assets/image-20240818135422664.png)



直接添加成一个 maven 工程



![image-20240818135454814](./assets/image-20240818135454814.png)



可以的



![image-20240818135522983](./assets/image-20240818135522983.png)



这些东西就自动正确了



![image-20240818135628266](./assets/image-20240818135628266.png)



全部替换



![image-20240818135654033](./assets/image-20240818135654033.png)



简单检查一下，没问题就行了



直接启动一下啊



![image-20240818135851179](./assets/image-20240818135851179.png)



补回来，删多了



![image-20240818135932777](./assets/image-20240818135932777.png)



再来一次



![image-20240818140107728](./assets/image-20240818140107728.png)



没问题，启动成功



![image-20240818140133475](./assets/image-20240818140133475.png)



注册中心也有了，没问题



直接测试一下



![image-20240818140307058](./assets/image-20240818140307058.png)



没问题，初始化完成



##### 5.4 Caffeine本地缓存 & 圈子功能开发



圈子表：

![image-20240818140540824](./assets/image-20240818140540824.png)



![image-20240818140548090](./assets/image-20240818140548090.png)



这个东西，我们要做一个缓存，加依赖



![image-20240818140736004](./assets/image-20240818140736004.png)



新增圈子接口：

![image-20240818141232259](./assets/image-20240818141232259.png)



实现类



![image-20240818141427209](./assets/image-20240818141427209.png)



试试接口



![image-20240818141900455](./assets/image-20240818141900455.png)



这里我改了一下啊



![image-20240818141927454](./assets/image-20240818141927454.png)



新增成功，看看数据库



![image-20240818141958289](./assets/image-20240818141958289.png)



create_by 好像没拦住，可能是auth服务超时了



给网关配上这个服务，方便转发



![image-20240818141619995](./assets/image-20240818141619995.png)



记得重启网关



再来一个圈子后面的



![image-20240818142121225](./assets/image-20240818142121225.png)



OK，看看数据库



![image-20240818142131614](./assets/image-20240818142131614.png)



没问题，createby 我再看看，这个应该是拦截器做得



![image-20240818142238418](./assets/image-20240818142238418.png)



这个里面没有



![image-20240818142438183](./assets/image-20240818142438183.png)



在这儿打个断点看看



![image-20240818142513153](./assets/image-20240818142513153.png)



![image-20240818142518657](./assets/image-20240818142518657.png)



停在这儿



![image-20240818142547022](./assets/image-20240818142547022.png)



没拿到，为什么



![image-20240818142633739](./assets/image-20240818142633739.png)



试试



![image-20240818142859816](./assets/image-20240818142859816.png)



果然没拿到



![image-20240818142953975](./assets/image-20240818142953975.png)



auth 这边都没收到请求



![image-20240818143056029](./assets/image-20240818143056029.png)



我大概知道问题了，要 把auth clean、install 一下

再试一次



![image-20240818143230182](./assets/image-20240818143230182.png)



对吧，这 install 直接失败了，可能是要走网关才行试试，



![image-20240818143657812](./assets/image-20240818143657812.png)



这次就行了，不走网关就得自己带上 loginId，没毛病，这个打通流程再一次清晰



![image-20240818143731011](./assets/image-20240818143731011.png)





下面是修改圈子



新接口

![image-20240818144032627](./assets/image-20240818144032627.png)



实现类



![image-20240818144041940](./assets/image-20240818144041940.png)



重启试试



![image-20240818144233554](./assets/image-20240818144233554.png)



看看数据库



![image-20240818144252315](./assets/image-20240818144252315.png)



这里 updateby 是一样的问题，我刚刚没主动传 loginId，如果我走网关就能填上它



![image-20240818144337783](./assets/image-20240818144337783.png)



![image-20240818144348151](./assets/image-20240818144348151.png)



擦，又没带上，哦哦哦，又忘了，satoken



再来一次



![image-20240818144456523](./assets/image-20240818144456523.png)



![image-20240818144502917](./assets/image-20240818144502917.png)



这下 100 % 有了，我就不主动传 



![image-20240818144526749](./assets/image-20240818144526749.png)



我擦嘞，这就不知道为什么了，重启一下网关看看



![image-20240818144703698](./assets/image-20240818144703698.png)



看见了，超时了



再来一次，绝对成功



![image-20240818144738418](./assets/image-20240818144738418.png)



![image-20240818144750069](./assets/image-20240818144750069.png)





没毛病



删除圈子：

新接口：

![image-20240818144836135](./assets/image-20240818144836135.png)



我先新增一个



![image-20240818144852810](./assets/image-20240818144852810.png)



好



![image-20240818144954946](./assets/image-20240818144954946.png)



实现类

![image-20240818145013687](./assets/image-20240818145013687.png)



试试，直接来重启



![image-20240818145107754](./assets/image-20240818145107754.png)



删除成功，看看数据库



![image-20240818145122642](./assets/image-20240818145122642.png)



逻辑删除，没问题



最后就是查询了

新接口：

![image-20240818145218188](./assets/image-20240818145218188.png)



实现类

![image-20240818145254661](./assets/image-20240818145254661.png)



这下我可以看前端了，直接重启，先看接口吧



![image-20240818145404523](./assets/image-20240818145404523.png)



没问题，看看前端



![image-20240818145505862](./assets/image-20240818145505862.png)



好好好，它请求的路径是这样的，那我还要加一个



![image-20240818145527329](./assets/image-20240818145527329.png)



再来一次，这里我把前端路径改一下

![image-20240818145546387](./assets/image-20240818145546387.png)

![image-20240818145618123](./assets/image-20240818145618123.png)



![image-20240818145658903](./assets/image-20240818145658903.png)





![image-20240818145752957](./assets/image-20240818145752957.png)



![image-20240818145823505](./assets/image-20240818145823505.png)



没问题，就是没图，来点图



![image-20240818145933612](./assets/image-20240818145933612.png)



看看效果



![image-20240818145952943](./assets/image-20240818145952943.png)



前端那个可能做了防盗，换一个



![image-20240818150040523](./assets/image-20240818150040523.png)



OK， 没问题



##### 5.5 发布内容相关开发



就是

![image-20240818150225086](./assets/image-20240818150225086.png)



这张表了



首先是发布内容：

接口：

![image-20240818151404939](./assets/image-20240818151404939.png)



实现类



![image-20240818151514658](./assets/image-20240818151514658.png)



一会儿直接在前端全部一次性测试



查询列表：

接口：

![image-20240818151610395](./assets/image-20240818151610395.png)



实现：

![image-20240818151752590](./assets/image-20240818151752590.png)



删除接口：

![image-20240818151922788](./assets/image-20240818151922788.png)



忘了，鸡全部改成熊

实现：

![image-20240818152004588](./assets/image-20240818152004588.png)



直接重启在前端试试



![image-20240818152140755](./assets/image-20240818152140755.png)



发布！



![image-20240818152152770](./assets/image-20240818152152770.png)



就是用户信息有些问题，因为还没做，看看数据库



![image-20240818152243397](./assets/image-20240818152243397.png)



没问题，



##### 5.6 评论回复功能讲解



![image-20240818152404334](./assets/image-20240818152404334.png)



就这个东西



![image-20240818152436388](./assets/image-20240818152436388.png)



针对这张表



![image-20240818152452344](./assets/image-20240818152452344.png)





##### 5.7 评论回复功能开发



其实就是一样的了，直接上代码：

新增评论：

![image-20240818153058360](./assets/image-20240818153058360.png)



实现



![image-20240818153313032](./assets/image-20240818153313032.png)



删除接口：



![image-20240818153355281](./assets/image-20240818153355281.png)



实现



![image-20240818153537848](./assets/image-20240818153537848.png)







接着看，因为还有树状评论的东西还没说，下一步再演示，以及查询





##### 5.8 树工具&评论回复列表



接口：

![image-20240818153803537](./assets/image-20240818153803537.png)



实现，稍微不一样，用到一个 TreeNode 和 TreeUtil



![image-20240818153942240](./assets/image-20240818153942240.png)



![image-20240818153957661](./assets/image-20240818153957661.png)



最后这笔



![image-20240818154011188](./assets/image-20240818154011188.png)





![image-20240818154029220](./assets/image-20240818154029220.png)



这里就要加上这个关系



然后删除接口就要变了



![image-20240818154110618](./assets/image-20240818154110618.png)



评论删除，下面的回复都应该全部删除



这里再等一下，用户信息还没拿，



##### 5.9 批量用户信息feign优化



![image-20240818154256584](./assets/image-20240818154256584.png)



这里要做一个批量查询，不用，就要开 for 循环了，肯定影响性能和体验



![image-20240818154411390](./assets/image-20240818154411390.png)



那么服务提供者也要加上这个接口方法给我们进行调用





![image-20240818155216355](./assets/image-20240818155216355.png)



![image-20240818155146303](./assets/image-20240818155146303.png)



好好好，从 controller 到 domain 再到 infra ，全加上





![image-20240818154506773](./assets/image-20240818154506773.png)



加上就行，实现



![image-20240818154639721](./assets/image-20240818154639721.png)



实现这个接口

![image-20240818154730243](./assets/image-20240818154730243.png)



数据接口层完成即可



![image-20240818154803801](./assets/image-20240818154803801.png)



![image-20240818154847473](./assets/image-20240818154847473.png)



OK，记得重启一下我们的 auth 服务



【这下可以完整演示了】



![image-20240818155415446](./assets/image-20240818155415446.png)



这里头像好像没拿到



![image-20240818155625614](./assets/image-20240818155625614.png)



这里加上去 拿用户信息



![image-20240818155700554](./assets/image-20240818155700554.png)



这下就行了，我对这条圈子再进行一次评论



![image-20240818155729288](./assets/image-20240818155729288.png)



发送

![image-20240818155751686](./assets/image-20240818155751686.png)



没问题，看看数据库

![image-20240818155810092](./assets/image-20240818155810092.png)



这里加了 1



![image-20240818155825736](./assets/image-20240818155825736.png)



这里也插进去了，没问题，如果再来一级



![image-20240818155846036](./assets/image-20240818155846036.png)



发送



![image-20240818155906771](./assets/image-20240818155906771.png)



没问题，这就是评论的效果



![image-20240818160120203](./assets/image-20240818160120203.png)







##### 5.10 敏感词dfa介绍



###### 5.10.1 背景



项目中发帖，评论可能包含多个关键词，铭感词。此时需要对该内容进行过滤处理。此前都是在客户端层面操作，这样不仅带来了性能的损耗，而且新增铭感词时，需要客户端重新打包上架，显得十分不合理。所以应该在服务端层面进行算法数据处理。



###### 5.10.2 DFA 算法

DFA 全称为: Deterministic Finite Automaton, 即确定有穷自动机。其特征为：有一个有效状态的集合和一些从一个状态通向另一个状态的边，每条边上标记有一个符号，其中一个状态是初态，某些状态是终态。但不同于不确定的有限自动机，DFA 中不会有从同一个状态触发的两条边标志有相同的符号。



确定：状态以及引起状态转换的事件都是可确定的，不存在“意外”

有穷： 状态以及事件的数量都是可穷举的

DFA 算法模型如下：

```
state_event_dict = {
    "匹": {
        "配": {
            "算": {
                "法": {
                    "is_end": True
                },
                "is_end": False
            },
            "关": {
                "键": {
                    "词": {
                        "is_end": True
                    },
                    "is_end": False
                },
                "is_end": False
            },
            "is_end": False
        },
        "is_end": False
    },
    "信": {
        "息": {
            "抽": {
                "取": {
                    "is_end": True
                },
                "is_end": False
            },
            "is_end": False
        },
        "is_end": False
    }
}
```



用通俗易懂的话来解释，就是将数据库中的铭感词进行建立树结构，举个例子，数据库的铭感词汇有三个，分别是：今天，今天很好，今天真烦

建立树结构，并且标记好三个词汇的非叶子节点和叶子节点 (即最后一个字符是非叶子节点)，并且制定好匹配规则，只有碰到叶子节点才算一次过滤：



![image-20240818160357840](./assets/image-20240818160357840.png)



模拟用户输入以下一句话:

我觉得今天还行。

接下来我们将这句话逐个字拆分并将每一个字代入到上面的树状结构图中。



前面三个字不在铭感词树种直接可以跳过，直到遇到今这个字，发现匹配上铭感词树，接下来看树状结构发现只有一个字是天才能捕获。

再接着走发现在树结构中天这个字的下一个字只有匹配到很或者真才能继续匹配，

而用户输入的下一个字是还，第一步判断当前已经走到了叶子节点，故先将今天置为敏感词。

然后将还这个字从Top顶节点中重新继续流转，发现无法匹配。

过滤结束，且当前的节点是叶子节点，故这句话仅仅被[敏感词过滤]了今天这两个字，最终的过滤结果应该是：

我觉得**还行



要注意的是只有完整的碰到过一次叶子节点才算一次过滤，且一句话可以被多次过滤。



##### 5.11 敏感词功能实现



主要要做的事儿，就是发布内容、发布评论要做敏感词过滤



就一个工具

![image-20240818161740462](./assets/image-20240818161740462.png)



然后在接口里面用上就行



![image-20240818162007796](./assets/image-20240818162007796.png)



发布评论这儿

![image-20240818162036763](./assets/image-20240818162036763.png)



发布内容这儿，重启试试



![image-20240818162238268](./assets/image-20240818162238268.png)



我得先有一些啊



![image-20240818162326037](./assets/image-20240818162326037.png)



没给。我自己造一些，其实还有一个接口



![image-20240818162845971](./assets/image-20240818162845971.png)



我这里就直接改库了



![image-20240818162400215](./assets/image-20240818162400215.png)



哈哈哈哈，试试



![image-20240818162834408](./assets/image-20240818162834408.png)



直接爆了，找不到这个 bean



还有个config ，幸好我眼尖



![image-20240818163745843](./assets/image-20240818163745843.png)



我就说，filter 上没有显式声明成bean，试试



![image-20240818163852631](./assets/image-20240818163852631.png)



试试



![image-20240818163907945](./assets/image-20240818163907945.png)



试试发布

![image-20240818163921498](./assets/image-20240818163921498.png)



发不了的



![image-20240818163941512](./assets/image-20240818163941512.png)





![image-20240818164241988](./assets/image-20240818164241988.png)



这样就更明显了【上面是忘记选圈子了】



![image-20240818164315645](./assets/image-20240818164315645.png)





没问题



##### 5.12 赠送：websocket0基础实战



这里好像和这个项目暂时没什么关系【但是确实说了 websocket 怎么集成到自己的项目，怎么用】



直接看下一集吧，其实到这里我觉得已经差不多了，模拟面试那个前端还没做完





##### 5.13 websocket实现消息通知



这里前端应该还没做，先把接口实现吧【系统消息、用户消息，等等】

对应的



![image-20240818165637810](./assets/image-20240818165637810.png)



就是这张表了，当有人评论了，我们就应该发一个消息告诉被评论方



![image-20240818165737791](./assets/image-20240818165737791.png)



先加依赖



![image-20240818165838385](./assets/image-20240818165838385.png)



然后是服务接口以及实现



![image-20240818170345645](./assets/image-20240818170345645.png)



先看评论



![image-20240818170432001](./assets/image-20240818170432001.png)



回复

![image-20240818170453421](./assets/image-20240818170453421.png)

数据都要入库



直接重启项目，看看啥效果



![image-20240818170708183](./assets/image-20240818170708183.png)



怎么测试



连接 websocket，这里还有个controller 忘记写了



![image-20240818170901460](./assets/image-20240818170901460.png)



加上，其实 和 我们那个 连接咩关系，这 Raw 请求还是第一次见，



![image-20240818172342144](./assets/image-20240818172342144.png)



用这个



![image-20240818172427482](./assets/image-20240818172427482.png)



妙啊，直接连接成功



![image-20240818172447802](./assets/image-20240818172447802.png)



妙啊，这里建立失败



![image-20240818172550513](./assets/image-20240818172550513.png)



擦，断开也不行



![image-20240818172733797](./assets/image-20240818172733797.png)



这样试试



![image-20240818172818313](./assets/image-20240818172818313.png)



舒服了

发送一个评论



![image-20240818172945714](./assets/image-20240818172945714.png)



直接发送



![image-20240818172956555](./assets/image-20240818172956555.png)



评论完成



![image-20240818173010733](./assets/image-20240818173010733.png)



看看数据库



![image-20240818173118446](./assets/image-20240818173118446.png)



插进来了 ，这是个消息



![image-20240818173207672](./assets/image-20240818173207672.png)



我的好像不太对，数据库确实存进去了，但是消息好像没发啊



试试查看消息呢



![image-20240818173917197](./assets/image-20240818173917197.png)



断开可以正常断开，再看吧，这儿的前端也没有实现好像



打个断点看啊看



![image-20240818174409701](./assets/image-20240818174409701.png)



停这儿



![image-20240818174455178](./assets/image-20240818174455178.png)



一直到这儿



![image-20240818174525709](./assets/image-20240818174525709.png)



看见了，这个 socket 是 null



![image-20240818174600597](./assets/image-20240818174600597.png)



我明白了，用户名不能随便我要用我的 username 再试一次



![image-20240818174653588](./assets/image-20240818174653588.png)



这次肯定行了



![image-20240818174713275](./assets/image-20240818174713275.png)



再来一次



![image-20240818174908721](./assets/image-20240818174908721.png)







![image-20240818174922210](./assets/image-20240818174922210.png)



![image-20240818174928598](./assets/image-20240818174928598.png)



直接过



![image-20240818174936831](./assets/image-20240818174936831.png)



直接过



![image-20240818175002693](./assets/image-20240818175002693.png)



没问题，懂了懂了，



![image-20240818175038078](./assets/image-20240818175038078.png)



没毛病





##### 5.14 恭喜我，小总结



好诶！！！，第四期结束



#### 6. 项目开发流程【第五期】



##### 6.1 功能预览



第五期主要是模拟面试的功能，前端这下看不了了

![image-20240818175235181](./assets/image-20240818175235181.png)



把后端做了吧，看以后 前端什么时候更新



1、pdf 文件上传，返回资源地址

2、解析 pdf 匹配关键字（本地题库关键字）

3、关键字选择面试题（策略->分本地题库、gpt）

4、用户作答

5、答案校验、算分数 （策略->分本地题库简单校验、gpt 校验）

6、模式面试评分 （策略-> 分本地预设评语、gpt 评语）





![image-20240818175329747](./assets/image-20240818175329747.png)



所有题目都有输入文字的时候 出现提交并分析

查看答案， 自己评分加个小星星，不输入文字和查看答案不允许自评分（不评分默认为 0 分）





提交分析后弹出面试结果



![image-20240818175353024](./assets/image-20240818175353024.png)



点击再来一次可再次进行面试（再随机一波新的题目）



面试记录分页获取



![image-20240818175415248](./assets/image-20240818175415248.png)





详情页面



![image-20240818175438130](./assets/image-20240818175438130.png)



这一节统称为 画饼



##### 6.2 概要设计



###### 6.2.1 简历上传接口



上传一个 pdf。前端左侧预览出来。仅支持 pdf，生成一个 http 链接。



###### 6.2.2 简历分析及标签推荐



1、 基于 oss 地址，用 pdf 工具对其进行内容文字提取。提供一个 pdf 工具。

2、查询出库表内现有的标签数据，复用敏感词过滤功能进行快速匹配。

subject_label 表，labelName

3、返回出所有匹配的内容。标签可能存在于多个分类。

![image-20240818175615923](./assets/image-20240818175615923.png)



文字内容是 。缓存-Redis，  缓存-集群。用户自己再去选择。

category_id

label_id





###### 6.2.3 开始模拟



1、前端展示推荐标签，根据标签数据来进行抽题，抽 8 道简答题。

subject_mapping  查询出 subject_id

根据subject_id 去 subject_info 查题目 过滤 subject_type  = 4

subject_brief 查出 answer 答案

2、将八道题目一起返回给前端即可。题目，答案，解析一起返回。前端会做一个查看答案及解析的按钮。



###### 6.2.4 回答评分



自己对自己在心里答的内容进行评分，提交评分。有一张表存本次模拟的细节。



###### 6.2.5 生成面试结果



根据每次提交的评分的结果。生成一段面试评价。同时存入表。

评分的时候 会有五颗星。

同分类的进行平均分计算。0～2 分 掌握较差 3 掌握程度 ok。4～5 掌握程度很好。

最终就是

经过本次模拟面试，您的评估结果如下：缓存方面掌握较差，还需努力。数据库方面掌握程度 ok，再接再厉等等。





##### 6.3 数据表设计



###### 6.3.1 面试汇总记录表



```sql
DROP TABLE IF EXISTS `interview_history`;
CREATE TABLE `interview_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `avg_score` double DEFAULT NULL COMMENT '平均分',
  `key_words` varchar(1024) DEFAULT NULL COMMENT '面试关键字',
  `tip` varchar(1024) DEFAULT NULL COMMENT '面试评价',
  `interview_url` varchar(256) DEFAULT NULL COMMENT '简历地址',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`),
  KEY `idx_created_by` (`created_by`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='面试汇总记录表';
```





###### 6.3.2 面试题目记录表



```sql
DROP TABLE IF EXISTS `interview_question_history`;
CREATE TABLE `interview_question_history` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `interview_id` bigint(20) NOT NULL COMMENT '面试场次ID',
  `score` double DEFAULT NULL COMMENT '均分',
  `key_words` varchar(1024) DEFAULT NULL COMMENT '面试关键字',
  `question` varchar(1024) DEFAULT NULL COMMENT '问题',
  `answer` varchar(1024) DEFAULT NULL COMMENT '答案',
  `user_answer` varchar(1024) DEFAULT NULL COMMENT '用户答案',
  `created_by` varchar(32) DEFAULT NULL COMMENT '创建人',
  `created_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(32) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `is_deleted` int(11) DEFAULT '0' COMMENT '是否被删除 0为删除 1已删除',
  PRIMARY KEY (`id`),
  KEY `idx_interview_id` (`interview_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='面试题目记录表'
```



直接创建出来



![image-20240818180503032](./assets/image-20240818180503032.png)





##### 6.4 服务搭建



这次是 copy circle 服务【这里就先暂停啦，准备等这一期出完或者啥时候再搞吧】，收获超级大，我要换一个更牛逼的服务器了



























