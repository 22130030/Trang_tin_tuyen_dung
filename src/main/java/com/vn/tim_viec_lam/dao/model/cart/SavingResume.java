package com.vn.tim_viec_lam.dao.model.cart;

import com.vn.tim_viec_lam.dao.model.Job;
import com.vn.tim_viec_lam.dao.model.Resumes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SavingResume {
    private Map<Integer,ResumeCart> cartList;
    public SavingResume(){
        cartList = new java.util.HashMap<>();
    }
    public boolean addResume(Resumes re) {
        ResumeCart resumeCart = this.convert(re);
        cartList.put(resumeCart.getId(), resumeCart);
        return true;
//        }
    }
    public List<ResumeCart> getList() {
        return new ArrayList<>(cartList.values());
    }
    public int getSize() {
        return cartList.size();
    }
    public boolean removeJobCart(int id) {
        return cartList.remove(id) != null;
    }
    public ResumeCart convert(Resumes r){
        ResumeCart rc = new ResumeCart();
        rc.setId(r.getId());
        rc.setPath(r.getPath());
        rc.setCreated(LocalDateTime.now());
        rc.setUpdated(r.getUpdated());
        rc.setTitle(r.getTitle());
        rc.setType(r.getType());
        rc.setPhone(r.getPhone());
        return rc;
    }
}
