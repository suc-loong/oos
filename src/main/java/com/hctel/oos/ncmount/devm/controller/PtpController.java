package com.hctel.oos.ncmount.devm.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.PtpService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 13:59
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/ptps")
public class PtpController {
    @Resource
    private PtpService ptpService;

    @GetMapping
    public JSONObject getPtps(@PathVariable String node){
        return ptpService.getPtps(node);
    }

    @PostMapping
    public JSONObject getPtp(@PathVariable String node,@RequestBody JSONObject ptp){
        return ptpService.getPtp(node,ptp);
    }

    @PostMapping("/ptp")
    public String configPtp(@PathVariable String node,@RequestBody JSONObject ptp){
        return ptpService.configPtp(node,ptp);
    }
}
