package com.example.comisaria.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Form{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String run;
    private String name;
    private String address;
    private String reason;
    private String email;
    
    public Form(){
        
    }
    public Form(String run,String name, String address, String reason){
        this.run = run;
        this.name = name;
        this.address = address;
        this.reason = reason;
    }

    public long getId(){
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getReason() {
        return reason;
    }

    public String getRun() {
        return run;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id){
        this.id = id;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
