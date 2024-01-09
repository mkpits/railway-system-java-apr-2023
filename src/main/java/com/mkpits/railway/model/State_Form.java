package com.mkpits.railway.model;

public class State_Form {
    private String state_Name;
    private int country_Id;

    public State_Form() {
    }

    public State_Form(String state_Name, int country_Id) {
        this.state_Name = state_Name;
        this.country_Id = country_Id;
    }

    public String getState_Name() {
        return state_Name;
    }

    public void setState_Name(String state_Name) {
        this.state_Name = state_Name;
    }

    public int getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(int country_Id) {
        this.country_Id = country_Id;
    }
}
