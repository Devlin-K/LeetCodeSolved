package org.dkwork.leetcodesolved.controller;

import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dkwork.leetcodesolved.common.domain.ResultInfo;
import org.dkwork.leetcodesolved.common.domain.Status;
import org.dkwork.leetcodesolved.questSolved.SingleNumberQuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jin
 * @date 2020/10/14
 * @Mail Jinyl@mail.taiji.com.cn
 * @BelongProjecet javatemplate
 * @BelongPackage org.dkwork.javatemplate.controller
 * @Describe:
 */
@RestController
@RequestMapping("config")
public class ConfigController {
    @ApiOperation(value = "测试")
    @GetMapping(value = "/test")
    @SneakyThrows
    public ResultInfo<Object> Test() {

        return new ResultInfo<>(Status.SUCCESS).result(new SingleNumberQuest().getNum(new int[]{1, 2, 3, 4, 1, 2, 3}));
    }

    @ApiOperation(value = "测试")
    @GetMapping(value = "/test1")
    @SneakyThrows
    public ResultInfo<Object> Test1() {
        Level level = Level.toLevel("ERROR");
        Logger logger = LogManager.getLogger("org.dkwork.leetcodesolved.questSolved.SingleNumberQuest");
        logger.setLevel(level);
        return new ResultInfo<>(Status.SUCCESS);
    }
}
