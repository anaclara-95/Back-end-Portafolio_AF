

package com.portfolioB.AF.Dto;

import javax.validation.constraints.NotBlank;


public class DtoPersona {
@NotBlank
private String name;
@NotBlank
private String lastName;
@NotBlank
private String Birth;
@NotBlank
private String email;
@NotBlank
private String descP;
@NotBlank
private String imgPer;

//Contructores

    public DtoPersona() {
    }

    public DtoPersona(String name, String lastName, String Birth,String descP , String email, String imgPer) {
        this.name = name;
        this.lastName = lastName;
        this.Birth = Birth;
        this.email = email;
        this.descP= descP;
        this.imgPer = imgPer;
    }

//Getters & Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName; 
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String Birth) {
        this.Birth = Birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImgPer() {
        return imgPer;
    }

    public void setImgPer(String imgPer) {
        this.imgPer = imgPer;
    }

    public String getDescP() {
        return descP;
    }

    public void setDescP(String descP) {
        this.descP = descP;
    }
    

}

