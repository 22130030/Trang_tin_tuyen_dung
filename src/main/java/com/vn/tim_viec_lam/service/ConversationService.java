package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.ConversationDao;
import com.vn.tim_viec_lam.dao.model.Conversation;

import java.util.List;

public class ConversationService {
    private ConversationDao conversationDao;
    public ConversationService() {
        conversationDao = new ConversationDao();
    }
    public List<Conversation> getAllConversationByUserId(int userId) {
        return conversationDao.getConversation(userId);
    }

    public Conversation getConversationById(int conversationId,int role) {
        return conversationDao.getConversationById(conversationId,role);
    }
    public int getSenderId(int applicationId, Integer userId) {
        Conversation conversation = conversationDao.getSenderId(applicationId, userId);
        if(conversation != null) {
            int receiverId = (conversation.getUserSenderId() == userId)
                    ? conversation.getUserReceiverId()
                    : conversation.getUserSenderId();
            return receiverId;
        }
        return -1;
    }
    public List<Conversation> getConversationByAll(int senderId, int receiverId,int applicationId) {
        if(conversationDao.getConversationByALl(senderId, receiverId, applicationId) == null){
            conversationDao.insertConversation(senderId, receiverId, applicationId);
        }
        return conversationDao.getConversationNoEmpty(senderId);
    }
    public Conversation getConversationId(int senderId, int applicationId) {

        return conversationDao.getConversationId(senderId,applicationId);
    }
    public List<Integer> getConversationIdsByUserId(int senderId) {
        return conversationDao.getConversationIdsByUserId(senderId);
    }
    public static void main(String[] args) {
        ConversationService conversationService = new ConversationService();
        System.out.println(conversationService.deleteConversation(41));
    }

    public boolean deleteConversation(Integer conversationId) {
        return conversationDao.deleteConversation(conversationId);
    }
}
