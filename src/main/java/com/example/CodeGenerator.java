package com.example;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;
import com.github.yulichang.base.MPJBaseMapper;
import com.github.yulichang.base.MPJBaseService;
import com.github.yulichang.base.MPJBaseServiceImpl;

import java.nio.file.Paths;
import java.sql.Types;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        //数据库的url
        String url = "jdbc:mysql://localhost:3306/code_generator?serverTimezone=Asia/Shanghai";
        //数据库的账号
        String username = "root";
        //数据库的密码
        String password = "123456";
        String baseDir = System.getProperty("user.dir");
        String codePath = "src/main/java";
        String xmlPath = "src/main/resources/mapper";
        String codeOutputDir = Paths.get(baseDir, codePath).toString();
        String xmlOutputDir = Paths.get(baseDir, xmlPath).toString();

        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("蓝猫") // 设置作者
                            .enableSpringdoc() // 开启OpenAPI3 模式
                            .outputDir(codeOutputDir) // 指定输出目录
                            .commentDate("yyyy-MM-dd")
                            .disableOpenDir();
                })
                .dataSourceConfig(builder ->
                        builder.typeConvertHandler((globalConfig, typeRegistry, metaInfo) -> {
                            int typeCode = metaInfo.getJdbcType().TYPE_CODE;
                            if (typeCode == Types.SMALLINT) {
                                // 自定义类型转换
                                return DbColumnType.INTEGER;
                            }
                            return typeRegistry.getColumnType(metaInfo);
                        })
                )
                .packageConfig(builder ->
                        builder.parent("com.example") // 设置父包名
                                .moduleName("") // 设置父包模块名
                                .entity("entity")
                                .service("service")
                                .serviceImpl("service.impl")
                                .controller("controller")
                                .mapper("mapper")
                                .xml("mapper")
                                .pathInfo(Collections.singletonMap(OutputFile.xml, xmlOutputDir)) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("user") // 设置需要生成的表名
                                //.addTablePrefix("t_", "c_") // 设置过滤表前缀
                                //entity配置
                                .entityBuilder()
                                .javaTemplate("/templates/entity.java") //自定义实体类模板，改为使用@Data
                                .idType(IdType.AUTO) //id类型为自增
                                .enableLombok() // 启用Lombok
                                .enableChainModel() // 启用链式编程
                                .disableSerialVersionUID() //禁用生成 serialVersionUID
                                .enableTableFieldAnnotation()
                                .enableFileOverride() //覆盖已生成文件
                                //controller配置
                                .controllerBuilder()
                                .enableRestStyle()
                                .formatFileName("%sController")
                                .enableFileOverride()
                                //service配置
                                .serviceBuilder()
                                .superServiceClass(MPJBaseService.class)
                                .superServiceImplClass(MPJBaseServiceImpl.class)
                                .formatServiceFileName("%sService")
                                .formatServiceImplFileName("%sServiceImp")
                                .enableFileOverride()
                                //mapper配置
                                .mapperBuilder()
                                .superClass(MPJBaseMapper.class)
                                .mapperAnnotation(org.apache.ibatis.annotations.Mapper.class) //启用@Mapper注解
                                .enableBaseResultMap() //生成通用的resultMap
                                .formatMapperFileName("%sMapper")
                                .formatXmlFileName("%sMapper")
                                .enableFileOverride()
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
