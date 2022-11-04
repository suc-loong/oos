package com.hctel.oos.jeroMq;

import org.jeromq.ZMQ;

public class ZMQPublisher {

    public ZMQPublisher(int bindPort) {
        ZMQSendPort = bindPort;
    }
    /**
     * ZMQ启动线程数
     */
    private static int ZMQThreadCount = Integer.parseInt("1");

    /**
     * ZMQ数据广播端口
     */
    private static int ZMQSendPort = 0;

    private static ZMQ.Context context = null;
    private static ZMQ.Socket pubSock = null;

    /**
     * 初始化ZMQ对象
     */
    public ZMQ.Socket initZMQ() {
        if (context == null) {
            context = ZMQ.context(ZMQThreadCount);
        }
        if (ZMQSendPort != 0) {
            pubSock = context.socket(ZMQ.PUB);
            String bindUri = "tcp://*:" + ZMQSendPort;
            pubSock.bind(bindUri);
        } else {
            throw new RuntimeException("Error!");
        }

        return  pubSock;
    }

    private ZMQ.Socket getPubSock() {
        if (pubSock == null) {
            initZMQ();
        }
        return pubSock;
    }

    public  void sendData(String msg) {
        pubSock.send(msg, ZMQ.NOBLOCK);
    }

    public void sendData(byte[] msg) {
        pubSock.send(msg);
    }

}
