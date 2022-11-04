package com.hctel.oos.ncmount.performance.service;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.entity.TcaParameter;

import java.util.List;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/31 16:17
 * @Version 0.1.0
 */
public interface TcasService {


    /**
     * 获取全部性能阈值
     *
     * @param node 网元名称
     * @return 性能越限阈值列表
     */
    JSONObject getTcaParameter(String node);

    /**
     * 查询性能越限阈值
     * get
     *
     * @param node     节点名称
     * @param tcaParameter 需要查询的性能监控对象标识（objectName）
     *                     周期类型（granularity）
     *                     15min、24h 性能参数名称(pmParameterName)
     * @return 性能越限告警参数（tca-parameter）
     */
    JSONObject getTcaParameter(String node, JSONObject tcaParameter);

    /**
     * 查询性能越限阈值
     * get
     *
     * @param node     节点名称
     * @param tcaParameter 需要查询的性能监控对象标识（objectName）
     *                     周期类型（granularity）
     *                     15min、24h 性能参数名称(pmParameterName)
     * @return 性能越限告警参数（tca-parameter）
     */
    JSONObject getTcaParameter(String node, TcaParameter tcaParameter);
    /**
     * 设置性能越限阈值
     * edit-config
     *
     * @param node     节点名称
     * @param tcaParameter 性能越限告警参数（tcaParameter）对象列表
     * @return 操作状态（成功/失败）
     */
    String configTcaParameter(String node, List<TcaParameter> tcaParameter);


}
