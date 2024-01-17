package com.mkpits.railway.model;

import jakarta.persistence.*;

import java.sql.Date;

//import java.util.Date;

@Entity
@Table(name = "User_Details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int user_Id;
    @Column(name = "first_Name")
    private String first_Name;
    @Column(name = "middle_Name")
    private String middle_Name;
    @Column(name = "last_Name")
    private String last_Name;
    @Column(name = "date_Of_Birth")
    private Date date_Of_Birth;
    @Column(name = "gender")
    private String gender;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_No")
    private long mobile_No;
    public User() {
    }

    public User(String first_Name, String middle_Name, String last_Name, Date date_Of_Birth, String gender, String email, long mobile_No) {
        this.first_Name = first_Name;
        this.middle_Name = middle_Name;
        this.last_Name = last_Name;
        this.date_Of_Birth = date_Of_Birth;
        this.gender = gender;
        this.email = email;
        this.mobile_No = mobile_No;
    }

    public int getUser_Id() {
        return user_Id;
    }

    public void setUser_Id(int user_Id) {
        this.user_Id = user_Id;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getMiddle_Name() {
        return middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.middle_Name = middle_Name;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public Date getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(Date date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile_No() {
        return mobile_No;
    }

    public void setMobile_No(long mobile_No) {
        this.mobile_No = mobile_No;
    }
}
