package com.vn.tim_viec_lam.controller.message;

import com.vn.tim_viec_lam.dao.model.Conversation;
import com.vn.tim_viec_lam.dao.model.JobApplication;
import com.vn.tim_viec_lam.dao.model.Message;
import com.vn.tim_viec_lam.service.ConversationService;
import com.vn.tim_viec_lam.service.JobApplicationService;
import com.vn.tim_viec_lam.service.MessageService;
import com.vn.tim_viec_lam.service.UserService;
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
        List<Conversation> conversations = new ArrayList<>();
        List<Message> messages = new ArrayList<>();
        Conversation conversation = new Conversation();
        int applicationId = -1;
        if(session.getAttribute("companyUser")!=null){
            int companyUserId =(int) session.getAttribute("companyUserId");

            ConversationService conversationService = new ConversationService();
            MessageService messageService = new MessageService();
            if(req.getParameter("applicationId")!=null){
                int companyId = (int) session.getAttribute("companyId");
                applicationId =Integer.parseInt(req.getParameter("applicationId"));
                JobApplicationService jobApplicationService = new JobApplicationService();
                JobApplication jobApplication = jobApplicationService.getApplication(applicationId,companyId);
                int candidateId = jobApplication.getUserID();

                UserService userService = new UserService();
                int userCandidateId = userService.getUserIdByCandidateId(candidateId);

                conversations = conversationService.getConversationByAll(companyUserId,userCandidateId,applicationId);
                conversation = conversationService.getConversationId(companyUserId,applicationId);
                messages = messageService.getAllMessageByConversationId(conversation.getId());
            }
            else if (req.getParameter("applicationId")==null){
                conversations = conversationService.getAllConversationByUserId(companyUserId);
                messages = new ArrayList<>();

                conversation = new Conversation();
                applicationId = -1;
                if (!conversations.isEmpty()) {
                    conversation = conversations.get(0);
                    applicationId = conversation.getApplicationId();
                    messages = messageService.getAllMessageByConversationId(conversation.getId());

                }


            }
            req.setAttribute("conversations",conversations);
            req.setAttribute("conversation",conversation);
            req.setAttribute("conversationId", conversation.getId());
            req.setAttribute("applicationId", conversation.getApplicationId());
            req.setAttribute("candidateName", conversation.getCandidateName());
            req.setAttribute("companyName", conversation.getCompanyName());
            req.setAttribute("jobTitle", conversation.getJobTitle());
            req.setAttribute("status", conversation.getStatus());
            req.setAttribute("convertLastActive",conversation.getConvertLastActive());
            req.setAttribute("convertAppDate", conversation.getConvertAppDate());
            System.out.println(conversation.getIsOnline());
            req.setAttribute("isOnline",conversation.getIsOnline());
            req.setAttribute("messages", messages);
                
                if (applicationId != -1) {
                    req.setAttribute("applicationId", applicationId);
                }
                req.getRequestDispatcher("chat.jsp").forward(req, resp);
        }else {
            resp.sendRedirect(req.getContextPath()+"/login_employer.jsp");
        }
    }
}
