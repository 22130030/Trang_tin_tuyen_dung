package com.vn.tim_viec_lam.controller.message;

import com.vn.tim_viec_lam.service.MessageService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat",configurator = GetHttpSessionConfigurator.class)
public class ChatController {
    private static Map<String, Session> users = new ConcurrentHashMap<>();
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        if(httpSession != null) {
            String username = (String) httpSession.getAttribute("username");
            if(username != null) {
                users.put(username, session);
                session.getUserProperties().put("username", username);
            }
        }
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject obj = new JSONObject(message);
        String receiver = obj.getString("receiver");
        String content = obj.getString("content");

        String sender = (String) session.getUserProperties().get("username");

        if(receiver != null && sender != null) {
            if(users.containsKey(receiver)) {
                try{
                    users.get(receiver).getBasicRemote().sendText(sender + ":" + content);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
            try{
                session.getBasicRemote().sendText("you :" + content);
            }catch (IOException e) {
                throw new RuntimeException(e);
            }
            MessageService messageService = new MessageService();
            messageService.insertMessage(1,1,1,content);

        }
    }
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        String username = (String) session.getUserProperties().get("username");
        if(username != null) {
            users.remove(username);
        }
    }
}
