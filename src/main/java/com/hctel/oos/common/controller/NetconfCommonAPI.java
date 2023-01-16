package com.hctel.oos.common.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.service.impl.NetconfCommonAPIService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 * 基于网元（挂载点）的netconf通用操作接口
 *
 * @Author wcloong
 * @Date 2022/12/30 16:15
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}")
public class NetconfCommonAPI {

    @Resource
    private NetconfCommonAPIService netconfCommonAPIService;

    @PostMapping("/get")
    public JSONObject generalGetRequest(@PathVariable String node, @RequestBody JSONObject input) {
        return netconfCommonAPIService.generalGetRequest(node, input);
    }

    @PostMapping("/edit-config")
    public JSONObject generalEditConfigRequest(@PathVariable String node, @RequestBody JSONObject input) {
        return netconfCommonAPIService.generalEditConfigRequest(node, input);
    }
}
