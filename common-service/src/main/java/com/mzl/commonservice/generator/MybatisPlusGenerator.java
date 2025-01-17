package com.mzl.commonservice.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.core.exceptions.MybatisPlusException;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang.StringUtils;
import java.util.Scanner;

/**
 * @Description: Mybatis生成器
 * @Author: mzl
 */
public class MybatisPlusGenerator {

    /**
     * 读取控制台内容
     *
     * @param tip 输入的提示
     * @return 输入处理表
     */
    public static String scanner(String tip) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder help = new StringBuilder();
        help.append("请输入" + tip + "：");
        System.out.println(help.toString());
        if (scanner.hasNext()) {
            String ipt = scanner.next();
            if (StringUtils.isNotBlank(ipt)) {
                return ipt;
            }
        }
        // 输入多个表名要用逗号隔开，然后按enter键即可
        throw new MybatisPlusException("请输入正确的" + tip + "！");
    }

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/java_stack_study?characterEncoding=utf8&useSSL=false&useUnicode=true&serverTimezone=UTC&allowMultiQueries=true");
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("105293");
        mpg.setDataSource(dsc);

        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(System.getProperty("user.dir" ) + "/common-service/src/main/java");
        gc.setAuthor("mzl");
        // 生成之后是否打开资源管理器
        gc.setOpen(false);
        // 重新生成后是否覆盖文件
        gc.setFileOverride(true);
        // %s为占位符，mp生成Service层代码，默认接口名称第一个字母是有I
        gc.setServiceName("%sService");
        // 设置主键生成策略 自动增长
        gc.setIdType(IdType.AUTO);
        // 设置Date类型 只使用java.util.date代替
        gc.setDateType(DateType.ONLY_DATE);
        mpg.setGlobalConfig(gc);

        // 包配置(自己根据实际项目路径修改一下即可)
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.mzl.commonservice.generator");
        pc.setController("controller");
        pc.setService("service");
        pc.setServiceImpl("service.impl");
        pc.setMapper("mapper");
        pc.setEntity("entity");
        mpg.setPackageInfo(pc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        // 实体类名称驼峰命名
        strategy.setNaming(NamingStrategy.underline_to_camel);
        // 字段名称驼峰命名
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        // 设置lombok
        strategy.setEntityLombokModel(true);
        // Controller使用RestController
        strategy.setRestControllerStyle(true);
        // 驼峰转连字符
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        // 执行生成代码
        mpg.execute();
    }
}