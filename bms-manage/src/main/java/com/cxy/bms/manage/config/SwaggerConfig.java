package com.cxy.bms.manage.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author chenxy
 * @date 2020/4/26 16:31
 * @desc swagger配置
 *  Swagger常用注解
 * @Api：修饰整个类，描述Controller的作用；
 *
 * @ApiOperation：描述一个类的一个方法，或者说一个接口；
 *
 * @ApiParam：单个参数描述；
 *
 * @ApiModel：用对象来接收参数；
 *
 * @ApiProperty：用对象接收参数时，描述对象的一个字段；
 *
 * @ApiResponse：HTTP响应其中1个描述；
 *
 * @ApiResponses：HTTP响应整体描述；
 *
 * @ApiIgnore：使用该注解忽略这个API；
 *
 * @ApiError ：发生错误返回的信息；
 *
 * @ApiImplicitParam：一个请求参数；
 *
 * @ApiImplicitParams：多个请求参数。
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket buildDocket(){

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.cxy.bms.manage.api"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }

    private ApiInfo apiInfo(){
        ApiInfo apiInfo = new ApiInfoBuilder()
                .title("预算管理系统API文档")
                .contact(new Contact("eason","https://www.baidu.com","chenxingyu@xinchao.com"))
                .version("v2.1")
                .build();
        return apiInfo;
    }

}

