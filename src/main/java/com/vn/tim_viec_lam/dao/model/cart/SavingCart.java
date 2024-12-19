package com.vn.tim_viec_lam.dao.model.cart;

import com.vn.tim_viec_lam.dao.model.Job;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SavingCart {
    private Map<Integer,JobCart> cartList;
    public SavingCart(){
        cartList = new HashMap<>();
    }
    public boolean addJobCart(Job job) {
            JobCart jobCart = this.convert(job);
            cartList.put(job.getId(), jobCart);
            return true;
//        }
    }
    public List<JobCart> getList() {
        return new ArrayList<>(cartList.values());
    }
    public int getSize() {
        return cartList.size();
    }
    public boolean removeJobCart(int id) {
        return cartList.remove(id) != null;
    }
    public JobCart convert(Job job) {
        JobCart jobCart = new JobCart();
        jobCart.setId(job.getId());
        jobCart.setCompanyId(job.getCompanyId());
        jobCart.setTitle(job.getTitle());
        jobCart.setCompanyName(job.getCompanyName());
        jobCart.setImg(job.getImg());
        jobCart.setSalary(job.getSalary());
        return jobCart;
    }

    public static void main(String[] args) {
        SavingCart savingCart = new SavingCart();
        System.out.println(savingCart.getSize());
    }
}
