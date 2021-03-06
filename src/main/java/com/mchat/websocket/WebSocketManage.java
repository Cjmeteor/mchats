package com.mchat.websocket;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocketManage
 *
 * @author zhangwenzhi
 * @description
 * @date 2020/6/5 11:53
 */
@Controller
@CrossOrigin(origins = "*")
@RequestMapping(path = "/wwww")
@ServerEndpoint(value = "/websocket/{userid}")
@Component
public class WebSocketManage {
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;

    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。若要实现服务端与单一客户端通信的话，可以使用Map来存放，其中Key可以为用户标识
    //private static CopyOnWriteArraySet<WebSocketManage> webSocketSet = new CopyOnWriteArraySet<WebSocketManage>();

    private static Map<String, WebSocketManage> webSocketMap = new ConcurrentHashMap<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 连接建立成功调用的方法
     *
     * @param session 可选的参数。session为与某个客户端的连接会话，需要通过它来给客户端发送数据
     */
    @OnOpen
    public void onOpen(@PathParam("userid")String userid,Session session) {
        this.session = session;
        /*if(webSocketMap.containsKey(userid)){
            System.out.println("该连接已存在！当前在线人数为" + getOnlineCount());
            return;
        };*/
        webSocketMap.put(userid,this);     //加入set中
        addOnlineCount();           //在线数加1
        System.out.println("有新连接加入！当前在线人数为" + getOnlineCount());
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketMap.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1    
        System.out.println("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     * @param session 可选的参数
     */
    @OnMessage
    public void onMessage(String message, Session session) throws Exception {
        System.out.println("来自客户端的消息:" + message);

        JSONObject jo = JSONObject.parseObject(message);

        JSONObject content = jo.getJSONObject("content");
        String targetId = content.getString("targetId");

        if(webSocketMap.containsKey(targetId)){
            WebSocketManage item = webSocketMap.get(targetId);
            item.sendMessage(message);
        };

        //群发消息
        /*for (WebSocketManage item : webSocketMap) {
            try {
                item.sendMessage(message);
            } catch (IOException e) {
                e.printStackTrace();
                continue;
            }
        }*/
    }

    /**
     * 发生错误时调用
     *
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println("发生错误");
        error.printStackTrace();
    }

    /**
     * 这个方法与上面几个方法不一样。没有用注解，是根据自己需要添加的方法。
     *
     * @param message
     * @throws IOException
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
        //this.session.getAsyncRemote().sendText(message);
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketManage.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketManage.onlineCount--;
    }
}
