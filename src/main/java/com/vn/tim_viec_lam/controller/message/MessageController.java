package com.vn.tim_viec_lam.controller.message;

import com.google.gson.*;
import com.vn.tim_viec_lam.dao.model.Conversation;
import com.vn.tim_viec_lam.dao.model.Message;
import com.vn.tim_viec_lam.service.ConversationService;
import com.vn.tim_viec_lam.service.MessageService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "get-message",value = "/get-message")
public class MessageController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("role") != null) {
            int role = (int) session.getAttribute("role");
            int userId = -1;
            if (role == 1) {
                userId = (int) session.getAttribute("userID");
            }
            if (role == 2) {
                userId = (int) (session.getAttribute("companyUserId"));
            }
            try {
                int jobPostId = -1;
                int conversationId = -1;

                ConversationService conversationService = new ConversationService();
                Conversation conversation = new Conversation();

                MessageService messageService = new MessageService();
                List<Message> messages = new ArrayList<>();

                    conversationId = Integer.parseInt(request.getParameter("conversationId"));

                    conversationService = new ConversationService();
                    conversation = conversationService.getConversationById(conversationId,role);
                    messageService = new MessageService();
                    messages = messageService.getAllMessageByConversationId(conversationId);
                Map<String, Object> result = new HashMap<>();
                result.put("conversationId", conversation.getId());
                result.put("applicationId", conversation.getApplicationId());
                result.put("candidateName", conversation.getCandidateName());
                result.put("companyName", conversation.getCompanyName());
                result.put("jobTitle", conversation.getJobTitle());
                result.put("status", conversation.getStatus());
                result.put("convertLastActive",conversation.getConvertLastActive());
                result.put("convertAppDate", conversation.getConvertAppDate());
                System.out.println(conversation.getIsOnline());
                result.put("isOnline",conversation.getIsOnline());
                result.put("messages", messages);

                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");

                Gson gson = new GsonBuilder()
                        .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                            @Override
                            public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                                return new JsonPrimitive(src.format(formatter));
                            }
                        })
                        .create();

                String json = gson.toJson(result);
                response.getWriter().write(json);

            } catch (NumberFormatException e) {
                response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                response.getWriter().write("{\"error\":\"Invalid parameters.\"}");
            }
        }
    }
}
