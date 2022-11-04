package com.hctel.oos.netconf.service;

import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.ncmount.alarm.entity.AlarmMaskState;
import com.hctel.oos.ncmount.entity.*;
import com.hctel.oos.ncmount.performance.entity.Performance;
import com.hctel.oos.ncmount.pg.entity.PG;
import com.hctel.oos.ncmount.pg.entity.PGSwitch;
import com.hctel.oos.ncmount.topology.entity.NodeInfo;

import java.util.List;

/**
 * 所有南向操作接口
 * author wloong
 * date 2022-4-10
 */
public interface NetconfService {

    /////////////////////////////测试用例//////////////////////////////////////
    String testRpcs1(String strJson);

    String testRpcs(String strJson);
    //////////////////////////////////////////////////////////////////////////

    /**
     * 设置订阅通知
     *
     * @param nodeName   节点名称
     * @param setContext 设置内容
     * @return 操作结果
     */
    String configNotification(String nodeName, Object setContext);
    /////////////////////////////节点模块//////////////////////////////////////

    /**
     * 获取拓扑的所有节点详细信息
     * get
     *
     * @return 所有拓扑节点信息
     */
    String getNodeList();


    /**
     * 获取指定节点详细信息
     * get
     *
     * @return 指定节点信息
     */
    String getNode(String nodeName);

    /**
     * 设置节点信息，创建设备节点
     * put
     *
     * @param node 节点信息实体
     * @return 操作状态
     */
    Integer createNode(NodeInfo node);

    /**
     * 修改节点下的信息
     * put
     *
     * @param nodeName 节点名称
     * @return 节点信息
     */
    NodeInfo getConfigNode(String nodeName);

    /**
     * 删除节点
     * delete
     *
     * @param nodeName 节点名称
     * @return 操作状态
     */
    Integer deleteNode(String nodeName);

    /**
     * 节点统计信息
     * get
     *
     * @param nodeName 节点名称
     * @return 统计信息
     */
    String getNodeStatistics(String nodeName);

    /**
     * 节点会话信息
     * get
     *
     * @param nodeName 节点名称
     * @return （会话的主机IP、登录用户、登录时间、传输方式、rpc的统计）
     */
    String getNodeSession(String nodeName);

    /**
     * 节点下加载的Yang模块信息
     * get
     *
     * @param nodeName 节点名称
     * @return YANG Schemas 列表
     */
    String getSchemas(String nodeName);
    //////////////////////////////////////////////////////////////////////////

    /////////////////////////////网元设备模块///////////////////////////////////
    /////// network element device module

    /**
     * 获取网元设备的详细信息
     * get
     *
     * @param nodeName 节点名称
     * @return 设备信息
     */
    String getNodeMe(String nodeName);

    /**
     * 查询所有是单板信息
     * get
     *
     * @param nodeName 节点名称
     * @return 所有单板信息 列表
     */
    String getNodeEqs(String nodeName);


    /**
     * 获取Ntp服务信息
     * get
     *
     * @param nodeName 节点名称
     * @return 所有ntp服务列表信息
     */
    String getNtpServers(String nodeName);

    /**
     * OTN 网元端口属性修改
     *
     * @param nodeName  节点名称
     * @param ptpName   端口名称
     * @param oduPtpPac 修改配置报文
     * @return 操作状态（成功/失败）
     */
    String configOduPtpPac(String nodeName, String ptpName, OduPtpPac oduPtpPac);

    /**
     * SDH 客户侧端口配置
     *
     * @param nodeName  节点名称
     * @param ptpName   端口名称
     * @param sdhPtpPac 修改配置报文
     * @return 操作状态（成功/失败）
     */
    String setSdhTerminationPointData(String nodeName, String ptpName, SdhPtpPac sdhPtpPac);

    /**
     * ETH 端口属性修改
     *
     * @param nodeName  节点名称
     * @param ptpName   端口名称
     * @param ethPtpPac 修改配置报文
     * @return 操作状态（成功/失败）
     */
    String configEthPtpPac(String nodeName, String ptpName, EthPtpPac ethPtpPac);

    /**
     * ETH 端口 OAM 配置修改
     *
     * @param nodeName  节点名称
     * @param ctpName   连接端口名称
     * @param ethOamPac 配置报文
     * @return 操作状态（成功/失败）
     */
    String configEthOamPac(String nodeName, String ctpName, EthOamPac ethOamPac);


