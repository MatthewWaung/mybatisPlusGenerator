package com.maqh.demo;

import java.util.Collections;

/**
 * mybatis-plus最新版代码生成器（Swagger3）
 * https://blog.51cto.com/u_15082395/4338652
 */
public class GeneratorSwagger3 {

    /**
     * 注意mybatis-plus-generator版本为3.5以上
     *
     * <!--lombok-->
     *         <dependency>
     *             <groupId>org.projectlombok</groupId>
     *             <artifactId>lombok</artifactId>
     *         </dependency>
     *         <!--代码生成器构建依赖-->
     *         <dependency>
     *             <groupId>com.baomidou</groupId>
     *             <artifactId>mybatis-plus-generator</artifactId>
     *             <version>3.5.1</version>
     *         </dependency>
     *         <!--mybatis-plus-starter-->
     *         <dependency>
     *             <groupId>com.baomidou</groupId>
     *             <artifactId>mybatis-plus-boot-starter</artifactId>
     *             <version>3.4.3.4</version>
     *         </dependency>
     *         <!--默认模板，不引入这个会报错-->
     *         <dependency>
     *             <groupId>org.apache.velocity</groupId>
     *             <artifactId>velocity-engine-core</artifactId>
     *             <version>2.3</version>
     *         </dependency>
     *         <!--swagger3-->
     *         <dependency>
     *             <groupId>io.springfox</groupId>
     *             <artifactId>springfox-boot-starter</artifactId>
     *             <version>3.0.0</version>
     *         </dependency>
     * -----------------------------------
     * mybatis-plus最新版代码生成器（Swagger3）
     * https://blog.51cto.com/u_15082395/4338652
     */

    static final String URL = "jdbc:mysql://localhost:3306/m_manage?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&useSSL=true";


//    public static void main(String[] args) {
//        String projectPath = System.getProperty("user.dir");//获取项目路径
//        FastAutoGenerator.create(URL, "root", "125803")
//                //全局配置
//                .globalConfig(builder -> {
//                    builder.author("wjc")
//                            .outputDir(projectPath + "/src/main/java")//输出路径
//                            .enableSwagger()//开启swagger3
//                            .fileOverride()//覆盖文件
//                            .disableOpenDir();//不打开文件夹
//                })
//                //包名配置
//                .packageConfig(builder -> {
//                    builder.parent("com.wang")
//                            .moduleName("blog")
//                            .service("service")
//                            .serviceImpl("service.impl")
//                            .controller("controller")
//                            .entity("pojo")
//                            .mapper("mapper")
//                            //自定义输出路径，mapper.xml生成到resources目录下
//                            .pathInfo(Collections.singletonMap(OutputFile.mapperXml, projectPath + "/src/main/resources/mapper"));
//                })
//                //策略配置
//                .strategyConfig(builder -> {
//                    builder.addInclude("student")
//                            .addTablePrefix("t_")//表前缀
//                            .serviceBuilder().formatServiceFileName("%sService")//去掉Service的 "I" 前缀
//                            .controllerBuilder().enableRestStyle()//restful开启
//                            .enableHyphenStyle()//url改变 例如：index_id_1
//                            .entityBuilder().enableLombok();//开启lombok
//                })
//                //执行
//                .execute();
//    }

}
