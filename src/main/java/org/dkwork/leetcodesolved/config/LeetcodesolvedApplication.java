package org.dkwork.leetcodesolved.config;

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
@SpringBootApplication(scanBasePackages={"org.dkwork.leetcodesolved"})
public class LeetcodesolvedApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        /*禁用 热部署*/
        // System.setProperty("spring.devtools.restart.enabled", "false");
        SpringApplication.run(LeetcodesolvedApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(LeetcodesolvedApplication.class);
    }

}
