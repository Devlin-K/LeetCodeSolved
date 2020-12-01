package org.dkwork.javatemplate.common.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author Jinyl
 * @date 2020/5/12
 * @Mail Jinyl@mail.taiji.com.cn
 * @Describe: 配置类，解决service无法注入的问题
 */
@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        ApplicationContextUtil.applicationContext = applicationContext;

    }
    public static Object getBean(String beanName) {
        return applicationContext.getBean(beanName);
    }
}