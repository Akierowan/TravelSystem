package jiang.luo.travelsystem.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.basePackage("jiang.luo.travelsystem.controller"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo()); // 添加API信息
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("旅游业务管理系统")
                .description("大模型+软件工程基础实验")
                .version("1.0")
                .build();
    }
}
