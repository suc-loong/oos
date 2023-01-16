package com.hctel.oos.netconf.notifications.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hctel.oos.common.utils.PrettyJSON;
import com.hctel.oos.jeroMq.ZMQSubscriberThread;
import com.hctel.oos.websocket.WebSocketServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SubscribeDeviceMessage {

    private static final Logger LOG = LoggerFactory.getLogger(SubscribeDeviceMessage.class);

    public static String noticeMsg;

    public String getNoticeMsg() {
        return noticeMsg;
    }

    public void setNoticeMsg(String noticeMsg) {
        SubscribeDeviceMessage.noticeMsg = noticeMsg;
    }


    //订阅通知
    public void receiveNotification() {
        ZMQSubscriberThread zmqSubThread = new ZMQSubscriberThread("127.0.0.1", 7111) {
            @Override
            public void dealWith(byte[] data) {
                String msg = new String(data);
                System.out.println(msg);
                msg = msg.replace("notification:", "{\"notification\":");
                msg += "}";
                setNoticeMsg(msg);
//                webSocket.sendMessage(msg);
                System.out.println("收到的通知：\n"+PrettyJSON.pretty(msg));
            }
        };
        zmqSubThread.subscribe("notification:");
        Thread thread = new Thread(zmqSubThread);
        thread.start();
    }

    //订阅告警
    public void receiveAlarms() {
        ZMQSubscriberThread zmqSubThread = new ZMQSubscriberThread("127.0.0.1", 7111) {
            @Override
            public void dealWith(byte[] data) {
                String msg = new String(data);
                msg = msg.replace("session", "");
                System.out.println("接收到的消息:\n" + msg);

                JSONObject jsonObject = (JSONObject) JSON.parse(msg);
                String name = jsonObject.getString("userName");
                System.out.println("name " + name);
                String ipAddress = jsonObject.getString("ipAddress");
                System.out.println("ip " + ipAddress);
                String time = (String) jsonObject.get("time");
                System.out.println("time " + time);

                msg = msg.replace("session:", "");
                System.out.println(msg);
                WebSocketServer.sendInfo(msg);
            }
        };
        zmqSubThread.subscribe("session");
        Thread thread = new Thread(zmqSubThread);
        thread.start();
    }

    //订阅告警
    public void receiveNodeState() {
        ZMQSubscriberThread zmqSubThread = new ZMQSubscriberThread("127.0.0.1", 7111) {
            @Override
            public void dealWith(byte[] data) {
                String msg = new String(data);
                System.out.println(msg);
                msg = msg.replace("node:", "{\"node\":");
                msg += "}";
                System.out.println(msg);
            }
        };
        zmqSubThread.subscribe("node:");
        Thread thread = new Thread(zmqSubThread);
        thread.start();
    }




}
