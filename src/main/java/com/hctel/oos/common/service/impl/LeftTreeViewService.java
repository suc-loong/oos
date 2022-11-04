package com.hctel.oos.common.service.impl;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/26 15:13
 * @Version 0.1.0
 */
public interface LeftTreeViewService {
    /**
     * 获取左侧树的视图数据
     * @param node 网元名称
     * @return 网元数据
     */
    String getLeftTreeView(String node);
}
