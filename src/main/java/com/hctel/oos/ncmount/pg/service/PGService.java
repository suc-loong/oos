package com.hctel.oos.ncmount.pg.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 15:07
 * @Version 0.1.0
 */
public interface PGService {

    /**
     * 查询所有保护组信息
     *
     * @param nodeName 节点名称
     * @return 保护组信息列表
     */
    JSONObject getPgs(String nodeName);

    /**
     * 查询指定名称保护组信息
     *
     * @param nodeName 节点名称
     * @param pgId     保护组唯一标识符
     * @return 保护组信息
     */
    JSONObject getPg(String nodeName, String pgId);

    /**
     * 创建保护组
     *
     * @param nodeName 节点名称
     * @param data     下发保护组信息报文
     * @return 操作状态（成功/失败）
     */
    String createPg(String nodeName, JSONObject data);


    /**
     * 删除网元上保护组信息
     *
     * @param nodeName 节点名称
     * @param pgId     保护组唯一标识符
     * @return 操作状态（成功/失败）
     */
    String deletePg(String nodeName, String pgId);

    /**
     * 保护组倒换操作
     * 不支持 SF_SWITCH、SD_SWITCH
     *
     * @param nodeName 节点名称
     * @param input 保护组输入参数配置报文
     * @return 操作状态（成功/失败）
     */
    String performProtectionCommand(String nodeName, JSONObject input);


    /**
     * SD 触发保护倒换设置
     *
     * @param nodeName  节点名称
     * @param input SD 触发倒换使能或者禁止
     * @return 操作状态（成功/失败）
     */
    String switchSdTriggerEnable(String nodeName, JSONObject input);

    /**
     * 查询 sd 触发保护倒换的设置状态
     *
     * @param nodeName 节点名称
     * @param input     pg-id 保护组唯一标识符(ID)
     * @return Sd 触发倒换设置状态
     */
    String getSwitchSdTriggerStatus(String nodeName, JSONObject input);
}
