package com.hctel.oos.ncmount.performance.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.entity.TcaParameter;
import com.hctel.oos.ncmount.performance.service.TcasService;
import com.hctel.oos.netconf.utils.ODLNetconfChannelUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.hctel.oos.netconf.utils.ODLNetconfChannelUtils.operational;

/**
 * Description
 *
 * @Author wcloong
 * @Date 2022/10/31 16:18
 * @Version 0.1.0
 */
@Service
public class TcasImpl implements TcasService {
    @Resource
    private ODLNetconfChannelUtils odlNetconfChannelUtils;

    @Override
    public JSONObject getTcaParameter(String node) {
        String module = "acc-alarms:tca-parameters";
        return odlNetconfChannelUtils.getRequest(operational, node, module);
    }

    @Override
    public JSONObject getTcaParameter(String node, JSONObject tcaParameter) {
        JSONObject tcaParameters = new JSONObject();
        tcaParameters.put("tca-parameters",tcaParameter);
        return JSONObject.parseObject(odlNetconfChannelUtils.generalGetRequest(node,tcaParameters));
    }

    @Override
    public JSONObject getTcaParameter(String node, TcaParameter tcaParameter) {
        String module = "acc-alarms:tca-parameters/tca-parameter" + tcaParameter.getObjectName()
                + tcaParameter.getPmParameterName() + tcaParameter.getGranularity()
                + tcaParameter.getThresholdType();
        return odlNetconfChannelUtils.getRequest(operational, node, module);
    }

    @Override
    public String configTcaParameter(String node, List<TcaParameter> tcaParameter) {
        String module = "acc-alarms:tca-parameters";
        JSONArray tcaArr = new JSONArray();
        for (TcaParameter parameter : tcaParameter) {
            JSONObject object = (JSONObject) JSON.toJSON(parameter);
            tcaArr.add(parameter);
        }
        JSONObject tca = new JSONObject();
        tca.put("tca-parameter", tcaArr);
        JSONObject tcas = new JSONObject();
        tcas.put("tca-parameters", tca);

        return odlNetconfChannelUtils.putRequest(node, module, tcas).toString();
    }
}
