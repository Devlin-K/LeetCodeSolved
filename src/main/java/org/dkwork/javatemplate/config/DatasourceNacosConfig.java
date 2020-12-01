package org.dkwork.javatemplate.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.alibaba.druid.pool.DruidDataSource;

/**
 * @author jin
 * @date 2020/10/14
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProjecet javatemplate
 * @BelongPackage org.dkwork.javatemplate.config
 * @Describe:
 */
@Slf4j
@Configuration
@Data
@NacosPropertySource(dataId = "DBproperties", autoRefreshed = true)
public class DatasourceNacosConfig {
    @NacosValue(value = "${spring.datasource.url}", autoRefreshed = true)
    private String dbUrl;

    @NacosValue(value = "${spring.datasource.username}", autoRefreshed = true)
    private String username;

    @NacosValue(value = "${spring.datasource.password}", autoRefreshed = true)
    private String password;

    @NacosValue(value = "${spring.datasource.driver-class-name}", autoRefreshed = true)
    private String driverClassName;

    @Bean
    public DruidDataSource dataSource()
    {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(this.dbUrl);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);
        return datasource;
    }
}
