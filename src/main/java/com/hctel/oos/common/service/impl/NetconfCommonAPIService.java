package com.hctel.oos.common.service.impl;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 * netconf通用接口（get、get-config、edit-config、copy-config）
 *
 * @Author wcloong
 * @Date 2022/12/30 16:17
 * @Version 0.1.0
 */
public interface NetconfCommonAPIService {
    /**
     * 通用获取操作接口
     *
     * @param node  网元名称
     * @param input 输入参数
     * @return 获取内容信息
     */
    JSONObject generalGetRequest(String node, JSONObject input);

    /**
     * 通用获取可配置内容接口
     *
     * @param node  网元名称
     * @param input 输入参数
     * @return 获取内容信息
     */
    JSONObject generalGetConfigRequest(String node, JSONObject input);

    /**
     * 通用配置数据接口
     *
     * @param node  网元名称
     * @param input 输入参数
     * @return 操作结果
     */
    JSONObject generalEditConfigRequest(String node, JSONObject input);

    /**
     * 通用复制配置操作接口
     *
     * @param node  网元名称
     * @param input 输入参数
     * @return 操作结果
     */
    JSONObject generalCopyConfigRequest(String node, JSONObject input);


}
