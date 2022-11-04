package com.hctel.oos.netconf.notifications.service.impl;

import com.hctel.oos.netconf.notifications.service.PushMsg;
import com.hctel.oos.netconf.notifications.utils.WebSocketUtils;

import javax.annotation.Resource;

public class PushMsgImpl implements PushMsg {

    @Resource
    private WebSocketUtils webSocket;
    @Resource
    private SubscribeDeviceMessage subscribeDeviceMessage;

    @Override
    public String sendMsg() {

        subscribeDeviceMessage.receiveNotification();

        String noticeMsg = subscribeDeviceMessage.getNoticeMsg();

        webSocket.sendMessage(noticeMsg);


        return null;
    }
}
