package com.maqh.demo;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.maqh.demo.common.BaseAutoFillModel;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author maqh
 * @date 2019/9/6 16:41
 */
public class Generator {

    /**
     * 包名
     */
    public static final String PACKAGE_NAME = "com.ecoflow";

    /**
     * 模块名
     */
    public static final String MODULE_NAME = "oms";

    /**
     * 获取当前项目的路径
     */
//    public static final String PROJECT_PATH = System.getProperty("user.dir") + "/code-generator";
    public static final String PROJECT_PATH = System.getProperty("user.dir");


    /**
     * 代码存储路径
     */
    public static final String CODE_SAVE_PATH = PROJECT_PATH + "/src/main/java/" + StringUtils.join((PACKAGE_NAME + "." + MODULE_NAME).split("\\."), "/");


    /**
     * <p>
     * 读取控制台内容
     * </p>
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotEmpty(ipt)) {
                return ipt;
            }
        }
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        System.out.println("当前项目在磁盘的绝对路径：" + System.getProperty("user.dir"));
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("");
        gc.setOpen(false);
        gc.setFileOverride(true);//是否覆盖文件
        gc.setBaseResultMap(true); // xml resultmap
        gc.setBaseColumnList(true); // xml columlist
        gc.setSwagger2(true);  //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
//        dsc.setUrl("jdbc:mysql://192.168.1.230:3306/bim?&characterEncoding=utf8&useSSL=false&serverTimezone=UTC");
//        dsc.setDriverName("com.mysql.jdbc.Driver");
//        dsc.setUsername("root");
//        dsc.setPassword("123456");
        dsc.setUrl("jdbc:mysql://10.10.12.18:3306/ecoflow_admin?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8&nullCatalogMeansCurrent=true&allowMultiQueries=true");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("Ecoflow@123");
        dsc.setTypeConvert(new MySqlTypeConvert(){
            // 自定义数据库表字段类型转换【可选】
            @Override
            public IColumnType processTypeConvert(GlobalConfig globalConfig, String fieldType) {
                if ( fieldType.toLowerCase().contains( "datetime" ) ) {
                    return DbColumnType.LOCAL_DATE_TIME;
                }
                return super.processTypeConvert(globalConfig, fieldType);
            }

        });
        mpg.setDataSource(dsc);

        // 包配置
        PackageConfig pc = new PackageConfig();
//        String packgeName = scanner("包名");
//        pc.setParent("com.maqh.demo");
//        pc.setController("controller."+packgeName);
//        pc.setEntity("domain." + packgeName);
//        pc.setService("service." + packgeName);
//        pc.setServiceImpl("service." + packgeName +".impl");
//        pc.setMapper("dao." + packgeName);
        pc.setParent("com.ecoflow");
        pc.setModuleName("oms");

        mpg.setPackageInfo(pc);
        mpg.setPackageInfo(pc);

        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

        // 如果模板引擎是 freemarker，这里的路径是编译后工程的相对路径，其文件是resources目录下的templates文件
        String templatePath = "/templates/mapper.xml.ftl";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
//        focList.add(new FileOutConfig(templatePath) {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
//                return projectPath + "/src/main/resources/mapper/"
//                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });

        // 自定义输出文件的位置，参考：https://blog.csdn.net/qq_42151769/article/details/103801366
        //mapper xml类
//        focList.add(new FileOutConfig("/templates/mapper.xml.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return CODE_SAVE_PATH + "/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
//            }
//        });

//        // entity 类
//        focList.add(new FileOutConfig("/templates/entity.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return CODE_SAVE_PATH + "/entity/" + tableInfo.getEntityName() + "DO" + StringPool.DOT_JAVA;
//            }
//        });
//
//        //service类
//        focList.add(new FileOutConfig("/templates/service.java.ftl") {
//            @Override
//            public String outputFile(TableInfo tableInfo) {
//                // 自定义输入文件名称
//                return CODE_SAVE_PATH + "/service/" + tableInfo.getEntityName() + "Service" + StringPool.DOT_JAVA;
//            }
//        });


        cfg.setFileOutConfigList(focList);
        mpg.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();
        mpg.setTemplate(templateConfig);

        // 策略配置，配置模板文件entity.java.ftl、mapper.xml.ftl、serviceImpl.java.ftl等文件中的配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);  // 数据库下划线转驼峰格式
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);  // 列名下划线转驼峰格式
        strategy.setEntityLombokModel(true);  // 开启Lombok
        strategy.setRestControllerStyle(true);
        strategy.setSuperEntityClass(BaseAutoFillModel.class);  // 设置父类
        strategy.setEntityTableFieldAnnotationEnable(true);  // 列名开启@TableField注解
        strategy.setEntitySerialVersionUID(false);  // 取消UID

        // 设置自动填充字段 和 设置乐观锁字段 参考：https://blog.csdn.net/weixin_41998947/article/details/125349898
        // 设置自动填充字段，对应entity.java.ftl中<#elseif field.fill??>的开关
//        List<TableFill> tableFillList = new ArrayList<>();
//        TableFill tableFill = new TableFill("create_time", FieldFill.INSERT);
//        tableFillList.add(tableFill);
//        strategy.setTableFillList(tableFillList);
//        // 设置乐观锁字段
//        strategy.setVersionFieldName("version");

        // 公共父类
        // 写于父类中的公共字段
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setControllerMappingHyphenStyle(true);
        strategy.setTablePrefix("t_");
        mpg.setStrategy(strategy);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        mpg.execute();
    }
}
