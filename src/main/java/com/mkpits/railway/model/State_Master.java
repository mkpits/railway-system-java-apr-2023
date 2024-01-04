package com.mkpits.railway.model;

import jakarta.persistence.*;

@Entity
@Table(name = "state_master")
public class State_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "state_id")
    private int state_Id;
    @Column(name = "state_name")
    private String state_Name;
    public State_Master() {
    }

    public State_Master(String state_Name) {
        this.state_Name = state_Name;
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
}
