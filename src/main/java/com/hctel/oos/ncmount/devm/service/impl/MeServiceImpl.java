package com.hctel.oos.ncmount.devm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.MeService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MeServiceImpl implements MeService {
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;


    @Override
    public JSONObject getMe(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,"acc-devm:me");
    }

    @Override
    public JSONObject getNtpServers(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,"acc-devm:me/ntp-servers");
    }

    @Override
    public String configNtpServers(String node, JSONObject jsonObject) {
        return null;
    }

    @Override
    public String setManagedElementTime(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node,"acc-devm:set-managed-element-time",input);
    }

    @Override
    public String getManagedElementTime(String node) {
        return odlNetconfChannelUtils.postRequest(node,"acc-devm:get-managed-element-time");
    }

    @Override
    public String modifyUserPassword(String node, JSONObject input) {
        return odlNetconfChannelUtils.postRequest(node,"acc-devm:modify-user-password",input);
    }

    @Override
    public String getDHCP(String node, JSONObject input) {
        return null;
    }

    @Override
    public String setDHCP(String node, JSONObject input) {
        return null;
    }

    @Override
    public String deleteDHCP(String node, JSONObject input) {
        return null;
    }

    @Override
    public JSONObject getStatistics(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,"ietf-netconf-monitoring:netconf-state/statistics");
    }

    @Override
    public JSONObject getSessions(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,"ietf-netconf-monitoring:netconf-state/sessions");
    }

    @Override
    public JSONObject getSchemas(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,"ietf-netconf-monitoring:netconf-state/schemas");
    }
}
