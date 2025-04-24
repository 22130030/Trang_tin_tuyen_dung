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
    public List<Conversation> getConversationByJobPostId(int jobPostId) {
        return conversationDao.getConversationByJobPostId(jobPostId);
    }
    public Conversation getConversationById(int conversationId) {
        return conversationDao.getConversationById(conversationId);
    }
    public int getSenderId(int jobPostId, Integer userId) {
        Conversation conversation = conversationDao.getSenderId(jobPostId, userId);
        if(conversation != null) {
            int receiverId = (conversation.getUserSenderId() == userId)
                    ? conversation.getUserReceiverId()
                    : conversation.getUserSenderId();
            return receiverId;
        }
        return -1;
    }

    public static void main(String[] args) {
        ConversationService conversationService = new ConversationService();
        System.out.println(conversationService.getConversationById(10));
    }
}
