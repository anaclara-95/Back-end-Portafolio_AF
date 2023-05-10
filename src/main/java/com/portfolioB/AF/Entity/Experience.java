
package com.portfolioB.AF.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Experience {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@NotNull 
private String nameE;
@NotNull 
private String ocpE;
@NotNull 
private String dateI;
@NotNull 
private String dateF;
@NotNull 
private String descE;
@NotNull 
private String refE;

//Constructor

    public Experience( ) {
    }

    public Experience(String nameE, String ocpE, String dateI, String dateF, String descE, String refE) {
        this.nameE = nameE;
        this.ocpE = ocpE;
        this.dateI = dateI;
        this.dateF = dateF;
        this.descE = descE;
        this.refE = refE;
    }
//Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

 

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
