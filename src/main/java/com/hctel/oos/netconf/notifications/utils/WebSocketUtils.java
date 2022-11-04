package com.hctel.oos.netconf.notifications.utils;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@ServerEndpoint("/device/{node}/notification")
@Component
public class WebSocketUtils {

    private Session session;

    private static Set<WebSocketUtils> webSocket = new HashSet<>();
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    //发送消息
    public void sendMessage(String message){
        if(session != null){
            for (WebSocketUtils ws : webSocket) {
                System.out.println("发送数据：" + message);
                try {
                    ws.session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //建立连接成功调用
    @OnOpen
    public void onOpen(@PathVariable(value = "node") String node, Session session){
        System.out.println("节点名称："+node);
        this.session = session;
        webSocket.add(this);
        System.out.println("成功建立websocket连接。。。 共计： " + webSocket.size());

    }

    //关闭连接时调用
    @OnClose
    public void onClose(Session session){
        if (session.isOpen()) {
            try {
                session.close();
                System.out.println("关闭了websocket");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //收到客户端信息后 发送消息
    @OnMessage
    public void onMessage(String message) throws IOException{
        System.out.println("websocket 建立成功"+message);
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }

    public static AtomicInteger getOnlineNumber() {
        return onlineNum;
    }

    public static ConcurrentHashMap<String, Session> getSessionPools() {
        return sessionPools;
    }
}
