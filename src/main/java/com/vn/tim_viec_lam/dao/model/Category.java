package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Category implements Serializable {
    private int id;
    private String name;
    private List<Job> jobs;
    public Category() {}
    public Category(int id, String name) {
        this.id = id;
        this.name = name;
        jobs = new ArrayList<Job>();
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }
    public int getSize(){
        return jobs.size();
    }
    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '\n';
    }
}
