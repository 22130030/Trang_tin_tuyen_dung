package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.LogDao;
import com.vn.tim_viec_lam.dao.model.CompanyUser;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.dao.model.UserLog;

import java.util.List;

public class LogService {
    private LogDao logDao;

    public LogService() {
        logDao = new LogDao();
    }
    public boolean addLog(User user, String role, String action, String loginType, String status, String ipAddress, String description) {
        return logDao.insertUserLog(user, role, action, loginType, status, ipAddress, description);
    }
    public boolean addLogCompany(CompanyUser user, String role, String action, String loginType, String status, String ipAddress, String description) {
        return logDao.insertUserCompanyLog(user, role, action, loginType, status, ipAddress, description);
    }
    public List<UserLog> getListLog() {
        return logDao.getListLog();
    }
}
