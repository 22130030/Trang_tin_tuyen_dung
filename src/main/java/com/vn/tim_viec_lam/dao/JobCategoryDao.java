package com.vn.tim_viec_lam.dao;

import com.vn.tim_viec_lam.dao.model.JobCategy;
import com.vn.tim_viec_lam.database.DBconnect;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class JobCategoryDao {
   public List<JobCategy> getListJobCategroy() {
       List<JobCategy> list = new ArrayList<JobCategy>();
       Connection conn = DBconnect.getConnection();
       String sql = "select * " +
               "from job_category";
       return list;

   }
}
