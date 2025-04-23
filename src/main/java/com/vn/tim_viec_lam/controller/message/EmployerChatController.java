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

@WebServlet(name = "employer-chat",value = "/employer-chat")
public class EmployerChatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(true);
        if(session.getAttribute("companyUser")!=null){
            int companyUserId =(int) session.getAttribute("companyUserId");

            ConversationService conversationService = new ConversationService();
            MessageService messageService = new MessageService();

            List<Conversation> conversations = conversationService.getAllConversationByUserId(companyUserId);
            List<Message> messages = new ArrayList<>();
            Conversation conversation = null;
            int jobPostId = -1;
            if(!conversations.isEmpty()){
                conversation = conversations.get(0);
                jobPostId = conversation.getJobPostId();
                messages = messageService.getAllMessageByCanidateId(companyUserId,jobPostId);

            }

            req.setAttribute("messages", messages);
            req.setAttribute("conversations", conversations);
            req.setAttribute("conversation", conversation);
            if(jobPostId != -1){
                req.setAttribute("jobPostId", jobPostId);
            }

            req.getRequestDispatcher("chat.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/login_employer.jsp");
        }
    }
}
