package com.hctel.oos.ncmount.xc.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.EosConnectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/25 14:37
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}")
public class EosConnectionController {

    @Resource
    private EosConnectionService eosConnectionService;

    @PostMapping("/create-eos-connection")
    public String createEosConnection(@PathVariable String node, JSONObject input){
        return eosConnectionService.createEosConnection(node,input);
    }
}
