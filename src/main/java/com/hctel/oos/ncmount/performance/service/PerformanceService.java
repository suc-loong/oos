package com.hctel.oos.ncmount.performance.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.performance.entity.Performance;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 9:19
 * @Version 0.1.0
 */
public interface PerformanceService {
    /**
     * 查询当前性能
     * get
     *
     * @param node 节点名称
     * @return 性能数据列表（performances）
     */
    JSONObject getPerformances(String node);

    /**
     * 根据限定条件查询性能
     *
     * @param node        网元名称
     * @param performance 性能
     *                    pm-parameter-name
     *                    object-type 对象类型
     *                    object-name 对象名称
     *                    start-time 开始时间
     *                    granularity 周期 15min 24h
     * @return 符合条件的性能列表
     */
    JSONObject getPerformance(String node, JSONObject performance);

    /**
     * 查询历史性能
     * 注意：需要考虑拆分数据包传送大数据量。当前使用该接口进行历史性能数据的查询。
     * 支持查询 CPE-OTN/网元/端口。 支持 24 小时内 15min 性能值。
     * rpc
     *
     * @param node      节点名称
     * @param inputJson 需要查询的性能监控对象标识（objectName）
     *                  周期类型（granularity）：15min、24h
     *                  性能参数(pmParameterName)(可选、可为空) 最多只能指定一个参数，如果为空则返回全部
     *                  起始时间和终止时间
     * @return 性能数据列表（performances）
     */
    JSONObject getHistoryPerformanceMonitoringData(String node, JSONObject inputJson);
}
