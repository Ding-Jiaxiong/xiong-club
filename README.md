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

















































































































