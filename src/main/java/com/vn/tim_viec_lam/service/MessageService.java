package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.MessageDao;
import com.vn.tim_viec_lam.dao.model.Message;

import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    public MessageService() {
        this.messageDao = new MessageDao();
    }
    public boolean insertMessage(int candidateId,int employerId,int applicationID,String message) {
        return messageDao.insertMessage(candidateId,employerId,applicationID,message);
    }
    public List<Message> getAllMessageByCanidateId(int candateId) {
        return messageDao.getMessageListByCandidateId(candateId);
    }
    public List<Message> getTopMessageByCanidateId(int candateId) {
        return messageDao.getTopMessage(candateId);
    }
}