    /**
     * ETH 性能测量使能开关修改
     *
     * @param nodeName       节点名称
     * @param ctpName        连接端口
     * @param ethOamStatePac 以太网OAM状态属性配置报文
     * @return 操作状态（成功/失败）
     */
    String configEthOamStatePac(String nodeName, String ctpName, EthOamStatePac ethOamStatePac);

    /**
     * 配置Ntp服务
     * 注意：
     * 对于不支持NTP的网元，若适配层下发的是NTP server地址，
     * 返回异常 operation-not-supported，在reason中描述详细原因 Not support NTP
     *
     * @param nodeName   节点名称
     * @param jsonObject 配置报文
     * @return 操作状态（成功/失败代码）
     */
    String configNtpServers(String nodeName, JSONObject jsonObject);

    /**
     * 非 NTP 时间设置
     * 将网元时间与接入型 OTN 时间进行同步 (要求网元具备 NTP 功能或与接入型 OTN 自动同 步功能)
     * 对于老网元直接设置网元时间(newTime)
     * rpc
     *
     * @param nodeName 节点名称
     * @param newTime  设置报文
     * @return 操作状态（成功/失败）
     */
    String setManagedElementTime(String nodeName, String newTime);

    /**
     * 查询网元当前时间
     * 当配置了 NTP 使能后，网元的当前时间由 NTP 时间提供
     *
     * @param nodeName 节点名称
     * @return 网元时间报文
     */
    String getManagedElementTime(String nodeName);

    /**
     * 获取端口信息
     * get
     *
     * @param nodeName 节点名称
     * @return ptp物理端口列表报文
     */
    String getPtps(String nodeName);

    /**
     * 查询指定ptp的信息
     * get
     *
     * @param nodeName 节点名称
     * @param ptpName  物理端口
     * @return 指定物理端口信息报文
     */
    String getPtp(String nodeName, String ptpName);

    /**
     * 获取端口信息
     * get
     *
     * @param nodeName 节点名称
     * @return Ftp浮动端口列表报文
     */
    String getFtps(String nodeName);

    /**
     * 查询指定ftp的信息
     * get
     *
     * @param nodeName 节点名称
     * @param ftpName  浮动端口
     * @return 指定浮动端口信息报文
     */
    String getFtp(String nodeName, String ftpName);


    /**
     * 查询所有 CTP
     * get
     *
     * @param nodeName 节点名称
     * @return 连接端口列表信息报文
     */
    String getCtps(String nodeName);

    /**
     * 查询指定ctp的信息
     * get
     *
     * @param nodeName 节点名称
     * @param ctpName  连接端口
     * @return 指定连接端口信息报文
     */
    String getCtp(String nodeName, String ctpName);


    /**
     * Vcg 属性修改
     *
     * @param nodeName 节点名称
     * @param ftpName  浮动端口名称
     * @param vcgPac   配置下发报文
     * @return 操作状态（成功/失败）
     */
    String configVcgPac(String nodeName, String ftpName, VcgPac vcgPac);
    //////////////////////////////////////////////////////////////////////////

    ////////////////////////////////告警模块///////////////////////////////////

    /**
     * 告警实时上报
     * notification
     *
     * @param nodeName 节点名称
     * @return 返回实时告警报文
     */
    String alarmNotification(String nodeName);


    /**
     * 查询设备当前告警
     * get
     *
     * @param nodeName 节点名称
     * @return 返回实时告警和性能报文
     */
    String getAlarmTcas(String nodeName);

    /**
     * 查询设备历史告警
     * rpc
     *
     * @param nodeName  节点名称
     * @param inputTime startTime 网元告警产生的起始时间
     *                  endTime   网元告警产生的结束时间
     * @return 查询到的告警列表（Alarms） 和 性能越限列表（TCAs）
     */
    String getHistoryAlarms(String nodeName, String inputTime);


    /**
     * 设置告警抑制状态
     * objectType=ME 时，表达的是整网元属性的告警；与其他类型是并列存在的关系
     * edit-config
     *
     * @param nodeName       节点名称
     * @param alarmMaskState 设置 状态下发报文
     * @return 设置成功 设置失败，并且返回错误码： 告警名称错误、对象类型错误、对象不存在
     */
    String configAlarmMaskState(String nodeName, AlarmMaskState alarmMaskState);

