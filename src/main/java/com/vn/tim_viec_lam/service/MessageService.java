package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.MessageDao;
import com.vn.tim_viec_lam.dao.model.Message;

import java.util.List;

public class MessageService {
    private MessageDao messageDao;
    public MessageService() {
        this.messageDao = new MessageDao();
    }
    public boolean insertMessage(int receiverId,int jobPostId,int senderId,String message) {
        int conversationId = -1;
        conversationId = messageDao.getConversationById(receiverId,senderId, jobPostId);


        if(conversationId > 0){
            return messageDao.insertMessage(conversationId,senderId,message);
        }
        else {
            return messageDao.insertConversation(receiverId,senderId,jobPostId,message);
        }
    }
    public List<Message> getAllMessageByCanidateId(int id,int jobPostId) {
        return messageDao.getMessage(id,jobPostId);
    }



    public static void main(String[] args) {
        MessageService getConversationMessage = new MessageService();
        System.out.println(getConversationMessage.getAllMessageByCanidateId(27,3));
    }
}
