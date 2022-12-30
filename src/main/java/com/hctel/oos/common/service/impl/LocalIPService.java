package com.hctel.oos.common.service.impl;

import java.util.List;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/12/12 11:17
 * @Version 0.1.0
 */
public interface LocalIPService {

    /**
     * 获取本机IP列表
     *
     * @return 本机IP列表
     */
    List<String> getLocalIPList();
}
