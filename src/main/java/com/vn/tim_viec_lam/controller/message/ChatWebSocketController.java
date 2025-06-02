package com.vn.tim_viec_lam.controller.message;

import com.vn.tim_viec_lam.service.ConversationService;
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
    private static Map<Integer, Session> users = new ConcurrentHashMap<>();
    private static int isOnline = 1;
    @OnOpen
    public void onOpen(Session session, EndpointConfig config) {
        HttpSession httpSession = (HttpSession) config.getUserProperties().get("httpSession");
        UserService userService = new UserService();
        if (httpSession != null) {

            int role = -999;
            if (httpSession.getAttribute("role") != null) {
                role = Integer.parseInt(httpSession.getAttribute("role").toString());
            }

            int userId = -1;
            if(role == 1){
                userId = (int) httpSession.getAttribute("userID");
            }
            if(role == 2 ){
                userId = (int) httpSession.getAttribute("companyUserId");
            }
            System.out.println("UserId :" + userId);
            if (userId > 0) {

                users.put(userId, session);
                session.getUserProperties().put("userId", userId);
                isOnline = 1;
                userService.updateIsOnline(userId,isOnline);
                System.out.println("Current online users: " + users.keySet());
            }
        }
    }

    @OnMessage
    public void onMessage(String message, Session session) {
        JSONObject obj = new JSONObject(message);
        String content = obj.getString("content");
        int applicationId = obj.getInt("applicationId");

        Integer senderId = (Integer) session.getUserProperties().get("userId");

        ConversationService conversationService = new ConversationService();
        int receiver = conversationService.getSenderId(applicationId, senderId);


        if (users.containsKey(receiver)) {
            try {
                users.get(receiver).getBasicRemote().sendText(receiver + ": " + content);
                System.out.println("Người nhận đang online");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            System.out.println("Người nhận đang offline");
        }

        MessageService messageService = new MessageService();
        messageService.insertMessage(receiver, applicationId, senderId, content);
        System.out.println("Đã lưu tin nhắn");
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        UserService userService = new UserService();
        int userId = (int) session.getUserProperties().get("userId");
        if (userId != 0) {
            isOnline = 0;
            userService.updateIsOnline(userId,isOnline);
            users.remove(userId);
            System.out.println("User " + userId + " disconnected.");


            ConversationService conversationService = new ConversationService();
            MessageService messageService = new MessageService();

            for (Integer conversationId : conversationService.getConversationIdsByUserId(userId)) {
                if (messageService.countMessagesInConversation(conversationId) == 0) {
                    conversationService.deleteConversation(conversationId);
                    System.out.println("Đã xoá conversation không có tin nhắn: " + conversationId);
                }
            }
        }
    }
}
