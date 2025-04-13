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
    public boolean insertMessage(int candidateId,int employerId,int applicationID,String message){
        Connection con = DBconnect.getConnection();
        String sql = "insert into message(canidateID,employerID,content,applicationID,sent) values(?,?,?,?,NOW())";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, candidateId);
            ps.setInt(2, employerId);
            ps.setString(3, message);
            ps.setInt(4, applicationID);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Message> getTopMessage(int candidateId){
        Connection con = DBconnect.getConnection();
        String sql = "select me.chatID,me.candidateID,me.applicationID,me.employerID,me.content,me.sent from messages me join (" +
                "  SELECT  *" +
                "  FROM messages" +
                "  WHERE candidateID = ?" +
                "  ORDER BY sent DESC" +
                "  limit 1) as m ON m.candidateID = me.candidateID and m.employerID = me.employerID and m.applicationID = me.applicationID" +
                " order by sent ASC";

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
                Message message = new Message(id, canidateID, employerID, applicationID, content, sentDate);
                messageList.add(message);

            }
            return messageList;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);

        }
    }
    public List<Message> getMessageListByCandidateId(int candidateId){
        Connection con = DBconnect.getConnection();
        String sql = "select * from messages where canidateID=? order by sent desc ";
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
                Message message = new Message(id,canidateID,employerID,applicationID,content,sentDate);
                messageList.add(message);

            }
            return messageList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        MessageDao dao = new MessageDao();
        System.out.println(dao.getTopMessage(1));
    }
}
