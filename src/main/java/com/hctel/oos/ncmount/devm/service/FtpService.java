package com.hctel.oos.ncmount.devm.service;

import com.alibaba.fastjson.JSONObject;

/**
 * Description（ftp端口操作）
 *
 * @Author wcloong
 * @Date 2022/11/2 13:39
 * @Version 0.1.0
 */
public interface FtpService {
    /**
     * 获取网元下的所有ftp信息
     *
     * @param node 网元名称
     * @return ftp信息列表
     */
    JSONObject getFtps(String node);

    /**
     * 获取指定ftp信息
     *
     * @param node 网元名称
     * @param ftp  ftp名称等
     * @return 指定ftp信息
     */
    JSONObject getFtp(String node, JSONObject ftp);

    /**
     * 配置端口信息
     *
     * @param node 网元名称
     * @param ftp  下发配置端口的信息
     * @return 配置结果
     */
    String configFtp(String node, JSONObject ftp);
}
