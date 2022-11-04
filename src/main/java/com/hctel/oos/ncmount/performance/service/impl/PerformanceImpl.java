package com.hctel.oos.ncmount.performance.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.performance.service.PerformanceService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 9:28
 * @Version 0.1.0
 */
@Service
public class PerformanceImpl implements PerformanceService {

    private static final String PERFORMANCE = "acc-performance:performances";

    private static final String PERFORMANCE_HISTORY = "acc-performance:get-history-performance-monitoring-data";

    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getPerformances(String node) {
        return odlNetconfChannelUtils.getRequest(ODLNetconfChannelUtils.operational,node,PERFORMANCE);
    }

    @Override
    public JSONObject getPerformance(String node, JSONObject performance) {
        JSONObject performances = new JSONObject();
        performances.put("performances",performance);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node, performances));
    }

    @Override
    public JSONObject getHistoryPerformanceMonitoringData(String node, JSONObject inputJson) {
        String response = odlNetconfChannelUtils.postRequest(node, PERFORMANCE_HISTORY, inputJson);
        return JSONObject.parseObject(response);
    }
}
