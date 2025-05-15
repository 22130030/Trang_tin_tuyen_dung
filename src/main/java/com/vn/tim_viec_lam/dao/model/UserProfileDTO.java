package com.vn.tim_viec_lam.dao.model;

public class UserProfileDTO {
    private int userID;
    private String email;
    private String name;
    private String phoneNumber;
    private String image;

    private String gender;
    private String birth;
    private String address;

    public UserProfileDTO() {}

    public UserProfileDTO(User user, Candidate candidate) {
        this.userID = user.getUserID();
        this.email = user.getEmail();
        this.name = user.getName();
        this.phoneNumber = user.getPhoneNumber();
        this.image = user.getImage();

        if (candidate != null) {
            this.gender = candidate.getGender();
            this.birth = candidate.getBirth();
            this.address = candidate.getAddress();
        }
    }

    // Getter và Setter
    // ...

    public int getUserID() { return userID; }
    public void setUserID(int userID) { this.userID = userID; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    public String getGender() { return gender; }
    public void setGender(String gender) { this.gender = gender; }

    public String getBirth() { return birth; }
    public void setBirth(String birth) { this.birth = birth; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
}
