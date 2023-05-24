package cn.edu.tongji.businessintelligencebackendwebsocket.controller;

import cn.edu.tongji.businessintelligencebackendwebsocket.repository.NewsRepository;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

@RestController
@ServerEndpoint(value = "/websocket/{userid}")
@Component
public class WebSocketController {
    private int userid;

    private static CopyOnWriteArraySet<WebSocketController> webSocketControllerSet = new CopyOnWriteArraySet<>();

    private static NewsRepository newsRepository;
    private Session session = null;

    private static int start = 0;
    @Autowired
    public void setUserService(NewsRepository newsRepository) {
        WebSocketController.newsRepository = newsRepository;
    }
    @OnOpen
    public void onOpen(Session session, @PathParam("userid") String userid) {
        // 建立连接
        this.session = session;
        webSocketControllerSet.add(this);
        this.userid = Integer.parseInt(userid);
//        this.sendMessage("测试一下");
    }

    @OnClose
    public void onClose() {
        // 关闭链接
        webSocketControllerSet.remove(this);
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        for (WebSocketController item: webSocketControllerSet) {
            try {
                Map<String,Object> result = new HashMap<>(16);
                List<Map<String,Object>> news = newsRepository.findNewsByUserId(userid);
                result.put("news",news);
                List<Map<String,Object>> recentClick = newsRepository.getRecentClick(start);
                if(recentClick.size() != 0){
                    start = Integer.parseInt(recentClick.get(0).get("start_ts").toString());
                    result.put("clicks",recentClick);
                }else{
                    result.put("clicks",null);
                }
                item.session.getBasicRemote().sendText(JSON.toJSONString(result));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void onError(Session session, Throwable error) {
        error.printStackTrace();
    }

//    public void sendMessage(Integer fromId, Integer toId, ChatMessageEntity messageEntity) throws IOException{
//        synchronized (this.session) {
//            JSONObject message = new JSONObject();
//            message.put("fromId", fromId);
//            message.put("toId", toId);
//            message.put("createTime", messageEntity.getCreateTime());
//            message.put("content", messageEntity.getContent());
//            this.session.getBasicRemote().sendText(message.toJSONString());
//        }
//    }
}
