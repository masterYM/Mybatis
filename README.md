# Mybatis
### 传统 JDBC 的弊端 ：
- 1.jdbc 底层没有用连接池、操作数据库需要频繁的创建和关联链接。消耗很大的资源
- 2.写原生的 jdbc 代码在 java 中，一旦我们要修改 sql 的话，java 需要整体编译，不利于系
    统维护
- 3.使用 PreparedStatement 预编译的话对变量进行设置 123 数字，这样的序号不利于维护
- 4.返回 result 结果集也需要硬编码。
### mybatis 介绍：
- Mybatyis:Object relation mapping 对象关系映射
- 快速开始 mybatis（xml 方式）：
   - 1、maven
   - 2、mybatis-config.xml
   - 3、Mapper.xml
### Mybatis 全局配置详解：
  |属性名 |作用      |
  |--|-:|:-:|
  |属性(properties) |系统属性占用配置 |
  |设置(settings) |用于修改Mybatis的运行时行为 |
  |类型别名(typeAliases) |为类型建立别名，一般使用更短的名称替代 |
  |类型处理器(typeHanders) |用于将预编译语句（PreparedStatement）或结果集（ResultSet）中的JDBC类型转化为Java类型 |
  |对象工厂(objectFactory) |提供默认构造器或者执行构造参数初始化目标类型的对象 |
  |插件(plugins) |Mybatis提供插件的方式来拦截映射 |
  |环境(environment) |Mybatis允许配置多个环境 |
  |数据库标识提供商(databaseIdProvider) |数据库标识提供商 |
  |SQL映射文件(mappers) |SQL映射文件 |
### Mybatis 之注解和 xml 优缺点:
- Xml：增加 xml 文件、麻烦、条件不确定、容易出错，特殊字符转义
- 注释：不适合复杂 sql，收集 sql 不方便，重新编译
### Mybatis 之#与$区别：
- '#预编译，防止 sql 注入(推荐)
- $可以 sql 注入，代替作用
### Mybatis 之 parameterType 与 parameterMap 区别：
- 通过 parameterType 指定输入参数的类型，类型可以是简单类型、hashmap、pojo 的包装类型
### Mybatis 之 resultType 与 resultMap 区别：
- 使用 resultType 进行输出映射，只有查询出来的列名和 pojo 中的属性名一致，该列才可以映射成功
- mybatis 中使用 resultMap 完成高级输出结果映射。
### Mybatis 之 plugin：
### Mybatis 逆向工程：
#### MyBatis 的一个主要的特点就是需要程序员自己编写 sql，那么如果表太多的话，难免会很麻烦，所以 mybatis 官方提供了一个逆向工程，可以针对单表自动生成 mybatis 执行所需要的代码（包括 mapper.xml、mapper.java、po..）。一般在开发中，常用的逆向工程方式是通过数据库的表生成代码
 - 1.引入jar
 - 2.配置mybatis-genrtator.xml
 - 3.mybatis-generator:generate
