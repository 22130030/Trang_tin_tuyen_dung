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
        if (httpSession != null) {
            int userId = -1;
            int role = -999;
            if (httpSession.getAttribute("role") != null) {
                role = Integer.parseInt(httpSession.getAttribute("role").toString());
            } else if (httpSession.getAttribute("companyRole") != null) {
                role = Integer.parseInt(httpSession.getAttribute("companyRole").toString());
            }

            if (role == 1) {
                userId = (int) httpSession.getAttribute("candidateId");
            }
            if (role == 2) {
                userId = (int) httpSession.getAttribute("companyId");
            }
            System.out.println("UserId :" + userId);
            String userType = null;
            if (userId > 0) {
                userType = role == 1 ? "candidate" : (role == 2 ? "company" : "unknown");
                String userKey = userId + "_" + userType;

                users.put(userKey, session);
                session.getUserProperties().put("userId", userId);
                session.getUserProperties().put("userType", userType);
                session.getUserProperties().put("userKey", userKey);
                System.out.println("Current online users: " + users.keySet());
            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject obj = new JSONObject(message);
        String content = obj.getString("content");
        int jobPostId = obj.getInt("jobPostId");


        Integer senderId = (Integer) session.getUserProperties().get("userId");
        String senderType = (String) session.getUserProperties().get("userType");
        String senderKey = senderId + "_" + senderType;

        UserService userService = new UserService();
        Map.Entry<Integer, Integer> keys = userService.getUserIdAndRoleByJobPostId(jobPostId, senderType);

        int userId = keys.getKey();
        int role = keys.getValue();
        String userType = role == 1 ? "candidate" : (role == 2 ? "company" : "unknown");
        String receiverKey = userId + "_" + userType;

        if (users.containsKey(receiverKey)) {
            try {
                users.get(receiverKey).getBasicRemote().sendText(senderKey + ": " + content);

                session.getBasicRemote().sendText("Bạn: " + content);
                System.out.println("người nhận đang online");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("người nhận đang offline");
        }
        MessageService messageService = new MessageService();
        System.out.println("senderId : " + senderId);
        messageService.insertMessage(senderId, userId, jobPostId, senderId, content,senderType);
        System.out.println("da lu tin nhan");
//        }
    }
    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        String userKey = (String) session.getUserProperties().get("userKey");
        if (userKey != null) {
            users.remove(userKey);
            System.out.println("User " + userKey + " disconnected.");
        }
    }
}
