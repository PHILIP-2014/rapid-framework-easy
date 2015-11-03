rapid-framework-easy

*UTF-8 Encoding

修改整个项目的属性为UTF-8编码

项目搭建请查看doc/guide.html

项目网站:http://code.google.com/p/rapid-framework/

基于spring,struts(struts2),hibernate的web项目脚手架

一个类似 ruby on rails 的java web快速开发脚手架,本着不重复发明轮子的原则,框架只是将零散的struts(struts2)+spring+hibernate各个组件组装好在 一起,并对struts及struts2进行改造,提供零配置编程,并内置一个强大的代码生成器及模板文件, 可以生成java的hibernat model,dao,manager,struts+struts2 action类,可以生成jsp的增删改查及列表页面

*框架特性

内置一个基于数据库的代码生成器rapid-generator,极易进行二次开发
struts1,struts2的零配置
spring集成及加强,自动搜索hibernate的entity annotation class
集成动态构造sql的工具:rapid-xsqlbuilder
集成javascript表单验证:rapid-validation
集成extremeTable列表分页组件,并简单扩展显示pageNumber
集成DBUnit及spring对数据库测试的支持
内置的分页查询PageInfo接口
Java日期转换的特殊处理,与My97DatePicker集成
内置最精简的ant构建脚本,简单修改即可使用
公共类库友好的包名javacommon
整个项目尽量做到最小集,无需删除任何资源,拿来即可使用.
友好的MIT-Licence

