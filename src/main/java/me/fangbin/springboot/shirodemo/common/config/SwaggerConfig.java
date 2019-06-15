package me.fangbin.springboot.shirodemo.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author BG348516
 * @date 2019/6/14
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket createRestApi(){
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        //name表示对象名称，description表示描述
        //required表示是否必填，defaultvalue表示默认值
        ticketPar.name("token").description("登录校验token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build();
        //添加完此处一定要把下边的带***的也加上否则不生效
        pars.add(ticketPar.build());

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("me.fangbin.springboot.shirodemo.controller"))
                .paths(PathSelectors.any())
                .build()
                .globalOperationParameters(pars);

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Swagger2.0 接口文档")
                .description("shirodemo项目1.0版本全部接口")
                .termsOfServiceUrl("http://blog.fangbin.me")
                .version("1.0").build();
    }

}
