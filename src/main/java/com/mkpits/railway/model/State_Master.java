package com.mkpits.railway.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "state_master")
public class State_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int state_Id;
    @Column(name = "state_name")
    private String state_Name;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id",referencedColumnName = "country_Id")
    private Country_Master countryMaster;

    public State_Master() {
    }

//    public State_Master(String state_Name) {
//        this.state_Name = state_Name;
//    }
        public State_Master(String state_Name, Country_Master countryMaster) {
        this.state_Name = state_Name;
        this.countryMaster = countryMaster;
    }

    public int getState_Id() {
        return state_Id;
    }

    public void setState_Id(int state_Id) {
        this.state_Id = state_Id;
    }

    public String getState_Name() {
        return state_Name;
    }

    public void setState_Name(String state_Name) {
        this.state_Name = state_Name;
    }

    public Country_Master getCountryMaster() {
        return countryMaster;
    }

    public void setCountryMaster(Country_Master countryMaster) {
        this.countryMaster = countryMaster;
    }
}
