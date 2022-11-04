package com.hctel.oos.netconf.controller;

import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.ncmount.alarm.entity.AlarmMaskState;
import com.hctel.oos.ncmount.entity.*;
import com.hctel.oos.ncmount.performance.entity.Performance;
import com.hctel.oos.ncmount.pg.entity.PG;
import com.hctel.oos.ncmount.pg.entity.PGSwitch;
import com.hctel.oos.ncmount.topology.entity.NodeInfo;
import com.hctel.oos.netconf.service.NetconfService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 所有设备开始的起点，实现连接odl服务器
 * 创建网元设备、修改配置内容
 */
@CrossOrigin
@RestController
public class NetconfController {
    /**
     * 服务对象
     */
    @Resource
    private NetconfService netconfService;

    /////////////////////////////测试用例//////////////////////////////////////
    @RequestMapping("/test/rpc")
    public String testRpc(@RequestBody String json) {
        return netconfService.testRpcs(json);
    }

    @RequestMapping("/test/create/node")
    public String testRpc1(@RequestBody String json) {
        return netconfService.testRpcs1(json);
    }
    //////////////////////////////////////////////////////////////////////////

    @RequestMapping("/node/{node}/notification")
    public String configNotification(@PathVariable String node,String setContext){
        System.out.println("订阅报文设置："+PrettyJSON.pretty(setContext));
        return netconfService.configNotification(node,setContext);
    }

    /////////////////////////////节点模块//////////////////////////////////////

    /**
     * 获取拓扑的所有节点详细信息
     * 主要是连接状态的获取
     * 该字段应该对应前端设备的连接状态实时刷新，并设置到每一个设备上
     *
     * @return 所有拓扑节点信息
     */
    @RequestMapping("/list/nodes")
    public String getNodeList() {
        return netconfService.getNodeList();
    }

    @RequestMapping("/node/{node}")
    public String getNode(@PathVariable String node) {
        return netconfService.getNode(node);
    }

    /**
     * 设置节点信息，创建设备节点
     * 节点是必须字段
     *
     * @param node
     * @return 操作状态
     */
    @RequestMapping(value = "/create/node",method = RequestMethod.PUT)
    public Integer createNode(@RequestBody NodeInfo node) {
        return netconfService.createNode(node);
    }

    /**
     * 获取已存在的节点信息便于修改使用
     *
     * @param node 节点名称
     * @return
     */
    @GetMapping("/config/node/{node}")
    public NodeInfo getConfigNode(@PathVariable String node) {
        return netconfService.getConfigNode(node);
    }

    /**
     * 删除节点
     *
     * @param node 节点名称
     * @return 操作状态
     */
    @DeleteMapping("/node/{node}")
    public Integer deleteNode(@PathVariable String node) {
        return netconfService.deleteNode(node);
    }

    /**
     * 节点统计信息
     *
     * @param nodeName
     * @return
     */
    @RequestMapping("/node/statistics")
    public String getNodeStatistics(@RequestBody String nodeName) {
        return netconfService.getNodeStatistics(nodeName);
    }

    /**
     * 获取会话信息
     *
     * @param nodeName
     * @return （会话的主机IP、登录用户、登录时间、传输方式、rpc的统计）
     */
    @RequestMapping("/node/{node}/session")
    public String getNodeSession(@PathVariable(name = "node") String nodeName) {
        return netconfService.getNodeSession(nodeName);
    }

    @RequestMapping("/node/{node}/schemas")
    public String getSchemas(@PathVariable String node) {
        return netconfService.getSchemas(node);
    }

    //////////////////////////////////////////////////////////////////////////


