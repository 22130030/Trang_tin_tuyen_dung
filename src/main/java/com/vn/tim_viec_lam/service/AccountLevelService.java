package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.AccountLevelDao;
import com.vn.tim_viec_lam.dao.model.AccountLevel;

public class AccountLevelService {
    AccountLevelDao accountLevelDao;
    public AccountLevelService() {
        accountLevelDao = new AccountLevelDao();
    }
    public AccountLevel getAccountLevelById(int status) {
        return accountLevelDao.getLimitByStatus(status);
    }

    public static void main(String[] args) {
        AccountLevelService accountLevelService = new AccountLevelService();
        System.out.println(accountLevelService.getAccountLevelById(1));
    }
}
