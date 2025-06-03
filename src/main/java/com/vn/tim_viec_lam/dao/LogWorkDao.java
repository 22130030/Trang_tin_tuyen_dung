package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.LogWork;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LogWorkDao {
    public boolean insertLogWork(LogWork logWork) {
        Connection con = DBconnect.getConnection();
        String sql = "insert log_works(userId,action,old_data,new_data,changed) values(?,?,?,?,NOW())";


        try {
            PreparedStatement prep = con.prepareStatement(sql);
            prep.setInt(1,logWork.getUserId());
            prep.setString(2,logWork.getAction());
            prep.setString(3,logWork.getOldData());
            prep.setString(4,logWork.getNewData());

            return prep.executeUpdate() > 0;

       } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<LogWork> getAll() {
        Connection con = DBconnect.getConnection();
        String sql = "select * from log_works";

        List<LogWork> list = new ArrayList<LogWork>();
        try {
            PreparedStatement prep = con.prepareStatement(sql);
            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                int userId = rs.getInt("userId");
                String action = rs.getString("action");
                String oldData = rs.getString("old_data");
                String newData = rs.getString("new_data");
                LocalDateTime changed = rs.getTimestamp("changed").toLocalDateTime();

                LogWork logWork = new LogWork(userId,action,oldData,newData);
                logWork.setId(id);
                logWork.setChanged(changed);

                list.add(logWork);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
