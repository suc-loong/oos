package com.hctel.oos.ncmount.xc.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.EthConnectionService;
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
public class EthConnectionController {

    @Resource
    private EthConnectionService ethConnectionService;

    @PostMapping("/create-eth-connection")
    public String createEthConnection(@PathVariable String node, @RequestBody JSONObject input){
        return ethConnectionService.createEthConnection(node,input);
    }
    @PostMapping("/create-eth-to-eth-connection")
    public String createEth2EthConnection(@PathVariable String node,@RequestBody JSONObject input){
        return ethConnectionService.createEth2EthConnection(node,input);
    }
}
