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
        String sql = "select cp.companyName,jp.titleJob,c.conversationId,ja.status,ja.created_at" +
                ",c.jobPostId,c.userSenderId,c.userReceiverID,cd.fullName from job_posting jp" +
                " join job_applications ja on ja.jobPostId = jp.jobPostId " +
                " join candidates cd on cd.candidateId = ja.candidateId" +
                " join conversations c on c.jobPostId = jp.jobPostId " +
                " join companies cp on cp.companyID = jp.companyID " +
                " where c.userSenderId = ? or c.userReceiverID = ?" +
                " group by c.created_at asc";
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
                int jobPostID = rs.getInt("jobPostID");
                Conversation conversation = new Conversation();
                conversation.setId(conversationID);
                conversation.setUserSenderId(userSenderID);
                conversation.setCandidateName(fullName);
                conversation.setUserReceiverId(userReceiverID);
                conversation.setCompanyName(companyName);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setApplicationDate(created_at);
                conversation.setJobPostId(jobPostID);
                conversations.add(conversation);
            }
            return conversations;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Conversation> getConversationByJobPostId(int jobPostId){
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
            List<Conversation> conversations = new ArrayList<>();
            Conversation conversation = new Conversation();
            while (rs.next()) {
                String companyName = rs.getString("companyName");
                String titleJob = rs.getString("titleJob");
                int conversationId = rs.getInt("conversationId");
                String status = rs.getString("status");
                LocalDateTime created_at = rs.getTimestamp("created_at").toLocalDateTime();
                conversation.setCompanyName(companyName);
                conversation.setId(conversationId);
                conversation.setJobTitle(titleJob);
                conversation.setStatus(status);
                conversation.setStartDate(created_at);
                conversations.add(conversation);
            }
            return conversations;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Conversation getSenderId(int jobPostId,int userID) {
        Connection con = DBconnect.getConnection();
        String sql = "select c.userSenderID,c.userReceiverID from conversations c " +
                " where c.jobPostID = ? and (c.userReceiverID = ? or c.userSenderID = ?)";



        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, jobPostId);
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
    public static void main(String[] args) {
        ConversationDao dao = new ConversationDao();
        System.out.println(dao.getSenderId(1,2));
    }
}
