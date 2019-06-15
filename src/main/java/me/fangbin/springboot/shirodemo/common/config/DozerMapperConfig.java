package me.fangbin.springboot.shirodemo.common.config;

import org.dozer.spring.DozerBeanMapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BG348516
 * @date 2019/6/15
 */
@Configuration
public class DozerMapperConfig {
    @Bean
    public DozerBeanMapperFactoryBean dozerBeanMapperFactoryBean() throws Exception {
        return new DozerBeanMapperFactoryBean();
    }
}
