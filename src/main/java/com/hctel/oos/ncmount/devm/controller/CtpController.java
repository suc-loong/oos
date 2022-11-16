package com.hctel.oos.ncmount.devm.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.CtpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 14:04
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/ctps")
public class CtpController {
    @Resource
    private CtpService ctpService;

    @GetMapping
    public JSONObject getCtps(@PathVariable String node){
        return ctpService.getCtps(node);
    }

    @GetMapping("/{name}")
    public JSONObject getCtp(@PathVariable String node,@PathVariable String name){
        return ctpService.getCtp(node,name);
    }

    @PostMapping
    public JSONObject getCtp(@PathVariable String node,@RequestBody JSONObject ctp){
        return ctpService.getCtp(node,ctp);
    }

    @PostMapping("/ctp")
    public String configCtp(@PathVariable String node,@RequestBody JSONObject ctp){
        return ctpService.configCtp(node,ctp);
    }
}
