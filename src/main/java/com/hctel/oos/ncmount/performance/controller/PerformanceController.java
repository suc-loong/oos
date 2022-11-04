package com.hctel.oos.ncmount.performance.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.performance.service.PerformanceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:24
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}")
public class PerformanceController {
    @Resource
    private PerformanceService performanceService;

    @GetMapping("/performances")
    public JSONObject getPerformances(@PathVariable String node){
        return performanceService.getPerformances(node);
    }

    @PostMapping("/performances")
    public JSONObject getPerformance(@PathVariable String node,@RequestBody JSONObject performance){
        return performanceService.getPerformance(node,performance);
    }

    @PostMapping("/performance&history")
    public JSONObject getHistoryPerformances(@PathVariable String node,@RequestBody JSONObject input){
        return performanceService.getHistoryPerformanceMonitoringData(node,input);
    }
}
