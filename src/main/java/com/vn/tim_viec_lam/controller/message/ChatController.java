package com.vn.tim_viec_lam.controller.message;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "chat",value = "/chat")
public class ChatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("user") != null){
            int userId = session.getAttribute("userID") == null ? -1 : Integer.parseInt(session.getAttribute("userID").toString());

            ConversationService conversationService = new ConversationService();
            MessageService messageService = new MessageService();

            List<Conversation> conversations = conversationService.getAllConversationByUserId(userId);
            List<Message> messages = new ArrayList<>();
            int applicationId = -1;
            Conversation conversation = null;
            if(!conversations.isEmpty()){
                conversation = conversations.get(0);
                applicationId = conversation.getApplicationId();
                messages = messageService.getAllMessageByCanidateId(userId,applicationId);

            }


            req.setAttribute("messages", messages);
            req.setAttribute("conversation", conversation);
            req.setAttribute("conversations", conversations);
            if(applicationId != -1){
                req.setAttribute("applicationId", applicationId);
            }

            req.getRequestDispatcher("chat.jsp").forward(req,resp);

        }

        else{
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MessageService messageService = new MessageService();
        if(session.getAttribute("candidateId")!=null){
            int id = (int)session.getAttribute("candidateId");
            List<Message> messages =messageService.getAllMessageByCanidateId(id,1);
            if(messages.size()>0){
                session.setAttribute("messages",messages);
            }
        }
    }
}
