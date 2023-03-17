package shop.mtcoding.hiberpc.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import shop.mtcoding.hiberpc.config.filter.MyBlackListFilter;

@Configuration
public class FilterRegisterConfig {

    @Bean // 내가 만들지 않은 클래스는 @Bean 방식이 좋다. 아니면 extends 해야 하기 때문.
    public FilterRegistrationBean<?> blackListFilter() {
        FilterRegistrationBean<MyBlackListFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new MyBlackListFilter());
        registration.addUrlPatterns("/filter");
        registration.setOrder(1); // Filter의 순서
        return registration;
    }
}
