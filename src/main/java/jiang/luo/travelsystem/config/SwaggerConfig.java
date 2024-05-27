package jiang.luo.travelsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30) // 使用 OAS 3.0
                .select()
                .apis(RequestHandlerSelectors.basePackage("jiang.luo.travelsystem.controller")) // 选择所有API
                .paths(PathSelectors.any()) // 选择所有路径
                .build()
                .apiInfo(apiInfo()); // 添加API信息
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("旅游业务管理系统") // API文档标题
                .description("大模型+软件工程基础实验") // API文档描述
                .version("1.0") // 版本
//                .contact(new Contact("Name", "URL", "Email")) // 联系人信息
                .build();
    }
}