package com.hctel.oos.ncmount.devm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.ncmount.devm.service.MeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}")
public class MeController {

    /**
     * 服务对象
     */
    @Resource
    private MeService meService;

    @GetMapping("/me")
    public JSONObject getNodeMe(@PathVariable String node) {
        return meService.getMe(node);
    }

    @GetMapping("/ntp-servers")
    public JSONObject getNtps(@PathVariable String node) {
        return meService.getNtpServers(node);
    }

    @RequestMapping("/ntp-servers")
    public String configNtps(@PathVariable String node, @RequestBody String json) {
        System.out.println(PrettyJSON.pretty(json));
        return meService.configNtpServers(node, JSON.parseObject(json));
    }

    @RequestMapping("/managed-element-time")
    public String setManagedElementTime(@PathVariable String node, @RequestBody JSONObject input) {
        return meService.setManagedElementTime(node, input);
    }

    @GetMapping("/managed-element-time")
    public String getManagedElementTime(@PathVariable String node) {
        return meService.getManagedElementTime(node);
    }



}
