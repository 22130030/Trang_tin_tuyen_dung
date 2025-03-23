package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.Log;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogDao {
    public List<Log> getLogs(){
        List<Log> logs = new ArrayList<>();
        Connection connection = DBconnect.getConnection();

        String sql = "select * from logworks";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);

            ResultSet resultSet = prep.executeQuery();
            while(resultSet.next()){
                int id = resultSet.getInt("logID");
                LocalDateTime dateTime = resultSet.getTimestamp("logTime").toLocalDateTime();
                String res = resultSet.getString("resource");
                String dataNew = resultSet.getString("dataNew");
                String dataOld = resultSet.getString("dataOld");
                logs.add(new Log(id,dateTime,res,dataNew,dataOld));

            }
            return logs;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public boolean addLog(String resource,String dataNew){
        Connection connection = DBconnect.getConnection();

        String sql = "insert into logworks(logTime,resource,dataNew,dataOld)" +
                " values(NOW(),?,?,?)";
        try {
            PreparedStatement prep = connection.prepareStatement(sql);
            prep.setString(1,resource);
            prep.setString(2,dataNew);
            prep.setString(3,dataNew);
            int res = prep.executeUpdate();

            return res == 1 ? true : false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        LogDao logDao = new LogDao();
        System.out.println(logDao.addLog("login.jsp","mk moi"));
    }
}
