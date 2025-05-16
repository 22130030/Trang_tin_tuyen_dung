package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.model.Candidate;
import com.vn.tim_viec_lam.dao.model.User;
import com.vn.tim_viec_lam.dao.model.UserProfileDTO;

public class UserProfileService {
    private UserService userService = new UserService();
    private CandidateService candidateService = new CandidateService();

    public UserProfileDTO getUserProfile(int userID) {
        User user = userService.getUserById(userID);
        Candidate candidate = candidateService.getCandidateByUserId(userID);
        return new UserProfileDTO(user, candidate);
    }

    public UserService getUserService() {
        return this.userService;
    }


    public boolean updateUserProfile(User user, Candidate candidate) {
        boolean userUpdated = userService.updateUser(user);
        boolean candidateUpdated = candidateService.updateCandidate(candidate);
        return userUpdated && candidateUpdated;
    }
}

