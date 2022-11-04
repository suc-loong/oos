package com.hctel.oos.netconf.utils;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.IPUtils;
import com.hctel.oos.common.utils.PrettyJSON;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.io.IOException;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

/**
 * 建立与odl通信的关键服务对象
 * get、delete、put、post的方法实现
 */
@Service
public class ODLNetconfChannelUtils {
    /**
     * 说明：
     * 为了统一配置，将url字段分解声明，后期不重复使用的url字段可以删除直接字符串写死
     */
    //http头 + 服务器主机ip + 端口号 + restconf + 操作 + 拓扑 + 节点 + （挂载点 + 模块）
    private static final String HTTP_HEAD = "http://";
    private static final String PORT = ":8181/";
    private static final String RESTCONF = "restconf/";

    public static final String operational = "operational";
    public static final String config = "config";
    //RPC操作
    public static final String operations = "operations";

    private static final String TOPOLOGY = "/network-topology:network-topology/topology/topology-netconf";
    private static final String PRE_NODE = "/node/";
    private static final String EXT_PRE = "/yang-ext:mount/";

    public static final String devm = "acc-devm:";
    public static final String alarm = "acc-alarms:";
    public static final String connection = "acc-connection:";
    public static final String eos = "acc-eos:";
    public static final String eth = "acc-eth:";
    public static final String otn = "acc-otn:";
    public static final String sdh = "acc-sdh:";


    public static final String ME = "acc-devm:me";
    public static final String PTPS = "acc-devm:ptps";
    public static final String CTPS = "acc-devm:ctps";
    public static final String FTPS = "acc-devm:ftps";
    public static final String EQS = "acc-devm:eqs";
    public static final String ALARM_MASK = "acc-alarms:alarm-mask-states";
    public static final String NETCONF_STATISTICS = "ietf-netconf-monitoring:netconf-state/statistics";

    /**
     * 构造url指向odl
     *
     * @param operate 操作方式
     * @param node    节点名称
     * @return odl-url
     */
    public String getUrl(String operate, String node) {
/*        StringBuffer url = new StringBuffer();
        String ip = null;
        try {
            ip = IPUtils.getLocalHostLANAddress().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        url.append(HTTP_HEAD).append(ip).append(PORT).append(operate);
        if (!(node == null)) {
            //http头 + 服务器主机ip + 端口号 + restconf + 操作 + 拓扑 + 节点 + （挂载点 + 模块）
            url.append(TOPOLOGY).append(PRE_NODE).append(node);
        } else {
            url.append(TOPOLOGY);
        }
        return url.toString();*/
        return getUrl(operate, node, null);
    }

