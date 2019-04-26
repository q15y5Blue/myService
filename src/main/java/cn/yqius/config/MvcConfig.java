package cn.yqius.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/login").setViewName("login");
        this.addTieBa(registry);
    }

    //addViewController("前端显示").setViewName("实际路径")
    public void addTieBa(ViewControllerRegistry registry){
        registry.addViewController("/article").setViewName("article");
        registry.addViewController("/article/reply").setViewName("reply");
        registry.addViewController("/faq").setViewName("faq");
    }

    //静态文件处理
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
    }
}