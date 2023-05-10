

package com.portfolioB.AF.Dto;

import javax.validation.constraints.NotBlank;


public class DtoExp {
@NotBlank
private String nameE;
@NotBlank 
private String ocpE;
@NotBlank
private String dateI;
@NotBlank 
private String dateF;
@NotBlank 
private String descE;
@NotBlank 
private String refE; 

//Constructor void & constructors


    public DtoExp() {
    } 

    public DtoExp(String nameE, String ocpE, String dateI, String dateF, String descE, String refE) {
        this.nameE = nameE;
        this.ocpE = ocpE;
        this.dateI = dateI;
        this.dateF = dateF;
        this.descE = descE;
        this.refE = refE;
    }

//Getters & Setters

    public String getNameE() {
        return nameE;
    }

    public void setNameE(String nameE) {
        this.nameE = nameE;
    }

    public String getOcpE() {
        return ocpE;
    }

    public void setOcpE(String ocpE) {
        this.ocpE = ocpE;
    }

    public String getDateI() {
        return dateI;
    }

    public void setDateI(String dateI) {
        this.dateI = dateI;
    }

    public String getDateF() {
        return dateF;
    }

    public void setDateF(String dateF) {
        this.dateF = dateF;
    }

    public String getDescE() {
        return descE;
    }

    public void setDescE(String descE) {
        this.descE = descE;
    }

    public String getRefE() {
        return refE;
    }

    public void setRefE(String refE) {
        this.refE = refE;
    }
    
    

}
