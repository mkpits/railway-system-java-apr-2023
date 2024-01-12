package com.mkpits.railway.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@Entity
@Table(name = "city_master")
public class City_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "city_id")
    private int city_Id;
    @Column(name = "city_name")
    private String city_Name;
    @ManyToOne(cascade = {CascadeType.MERGE,CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH})
    @NotNull
    @JoinColumn(name = "state_id",referencedColumnName = "state_id")
    State_Master stateMaster;

    public City_Master() {
    }

//    public City_Master(String city_Name) {
//        this.city_Name = city_Name;
//    }


    public City_Master(String city_Name, State_Master stateMaster) {
        this.city_Name = city_Name;
        this.stateMaster = stateMaster;
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

    public State_Master getStateMaster() {
        return stateMaster;
    }

    public void setStateMaster(State_Master stateMaster) {
        this.stateMaster = stateMaster;
    }
}
