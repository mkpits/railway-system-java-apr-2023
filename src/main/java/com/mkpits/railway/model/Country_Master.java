package com.mkpits.railway.model;

import jakarta.persistence.*;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.lang.NonNull;

import java.util.List;

@Entity
@Table(name = "country_master")
public class Country_Master {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id")
    private int country_Id;
    @Column(name = "country_name")
    @NotNull
    private String country_Name;
    @OneToMany(mappedBy = "countryMaster",cascade =CascadeType.ALL)
    @NotNull
    private List<State_Master> stateMasterList;

    public Country_Master() {
    }
    public Country_Master(String country_Name) {
        this.country_Name = country_Name;
    }

    public int getCountry_Id() {
        return country_Id;
    }

    public void setCountry_Id(int country_Id) {
        this.country_Id = country_Id;
    }

    public String getCountry_Name() {
        return country_Name;
    }

    public void setCountry_Name(String country_Name) {
        this.country_Name = country_Name;
    }

    public List<State_Master> getStateMasterList() {
        return stateMasterList;
    }
    public void setStateMasterList(List<State_Master> stateMasterList) {
        this.stateMasterList = stateMasterList;
    }

}
