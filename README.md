# jpa-plus-spring-boot-starter

[![Join the chat at https://gitter.im/yjgbg/jpa-plus](https://badges.gitter.im/yjgbg/jpa-plus.svg)](https://gitter.im/yjgbg/jpa-plus?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

description
## User Guide
从maven中引入包，替换掉spring-boot-starter-data-jpa即可,
功能为spring-boot-starter-data-jpa的超集,可以便捷的构造查询条件
```xml
<dependency>
    <groupId>com.github.yjgbg</groupId>
    <artifactId>jpa-plus-spring-boot-starter</artifactId>
    <version>2.4.1.1</version>
</dependency>
```

重要类:```ExecutableSpecification```, 对Jpa中的Specification的包装，
便捷地构造查询条件，以及执行查询，返回结果