package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.LogWorkDao;
import com.vn.tim_viec_lam.dao.model.LogWork;

import java.util.List;

public class LogWorkService {
    private LogWorkDao logWorkDao;
    public LogWorkService(){
        logWorkDao = new LogWorkDao();
    }
    public boolean insertLogWork(LogWork logWork){
        return logWorkDao.insertLogWork(logWork);
    }

    public List<LogWork> getAll() {
        return logWorkDao.getAll();
    }
}
