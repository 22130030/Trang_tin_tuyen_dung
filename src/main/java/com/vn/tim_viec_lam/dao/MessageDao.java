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
    public boolean insertMessage(int id,int senderId,String content){
        Connection con = DBconnect.getConnection();
        String sql = "insert into messages(conversationId,senderId,content,sent_at) values(?,?,?,NOW())";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, senderId);
            ps.setString(3, content);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Message> getMessage(int id,String param,int jobPostId){
        Connection con = DBconnect.getConnection();
        String sql = "select m.conversationId,c.candidateId,c.companyId,c.created_at" +
                ",m.messageId,m.senderId,m.content,m.sent_at,m.is_read from messages m " +
                " join conversations c on c.conversationID = m.conversationID" +
                " where m.conversationID = (" +
                "select conversationID from conversations " +
                "where "+ param  +"= ? and jobPostID = ?" +
                ")";

        List<Message> messageList = new ArrayList<Message>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setInt(2, jobPostId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int messageId = rs.getInt("messageId");
                int senderID = rs.getInt("senderId");
                String content = rs.getString("content");
                LocalDateTime sent_at = rs.getTimestamp("sent_at").toLocalDateTime();
                Message message = new Message();
                if(param.equals("candidateId")){
                    int companyId = rs.getInt("companyId");
                    message = new Message(messageId, id, companyId, jobPostId,senderID, content, sent_at);

                }else {
                    int candidateId = rs.getInt("candidateId");
                    message = new Message(messageId, candidateId, id, jobPostId,senderID, content, sent_at);
                }
                messageList.add(message);

            }
            return messageList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public List<Message> getConversation(int id,String param){
        Connection con = DBconnect.getConnection();
        String sql = "select jp.companyID,cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at" +
                ",c.jobPostId,c.candidateId,c.companyId from job_posting jp" +
                " join job_applications ja on ja.jobPostId = jp.jobPostId " +
                " join conversations c on c.jobPostId = jp.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where c."+ param +" = ?" +
                " group by c.created_at asc";
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int conversationID = rs.getInt("conversationID");
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                int jobPostID = rs.getInt("jobPostID");
                Message message = new Message();
                message.setId(conversationID);
                if(param.equals("candidateId")){
                    int companyId = rs.getInt("companyId");
                    message.setcanidateId(id);
                    message.setcompanyId(companyId);

                }else if(param.equals("companyId")){
                    int candidateID = rs.getInt("candidateID");
                    message.setcanidateId(candidateID);
                    message.setcompanyId(id);
                }
                message.setCompanyName(companyName);
                message.setTitleJob(titleJob);
                message.setStatus(status);
                message.setApp_created_at(created_at);
                message.setjobPostId(jobPostID);
                messages.add(message);
            }
            return messages;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int getConversationById(int candidateId,int companyId,int jobPostId){
        Connection con = DBconnect.getConnection();
        String sql = "select conversationId from conversations" +
                " where candidateId = ? and companyId = ? and jobPostId = ?";
        List<Message> messages = new ArrayList<>();
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ps.setInt(2, companyId);
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

    public List<Message> getConversationByJobPostId(int jobPostId){
        Connection con = DBconnect.getConnection();
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at from job_posting jp" +
                " join job_applications ja on ja.jobPostId = jp.jobPostId " +
                " join conversations c on c.jobPostId = jp.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where jp.jobPostId= ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, jobPostId);
            ResultSet rs = ps.executeQuery();
            List<Message> messages = new ArrayList<>();
            Message message = new Message();
            while (rs.next()) {
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                int conversationId = rs.getInt("conversationId");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                message.setCompanyName(companyName);
                message.setId(conversationId);
                message.setApp_created_at(created_at);
                message.setStatus(status);
                messages.add(message);
            }
            return messages;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        MessageDao dao = new MessageDao();
        System.out.println(dao.getConversation(53,"candidateId"));
    }


}
