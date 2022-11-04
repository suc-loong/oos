package com.hctel.oos.ncmount.devm.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/3 10:50
 * @Version 0.1.0
 */
public interface EqService {

    /**
     * 查询所有是单板信息
     * get
     *
     * @param node 节点名称
     * @return 所有单板信息 列表
     */
    JSONObject getEqs(String node);


    /**
     * 获取指定的板卡信息
     *
     * @param node   网元名称
     * @param eqName 板卡名称
     * @return 板卡信息
     */
    JSONObject getEq(String node, String eqName);

    /**
     * 获取指定的板卡信息
     * post
     *
     * @param node 网元名称
     * @param eq   内容参数
     * @return 板卡信息
     */
    JSONObject getEq(String node, JSONObject eq);

    /**
     * 单板复位
     * rpc
     *
     * @param node  网元名称
     * @param input 输入报文
     *              eq-name 板卡名称
     *              reset-type ：soft-reset、 hard-reset
     * @return 操作状态
     */
    String resetEq(String node, JSONObject input);
}
