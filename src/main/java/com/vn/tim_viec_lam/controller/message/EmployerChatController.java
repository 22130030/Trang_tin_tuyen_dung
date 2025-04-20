package com.vn.tim_viec_lam.controller.message;

import com.vn.tim_viec_lam.dao.model.Message;
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
            int companyId =(int) session.getAttribute("companyId");
            MessageService messageService = new MessageService();

            List<Message> conversations = messageService.getConversationMessage(companyId,"companyId");
            List<Message> messages = new ArrayList<>();
            int jobPostId = -1;
            if(!conversations.isEmpty()){
                Message message = conversations.get(0);
                jobPostId = message.getjobPostId();
                messages = messageService.getAllMessageByCanidateId(companyId,"companyId",jobPostId);

            }
            req.setAttribute("messages", messages);
            if(jobPostId != -1){
                req.setAttribute("jobPostId", jobPostId);
            }

            req.getRequestDispatcher("chat.jsp").forward(req,resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/login_employer.jsp");
        }
    }
}
