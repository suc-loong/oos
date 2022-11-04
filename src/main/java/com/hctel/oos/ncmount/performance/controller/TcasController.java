package com.hctel.oos.ncmount.performance.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.performance.service.TcasService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/31 16:16
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/tca-parameters")
public class TcasController {
    @Resource
    private TcasService tcasService;

    @GetMapping
    public JSONObject getTcas(@PathVariable String node){
        return tcasService.getTcaParameter(node);
    }

    @PostMapping
    public JSONObject getTca(@PathVariable String node,@RequestBody JSONObject tcaParameter){
        return tcasService.getTcaParameter(node,tcaParameter);
    }


}
