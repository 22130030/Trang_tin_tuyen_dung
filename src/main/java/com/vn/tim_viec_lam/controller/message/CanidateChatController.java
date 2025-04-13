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

@WebServlet(name = "chat",value = "/chat")
public class CanidateChatController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if(session.getAttribute("user") != null){
            int candidateId = session.getAttribute("candidateId") == null ? -1 : Integer.parseInt(session.getAttribute("candidateId").toString());
            MessageService messageService = new MessageService();

            List<Message> messages = messageService.getAllMessageByCanidateId(candidateId);
            List<Message> chatMessages = messageService.getTopMessageByCanidateId(candidateId);

            req.setAttribute("chatMessages", chatMessages);
            req.setAttribute("messages", messages);

            req.getRequestDispatcher("chat.jsp").forward(req,resp);

        }else{
            resp.sendRedirect("login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        MessageService messageService = new MessageService();
        if(session.getAttribute("candidateId")!=null){
            int id = (int)session.getAttribute("candidateId");
            List<Message> messages =messageService.getAllMessageByCanidateId(id);
            if(messages.size()>0){
                session.setAttribute("messages",messages);
            }
        }
    }
}
