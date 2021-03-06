package com.decode9.inventory.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import com.decode9.inventory.utils.ModelValidations;

@Entity
public class CategoryModel extends ModelValidations{

    @Id
    @GeneratedValue
    @NotNull(groups={PutValidation.class})
    private Long id;
    @NotEmpty(groups={PostValidation.class, PutValidation.class})
    private String name;

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
}