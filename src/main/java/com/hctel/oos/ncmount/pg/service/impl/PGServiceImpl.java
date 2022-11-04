package com.hctel.oos.ncmount.pg.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.pg.service.PGService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:08
 * @Version 0.1.0
 */
@Service
public class PGServiceImpl implements PGService {
    private static final String PG_MODULE = "acc-protection-group:pgs";

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getPgs(String nodeName) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational, nodeName, PG_MODULE);
    }

    @Override
    public JSONObject getPg(String nodeName, String pgId) {
        String module = PG_MODULE + "/pg/" + pgId;
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational, nodeName, module);
    }

    @Override
    public String createPg(String nodeName, JSONObject data) {
        String pgId = data.getJSONObject("pg").getString(" pg-id");
        String module = PG_MODULE + "/pg/" + pgId;
        return odlNetconfChannelUtils.putRequest(nodeName, module, data).toString();
    }

    @Override
    public String deletePg(String nodeName, String pgId) {
        String module = PG_MODULE + "/pg/" + pgId;
        return odlNetconfChannelUtils.deleteRequest(nodeName, module).toString();
    }

    @Override
    public String performProtectionCommand(String nodeName, JSONObject input) {
        String module = "acc-protection-group:perform-protection-command";
        return odlNetconfChannelUtils.postRequest(nodeName, module, input);
    }

    @Override
    public String switchSdTriggerEnable(String nodeName, JSONObject input) {
        String module = "acc-protection-group:switch-sd-trigger-enable";
        return odlNetconfChannelUtils.postRequest(nodeName, module, input);
    }

    @Override
    public String getSwitchSdTriggerStatus(String nodeName, JSONObject input) {
        String module = "acc-protection-group:get-switch-sd-trigger-status";

        return odlNetconfChannelUtils.postRequest(nodeName, module, input);
    }
}
