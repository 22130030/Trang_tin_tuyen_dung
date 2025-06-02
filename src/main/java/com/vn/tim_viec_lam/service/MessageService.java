package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.MessageDao;
import com.vn.tim_viec_lam.dao.model.Message;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    public MessageService() {
        this.messageDao = new MessageDao();
    }
    public boolean insertMessage(int receiverId,int applicationId,int senderId,String message) {
        int conversationId = -1;
        conversationId = messageDao.getConversationById(receiverId,senderId, applicationId);


        if(conversationId > 0){
            return messageDao.insertMessage(conversationId,senderId,message);
        }
        else {
            return messageDao.insertConversation(receiverId,senderId,applicationId,message);
        }
    }
    public List<Message> getAllMessageByCanidateId(int id,int jobPostId) {
        return messageDao.getMessage(id,jobPostId);
    }
    public List<Message> getAllMessageByCompanyId(int companyId,int receiverId,int jobPostId) {
        return messageDao.getAllMessageByCompanyId(companyId,receiverId,jobPostId);
    }
    public List<Message> getAllMessageByConversationId(int conversationId) {
        return messageDao.getAllMessageByConversationId(conversationId);
    }

    public static void main(String[] args) {
        MessageService getConversationMessage = new MessageService();
        System.out.println(getConversationMessage.getAllMessageByConversationId(10));
    }

    public int countMessagesInConversation(Integer conversationId) {
        return messageDao.countMessagesInConversation(conversationId);

    }
}
