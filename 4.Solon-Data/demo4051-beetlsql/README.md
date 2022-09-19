
### 配置示例

```java
@Configuration
public class Config {
    @Bean(name = "db1", typed = true)
    public DataSource db1(@Inject("${test.db1}") HikariDataSource dataSource) {
        return dataSource;
    }
}
```

```yaml
demo.db1:
  schema: rock
  jdbcUrl: jdbc:mysql://localhost:3306/rock?useUnicode=true&characterEncoding=utf8&autoReconnect=true&rewriteBatchedStatements=true
  driverClassName: com.mysql.cj.jdbc.Driver
  username: root
  password: 123456

# 配置印射的是 SQLManagerBuilder 字段（1.10.3 开始支持）
beetlsql.db1:
  dialect: "mysql" #快捷配置
  slaves: "db2,db3"  #快捷配置
  debug: true  #快捷配置
  nc: "org.wisecloud.common.db.beetlsql.JPANameConversion" #字段映射
  dbStyle: "org.beetl.sql.core.db.MySqlStyle" #字段映射：与 dialect 效果相同
  interceptorList: #字段映射
    - "org.beetl.sql.ext.DebugInterceptor" #与 debug 效果相同
    - "org.beetl.sql.ext.Slf4JLogInterceptor"
```