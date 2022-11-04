package com.hctel.oos.ncmount.alarm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.alarm.service.AlarmService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 14:34
 * @Version 0.1.0
 */
@Service
public class AlarmServiceImpl implements AlarmService {

    private static final String ALARM = "acc-alarms:alarms";
    private static final String ALARM_HISTORY = "acc-alarms:get-history-alarms";
    private static final String ALARM_MASK = "acc-alarms:alarm-mask-states";

    @Resource 
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getAlarms(String node) {
        return odlNetconfChannelUtils.getRequest(node,ALARM);
    }

    @Override
    public JSONObject getHistoryAlarms(String node, JSONObject startEndTime) {
        String response = odlNetconfChannelUtils.postRequest(node, ALARM_HISTORY, startEndTime);
        return JSONObject.parseObject(response);
    }

    @Override
    public JSONObject getAlarmMaskStates(String node) {
        return odlNetconfChannelUtils.getRequest(node,ALARM_MASK);
    }

    @Override
    public String configAlarmMaskState(String node, JSONObject alarmMaskState) {
        JSONObject alarmMasks = new JSONObject();
        alarmMasks.put("alarm-mask-states",alarmMaskState);
        return odlNetconfChannelUtils.generalEditConfigRequest(node, alarmMasks);
    }
}
