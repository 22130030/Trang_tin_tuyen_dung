package com.vn.tim_viec_lam.dao.model.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobApplicationCart {
    private Map<Integer,FileCart> fileCartMap;
    public JobApplicationCart() {
        fileCartMap = new HashMap<Integer,FileCart>();
    }

    public boolean addFileCart(FileCart fileCart) {
        if(!fileCartMap.containsKey(fileCart.getId())) {
            fileCartMap.put(fileCart.getId(), fileCart);
            return true;
        }
        return false;
    }
    public List<FileCart> getList() {
        return new ArrayList<FileCart>(fileCartMap.values());
    }
    public boolean removeFileCart(int id) {
        if(fileCartMap.containsKey(id)) {
            fileCartMap.remove(id);
            return true;
        }
        return false;
    }
    public int getSize(){
        return fileCartMap.size();
    }
}
