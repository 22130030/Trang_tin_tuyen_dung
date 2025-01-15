package com.vn.tim_viec_lam.service;

import com.vn.tim_viec_lam.dao.model.Resumes;
import com.vn.tim_viec_lam.dao.model.Review;
import com.vn.tim_viec_lam.dao.model.ReviewDao;

import java.util.List;

public class ReviewService {
    ReviewDao reviewDao;
    public ReviewService(){
        reviewDao = new ReviewDao();
    }
    public List<Review> getAllReviewByJobId(int jobId){
        return reviewDao.getAllReviewByJobId(jobId);
    }
}
