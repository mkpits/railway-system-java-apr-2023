package com.mkpits.railway.model;

import jakarta.persistence.*;

@Entity
@Table(name = "city_master")
public class City_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int city_Id;
    @Column(name = "city_name")
    private String city_Name;

    public City_Master() {
    }

    public City_Master(String city_Name) {
        this.city_Name = city_Name;
    }

    public int getCity_Id() {
        return city_Id;
    }

    public void setCity_Id(int city_Id) {
        this.city_Id = city_Id;
    }

    public String getCity_Name() {
        return city_Name;
    }

    public void setCity_Name(String city_Name) {
        this.city_Name = city_Name;
    }
}
