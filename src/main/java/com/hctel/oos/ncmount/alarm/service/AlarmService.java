package com.hctel.oos.ncmount.alarm.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 14:34
 * @Version 0.1.0
 */
public interface AlarmService {

    /**
     * 获取所有的告警信息
     *
     * @param node 网元名称
     * @return 所有告警信息列表
     */
    JSONObject getAlarms(String node);

    /**
     * 获取指定时间段的历史告警
     *
     * @param node  网元名称
     * @param input start-time,end-time
     * @return 历史告警列表
     */
    JSONObject getHistoryAlarms(String node, JSONObject input);

    /**
     * 获取所有的告警屏蔽信息
     *
     * @param node 网元名称
     * @return 所有的告警屏蔽信息列表
     */
    JSONObject getAlarmMaskStates(String node);

    /**
     * 配置告警屏蔽信息
     *
     * @param node
     * @param alarmMaskState
     * @return
     */
    String configAlarmMaskState(String node, JSONObject alarmMaskState);

}
