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
    public boolean insertMessage(int candidateId,int senderId,String content){
        Connection con = DBconnect.getConnection();
        String sql = "insert into messages(conversationId,senderId,content,sent_at) values(?,?,?,NOW())";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ps.setInt(2, senderId);
            ps.setString(3, content);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Message> getTopMessage(int candidateId){
        Connection con = DBconnect.getConnection();
        String sql = "select * from conversations c ";

        List<Message> messageList = new ArrayList<Message>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
//            ps.setInt(1, candidateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            }
            return messageList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public List<Message> getMessage(int candidateId,int jobPostId){
        Connection con = DBconnect.getConnection();
        String sql = "select m.conversationId,c.employerId,c.created_at" +
                ",m.messageId,m.senderId,m.content,m.sent_at,m.is_read from messages m " +
                " join conversations c on c.conversationID = m.conversationID" +
                " where m.conversationID = (" +
                "select conversationID from conversations " +
                "where candidateID = ? and jobPostID = ?" +
                ")";

        List<Message> messageList = new ArrayList<Message>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ps.setInt(2, jobPostId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("messageId");
                int employerID = rs.getInt("employerId");
                int senderID = rs.getInt("senderId");
                String content = rs.getString("content");
                LocalDateTime sent_at = rs.getTimestamp("sent_at").toLocalDateTime();
                Message message = new Message(id, candidateId, employerID, jobPostId,senderID, content, sent_at);
                messageList.add(message);

            }
            return messageList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public List<Message> getConversation(int candidateId){
        Connection con = DBconnect.getConnection();
        String sql = "select * from conversations" +
                " where candidateId = ?" +
                " group by created_at asc";
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                int employerID = rs.getInt("employerID");
                int jobPostID = rs.getInt("jobPostID");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                Message message = new Message();
                message.setId(conversationID);
                message.setcanidateId(candidateId);
                message.setemployerId(employerID);
                message.setjobPostId(jobPostID);
                messages.add(message);
            }
            return messages;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getConversationById(int candidateId,int employerId,int jobPostId){
        Connection con = DBconnect.getConnection();
        String sql = "select conversationId from conversations" +
                " where candidateId = ? and employerId = ? and jobPostId = ?";
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ps.setInt(2, employerId);
            ps.setInt(3, jobPostId);
            ResultSet rs = ps.executeQuery();
            int conversationID = -1;
            if(rs.next()){
                conversationID = rs.getInt("conversationId");
            }
            return conversationID;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Message> getMessageListByCandidateId(int candidateId){
        Connection con = DBconnect.getConnection();
        String sql = "select * from conversations where candidateID=? order by sent desc ";
        List<Message> messageList = new ArrayList<Message>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                int canidateID = rs.getInt(2);
                int employerID = rs.getInt(3);
                String content = rs.getString(4);
                int applicationID = rs.getInt(5);
                LocalDateTime sentDate = rs.getTimestamp(6).toLocalDateTime();
//                Message message = new Message(id,canidateID,employerID,applicationID,content,sentDate);
//                messageList.add(message);

            }
            return messageList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        MessageDao dao = new MessageDao();
        System.out.println(dao.getMessage(53,1));
    }
}