    /////////////////////////////网元设备模块///////////////////////////////////

//    /**
//     * 获取网元设备的详细信息
//     * 对应设备的悬浮属性，并且可以进行修改
//     *
//     * @param node 节点名称
//     * @return 设备信息
//     */
//    @GetMapping("/node/{node}/me")
//    public String getNodeMe(@PathVariable String node) {
//        return netconfService.getNodeMe(node);
//    }
//
//    @GetMapping("/node/{node}/eqs")
//    public String getEqs(@PathVariable String node) {
//        return netconfService.getEqs(node);
//    }
//
//    /**
//     * Ntp服务
//     *
//     * @return
//     */
//    @GetMapping("/node/{node}/ntp")
//    public String getNtps(@PathVariable String node) {
//        return netconfService.getNtpServers(node);
//    }
//
//    @RequestMapping("/node/odu")
//    public String configOduPtpPac(@RequestBody OduPtpPac oduPtpPac) {
////        String ptpName = "PTP=/shelf=1/slot=1/subslot=1/port=9";
//        String ptpName = "PTP=%2Fshelf=1%2Fslot=1%2Fsubslot=1%2Fport=9";
//        String nodeName = "otna3";
//        System.out.println(oduPtpPac);
//        return netconfService.configOduPtpPac(nodeName, ptpName, oduPtpPac);
//    }
//
//    @RequestMapping("/node{node}/sdh/ptp/{ptp}")
//    public String configSdhPtpPac(@PathVariable String node, @PathVariable String ptp, SdhPtpPac sdhPtpPac) {
//        return netconfService.setSdhTerminationPointData(node, ptp, sdhPtpPac);
//    }
//
//    @RequestMapping("/node/{node}/eth/ptp/{ptp}")
//    public String configEthPtpPac(@PathVariable String node, @PathVariable String ptp, EthPtpPac ethPtpPac) {
//        return netconfService.configEthPtpPac(node, ptp, ethPtpPac);
//    }
//
//    @RequestMapping("/node/{node}/ethoam/ctp/{ctp}")
//    public String configEthOamPac(@PathVariable String node, @PathVariable String ctp, EthOamPac ethOamPac) {
//        return netconfService.configEthOamPac(node, ctp, ethOamPac);
//    }
//
//    @RequestMapping("/node/{node}/ethoamstate/ctp/{ctp}")
//    public String configEthOamStatePac(@PathVariable String node, @PathVariable String ctp, EthOamStatePac ethOamStatePac) {
//        return netconfService.configEthOamStatePac(node, ctp, ethOamStatePac);
//    }
//
//    @RequestMapping("node/{node}/ntpservers")
//    public String configNtps(@PathVariable String node, @RequestBody String json) {
//        System.out.println(PrettyJSON.pretty(json));
//        return netconfService.configNtpServers(node, JSON.parseObject(json));
//    }
//
//    @RequestMapping("node/{node}/newtime")
//    public String setManagedElementTime(@PathVariable String node, String newTime) {
//        return netconfService.setManagedElementTime(node, newTime);
//    }
//
//    @GetMapping("node/{node}/time")
//    public String getManagedElementTime(@PathVariable String node) {
//        return netconfService.getManagedElementTime(node);
//    }
//
//    /**
//     * 获取端口信息
//     *
//     * @param node 节点名称
//     * @return （会话的主机IP、登录用户、登录时间、传输方式、rpc的统计）
//     */
//    @GetMapping("/node/{node}/ptps")
//    public String getPtps(@PathVariable String node) {
//        return netconfService.getPtps(node);
//    }
//
//    @GetMapping("/node/{node}/ptps/{ptp}")
//    public String getPtp(@PathVariable String node, @PathVariable String ptp) {
//        return netconfService.getPtp(node, ptp);
//    }
//
//    @GetMapping("/node/{node}/ftps")
//    public String getFtps(@PathVariable String node) {
//        return netconfService.getFtps(node);
//    }
//
//    @GetMapping("/node/{node}/ftps/{ftp}")
//    public String getFtp(@PathVariable String node, @PathVariable String ftp) {
//        return netconfService.getFtp(node, ftp);
//    }
//
//    @GetMapping("/node/{node}/ctps")
//    public String getCtps(@PathVariable String node) {
//        return netconfService.getCtps(node);
//    }
//
//
//    @GetMapping("/node/{node}/ctps/{ctp}")
//    public String getCtp(@PathVariable String node, @PathVariable String ctp) {
//        return netconfService.getCtp(node, ctp);
//    }
//
//    @RequestMapping("/node/{node}/ftps/{ftp}/vcg")
//    public String configVcgPac(@PathVariable String node, @PathVariable String ftp, VcgPac vcgPac) {
//        return netconfService.configVcgPac(node, ftp, vcgPac);
//    }
    //////////////////////////////////////////////////////////////////////////


    //////////////////////////////////////////////////////////////////////////

    ////////////////////////////////告警模块///////////////////////////////////
    @GetMapping("/node/{node}/alarms&tcas")
    public String getAlarmTcas(@PathVariable String node){
        return netconfService.getAlarmTcas(node);
    }

    @RequestMapping("/node/{node}/history/alarms")
    public String getHistoryAlarms(@PathVariable String node, String inputTime){
        return netconfService.getHistoryAlarms(node,inputTime);
    }

    @RequestMapping("/node/{node}/alarm/mask")
    public String configAlarmMaskState(@PathVariable String node, AlarmMaskState alarmMaskState){
        return netconfService.configAlarmMaskState(node,alarmMaskState);
    }

    @GetMapping("/node/{node}/alarm/mask")
    public String getAlarmMaskState(@PathVariable String node, AlarmMaskState alarmMaskState){
        return netconfService.getAlarmMaskState(node,alarmMaskState);
    }

