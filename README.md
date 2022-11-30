<img src="https://img.bkood.com/yuque.png" alt="img" style="zoom: 33%;" />

<p align="center">
	<strong>Yuque for java  SDK</strong>
</p>

------



## 📚 介绍

👋 你好，欢迎使用语雀Java版SDK，写这个SDK的目的是为了方便使用Java语言调用语雀，同时也欢迎使用SDK的伙伴一起完善Java版SDK，如果有什么问题可以提出Issue。

## 📦 安装

#### 🏗 Maven

```xml
<dependency>
  <groupId>com.bkood</groupId>
  <artifactId>yuque</artifactId>
  <version>1.0.0</version>
</dependency>
```

#### 🛖 Gradle

```Gradle
implementation group: 'com.bkood', name: 'yuque', version: '1.0.0'
```

#### 📥 下载 jar

- [点击下载](https://repo1.maven.org/maven2/com/bkood/yuque/)

> SDK 没有对移动端测试，如果有移动端使用请自行测试，大家自行甄别

## 🤔 SDK 都实现了那些

> SDK分为4个模块 新增、 查询、更新、删除，  功能请看下面的列表

| 模块           | 功能        | 介绍                          |
| -------------- | ----------- | ----------------------------- |
| 查询（query）  | users       | 用户ID或login获取单个用户信息 |
|                | user        | 获取单个用户信息              |
|                | usersGroup  | 获取某个用户的加入的组织列表  |
|                | groupsUsers | 获取组织成员信息              |
|                | usersRepos  | 获取某个用户的知识库列表      |
|                | groupsRepos | 获取团队的知识库列表          |
|                | repos       | 获取知识库详情                |
|                | reposDocs   | 获取一个仓库的文档列表        |
|                | reposDoc    | 获取单篇文档的详细信息        |
| 新增（add）    | groupsRepos | 创建团队知识库                |
|                | reposDoc    | 创建文档                      |
|                | usersRepos  | 创建自己知识库                |
| 更新（update） | repos       | 更新知识库信息                |
|                | reposDocs   | 更新文档                      |
|                | groupsUsers | 增加或更新组织成员            |
| 删除（delete） | groupsUsers | 删除组织成员                  |
|                | repos       | 删除知识库                    |
|                | reposDocs   | 删除文档                      |

## 🚀 快速使用

#### 🛠 配置

> 配置主要是配置个人信息，如：token、agent、proxy 这些

```java
Config config = Config.builder().token("xxx").userAgent("xx").build();
```

#### 🛫 使用

> 例如我想要查询，那么就可以：`YuQueClient`.`query`.`功能`.`run()` 就可以实现一个简单的查询功能，其中`query`就是上面表格的模块，如果是删除就是上面表格模块的`delete`

```java
YuQueClient.query(config).xxx().run()
```

