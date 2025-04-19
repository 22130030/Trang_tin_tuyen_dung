package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.MessageDao;
import com.vn.tim_viec_lam.dao.model.Message;

import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    public MessageService() {
        this.messageDao = new MessageDao();
    }
    public boolean insertMessage(int candidateId,int employerId,int applicationID,int senderId,String message) {
        int conversationId = messageDao.getConversationById(candidateId, employerId, applicationID);
        if(conversationId > 0){
            return messageDao.insertMessage(conversationId,senderId,message);
        }
        return false;
    }
    public List<Message> getAllMessageByCanidateId(int candateId,int jobPostId) {
        return messageDao.getMessage(candateId,jobPostId);
    }
    public List<Message> getTopMessageByCanidateId(int candateId) {
        return messageDao.getTopMessage(candateId);
    }
    public List<Message> getConversationMessageByCanidateId(int candateId) {
        return messageDao.getConversation( candateId);
    }
}
