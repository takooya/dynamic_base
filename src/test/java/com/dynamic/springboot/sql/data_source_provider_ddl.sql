create table data_source_property
(
    id              int auto_increment primary key comment '主键id',
    poolName        varchar(63) comment '连接池名称(只是一个名称标识)</br> 默认是配置文件上的名称',
    type            varchar(63) comment '连接池类型，如果不设置自动查找 Druid > HikariCp; javatype = Class<? extends DataSource>',
    driverClassName varchar(63) comment 'JDBC driver',
    url             varchar(1023) comment 'JDBC url 地址',
    username        varchar(63) comment 'JDBC 用户名',
    password        varchar(63) comment 'JDBC 密码',
    jndiName        varchar(63) comment 'jndi数据源名称(设置即表示启用)',
    `schema`        text comment '自动运行的建表脚本',
    data            text comment '自动运行的数据脚本',
    seata           boolean    default true comment '是否启用seata 默认开启',
    p6spy           boolean    default true comment '是否启用p6spy 默认开启',
    lazy            boolean comment 'lazy init datasource',
    continueOnError boolean    default true comment '错误是否继续 默认 true',
    `separator`     varchar(3) default ';' comment '分隔符 默认 ;'
);