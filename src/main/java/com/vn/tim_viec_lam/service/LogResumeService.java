package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.LogResumeDao;
import com.vn.tim_viec_lam.dao.model.LogResume;

import java.util.List;

public class LogResumeService {
    private LogResumeDao logResumeDao;
    public LogResumeService() {
        logResumeDao = new LogResumeDao();
    }
    public List<LogResume> getAllLogResumeById(int resumeId) {
        return logResumeDao.getLogReById(resumeId);
    }
}
