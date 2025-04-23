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
import java.util.List;

@WebServlet(name = "get-message",value = "/get-message")
public class MessageController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session.getAttribute("role") != null) {
            int role = (int)session.getAttribute("role");
            int userId = -1;
            if(role == 1){
                userId = (int)session.getAttribute("userID");
            }
            if(role == 2){
                userId = Integer.parseInt(request.getParameter("companyUserId"));
            }
            int jobPostId = Integer.parseInt(request.getParameter("jobPostId"));
            System.out.println("jobPostId = " + jobPostId);
            MessageService messageService = new MessageService();
            List<Message> messages = messageService.getAllMessageByCanidateId(userId,jobPostId);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            Gson gson = new GsonBuilder()
                    .registerTypeAdapter(LocalDateTime.class, new JsonSerializer<LocalDateTime>() {
                        @Override
                        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
                            return new JsonPrimitive(src.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
                        }
                    })
                    .create();

            String json = gson.toJson(messages);
            response.getWriter().write(json);
        }
    }
}
