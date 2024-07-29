package com.example.config;


import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger开发文档相关配置
 */
@Configuration
public class SwaggerConfiguration {

    /**
     * 配置文档介绍以及详细信息
     * @return OpenAPI
     */
    @Bean
    public OpenAPI springShopOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("示例项目 API 文档")
                        .description("欢迎来到本示例项目API测试文档，在这里可以快速进行接口调试")
                        .contact(new Contact().name("作者").email("邮箱").url("https://github.com"))
                        .version("1.0")
                        .license(new License()
                                .name("项目开源地址")
                                .url("https://github.com/Ketuer/SpringBoot-Vue-Template-Jwt")
                        )
                )
                // 引入外部的文档，我这里引得是 springdoc 官方文档地址，你可以不配此项
                .externalDocs(new ExternalDocumentation()
                        .description("SpringDoc Full Documentation")
                        .url("https://springdoc.org/")
                );
    }
}
