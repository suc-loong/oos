package com.hctel.oos.ncmount.pg.controller;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.pg.entity.PG;
import com.hctel.oos.ncmount.pg.entity.PGSwitch;
import com.hctel.oos.ncmount.pg.service.PGService;
import com.hctel.oos.netconf.service.NetconfService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/27 15:47
 * @Version 0.1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/topology/node/{node}/pgs")
public class PGController {
    @Resource
    private PGService pgService;

    @GetMapping
    public JSONObject getPgs(@PathVariable String node) {
        return pgService.getPgs(node);
    }

    /**
     * 创建保护组
     *
     * @param node 网元名称
     * @param pgId 保护id
     * @param pg   报文内容
     * @return 操作状态
     */
    @PostMapping("/pg/{pgId}")
    public String createPg(@PathVariable String node, @PathVariable String pgId, @RequestBody JSONObject pg) {
        return pgService.createPg(node, pg);
    }

    @GetMapping("/pg/{pgId}")
    public JSONObject getPg(@PathVariable String node, @PathVariable String pgId) {
        return pgService.getPg(node, pgId);
    }

    @DeleteMapping("/pg/{pgId}")
    public String deletePg(@PathVariable String node, @PathVariable String pgId) {
        return pgService.deletePg(node, pgId);
    }

    @PostMapping("/ppc")
    public String performProtectionCommand(@PathVariable String node, @RequestBody JSONObject input) {
        return pgService.performProtectionCommand(node, input);
    }

    @PostMapping("/ste")
    public String switchSdTriggerEnable(@PathVariable String node, @RequestBody JSONObject input) {
        return pgService.switchSdTriggerEnable(node, input);
    }

    @PostMapping("/ssts")
    public String getSwitchSdTriggerStatus(@PathVariable String node, @RequestBody JSONObject input) {
        return pgService.getSwitchSdTriggerStatus(node, input);
    }
}
