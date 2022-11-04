package com.hctel.oos.ncmount.devm.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.FtpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 14:05
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/ftps")
public class FtpController {
    @Resource
    private FtpService ftpService;

    @GetMapping
    public JSONObject getFtps(@PathVariable String node) {
        return ftpService.getFtps(node);
    }

    /**
     * 获取指定信息的ftp
     *
     * @param node   网元名称
     * @param object 指定内容
     * @return ftp信息
     */
    @PostMapping
    public JSONObject getFtp(@PathVariable String node, @RequestBody JSONObject object) {
        return ftpService.getFtp(node, object);
    }

    @PostMapping("/ftp")
    public String configFtp(@PathVariable String node, @RequestBody JSONObject object) {
        return ftpService.configFtp(node, object);
    }
}
