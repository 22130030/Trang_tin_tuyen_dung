package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.util.Date;

public class UserLog implements Serializable {
    private int id;
    private Integer userId;    // Cho phép null (nếu đăng ký thì có thể chưa có userId)
    private String username;
    private String role;       // ung_vien, nha_tuyen_dung, admin
    private String action;     // login, register
    private String loginType;  // facebook, google, password
    private String status;     // success, failed
    private String ipAddress;
    private Date logTime;
    private String description;

    public UserLog(User user, String role, String action, String loginType, String status, String ipAddress, String description) {
    }
    public UserLog(CompanyUser user, String role, String action, String loginType, String status, String ipAddress, Date logTime, String description) {
        if (user != null) {
            this.userId = user.getUserID();
            this.username = user.getEmail();
        }
        this.role = role;
        this.action = action;
        this.loginType = loginType;
        this.status = status;
        this.ipAddress = ipAddress;
        this.logTime = logTime;
        this.description = description;
    }

    public UserLog(User user, String role, String action, String loginType, String status, String ipAddress, Date logTime, String description) {
        if (user != null) {
            this.userId = user.getUserID();
            this.username = user.getEmail();
        }
        this.role = role;
        this.action = action;
        this.loginType = loginType;
        this.status = status;
        this.ipAddress = ipAddress;
        this.logTime = logTime;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "UserLog{" +
                "id=" + id +
                ", userId=" + userId +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", action='" + action + '\'' +
                ", loginType='" + loginType + '\'' +
                ", status='" + status + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", logTime=" + logTime +
                ", description='" + description + '\'' +
                '}';
    }
}
