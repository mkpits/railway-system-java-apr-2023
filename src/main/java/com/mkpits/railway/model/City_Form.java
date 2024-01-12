package com.mkpits.railway.model;

public class City_Form {
    private int city_Id;
    private String city_Name;
    private int state_Id;

    public City_Form() {
    }
//    public City_Form(String city_Name, int state_Id) {
//        this.city_Name = city_Name;
//        this.state_Id = state_Id;
//    }


    public City_Form(int city_Id, String city_Name, int state_Id) {
        this.city_Id = city_Id;
        this.city_Name = city_Name;
        this.state_Id = state_Id;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }

    public int getState_Id() {
        return state_Id;
    }

    public void setState_Id(int state_Id) {
        this.state_Id = state_Id;
    }

    public int getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(int city_Id) {
        this.city_Id = city_Id;
    }
}
