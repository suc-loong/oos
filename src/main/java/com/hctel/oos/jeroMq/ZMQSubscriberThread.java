package com.hctel.oos.jeroMq;


import org.jeromq.ZMQ;

/**
 * ZMQ接收线程
 */
public abstract class ZMQSubscriberThread implements Runnable {

    /**
     * MQ启动线程数
     */
    private int ZMQThreadCount = Integer.parseInt("1");

    /**
     * ZMQ监听端口
     */
    private int ZMQPubPort;

    /**
     * ZMQ监听IP
     */
    private String ZMQPubIP;

    private ZMQ.Context context = null;
    private ZMQ.Socket subSock = null;

    public ZMQSubscriberThread() {
        initZMQ();
    }

    public ZMQSubscriberThread(String MQPubIP, int MQPubPort) {
        this.ZMQPubIP = MQPubIP;
        this.ZMQPubPort = MQPubPort;
        initZMQ();
    }

    @Override
    protected  void finalize(){
        if (subSock != null){
            subSock.close();
            subSock = null;
        }
        if (context != null) {
            context.term();
            context = null;
        }
     }

    /**
     * 初始化MQ对象
     */
    public void initZMQ() {
        if (ZMQPubIP == null || "".equals(ZMQPubIP)) {
            throw new RuntimeException("IP Error!");
        }
        if (ZMQPubPort == 0) {
            throw new RuntimeException("Port Error!");
        }

        context = ZMQ.context(ZMQThreadCount);
        subSock = context.socket(ZMQ.SUB);
        String ConUri = "tcp://" + ZMQPubIP + ":" + ZMQPubPort;
        subSock.connect(ConUri);
    }

    public void subscribe(String topic){
        subSock.subscribe(topic.getBytes());
    }

    public ZMQ.Context getContext(){return context;}

    public ZMQ.Socket getSubSock(){return subSock;}

    @Override
    public void run() {
        while (true) {
            try {
                byte[] recvBuf = subSock.recv(ZMQ.SUB);
                if (recvBuf == null) {
                    continue;
                }
                dealWith(recvBuf);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 处理接收到数据的抽象方法
     */
    public abstract void dealWith(byte[] data);
}


