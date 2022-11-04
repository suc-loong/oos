package com.hctel.oos.ncmount.xc.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.entity.Json2Odl;
import com.hctel.oos.ncmount.xc.entity.OduConnection;
import com.hctel.oos.ncmount.xc.service.OduConnectionService;
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
public class OduConnectionController {

    @Resource
    private OduConnectionService oduConnectionService;

    @PostMapping("/create-odu-connection")
    public String createOduConnection(@PathVariable String node, @RequestBody JSONObject input){
        System.out.println(input);
        return oduConnectionService.createOduConnection(node,input);
    }
}
