# cloud-learn
learn spring cloud together

##目前的问题
###1.1不知道为什么orderservice通过resttemplate调用userservice时找不到实例

##遇到的已解决的问题
###1.1 SpringCloud版本太高需要添加BootStrap的坐标，否则nacos的bootstrap.yml文件读取失败，导致一系列问题
###1.2 配置cluster.conf时候，记得用ip地址（浏览器输入ip即可），写127.0.0.1的话，会调用失败
###1.3 很多问题都是因为各个库版本不兼容导致，最好的处理方式就是不手动指定版本，自动指定
###1.4 通过阅读官方文档得知，feign的日志级别需要logging.level为debug时才会生效
