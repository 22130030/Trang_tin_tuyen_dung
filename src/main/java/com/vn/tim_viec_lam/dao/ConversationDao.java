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
    public List<Conversation> getConversation(int id) {
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName,ou.isOnline,ou.lastActive " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN job_posting jp ON jp.jobPostID = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = ja.companyId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "LEFT JOIN online_users ou ON ou.userId = " +
                "    CASE WHEN c.userSenderId = ? THEN c.userReceiverID ELSE c.userSenderId END " +
                "WHERE (c.userSenderId = ? OR c.userReceiverID = ?) " +
                "AND c.conversationId IN (SELECT m.conversationId FROM messages m WHERE m.content IS NOT NULL AND TRIM(m.content) != '') " +
                "ORDER BY c.created_at ASC";

        List<Conversation> conversations = new ArrayList<>();
        try (
                Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setId(rs.getInt("conversationID"));
                    conversation.setLastActive(rs.getTimestamp("lastActive").toLocalDateTime());
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setCandidateName(rs.getString("fullName"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    conversation.setCompanyName(rs.getString("companyName"));
                    conversation.setJobTitle(rs.getString("titleJob"));
                    conversation.setStatus(rs.getString("status"));
                    conversation.setApplicationDate(rs.getTimestamp("created_at").toLocalDateTime());
                    conversation.setIsOnline(rs.getInt("isOnline"));
                    conversation.setApplicationId(rs.getInt("applicationId"));
                    conversations.add(conversation);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conversations;
    }
    public List<Conversation> getConversationNoEmpty(int id) {
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName,ou.isOnline,ou.lastActive " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN job_posting jp ON jp.jobPostID = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = ja.companyId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "LEFT JOIN online_users ou ON ou.userId = " +
                "    CASE WHEN c.userSenderId = ? THEN c.userReceiverID ELSE c.userSenderId END " +
                "WHERE (c.userSenderId = ? OR c.userReceiverID = ?) " +
                "ORDER BY c.created_at ASC";

        List<Conversation> conversations = new ArrayList<>();
        try (
                Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, id);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setId(rs.getInt("conversationID"));
                    conversation.setLastActive(rs.getTimestamp("lastActive").toLocalDateTime());
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setCandidateName(rs.getString("fullName"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    conversation.setCompanyName(rs.getString("companyName"));
                    conversation.setJobTitle(rs.getString("titleJob"));
                    conversation.setStatus(rs.getString("status"));
                    conversation.setApplicationDate(rs.getTimestamp("created_at").toLocalDateTime());
                    conversation.setIsOnline(rs.getInt("isOnline"));
                    conversation.setApplicationId(rs.getInt("applicationId"));
                    conversations.add(conversation);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conversations;
    }
    public Map<Integer, Integer> getMessageIsRead(int conversationID) {
        String sql = "SELECT m.conversationID, COUNT(m.is_read) AS count_is_read " +
                "FROM conversations c " +
                "JOIN messages m ON m.conversationID = c.conversationID " +
                "WHERE c.conversationId = ? AND m.is_read = 0 AND " +
                "c.conversationId IN (SELECT m.conversationId FROM messages m WHERE m.content IS NOT NULL AND TRIM(m.content) != '') " +
                "GROUP BY m.conversationID";

        Map<Integer, Integer> messageIsRead = new HashMap<>();
        try (
                Connection con = DBconnect.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, conversationID);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    messageIsRead.put(rs.getInt("conversationID"), rs.getInt("count_is_read"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return messageIsRead;
    }

    public Conversation getSenderId(int jobAppId, int userID) {
        String sql = "SELECT c.userSenderID, c.userReceiverID " +
                "FROM conversations c " +
                "WHERE c.applicationId = ? AND (c.userReceiverID = ? OR c.userSenderID = ?)";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement stmt = con.prepareStatement(sql)) {

            stmt.setInt(1, jobAppId);
            stmt.setInt(2, userID);
            stmt.setInt(3, userID);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    return conversation;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Conversation getConversationById(int conversationId, int role) {
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName, ";

        if (role == 1) {
            sql += "ou_sender.isOnline AS isOnline, ou_sender.lastActive AS lastActive ";
        } else if (role == 2) {
            sql += "ou_receiver.isOnline AS isOnline, ou_receiver.lastActive AS lastActive ";
        }

        sql += "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "JOIN job_posting jp ON jp.jobPostId = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = jp.companyID " +
                "LEFT JOIN online_users ou_sender ON ou_sender.userId = c.userSenderId " +
                "LEFT JOIN online_users ou_receiver ON ou_receiver.userId = c.userReceiverID " +
                "WHERE c.conversationId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, conversationId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setId(rs.getInt("conversationID"));
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    conversation.setCandidateName(rs.getString("fullName"));
                    conversation.setCompanyName(rs.getString("companyName"));
                    conversation.setJobTitle(rs.getString("titleJob"));
                    conversation.setStatus(rs.getString("status"));
                    conversation.setLastActive(rs.getTimestamp("lastActive").toLocalDateTime());
                    conversation.setApplicationDate(rs.getTimestamp("created_at").toLocalDateTime());
                    conversation.setApplicationId(rs.getInt("applicationId"));
                    conversation.setIsOnline(rs.getInt("isOnline"));
                    return conversation;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    public Conversation getConversationByALl(int senderId, int receiverId, int applicationId) {
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "JOIN job_posting jp ON ja.jobPostId = jp.jobPostId " +
                "JOIN companies cp ON cp.companyID = jp.companyID " +
                "WHERE c.userSenderID = ? AND c.userReceiverID = ? AND c.applicationId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, applicationId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setId(rs.getInt("conversationID"));
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    conversation.setCandidateName(rs.getString("fullName"));
                    conversation.setCompanyName(rs.getString("companyName"));
                    conversation.setJobTitle(rs.getString("titleJob"));
                    conversation.setStatus(rs.getString("status"));
                    conversation.setApplicationDate(rs.getTimestamp("created_at").toLocalDateTime());
                    conversation.setApplicationId(applicationId);
                    return conversation;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Conversation> getConversationsByALl(int senderId, int receiverId, int jobAppId) {
        List<Conversation> conversationList = new ArrayList<>();
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "JOIN job_posting jp ON ja.jobPostId = jp.jobPostId " +
                "JOIN companies cp ON cp.companyID = jp.companyID " +
                "WHERE c.userSenderID = ? AND c.userReceiverID = ? AND c.applicationId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, jobAppId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setId(rs.getInt("conversationID"));
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setCandidateName(rs.getString("fullName"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    conversation.setCompanyName(rs.getString("companyName"));
                    conversation.setJobTitle(rs.getString("titleJob"));
                    conversation.setStatus(rs.getString("status"));
                    conversation.setApplicationDate(rs.getTimestamp("created_at").toLocalDateTime());
                    conversation.setApplicationId(rs.getInt("applicationId"));
                    conversationList.add(conversation);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conversationList;
    }
    public boolean insertConversation(int senderId, int receiverId, int applicationID) {
        String sql = "INSERT INTO conversations (userSenderId, userReceiverId, applicationID, created_at) " +
                "VALUES (?, ?, ?, NOW())";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, applicationID);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Conversation getConversationId(int senderId, int applicationId) {
        String sql = "SELECT cp.companyName, jp.titleJob, c.conversationId, ja.status, ja.created_at, " +
                "c.applicationId, c.userSenderId, c.userReceiverID, cd.fullName, ou.isOnline, ou.lastActive " +
                "FROM conversations c " +
                "JOIN job_applications ja ON ja.applicationId = c.applicationId " +
                "JOIN job_posting jp ON jp.jobPostID = ja.jobPostId " +
                "JOIN companies cp ON cp.companyID = ja.companyId " +
                "JOIN candidates cd ON cd.candidateId = ja.candidateId " +
                "LEFT JOIN online_users ou ON ou.userId = " +
                "    CASE WHEN c.userSenderId = ? THEN c.userReceiverID ELSE c.userSenderId END " +
                "WHERE c.userSenderId = ? AND c.applicationId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, senderId);
            ps.setInt(2, senderId);
            ps.setInt(3, applicationId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Conversation conversation = new Conversation();
                    conversation.setId(rs.getInt("conversationID"));
                    conversation.setUserSenderId(rs.getInt("userSenderID"));
                    conversation.setCandidateName(rs.getString("fullName"));
                    conversation.setUserReceiverId(rs.getInt("userReceiverID"));
                    conversation.setCompanyName(rs.getString("companyName"));
                    conversation.setJobTitle(rs.getString("titleJob"));
                    conversation.setStatus(rs.getString("status"));
                    conversation.setApplicationDate(rs.getTimestamp("created_at").toLocalDateTime());
                    conversation.setApplicationId(applicationId);
                    conversation.setIsOnline(rs.getInt("isOnline"));
                    conversation.setLastActive(rs.getTimestamp("lastActive").toLocalDateTime());
                    return conversation;
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }

    public List<Integer> getConversationIdsByUserId(int userId) {
        List<Integer> conversationIds = new ArrayList<>();
        String sql = "SELECT conversationId FROM conversations WHERE userSenderId = ?";

        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    conversationIds.add(rs.getInt("conversationId"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conversationIds;
    }

    public boolean deleteConversation(Integer conversationId) {
        String sql = "DELETE FROM conversations WHERE conversationID = ?";

        try (Connection connection = DBconnect.getConnection();
             PreparedStatement ps = connection.prepareStatement(sql)) {

            ps.setInt(1, conversationId);
            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
