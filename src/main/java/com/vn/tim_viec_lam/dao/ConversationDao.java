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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConversationDao {
    public List<Conversation> getConversation(int id){
        Connection con = DBconnect.getConnection();
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName,ou.isOnline,ou.lastActive " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN job_posting jp ON jp.jobPostID = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = ja.companyId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "LEFT JOIN online_users ou ON ou.userId = " +
                "    CASE " +
                "        WHEN c.userSenderId = ? THEN c.userReceiverID " +
                "        ELSE c.userSenderId " +
                "    END " +
                "WHERE (c.userSenderId = ? OR c.userReceiverID = ?) " +
                "AND c.conversationId IN ( " +
                "    SELECT m.conversationId " +
                "    FROM messages m " +
                "    WHERE m.content IS NOT NULL AND TRIM(m.content) != '' " +
                ") " +
                "ORDER BY c.created_at ASC";
        List<Conversation> conversations = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                int isOnline = rs.getInt("isOnline");
                LocalDateTime lastActive = rs.getTimestamp("lastActive").toLocalDateTime();
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                int applicationId = rs.getInt("applicationId");
                Conversation conversation = new Conversation();
                conversation.setId(conversationID);
                conversation.setLastActive(lastActive);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setIsOnline(isOnline);
                conversation.setApplicationId(applicationId);
                conversations.add(conversation);
            }
            return conversations;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Map<Integer,Integer> getMessageIsRead(int conversationID){
        Connection con = DBconnect.getConnection();
        String sql = "select m.conversationID,count(m.is_read) as count_is_read from conversations C " +
                "join messages m on m.conversationID = c.conversationID " +
                "where c.conversationId = ? AND" +
                " m.is_read = 0 AND c.conversationId IN (   " +
                "                    SELECT m.conversationId   " +
                "                    FROM messages m   " +
                "                    WHERE m.content IS NOT NULL AND TRIM(m.content) != ''   " +
                "                )   " +
                "GROUP BY m.conversationID ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, conversationID);
            Map<Integer,Integer> messageIsRead = new HashMap<>();
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int conversationId = rs.getInt("conversationID");
                int numOfRead = rs.getInt("count_is_read");
                messageIsRead.put(conversationId, numOfRead);
            }
            return messageIsRead;
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
    public Conversation getConversationById(int conversationId, int role) {
        Connection con = DBconnect.getConnection();
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName, ";

        if (role == 1) {
            sql += "ou_sender.isOnline AS isOnline,ou_sender.lastActive As lastActive ";
        } else if (role == 2) {
            sql += "ou_receiver.isOnline AS isOnline,ou_receiver.lastActive As lastActive ";
        }

        sql += "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "JOIN job_posting jp ON jp.jobPostId = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = jp.companyID " +
                "LEFT JOIN online_users ou_sender ON ou_sender.userId = c.userSenderId " +
                "LEFT JOIN online_users ou_receiver ON ou_receiver.userId = c.userReceiverID " +
                "WHERE c.conversationId = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, conversationId);
            ResultSet rs = ps.executeQuery();
            Conversation conversation = new Conversation();
            if (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int userSenderID = rs.getInt("userSenderID");
                String fullName = rs.getString("fullName");
                int userReceiverID = rs.getInt("userReceiverID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime lastActive = rs.getTimestamp("lastActive").toLocalDateTime();
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                int applicationId = rs.getInt("applicationId");

                int isOnline = rs.getInt("isOnline");

                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setLastActive(lastActive);
                conversation.setApplicationDate(created_at);
                conversation.setApplicationId(applicationId);
                conversation.setIsOnline(isOnline); // Gán trạng thái online vào conversation
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
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName,ou.isOnline,ou.lastActive " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN job_posting jp ON jp.jobPostID = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = ja.companyId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "LEFT JOIN online_users ou ON ou.userId = " +
                "    CASE " +
                "        WHEN c.userSenderId = ? THEN c.userReceiverID " +
                "        ELSE c.userSenderId " +
                "    END " +
                " where c.userSenderId = ? and c.applicationId = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, senderId);
            ps.setInt(2, senderId);
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
                int isOnline = rs.getInt("isOnline");
                LocalDateTime lastActive = rs.getTimestamp("lastActive").toLocalDateTime();
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                conversation.setId(conversationID);
                conversation.setLastActive(lastActive);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setIsOnline(isOnline);
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
