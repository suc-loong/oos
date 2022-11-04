package com.hctel.oos.ncmount.devm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.devm.service.FtpService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.operational;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/11/2 13:43
 * @Version 0.1.0
 */
@Service
public class FtpServiceImpl implements FtpService {
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getFtps(String node) {
        JSONObject obj = odlNetconfChannelUtils.getRequest(operational, node, "acc-devm:ftps");
        if (obj.containsKey("ftps"))
            return obj.getJSONObject("ftps");
        return obj;
    }

    @Override
    public JSONObject getFtp(String node, JSONObject ftp) {
        JSONObject ftps = new JSONObject();
        ftps.put("ftps",ftp);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node, ftp));
    }

    @Override
    public String configFtp(String node, JSONObject ftp) {
        JSONObject ftps = new JSONObject();
        ftps.put("ftps",ftp);
        return odlNetconfChannelUtils.generalEditConfigRequest(node, ftp);
    }
}