    /**
     * 构造url指向odl
     *
     * @param operate 操作方式
     * @param node    节点名称
     * @param module  模块
     * @return odl-url
     */
    public String getUrl(String operate, String node, String module) {
        StringBuilder url = new StringBuilder();
        String ip = null;
        try {
            ip = IPUtils.getLocalHostLANAddress().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        url.append(HTTP_HEAD).append(ip).append(PORT).append(RESTCONF).append(operate);
        //http头 + 服务器主机ip + 端口号 + restconf + 操作 + 拓扑 + 节点 + （挂载点 + 模块）
        if ((node != null) && (module == null)) {
            //当前情况：在节点下操作，并未进入挂载点下的模块
            url.append(TOPOLOGY).append(PRE_NODE).append(node);
            System.out.println("【url】：" + url.toString());
        } else if ((node == null) && (module != null)) {
            //当前情况：在不进入挂载点的模块中操作
            url.append("/").append(module);
            System.out.println("【url】：" + url.toString());
        } else if ((node != null) && (module != null)) {
            //当前情况：进入到该节点下的挂载点的模块下进行操作
            url.append(TOPOLOGY).append(PRE_NODE).append(node).append(EXT_PRE).append(module);
            System.out.println("【url】：" + url.toString());
        } else {
            //当前情况：不指定节点，在拓扑下进行全量获取
            url.append(TOPOLOGY);
            System.out.println("【url】：" + url.toString());
        }
        return url.toString();
    }

    /**
     * 对ODL段的url
     *
     * @param node    网元可空，为空时模块必然为空，此时取的是拓扑层级的信息
     * @param module  模块可空，模块为空
     * @param content 可空，为空时取全部信息，即content=all
     * @return
     */
    public String getMixUrl(String node, String module, String content) {
        // http://192.168.10.58:8181/rests/data/network-topology:network-topology/topology=topology-netconf?content=all
        StringBuilder url = new StringBuilder();
        String ip = null;
        try {
            ip = IPUtils.getLocalHostLANAddress().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        String tmp_topology = "rests/data/network-topology:network-topology/topology=topology-netconf";
        String tmp_node = "/node=";
        String tmp_content = "?content=";
        url.append(HTTP_HEAD).append(ip).append(PORT).append(tmp_topology);
        if (node != null) url.append(tmp_node).append(node);
        if (module != null) url.append(EXT_PRE).append(module);
        if (content != null) url.append(tmp_content).append(content);
        System.out.println("【url】：" + url.toString());
        return url.toString();
    }

    //由于单独传节点名称，会造成添加路径问题，后面会多一个=或+  减去最后一个字符
    public String handleNodeName(String nodeName) {
        if (nodeName != null) {
            return nodeName.substring(0, nodeName.length() - 1);
        }
        return null;
    }

    // Send HTTP request to ODL
    // Establish HTTP request
    CloseableHttpClient httpClient = HttpClients.createDefault();

    /**
     * 发送get请求到odl
     * 可以获取指定节点信息、模块信息，拓扑下的全部节点信息
     *
     * @param url 下发路径
     * @return 返回获取的内容接送报文
     */
    private JSONObject sendGetRequestToOdl(String url) {
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json");

        // username:password--->访问的用户名，密码,并使用base64进行加密，将加密的字节信息转化为string类型，encoding--->token
        String encoding = null;
        encoding = DatatypeConverter.printBase64Binary("admin:admin".getBytes(StandardCharsets.UTF_8));

        httpGet.setHeader("Authorization", "Basic " + encoding);
        CloseableHttpResponse response = null;
        String result = null;
        try {
            response = httpClient.execute(httpGet);
            HttpEntity entity = response.getEntity();
            System.out.println("【Get - Status】：" + response.getStatusLine().getStatusCode());
            result = EntityUtils.toString(entity);
            System.out.println("【result】：\n" + PrettyJSON.pretty(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return JSONObject.parseObject(result);

    }

    //Send get HTTP request to ODL

    /**
     * 发送get请求到odl
     *
     * @param operate 操作类型
     * @param node    节点名称
     * @param module  模块名称
     * @return 返回json报文
     */
    public JSONObject getRequest(String operate, String node, String module) {
        return sendGetRequestToOdl(getUrl(operate, node, module));
    }

    /**
     * 发送get请求到odl
     *
     * @param operate 操作类型
     * @param node    节点名称
     * @return 返回json报文
     */
    public JSONObject getRequest(String operate, String node) {
        return sendGetRequestToOdl(getUrl(operate, node));
    }

    /**
     * 发送get请求到odl
     *
     * @param operate 操作类型
     * @return 返回json报文
     */
    public JSONObject getRequest(String operate) {
        return getRequest(operate, null);
    }

    public JSONObject getAllRequest(String node, String module, String content) {
        return sendGetRequestToOdl(getMixUrl(node, module, content));
    }

    /**
     * 获取网元层级
     *
     * @param node    网元名称
     * @param content all或config或null
     * @return 网元层的信息
     */
    public JSONObject getAllRequest(String node, String content) {
        return getAllRequest(node, null, content);
    }

    /**
     * 获取拓扑层级信息
     *
     * @param content all或者config或null
     * @return 拓扑层级信息
     */
    public JSONObject getAllRequest(String content) {
        return getAllRequest(null, content);
    }

    /**
     * 获取全量拓扑层级信息
     *
     * @return 全部拓扑信息
     */
    public JSONObject getAllRequest() {
        return getAllRequest(null, null);
    }


    //Pre information of deletion in HTTP request
    //Send delete HTTP request to ODL

    /**
     * 发送delete请求到odl
     * 注意：此请求应只在config中
     *
     * @param url 下发路径
     * @return http响应状态码
     */
    private Integer sendDeleteRequestToODL(String url) {
        HttpDelete httpDelete = new HttpDelete(url);
        httpDelete.setHeader("Content-Type", "application/json");
        // username:password--->访问的用户名，密码,并使用base64进行加密，将加密的字节信息转化为string类型，encoding--->token
        String encoding = null;
        encoding = DatatypeConverter.printBase64Binary("admin:admin".getBytes(StandardCharsets.UTF_8));

        httpDelete.setHeader("Authorization", "Basic " + encoding);

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpDelete);
            System.out.println("【Delete - Status】：" + response.getStatusLine().getStatusCode());

        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.getStatusLine().getStatusCode();
    }


    /**
     * 发送delete请求到odl
     *
     * @param node   节点名称
     * @param module 模块名称
     * @return http响应状态码
     */
    public Integer deleteRequest(String node, String module) {
        return sendDeleteRequestToODL(getUrl(config, node, module));
    }

    /**
     * 发送delete请求到odl
     *
     * @param node 节点名称
     * @return http响应状态码
     */
    public Integer deleteRequest(String node) {
        return sendDeleteRequestToODL(getUrl(config, node));
    }

    /**
     * 发送put请求到odl
     * 注意：此请求应只在config中
     *
     * @param url        下发路径
     * @param jsonObject 下发报文
     * @return http响应状态码
     */
    private Integer sendPutRequestToODL(String url, Object jsonObject) {
        HttpPut httpPut = new HttpPut(url);
        httpPut.setHeader("Content-Type", "application/json");
        String encoding = null;
        encoding = DatatypeConverter.printBase64Binary("admin:admin".getBytes(StandardCharsets.UTF_8));
        httpPut.setHeader("Authorization", "Basic " + encoding);
        StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");
//        entity.setContentType("application/json");

        httpPut.setEntity(entity);
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPut);
            System.out.println("【Put - Status】：" + response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert response != null;
        return response.getStatusLine().getStatusCode();

    }

    /**
     * 发送put请求到odl
     *
     * @param node       节点名称
     * @param module     模块名称
     * @param jsonObject 下发报文
     * @return http响应状态码
     */
    public Integer putRequest(String node, String module, Object jsonObject) {
        return sendPutRequestToODL(getUrl(config, node, module), jsonObject);
    }

    /**
     * 发送put请求到odl
     *
     * @param node       节点名称
     * @param jsonObject 下发报文
     * @return http响应状态码
     */
    public Integer putRequest(String node, Object jsonObject) {
        return sendPutRequestToODL(getUrl(config, node), jsonObject);
    }


    /**
     * 发送post请求给odl
     * 注意：此请求应只有rpc，即operations中
     *
     * @param url        下发路径
     * @param jsonObject 下发接送报文
     * @return 返回报文：失败返回http状态，成功返回响应rpc的报文
     */
    private String sendPostRequestToODL(String url, Object jsonObject) {
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Content-Type", "application/json");
        String encoding = null;
        encoding = DatatypeConverter.printBase64Binary("admin:admin".getBytes(StandardCharsets.UTF_8));
        httpPost.setHeader("Authorization", "Basic " + encoding);
        if (jsonObject != null) {
            String pretty = PrettyJSON.pretty(jsonObject.toString());
            System.out.println(pretty);
            StringEntity entity = new StringEntity(jsonObject.toString(), "utf-8");

            httpPost.setEntity(entity);
        }

        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpPost);
            System.out.println("【Post - Status】：" + response.getStatusLine().getStatusCode());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获得响应的实体对象
        assert response != null;
        HttpEntity responseEntity = response.getEntity();
        // 使用Apache提供的工具类进行转换成字符串
        String entityStr = null;
        try {
            entityStr = EntityUtils.toString(responseEntity, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (entityStr != null) {
            System.out.println("【result】：\n" + PrettyJSON.pretty(entityStr));
            return entityStr;
        }
        return String.valueOf(response.getStatusLine().getStatusCode());

    }

    /**
     * 发送post请求给odl
     *
     * @param node       节点名称
     * @param module     模块名称
     * @param jsonObject 下发报文
     * @return 返回报文：失败返回http状态，成功返回响应rpc的报文
     */
    public String postRequest(String node, String module, Object jsonObject) {
        return sendPostRequestToODL(getUrl(operations, node, module), jsonObject);
    }

    /**
     * 发送post请求给odl
     *
     * @param module     模块名称
     * @param jsonObject 下发报文
     * @return 返回报文：失败返回http状态，成功返回响应rpc的报文
     */
    public String postRequest(String module, Object jsonObject) {
        return sendPostRequestToODL(getUrl(operations, module), jsonObject);
    }

    /**
     * 获取信息的rpc请求
     *
     * @param nodeName 节点名称
     * @param module   模块名称
     * @return 返回报文
     */
    public String postRequest(String nodeName, String module) {
        return sendPostRequestToODL(getUrl(operations, nodeName, module), null);
    }

    /**
     * 通用get请求接口
     *
     * @param nodeName 网元名称
     * @param object   查询内容
     * @return 查询结果
     */
    public String generalGetRequest(String nodeName, Object object) {
        JSONObject getObj = new JSONObject();
        JSONObject input = new JSONObject();
        input.put("filter", object);
        input.put("ietf-netconf-with-defaults:with-defaults", "report-all-tagged");
        getObj.put("input", input);
        String res = sendPostRequestToODL(getUrl(operations, nodeName, "ietf-netconf:get"), getObj);
        JSONObject response = JSONObject.parseObject(res);

        if (response.containsKey("output")) {
            if (response.getJSONObject("output").containsKey("data")) {
                if (!response.getJSONObject("output").getJSONObject("data").isEmpty())
                    return response.getJSONObject("output").getJSONObject("data").toJSONString();
                else return null;
            }
        }
        return sendPostRequestToODL(getUrl(operations, nodeName, "ietf-netconf:get"), getObj);
    }

    /**
     * 通用标准edit-config请求接口
     *
     * @param nodeName 网元名称
     * @param object   修改内容
     * @return 修改结果
     */
    public String generalEditConfigRequest(String nodeName, Object object) {
        JSONObject edit = new JSONObject();
        JSONObject input = new JSONObject();
        JSONObject target = new JSONObject();
        JSONObject target_1 = new JSONObject();
        target.put("running", target_1);
        input.put("target", target);
        input.put("config", object);
        edit.put("input", input);
        return sendPostRequestToODL(getUrl(operations, nodeName, "ietf-netconf:get"), edit);
    }

    //================================================================================//
    //                          测试类开始                                              //
    //================================================================================//


    /**
     * 测试使用，为了直接指定url获取返回的json报文
     *
     * @param url 下发路径
     * @return 获取的json报文
     */
    public JSONObject getTest(String url) {
        return sendGetRequestToOdl(url);
    }

    /**
     * put请求下发json
     *
     * @param json 全部json
     * @return http请求状态码
     */
    public Integer putRequest(String json) {
        System.out.println(json);
        return sendPutRequestToODL("hclink", json);
    }

    //================================================================================//
    //                          测试类结束                                              //
    //================================================================================//
}
