package com.hctel.oos.ncmount.devm.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.PtpService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.operational;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 13:42
 * @Version 0.1.0
 */
@Service
public class PtpServiceImpl implements PtpService {
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getPtps(String node) {
        String module = "acc-devm:ptps";
        JSONObject obj = odlNetconfChannelUtils.getRequest(operational, node, module);
        JSONObject ptps = obj.getJSONObject("ptps");
        return ptps;
    }

    @Override
    public JSONObject getPtp(String node, JSONObject ptp) {
        JSONObject ptps = new JSONObject();
        ptps.put("ptps",ptp);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node, ptps));
    }

    @Override
    public String configPtp(String node, JSONObject ptp) {
        JSONObject ptps = new JSONObject();
        ptps.put("ptps",ptp);
        return odlNetconfChannelUtils.generalEditConfigRequest(node, ptp);
    }
}
