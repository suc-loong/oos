package com.hctel.oos.ncmount.devm.service;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.entity.*;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/24 11:17
 * @Version 0.1.0
 */
public interface MeService {

    /**
     * 获取网元设备的详细信息
     * get
     *
     * @param node 节点名称
     * @return 设备信息
     */
    JSONObject getMe(String node);

    /**
     * 获取Ntp服务信息
     * get
     *
     * @param node 节点名称
     * @return 所有ntp服务列表信息
     */
    JSONObject getNtpServers(String node);

    /**
     * 配置Ntp服务
     * 注意：
     * 对于不支持NTP的网元，若适配层下发的是NTP server地址，
     * 返回异常 operation-not-supported，在reason中描述详细原因 Not support NTP
     *
     * @param node       节点名称
     * @param jsonObject 配置报文
     * @return 操作状态（成功/失败代码）
     */
    String configNtpServers(String node, JSONObject jsonObject);

    /**
     * 非 NTP 时间设置
     * 将网元时间与接入型 OTN 时间进行同步 (要求网元具备 NTP 功能或与接入型 OTN 自动同 步功能)
     * 对于老网元直接设置网元时间(newTime)
     * rpc
     *
     * @param node  节点名称
     * @param input 设置报文 new-time
     * @return 操作状态（成功/失败）
     */
    String setManagedElementTime(String node, JSONObject input);

    /**
     * 查询网元当前时间
     * 当配置了 NTP 使能后，网元的当前时间由 NTP 时间提供
     * rpc
     *
     * @param node 节点名称
     * @return 网元时间报文
     */
    String getManagedElementTime(String node);

    /**
     * 修改网元密码
     * rpc
     *
     * @param node  网元名称
     * @param input 输入报文
     *              old-password 旧密码
     *              new-password 新密码
     * @return 操作状态
     */
    String modifyUserPassword(String node, JSONObject input);

    /**
     * 获取中继服务器信息
     * @param node
     * @param input
     * @return
     */
    String getDHCP(String node, JSONObject input);
    /**
     * 获取中继服务器信息
     * @param node 网元名称
     * @param input 下发信息
     * {
     *     "relay-serverip": "127.0.0.1",
     *     "relay-server-enable": true
     * }
     * @return
     */
    String setDHCP(String node, JSONObject input);
    /**
     * 获取中继服务器信息
     * @param node 网元名称
     * @param input 下发信息
     * {
     *     "relay-serverip": "127.0.0.1"
     *  }
     * @return
     */
    String deleteDHCP(String node, JSONObject input);

    //////////////////////////////////////////////////////////////////////////

    /**
     * 节点统计信息
     * get
     *
     * @param node 节点名称
     * @return 统计信息
     */
    JSONObject getStatistics(String node);

    /**
     * 节点会话信息
     * get
     *
     * @param node 节点名称
     * @return （会话的主机IP、登录用户、登录时间、传输方式、rpc的统计）
     */
    JSONObject getSessions(String node);

    /**
     * 节点下加载的Yang模块信息
     * get
     *
     * @param node 节点名称
     * @return YANG Schemas 列表
     */
    JSONObject getSchemas(String node);
    //////////////////////////////////////////////////////////////////////////
}
