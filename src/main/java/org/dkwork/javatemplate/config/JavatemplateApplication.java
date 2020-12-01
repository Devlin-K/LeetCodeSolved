package org.dkwork.javatemplate.config;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Jinyl
 * @Mail: Jinyl@mail.taiji.com.cn
 */
@EnableCaching
@EnableScheduling
@MapperScan({"org.dkwork.javatemplate.generator.mapper","org.dkwork.javatemplate.core.services.mapper2xml"})
@SpringBootApplication(scanBasePackages={"org.dkwork.javatemplate"})
@NacosPropertySource(dataId = "test20191230", autoRefreshed = true)
public class JavatemplateApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        /*禁用 热部署*/
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(JavatemplateApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JavatemplateApplication.class);
    }

}
