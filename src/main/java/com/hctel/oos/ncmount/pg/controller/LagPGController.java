package com.hctel.oos.ncmount.pg.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.pg.service.LagPGService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:14
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/lagPGs")
public class LagPGController {

    @Resource
    private LagPGService lagPGService;

    @GetMapping
    public JSONObject getLagPGs(@PathVariable String node){
        return lagPGService.getLagPGs(node);
    }

    @GetMapping("/lagPG/{pgId}")
    public JSONObject getLagPG(@PathVariable String node,@PathVariable String pgId){
        return lagPGService.getLagPG(node,pgId);
    }

    @PostMapping("/lagPG/{pgId}")
    public String configLagPG(@PathVariable String node,@PathVariable String pgId,@RequestBody JSONObject lagPG){
        return lagPGService.configLagPG(node,lagPG);
    }

}
