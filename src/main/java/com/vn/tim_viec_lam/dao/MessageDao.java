package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Message;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MessageDao {
    public boolean insertMessage(int id, int senderId, String content) {
        String sql = "insert into messages(conversationId,senderId,content,sent_at) values(?,?,?,NOW())";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, senderId);
            ps.setString(3, content);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean insertConversation(int receiverId, int senderId, int applicationId, String content) {
        String sql = "insert conversations(userSenderID,userReceiverId,applicationId,created_at) values(?,?,?,NOW())";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, applicationId);

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    int conversationId = rs.getInt(1);
                    String sqlMessage = "insert into messages(conversationId,senderId,content,sent_at) values(?,?,?,NOW())";
                    try (PreparedStatement psMessage = con.prepareStatement(sqlMessage)) {
                        psMessage.setInt(1, conversationId);
                        psMessage.setInt(2, senderId);
                        psMessage.setString(3, content);
                        return psMessage.executeUpdate() > 0;
                    }
                }
            }
            return false; // Nếu không lấy được conversationId
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Message> getMessage(int id, int applicationId) {
        String sql = "select m.conversationId,c.userSenderId,c.userReceiverId,c.created_at" +
                ",m.messageId,m.senderId,m.content,m.sent_at,m.is_read from messages m " +
                " join conversations c on c.conversationID = m.conversationID" +
                " where m.conversationID in (" +
                "select conversationID from conversations c " +
                "where (c.userSenderId = ? Or c.userReceiverId = ?) and c.applicationId = ?" +
                ")";

        List<Message> messageList = new ArrayList<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setInt(2, id);
            ps.setInt(3, applicationId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int messageId = rs.getInt("messageId");
                    int senderID = rs.getInt("senderId");
                    String content = rs.getString("content");
                    LocalDateTime sent_at = rs.getTimestamp("sent_at").toLocalDateTime();
                    Message message = new Message();
                    message.setMessage(content);
                    message.setId(messageId);
                    message.setSenderId(senderID);
                    message.setSentDate(sent_at);
                    messageList.add(message);
                }
            }
            return messageList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getConversationById(int receiverId, int senderId, int applicationId) {
        String sql = "select conversationId from conversations" +
                " where ((userSenderID = ? AND userReceiverID = ?) OR (userSenderID = ? AND userReceiverID = ?))" +
                " and applicationId = ?";
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, senderId);
            ps.setInt(2, receiverId);
            ps.setInt(3, receiverId);
            ps.setInt(4, senderId);
            ps.setInt(5, applicationId);
            try (ResultSet rs = ps.executeQuery()) {
                int conversationID = -1;
                if (rs.next()) {
                    conversationID = rs.getInt("conversationId");
                }
                return conversationID;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Message> getAllMessageByCompanyId(int companyId, int receiver, int applicationId) {
        String sql = "select m.conversationId,c.userSenderId,c.userReceiverId,c.created_at" +
                ",m.messageId,m.senderId,m.content,m.sent_at,m.is_read from messages m " +
                " join conversations c on c.conversationID = m.conversationID" +
                " where m.conversationID = (" +
                " select conversationID from conversations c " +
                " where c.userSenderId = ? and c.userReceiverId = ? and c.applicationId = ?" +
                ")";

        List<Message> messageList = new ArrayList<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, companyId);
            ps.setInt(2, receiver);
            ps.setInt(3, applicationId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int messageId = rs.getInt("messageId");
                    int senderID = rs.getInt("senderId");
                    String content = rs.getString("content");
                    LocalDateTime sent_at = rs.getTimestamp("sent_at").toLocalDateTime();
                    Message message = new Message();
                    message.setMessage(content);
                    message.setId(messageId);
                    message.setSenderId(senderID);
                    message.setSentDate(sent_at);
                    messageList.add(message);
                }
            }
            return messageList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Message> getAllMessageByConversationId(int conversationId) {
        String sql = "select m.conversationId,c.userSenderId,c.userReceiverId,c.created_at" +
                ",m.messageId,m.senderId,m.content,m.sent_at,m.is_read from messages m " +
                " join conversations c on c.conversationID = m.conversationID" +
                " where m.conversationID = ? ";

        List<Message> messageList = new ArrayList<>();
        try (Connection con = DBconnect.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, conversationId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int messageId = rs.getInt("messageId");
                    int senderID = rs.getInt("senderId");
                    String content = rs.getString("content");
                    LocalDateTime sent_at = rs.getTimestamp("sent_at").toLocalDateTime();
                    Message message = new Message();
                    message.setMessage(content);
                    message.setId(messageId);
                    message.setSenderId(senderID);
                    message.setSentDate(sent_at);
                    messageList.add(message);
                }
            }
            return messageList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
