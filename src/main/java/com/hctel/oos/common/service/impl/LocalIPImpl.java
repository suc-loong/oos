package com.hctel.oos.common.service.impl;

import com.hctel.oos.common.utils.IPUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/12/12 11:17
 * @Version 0.1.0
 */
@Service
public class LocalIPImpl implements LocalIPService{

    @Override
    public List<String> getLocalIPList() {
        return IPUtils.getLocalIPList();
    }
}
