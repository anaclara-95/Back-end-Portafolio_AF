
package com.portfolioB.AF.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull
    private String nameSk;
    @NotNull
    private String porcS;
    
    //Constructor

    public Skills() {
    }

    public Skills(String nameSk, String porcS) {
        this.nameSk = nameSk;
        this.porcS = porcS;
    }
    
    

  
    //Getters & Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSk() {
        return nameSk;
    }

    public void setNameSk(String nameSk) {
        this.nameSk = nameSk;
    }

    public String getPorcS() {
        return porcS;
    }

    public void setPorcS(String porcS) {
        this.porcS = porcS;
    }

   
    
}
