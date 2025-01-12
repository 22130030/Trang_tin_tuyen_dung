package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.CandidateDao;
import com.vn.tim_viec_lam.dao.model.Candidate;
import java.util.List;

public class CandidateService {
    private CandidateDao candidateDao;
    public CandidateService() {
        candidateDao = new CandidateDao();
    }
    public List<Candidate> getListCandidate()  {
        return candidateDao.getListCandidate();
    }
    public List<Candidate> findListCandidateEmail(String email)  {
        return candidateDao.FindListCandidateEmail(email);
    }
    public void deleteUserCandidate(int id)  {
        candidateDao.deleteCandidateById(id);
    }
    public  Candidate loadUserCandidate(int id)  {
        return candidateDao.getCandidateById(id);
    }
    public void editUserCandidate(int id , String fullname ,String email, String phone ,String status)  {
         candidateDao.editUserCandidate(id,fullname,email,phone,status);
    }

}
