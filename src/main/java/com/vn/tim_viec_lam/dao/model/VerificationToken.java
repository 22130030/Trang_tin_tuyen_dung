package com.vn.tim_viec_lam.dao.model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class VerificationToken implements Serializable {
    private int id;
    private String email;
    private String token;
    private LocalDateTime created_at;
    private LocalDateTime exp_at;

    public VerificationToken() {
    }

    public VerificationToken(int id, String email, String token, LocalDateTime created_at, LocalDateTime exp_at) {
        this.id = id;
        this.email = email;
        this.token = token;
        this.created_at = created_at;
        this.exp_at = exp_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getExp_at() {
        return exp_at;
    }

    public void setExp_at(LocalDateTime exp_at) {
        this.exp_at = exp_at;
    }

    @Override
    public String toString() {
        return "VerificationToken{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", token='" + token + '\'' +
                ", created_at=" + created_at +
                ", exp_at=" + exp_at +
                '}';
    }
}
