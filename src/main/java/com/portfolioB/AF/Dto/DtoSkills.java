

package com.portfolioB.AF.Dto;

import javax.validation.constraints.NotBlank;


public class DtoSkills {
    @NotBlank
    private String nameSk;
    @NotBlank
    private int porcS;
    
    //constructores

    public DtoSkills() {
    }

    public DtoSkills(String nameSk, int porcS) {
        this.nameSk = nameSk;
        this.porcS = porcS;
    }

    
    
    //getters & setters

    public String getNameSk() {
        return nameSk;
    }

    public void setNameSk(String nameSk) {
        this.nameSk = nameSk;
    }

    public int getPorcS() {
        return porcS;
    }

    public void setPorcS(int porcS) {
        this.porcS = porcS;
    }

    
 
    
}
