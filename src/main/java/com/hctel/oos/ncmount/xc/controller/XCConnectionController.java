package com.hctel.oos.ncmount.xc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.xc.service.XCConnectionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/3 14:20
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/xcs")
public class XCConnectionController {
    @Resource
    private XCConnectionService xcConnectionService;

    @GetMapping
    public JSONObject getConnections(@PathVariable String node) {
        return xcConnectionService.getConnections(node);
    }

    @PostMapping
    public JSONObject getConnection(@PathVariable String node, @RequestBody JSONObject connection) {
        return xcConnectionService.getConnection(node, connection);
    }

    @PostMapping("xc")
    public String configConnection(@PathVariable String node, @RequestBody JSONObject connection) {
        return xcConnectionService.configConnection(node, connection);
    }

    @DeleteMapping("xc/{name}")
    public String deleteConnection(@PathVariable String node, @PathVariable String name) {
        return xcConnectionService.deleteConnection(node, name);
    }
}
