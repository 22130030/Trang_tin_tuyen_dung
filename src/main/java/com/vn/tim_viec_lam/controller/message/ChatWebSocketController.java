package com.vn.tim_viec_lam.controller.message;

import com.vn.tim_viec_lam.service.MessageService;
import com.vn.tim_viec_lam.service.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint(value = "/chat-web-socket",configurator = GetHttpSessionConfigurator.class)
public class ChatWebSocketController {
    private static Map<String, Session> users = new ConcurrentHashMap<>();
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        if(httpSession != null) {
            int userId = -1;
            int role = (int) httpSession.getAttribute("role");
            if(role == 1){
                userId = (int) httpSession.getAttribute("candidateId");
            }
            if(role == 2){
                userId = (int) httpSession.getAttribute("companyId");

            }
            String userType = null;
            if(userId > 0) {
                userType = role == 1 ? "candidate" : (role == 2 ? "employer" : "unknown");
                String userKey = userId + "_" + userType;

                users.put(userKey, session);
                session.getUserProperties().put("userId", userId);
                session.getUserProperties().put("userType", userType);
                session.getUserProperties().put("userKey", userKey);
            }
        }
    }
    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject obj = new JSONObject(message);
        String content = obj.getString("content");
        int jobPostId = obj.getInt("jobPostId");

        UserService userService = new UserService();
        Map.Entry<Integer,Integer> keys = userService.getUserIdAndRoleByJobPostId(jobPostId);

        int userId = keys.getKey();
        int role = keys.getValue();


        Integer senderId = (Integer) session.getUserProperties().get("userId");

        String senderType = (String) session.getUserProperties().get("userType");

        String senderKey = senderId + "_" + senderType;

        String userType = role == 1 ? "candidate" : (role == 2 ? "employer" : "unknown");
        String receiverKey = userId + "_" + userType;

        if (users.containsKey(receiverKey)) {
            try {
                users.get(receiverKey).getBasicRemote().sendText(senderKey + ": " + content);

                session.getBasicRemote().sendText("Bạn: " + content);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
            MessageService messageService = new MessageService();
            messageService.insertMessage(senderId,userId,jobPostId,senderId,content);
            System.out.println("da lu tin nhan");
//        }
    }
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        String username = (String) session.getUserProperties().get("username");
        if(username != null) {
            users.remove(username);
        }
    }
}