    //////////////////////////////////////////////////////////////////////////

    ////////////////////////////////性能模块///////////////////////////////////
    @RequestMapping("/node/{node}/tca/parameter")
    public String configTcaParameter(@PathVariable String node, List<TcaParameter> tcaParameters){
        return netconfService.configTcaParameter(node,tcaParameters);
    }

    @GetMapping("/node/{node}/tca/parameter")
    public String getTcaParameter(@PathVariable String node, TcaParameter tcaParameter){
        return netconfService.getTcaParameter(node,tcaParameter);
    }

    @GetMapping("/node/{node}/performance")
    public String getPerformances(@PathVariable String node, Performance performance){
        return netconfService.getPerformances(node,performance);
    }

    @RequestMapping("/node/{node}/history/performance")
    public String getHistoryPerformanceMonitoringData(String node, String inputJson){
        return netconfService.getHistoryPerformanceMonitoringData(node,inputJson);
    }
    //////////////////////////////////////////////////////////////////////////

    ///////////////////////////////故障诊断////////////////////////////////////
    @PostMapping("/node/{node}/eqs/reset")
    public String configEqsReset(@PathVariable String node, @RequestBody Eq eq){
        System.out.println("收到json字符串信息： \n"+eq);
        return netconfService.configEqsReset(node,eq);
    }

    @RequestMapping("/node/{node}/ptps/{ptp}/laser")
    public String configPtpLaser(@PathVariable String node, @PathVariable String ptp, String laserStatus){
        return netconfService.configPtpLaser(node,ptp,laserStatus);
    }

    @GetMapping("/node/{node}/ptps/{ptp}/laser")
    public String getPtpLaser(@PathVariable String node,@PathVariable String ptp){
        return netconfService.getPtpLaser(node,ptp);
    }
    //////////////////////////////////////////////////////////////////////////

    ///////////////////////////////保护组管理///////////////////////////////////
    @GetMapping("/node/{node}/pgs")
    public String getPgs(@PathVariable String node) {
        return netconfService.getPgs(node);
    }

    @GetMapping("/node/{node}/pgs/{pg}")
    public String getPg(@PathVariable String node, @PathVariable String pg) {
        return netconfService.getPg(node, pg);
    }

    @RequestMapping("/node/{node}/pgs")
    public String createPgs(@PathVariable String node, PG pg) {
        return netconfService.createPgs(node, pg);
    }

    @DeleteMapping("/node/{node}/pgs/{pg}")
    public String deletePg(@PathVariable String node, @PathVariable String pg) {
        return netconfService.deletePg(node, pg);
    }

    @RequestMapping("/node/{node}/pgs/ppc")
    public String performProtectionCommand(@PathVariable String node, PGSwitch pgSwitch) {
        return netconfService.performProtectionCommand(node, pgSwitch);
    }

    @RequestMapping("/node/{node}/pgs/{pg}/ste")
    public String switchSdTriggerEnable(@PathVariable String node, @PathVariable String pg, boolean SdTrigger) {
        return netconfService.switchSdTriggerEnable(node, pg, SdTrigger);
    }

    @GetMapping("/node/{node}/pgs/{pg}/ssts")
    public String getSwitchSdTriggerStatus(@PathVariable String node, @PathVariable String pg) {
        return netconfService.getSwitchSdTriggerStatus(node, pg);
    }
    //////////////////////////////////////////////////////////////////////////

    ///////////////////////////业务发放管理接口//////////////////////////////////

    @GetMapping("/node/{node}/connections")
    public String getConnections(@PathVariable String node){
        return netconfService.getConnections(node);
    }

    @RequestMapping("/node/{node}/create_connection/eth")
    public String createEthConnection(@PathVariable String node, @RequestBody Json2Odl json) {
        System.out.println("111: "+json.getContext());
        return netconfService.createEthConnection(node, json.getContext());
    }

    @RequestMapping("/node/{node}/create_connection/sdh")
    public String createSdhConnection(@PathVariable String node, @RequestBody Json2Odl json) {
        System.out.println("222: "+json.getContext());
        return netconfService.createEthConnection(node,json.getContext());
    }

    @RequestMapping("/node/{node}/create_connection/odu")
    public String createOduConnection(@PathVariable String node, @RequestBody Json2Odl json) {
        System.out.println("333: "+json.getContext());
        return netconfService.createEthConnection(node,json.getContext());
    }
    @RequestMapping("/node/{node}/create_connection/eos")
    public String createEosConnection(@PathVariable String node, @RequestBody Json2Odl json) {
        System.out.println("444: "+json.getContext());
        return netconfService.createEosConnection(node, json.getContext());
    }
    //////////////////////////////////////////////////////////////////////////
}
