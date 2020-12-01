package org.dkwork.javatemplate.controller;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jin
 * @date 2020/10/14
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProjecet javatemplate
 * @BelongPackage org.dkwork.javatemplate.controller
 * @Describe:
 */
@Controller
@RequestMapping("config")
public class ConfigController {

    @NacosValue(value = "${config}", autoRefreshed = true)
    private String useLocalCache;

    @GetMapping(value = "/getConfig")
    @ResponseBody
    public String get() {
        return useLocalCache;
    }
}
