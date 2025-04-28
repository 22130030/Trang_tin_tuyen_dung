package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Conversation;
import com.vn.tim_viec_lam.dao.model.Message;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConversationDao {
    public List<Conversation> getConversation(int id){
        Connection con = DBconnect.getConnection();
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at,c.applicationId,c.userSenderId,c.userReceiverID,cd.fullName" +
                " from conversations c" +
                " join job_applications ja on ja.applicationId = c.applicationId " +
                " join job_posting jp on jp.jobPostID = ja.jobPostId " +
                " join companies cp on cp.companyID = ja.companyId" +
                " join candidates cd on cd.candidateId = ja.candidateId"+
                " where c.userSenderId = ? or c.userReceiverID = ? " +
                " order by c.created_at asc";
        List<Conversation> conversations = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                int applicationId = rs.getInt("applicationId");
                Conversation conversation = new Conversation();
                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setApplicationId(applicationId);
                conversations.add(conversation);
            }
            return conversations;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Conversation getSenderId(int jobAppId,int userID) {
        Connection con = DBconnect.getConnection();
        String sql = "select c.userSenderID,c.userReceiverID from conversations c " +
                " where c.applicationId = ? and (c.userReceiverID = ? or c.userSenderID = ?)";



        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, jobAppId);
            stmt.setInt(2, userID);
            stmt.setInt(3, userID);
            ResultSet rs = stmt.executeQuery();
            Conversation conversation = new Conversation();
            if (rs.next()) {
                int senderId = rs.getInt("userSenderID");
                int userReceiverID = rs.getInt("userReceiverID");
                conversation.setUserSenderId(senderId);
                conversation.setUserReceiverId(userReceiverID);

            }
            return conversation;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    public Conversation getConversationById(int conversationId) {
        Connection con = DBconnect.getConnection();
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at" +
                ",c.applicationId,c.userSenderId,c.userReceiverID,cd.fullName from conversations c" +
                " join job_applications ja on ja.applicationId = c.applicationId " +
                " join candidates cd on cd.candidateId = ja.candidateId" +
                " join job_posting jp on jp.jobPostId = ja.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where c.conversationId=?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            Conversation conversation = new Conversation();
            ps.setInt(1, conversationId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                int applicationId = rs.getInt("applicationId");
                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setApplicationId(applicationId);
            }
            return conversation;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Conversation getConversationByALl(int senderId,int receiverId,int applicationId) {
        Connection con = DBconnect.getConnection();
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at" +
                ",c.applicationId,c.userSenderId,c.userReceiverID,cd.fullName from conversations c" +
                " join job_applications ja on ja.applicationId = c.applicationId " +
                " join candidates cd on cd.candidateId = ja.candidateId" +
                " join job_posting jp on ja.jobPostId = jp.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where c.userSenderID = ? AND c.userReceiverID = ? " +
                " and c.applicationId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, applicationId);
            ResultSet rs = ps.executeQuery();
            Conversation conversation = new Conversation();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                conversation = new Conversation();
                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setApplicationId(applicationId);
                return conversation;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Conversation> getConversationsByALl(int senderId,int receiverId,int jobAppId) {
        Connection con = DBconnect.getConnection();
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at" +
                ",c.applicationId,c.userSenderId,c.userReceiverID,cd.fullName from conversations c" +
                " join job_applications ja on ja.applicationId = c.applicationId " +
                " join candidates cd on cd.candidateId = ja.candidateId" +
                " join job_posting jp on ja.jobPostId = jp.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where c.userSenderID = ? AND c.userReceiverID = ? " +
                " and c.applicationId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, jobAppId);
            ResultSet rs = ps.executeQuery();
            Conversation conversation = new Conversation();
            List<Conversation> conversationList = new ArrayList<>();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                int applicationId = rs.getInt("applicationId");
                conversation = new Conversation();
                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setApplicationId(applicationId);
                conversationList.add(conversation);
                return conversationList;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean insertConversation(int senderId,int receiverId,int applicationID) {
        Connection con = DBconnect.getConnection();
        String sql = "insert conversations(userSenderId,userReceiverId,applicationID,created_at) values(?,?,?,NOW())";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, applicationID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public Conversation getConversationId(int senderId, int applicationId) {
        Connection con = DBconnect.getConnection();
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at" +
                ",c.applicationId,c.userSenderId,c.userReceiverID,cd.fullName from conversations c" +
                " join job_applications ja on ja.applicationId = c.applicationId " +
                " join candidates cd on cd.candidateId = ja.candidateId" +
                " join job_posting jp on jp.jobPostId = ja.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where c.userSenderId = ? and c.applicationId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            Conversation conversation = new Conversation();
            ps.setInt(1, senderId);
            ps.setInt(2, applicationId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setApplicationId(applicationId);
            }
            return conversation;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        ConversationDao dao = new ConversationDao();
        System.out.println(dao.getSenderId(1,2));
    }


}
