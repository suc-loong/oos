package com.hctel.oos.ncmount.devm.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.EqService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/3 11:02
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/eqs")
public class EqController {
    @Resource
    private EqService eqService;

    @GetMapping
    public JSONObject getEqs(@PathVariable String node){
        return eqService.getEqs(node);
    }

    @PostMapping("/eq")
    public JSONObject getEq(@PathVariable String node,@RequestBody JSONObject eqs){
        return eqService.getEq(node,eqs);
    }

    @PostMapping("/reset")
    public String resetEq(@PathVariable String node,@RequestBody JSONObject input){
        return eqService.resetEq(node,input);
    }
}
