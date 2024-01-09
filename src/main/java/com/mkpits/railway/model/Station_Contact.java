package com.mkpits.railway.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Station_Contact")
public class Station_Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Contact_id")
    private int contact_id;
    @Column(name = "Mobile_no")
    private String mobile_no;
    @Column(name = "Phone_no")
    private String phone_no;
    @Column(name = "Email_id")
    private String email_id;

    public Station_Contact() {
    }

    public Station_Contact(int contact_id, String mobile_no, String phone_no, String email_id) {
        this.contact_id = contact_id;
        this.mobile_no = mobile_no;
        this.phone_no = phone_no;
        this.email_id = email_id;
    }

    public int getContact_id() {
        return contact_id;
    }

    public void setContact_id(int contact_id) {
        this.contact_id = contact_id;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getEmail_id() {
        return email_id;
    }

    public void setEmail_id(String email_id) {
        this.email_id = email_id;
    }
}