    /**
     * 查询网元、单板、端口(PTP、FTP、CTP)屏蔽状态
     * get
     *
     * @param nodeName       节点名称
     * @param alarmMaskState 指定查询告警抑制的对象名称和类型（objectName 和 objectType）
     *                       指定查询告警抑制的告警编码（alarmCode）（可空）
     * @return 返回本级（objectType）对象告警抑制状态。
     */
    String getAlarmMaskState(String nodeName, AlarmMaskState alarmMaskState);
    //////////////////////////////////////////////////////////////////////////


    ////////////////////////////////性能模块///////////////////////////////////

    /**
     * 实时性能越限通知上报
     * 进行性能值预警的判断，根据门限设置等规则判断是否产生预警
     * notification
     *
     * @param nodeName 节点名称
     * @return 性能越界告警（tca）
     */
    String TCANotification(String nodeName);

    /**
     * 设置性能越限阈值
     * edit-config
     *
     * @param nodeName     节点名称
     * @param tcaParameter 性能越限告警参数（tcaParameter）对象列表
     * @return 操作状态（成功/失败）
     */
    String configTcaParameter(String nodeName, List<TcaParameter> tcaParameter);


    /**
     * 查询性能越限阈值
     * get
     *
     * @param nodeName     节点名称
     * @param tcaParameter 需要查询的性能监控对象标识（objectName）
     *                     周期类型（granularity）
     *                     15min、24h 性能参数名称(pmParameterName)
     * @return 性能越限告警参数（tca-parameter）
     */
    String getTcaParameter(String nodeName, TcaParameter tcaParameter);

    /**
     * 查询当前性能
     * get
     *
     * @param nodeName    节点名称
     * @param performance 需要查询的性能监控对象标识（objectName）
     *                    周期类型（granularity）：15min、24h
     *                    性能参数(pmParameterName)(可选、可为空)最多只能指定一个参数，如果为空则返回全部性能任务
     *                    开始时间（starTime）
     * @return 性能数据列表（performances）
     */
    String getPerformances(String nodeName, Performance performance);

    /**
     * 查询历史性能
     * 注意：需要考虑拆分数据包传送大数据量。当前使用该接口进行历史性能数据的查询。
     * 支持查询 CPE-OTN/网元/端口。 支持 24 小时内 15min 性能值。
     * rpc
     *
     * @param nodeName  节点名称
     * @param inputJson 需要查询的性能监控对象标识（objectName）
     *                  周期类型（granularity）：15min、24h
     *                  性能参数(pmParameterName)(可选、可为空) 最多只能指定一个参数，如果为空则返回全部
     *                  起始时间和终止时间
     * @return 性能数据列表（performances）
     */
    String getHistoryPerformanceMonitoringData(String nodeName, String inputJson);

    //////////////////////////////////////////////////////////////////////////

    ///////////////////////////////故障诊断////////////////////////////////////


    /**
     * 执行端口环回操作
     * edit-config
     *
     * @param nodeName     节点名称
     * @param tpName       端口名称/类型
     * @param loopbackType 环回类型
     * @return 操作状态（成功/失败）
     */
    String configTpLookBack(String nodeName, String tpName, String loopbackType);

    /**
     * 查询端口的环回状态
     * get
     *
     * @param nodeName 节点名称
     * @param tpName   端口名称
     * @return 端口名称（tpName） 环回类型(loopbackType)
     */
    String getTpLookBackState(String nodeName, String tpName);


    /**
     * 单板复位
     * rpc
     *
     * @param nodeName 节点名称
     * @param eq       epName    单板名称
     *                 resetType 维护操作命令类型(resetType)：软复位(soft-reset)、硬复位(hard-reset)
     * @return 操作状态（成功/失败）
     */
    String configEqsReset(String nodeName, Eq eq);

    /**
     * 打开/关闭端口激光器
     * edit-config
     *
     * @param nodeName    节点名称
     * @param ptpName     端口名称
     * @param laserStatus 激光器状态  laserOn, laserOff
     * @return 操作状态（成功/失败）
     */
    String configPtpLaser(String nodeName, String ptpName, String laserStatus);

