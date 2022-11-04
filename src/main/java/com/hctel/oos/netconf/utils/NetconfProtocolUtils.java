package com.hctel.oos.netconf.utils;

import net.juniper.netconf.Device;
import net.juniper.netconf.NetconfException;
import net.juniper.netconf.XML;
import org.springframework.stereotype.Service;

/**
 * 基于netconf开发的连接方式
 */
@Service
public class NetconfProtocolUtils {

    private static final String HOSTNAME = "192.168.12.112";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "admin123!!!";

//    private static final String HOSTNAME = "192.168.135.117";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "dfqxyfy";

    private static final int NETCONF_PORT = 830;

    /**
     * 要发送的xml报文 例如：
     * <get>
     * <filter type="subtree">
     * <users xmlns="http://netconfcentral.org/ns/user">
     * <user>
     * <name>admin</name>
     * </user>
     * </users>
     * </filter>
     * </get>
     *
     * @param xmlContent
     * @return
     */
    public XML send(String xmlContent) throws NetconfException {

        Device device = null;

        XML xmlReply = null;

        try {
            device = Device.builder().hostName(HOSTNAME)
                    .userName(USERNAME)
                    .password(PASSWORD)
                    .port(NETCONF_PORT)
                    .strictHostKeyChecking(false)
                    .hostKeysFileName(null)
                    .build();
            device.connect();

            xmlReply = device.executeRPC(xmlContent);
            device.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NetconfException("报文发送失败");
        } finally {
            if (null != device) {
                device.close();
            }
        }
        return xmlReply;
    }


    public XML send(String deviceHOSTNAME, String deviceUSERNAME, String devicePASSWORD, int deviceNETCONFPORT
            , String xmlContent) throws NetconfException {

        Device device = null;

        XML xmlReply = null;

        try {
            device = Device.builder().hostName(deviceHOSTNAME)
                    .userName(deviceUSERNAME)
                    .password(devicePASSWORD)
                    .port(deviceNETCONFPORT)
                    .strictHostKeyChecking(false)
                    .hostKeysFileName(null)
                    .build();
            device.connect();

            xmlReply = device.executeRPC(xmlContent);
            device.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NetconfException("报文发送失败");
        } finally {
            if (null != device) {
                device.close();
            }
        }
        return xmlReply;
    }

}
