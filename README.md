### 面试熊 Club 社区项目



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



#### 2. 项目开发流程



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



好了【这里他比较炸裂的是，没有自己写了一个更新逻辑删除的东西 ... 离谱】



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



其实标签字段可以直接用 json 字段存啊，就离谱，还搞了个关联表



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



没问题，不知道为什么鸡翅要专门做一个删除状态的枚举，离谱



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



将就吧【这个集数安排有点问题】



不对，就是真的部署上去了 ... 还是要改一下



先做着走吧，没办法，没有真的买这个东西【好吧，我付款了，等着通过 gitcode，我得要到当时的前端代码，不然没办法做下去了】



通过了再说【这里先向后面做着】



其实不太对

![image-20240815211852260](./assets/image-20240815211852260.png)



这个地方，这里多了俩模块，都还没做呢，脑裂



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





































































