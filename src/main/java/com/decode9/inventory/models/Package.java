package com.decode9.inventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Package {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double quantity;

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public double getQuantity(){
        return quantity;
    }

    public void setId(Long id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setQuantity(double quantity){
        this.quantity = quantity;
    }
}