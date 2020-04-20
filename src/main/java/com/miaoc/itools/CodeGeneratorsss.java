package com.miaoc.itools;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * @program: formeal - 测试
 * @description:
 * @author: Mr.cc
 * @create: 2019-06-21 16:14
 **/

public class CodeGeneratorsss {
    public static void main(String[] args) {
        String packageName = "";
        boolean serviceNameStartWithI = true;//auth -> UserService, 设置成true: auth -> IUserService
        generateByTables(serviceNameStartWithI, packageName, "cc", "base", "fund_stat");
        System.out.println("completed...");
    }

    /**
     * @param serviceNameStartWithI
     * @param packageName   包名
     * @param author  作者
     * @param ModuleName  模块名
     * @param tableNames 表名
     */
    private static void generateByTables(boolean serviceNameStartWithI, String packageName, String author, String ModuleName, String tableNames) {
        GlobalConfig config = new GlobalConfig();
        String dbUrl = "jdbc:mysql://112.124.201.102:3306/crh_mof?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL)
                .setUrl(dbUrl)
                .setUsername("root")
                .setPassword("cairenhui")
                .setDriverName("com.mysql.cj.jdbc.Driver");
        StrategyConfig strategyConfig = new StrategyConfig();
        System.out.println("");
        strategyConfig
                .setCapitalMode(true)
                .setEntityLombokModel(false).setEntityColumnConstant(true).setEntityBuilderModel(true)
//                .setDbColumnUnderline(true)
                .setNaming(NamingStrategy.underline_to_camel)
//              .setSuperMapperClass("cn.saytime.mapper.BaseMapper")
                .setInclude(tableNames);//修改替换成你需要的表名，多个表名传数组
        config.setActiveRecord(false)
                .setAuthor(author)
//                .setOutputDir("formeal - 测试\\src\\main\\java")
                .setOutputDir("C:\\Users\\cc\\Desktop\\12")
//                .setOutputDir("D:\\workplace\\cc\\1111\\formeal - 测试\\src\\main\\java\\com\\miaoc\\itools")
                .setFileOverride(true)
                .setEnableCache(false);
        if (!serviceNameStartWithI) {
            config.setServiceName("%sService");
        }
        System.out.println("");
        new AutoGenerator().setGlobalConfig(config)
                .setDataSource(dataSourceConfig)
                .setStrategy(strategyConfig)
                .setPackageInfo(
                        new PackageConfig()
                                .setParent(packageName)
                                .setModuleName(ModuleName)
//                                .setController("controller")
                                .setEntity("entity")
//                                .setMapper("mapper")
//                                .setService("service")
//                                .setServiceImpl("service.impl")
//                                .setXml("mapper.mapping")
                ).execute();
    }

}
