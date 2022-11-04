package com.hctel.oos.ncmount.xc.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.EthConnectionService;
import com.hctel.oos.ncmount.xc.service.SdhConnectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 14:38
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}")
public class SdhConnectionController {
    @Resource
    private SdhConnectionService sdhConnectionService;

    @PostMapping("/create-sdh-connection")
    public String createSdhConnection(@PathVariable String node, @RequestBody JSONObject input){
        return sdhConnectionService.createSdhConnection(node,input);
    }
}