    /**
     * 查询激光器工作状态
     * get
     *
     * @param nodeName 节点名称
     * @param ptpName  端口名称
     * @return 端口标识符名称（ptpName）
     * 激光器开关（laserStatus）： laserOn, laserOff
     */

    String getPtpLaser(String nodeName, String ptpName);

    //////////////////////////////////////////////////////////////////////////

    ///////////////////////////////保护组管理///////////////////////////////////

    /**
     * 查询保护组信息
     *
     * @param nodeName 节点名称
     * @return 保护组信息列表
     */
    String getPgs(String nodeName);

    /**
     * 查询指定名称保护组信息
     *
     * @param nodeName 节点名称
     * @param pgId     保护组唯一标识符
     * @return 保护组信息
     */
    String getPg(String nodeName, String pgId);

    /**
     * 创建保护组
     *
     * @param nodeName 节点名称
     * @param pg       下发保护组信息报文
     * @return 操作状态（成功/失败）
     */
    String createPgs(String nodeName, PG pg);


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
     * @param pgSwitch 保护组输入参数配置报文
     * @return 操作状态（成功/失败）
     */
    String performProtectionCommand(String nodeName, PGSwitch pgSwitch);


    /**
     * SD 触发保护倒换设置
     *
     * @param nodeName  节点名称
     * @param SdTrigger SD 触发倒换使能或者禁止
     * @return 操作状态（成功/失败）
     */
    String switchSdTriggerEnable(String nodeName, String pgId, boolean SdTrigger);

    /**
     * 查询 sd 触发保护倒换的设置状态
     *
     * @param nodeName 节点名称
     * @param pgId     保护组唯一标识符(ID)
     * @return Sd 触发倒换设置状态
     */
    String getSwitchSdTriggerStatus(String nodeName, String pgId);
    //////////////////////////////////////////////////////////////////////////

    ///////////////////////////业务发放管理接口//////////////////////////////////

    /**
     * 创建 ETH connection
     * 前提：存在要创建 Connection 的相关资源
     *
     * @param nodeName    节点名称
     * @param jsonMessage 下发配置报文
     * @return 1）所创建的连接(connection)。 2）另外通过接口返回参数返回创建的FTP、服务层CTP等。
     */
    String createEthConnection(String nodeName, String jsonMessage);

    /**
     * 创建 ETH-ETH connection
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 1) 所创建的连接(connection)。 2) 另外通过接口返回参数返回创建的FTP。
     */
    String createEthToEthConnection(String nodeName, String jsonStr);

    /**
     * 创建SDH连接
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 1) 所创建的连接(connection) 2) 另外通过接口返回参数返回创建的FTP、服务层CTP等。
     */
    String createSdhConnection(String nodeName, String jsonStr);

    /**
     * 向接入型 OTN 下发创建 Connection 指令，存在 UNI-NNI 与 NNI-NNI 两种 情况的交叉创建
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 所创建的连接(connection)
     */
    String createOduConnection(String nodeName, String jsonStr);

    /**
     * 创建Eos连接
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 1) 所创建的连接(connection) 2) 另外通过接口返回VCG属性等
     */
    String createEosConnection(String nodeName, String jsonStr);

    /**
     * 删除指定连接
     *
     * @param nodeName 节点名称
     * @param connName 连接名称
     * @return 操作状态（成功/失败）
     */
    String deleteConnection(String nodeName, String connName);

    /**
     * 获取所有（交叉）连接信息
     *
     * @param nodeName 节点名称
     * @return
     */
    String getConnections(String nodeName);

    /**
     * 获取指定名称的连接信息
     *
     * @param nodeName 节点名称
     * @param connName 连接名称
     * @return
     */
    String getConnection(String nodeName, String connName);
    ////////////////////////////调整连接点带宽//////////////////////////////////

    /**
     * 修改 ETH connection 的带宽
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 成功/失败
     */
    String modifyEthConnectionCapacity(String nodeName, String jsonStr);

    /**
     * 修改 ODU connection 的带宽
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 成功/失败
     */
    String modifyOduConnectionCapacity(String nodeName, String jsonStr);

    /**
     * 修改 VCG connection 的带宽
     *
     * @param nodeName 节点名称
     * @param jsonStr  下发内容
     * @return 成功/失败
     */
    String modifyVcgConnectionCapacity(String nodeName, String jsonStr);
    /////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////

}
